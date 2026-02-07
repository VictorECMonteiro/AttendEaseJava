package com.victorecmonteiro.attendease.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService implements UserDetailsService {
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public Login createUser(LoginDTO dto){
        Login usuario = new Login();
        usuario.setUsername(dto.getUsername());
        usuario.setFuncao(dto.getFuncao());
        usuario.setSenha(
                passwordEncoder.encode(dto.getSenha()));
        try{
            return loginRepository.save(usuario);
        }
        catch(Exception e){
            System.out.println(e);
            throw new RuntimeException(e);

        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login login = loginRepository.findByusername(username).orElseThrow(()->new UsernameNotFoundException("Usuário não encontrado"));
        GrantedAuthority authority =
                new SimpleGrantedAuthority(login.getFuncao());

        User user = new User(login.getUsername(), login.getSenha(), List.of(authority));
        return user;
    }
}
