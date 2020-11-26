package org.enventure.demobackend.service;

import org.enventure.demobackend.domain.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AdminService {
    public Admin createAdmin (Admin admin);
    public List<Admin> getAdmins();
    public Admin getAdmin(Long id);
    public void updateAdmin(Long id);
    public void deleteAdmin(Long id);

    List<Admin> getAdminsByName(String firstName, String lastName);
}
