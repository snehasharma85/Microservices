package com.micro.department.controller;

import com.micro.department.entity.DepartmentEntity;
import com.micro.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public ResponseEntity<?> saveUser(@RequestBody DepartmentEntity departmentEntity) {
        log.info("Inside save user controller");
        Optional<DepartmentEntity> department = departmentService.getDepartmentByCode(departmentEntity.getDepartmentCode());
        if (!department.isPresent()) {
            log.info("saving user--- {}", departmentEntity.toString());
            departmentService.saveDepartment(departmentEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(departmentEntity);
        }
        else
            return ResponseEntity.status(HttpStatus.FOUND).body("Department with code :" + department.get().getDepartmentCode() + "already exists");
    }


    @GetMapping("/department/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {

        Optional<DepartmentEntity> departmentEntity =  departmentService.getDepartmentById(id);
        if(departmentEntity.isPresent())
            return ResponseEntity.status(HttpStatus.OK).body(departmentEntity.get());
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department with id: " + id + " not found");
    }
}
