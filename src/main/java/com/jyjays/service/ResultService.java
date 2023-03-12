package com.jyjays.service;

import com.jyjays.controller.Result;
import org.springframework.validation.BindingResult;

public interface ResultService {
    Result getResult(BindingResult bindingResult);
}
