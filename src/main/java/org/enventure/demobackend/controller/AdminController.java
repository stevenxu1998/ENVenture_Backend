package org.enventure.demobackend.controller;

import org.enventure.demobackend.domain.Admin;
import org.enventure.demobackend.domain.Quiz;
import org.enventure.demobackend.repository.AdminRepository;
import org.enventure.demobackend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Admins")
@CrossOrigin(origins = "http://localhost:9000")
public class AdminController {
    @Autowired
    private AdminService adminService;
    private AdminRepository adminRepository;

    @PostMapping
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin){
        Admin ad = adminService.createAdmin(admin);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("reach-status", "reached very well");
        return new ResponseEntity<>(ad, httpHeaders, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Admin>> getAdmins(){
        return new ResponseEntity<>(adminService.getAdmins(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public Admin getAdmin (@PathVariable Long id){
        return adminService.getAdmin(id);
    }

    @DeleteMapping("/{id}")
    private void deleteAdmin(@PathVariable("id") Long id){ adminService.deleteAdmin(id);}

    @RequestMapping(value = "/Admins/{id}", method = RequestMethod.PUT)
    public void updateAdmin(@PathVariable Long id){
        Admin newAdmin = adminRepository.findById(id).get();
        adminService.updateAdmin(id, newAdmin);
    }
}
