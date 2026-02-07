package com.victorecmonteiro.attendease.login;

import com.victorecmonteiro.attendease.config.JWTGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    JWTGenerator jwtGenerator;

    @PreAuthorize("hasRole('Professor')")
    @PostMapping("/createUser")
    public ResponseEntity<LoginDTO> createUser(
            @RequestBody
            @Validated
            LoginDTO dto
    ){
        Login usuario = loginService.createUser(dto);

        LoginDTO response = new LoginDTO(
                usuario.getSenha(),
                usuario.getFuncao(),
                usuario.getSenha()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody @Validated LoginDTO dto){
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            dto.getUsername(),
                            dto.getSenha()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtGenerator.generateToken(authentication);

            return new ResponseEntity<>(token, HttpStatus.OK);

        }
        catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<>("", HttpStatus.UNAUTHORIZED);

        }






    }

}
