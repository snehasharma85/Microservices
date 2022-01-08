package com.micro.user.Vo;

import com.micro.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseVoTemplate {

    private UserEntity userEntity;
    private Department department;
}
