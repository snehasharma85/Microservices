package com.micro.user.service;

import com.micro.user.Vo.Department;
import com.micro.user.Vo.ResponseVoTemplate;
import com.micro.user.entity.UserEntity;
import com.micro.user.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public UserEntity saveUser(UserEntity user) {
        log.info("Inside saveUser");
        if (null != user) return userRepository.save(user);
        return null;
    }

    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    public ResponseVoTemplate findUseDepartmentById(Long id) {
        ResponseVoTemplate responseVoTemplate;

        UserEntity user = userRepository.findById(id).get();
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/department/" + user.getDepartmentId(), Department.class);

        responseVoTemplate = new ResponseVoTemplate();
        responseVoTemplate.setDepartment(department);
        responseVoTemplate.setUserEntity(user);
        return  responseVoTemplate;

    }
}
