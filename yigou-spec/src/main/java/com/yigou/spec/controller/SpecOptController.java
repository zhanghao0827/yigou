package com.yigou.spec.controller;

import com.yigou.spec.service.SpecOptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpecOptController {

    @Autowired
    SpecOptService specOptService;



}
