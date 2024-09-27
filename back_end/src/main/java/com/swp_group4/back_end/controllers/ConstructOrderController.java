package com.swp_group4.back_end.controllers;

import com.swp_group4.back_end.services.ConstructOrderService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConstructOrderController {

    @Autowired
    ConstructOrderService constructOrderService;


}
