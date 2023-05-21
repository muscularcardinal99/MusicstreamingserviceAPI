package com.geekster.MusicStreaming.controller;

import com.geekster.MusicStreaming.model.Role;
import com.geekster.MusicStreaming.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping("/{email}")
    public String addRole(@PathVariable String email , @RequestBody Role role){

        return roleService.addRole(role , email);
    }
}
