package com.jyjays.service.impl;

import com.jyjays.controller.Code;
import com.jyjays.controller.Result;
import com.jyjays.service.ResultService;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

@Component
public class ResultServiceImpl implements ResultService {
    @Override
    public Result getResult(BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            List<ObjectError> errors = bindingResult.getAllErrors();
            for (ObjectError error : errors) {
                sb.append(error.getDefaultMessage()).append(";");
            }
            return new Result(null, Code.SYSTEM_ERR, sb.toString());
        }
        return null;
    }
}
