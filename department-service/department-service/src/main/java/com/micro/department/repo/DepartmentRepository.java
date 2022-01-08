package com.micro.department.repo;

import com.micro.department.entity.DepartmentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends CrudRepository<DepartmentEntity, Long> {
    Optional<DepartmentEntity> findByDepartmentCode(String code);
}
