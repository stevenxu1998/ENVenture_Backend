package org.enventure.demobackend.service.serviceImpl;

import org.enventure.demobackend.domain.Admin;
import org.enventure.demobackend.domain.Student;
import org.enventure.demobackend.repository.AdminRepository;
import org.enventure.demobackend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin createAdmin (Admin admin){ return adminRepository.save(admin);}

    @Override
    public List<Admin> getAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin getAdmin (Long id){
        return adminRepository.findById(id).get();
    }

    @Override
    public void updateAdmin (Long id, Admin admin){
        Admin newAdmin = adminRepository.findById(id).get();
        newAdmin.setEmail(admin.getEmail());
        newAdmin.setFirstName(admin.getFirstName());
        newAdmin.setLastName(admin.getLastName());
        adminRepository.save(newAdmin);
    }

    @Override
    public void deleteAdmin (Long id){
        adminRepository.deleteById(id);
    }

    @Override
    public List<Admin> getAdminsByName(String firstName, String lastName) {
        return adminRepository.findAdminsByFirstNameOrLastName(firstName, lastName);
    }
}
