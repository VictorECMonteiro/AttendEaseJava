package com.victorecmonteiro.attendease;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class IndexController {

        @GetMapping("/")
        public ResponseEntity<Map<String, String>> index() {
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("message","Estou retornando victor"));

        };




}
