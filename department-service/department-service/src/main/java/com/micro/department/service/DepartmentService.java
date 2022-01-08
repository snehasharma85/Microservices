package com.micro.department.service;

import com.micro.department.entity.DepartmentEntity;
import com.micro.department.repo.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentEntity saveDepartment(DepartmentEntity department){
        return departmentRepository.save(department);
    }

    public Optional<DepartmentEntity> getDepartmentById(Long id){
        return departmentRepository.findById(id);
    }


    public Optional<DepartmentEntity> getDepartmentByCode(String code){
        return departmentRepository.findByDepartmentCode(code);
    }

}
