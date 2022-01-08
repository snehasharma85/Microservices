package com.micro.cloud.gateway;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/userServiceFallBack")
    public ResponseEntity<?> fallbackForUserService(){
        return ResponseEntity.status(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED).body("Please try after sometime");
    }


    @GetMapping("/departmentServiceFallBack")
    public ResponseEntity<?> fallbackForDepartmentService(){
        return ResponseEntity.status(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED).body("Please try after sometime");
    }
}
