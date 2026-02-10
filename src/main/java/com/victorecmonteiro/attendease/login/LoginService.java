package com.victorecmonteiro.attendease.login;

import com.victorecmonteiro.attendease.login.dto.LoginCreateDTO;
import com.victorecmonteiro.attendease.user.Usuario;
import com.victorecmonteiro.attendease.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService implements UserDetailsService {
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    org.springframework.security.core.userdetails.User userAuth;


    public boolean createUser(LoginCreateDTO dto){
        Login login = new Login();
        Usuario user = new Usuario(
                dto.getNomeUsuario(),
                dto.getSobrenomeUsuario(),
                dto.getDataNascimento(),
                true
        );
        login.setUsername(dto.getUsername());
        login.setFuncao(dto.getFuncao());
        login.setSenha(
                passwordEncoder.encode(dto.getSenha()));
        try{
            Login loginDatabase = loginRepository.save(login);
            user.setLogin(loginDatabase);
            userRepository.save(user);
            return true;
        }
        catch(Exception e){
            System.out.println(e);
            return false;

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
