package com.victorecmonteiro.attendease.config;

import com.victorecmonteiro.attendease.login.Login;
import com.victorecmonteiro.attendease.login.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminBootstrap implements CommandLineRunner {
    private LoginRepository loginRepository;
    @Value("${app.properties.adminusername}")
    private String adminusername;
    @Value("${app.properties.adminpass}")
    private String adminpass;
    @Autowired
    PasswordEncoder passwordEncoder;


    public AdminBootstrap(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Login login = new Login();
        login.setUsername(adminusername);
        login.setSenha(passwordEncoder.encode(adminpass));
        login.setFuncao("Professor");
        loginRepository.save(login);
    }
}
