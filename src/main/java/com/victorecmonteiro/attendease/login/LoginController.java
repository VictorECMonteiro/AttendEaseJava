package com.victorecmonteiro.attendease.login;

import com.victorecmonteiro.attendease.config.JWTGenerator;
import com.victorecmonteiro.attendease.login.dto.LoginCreateDTO;
import com.victorecmonteiro.attendease.login.dto.LoginDTO;
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
    public ResponseEntity<Boolean> createUser(
            @RequestBody
            @Validated
            LoginCreateDTO dto
    ){
        try {
            boolean usuario = loginService.createUser(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(true);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);

        }

//        LoginDTO response = new LoginDTO(
//                usuario.getSenha(),
//                usuario.getFuncao(),
//                usuario.getSenha()
//        );


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
