package com.example.usa.boats.controller;

import com.example.usa.boats.model.AdminModel;
import com.example.usa.boats.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @GetMapping("/all")
    public List<AdminModel> getAllAdmin(){
        return adminService.getAllAdmin();
    }
    @GetMapping("{id}")
    public Optional<AdminModel> getAdmin(@PathVariable("id") Integer id){
        return adminService.getAdmin(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public AdminModel saveAdmin(@RequestBody AdminModel adminModel){
        return adminService.saveAdmin(adminModel);
    }
    @PutMapping("/update")
    public AdminModel updateAdmin(@RequestBody AdminModel adminModel){
        return adminService.updateAdmin(adminModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean delete(@PathVariable("id") Integer id){
        return adminService.deleteAdmin(id);
    }


}
