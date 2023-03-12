package com.jyjays.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PhoneDto {
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "手机号不能为空")
    private String phone;
}
