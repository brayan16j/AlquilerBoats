package com.example.usa.boats.service;

import com.example.usa.boats.model.AdminModel;
import com.example.usa.boats.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<AdminModel> getAllAdmin(){
        return adminRepository.getAllAdmin();
    }
    public Optional<AdminModel> getAdmin(Integer id){
        return adminRepository.getAdmin(id);
    }
    public AdminModel saveAdmin(AdminModel adminModel){
        if(adminModel.getIdAdmin()==null){
            return adminRepository.saveAdmin(adminModel);
        }else {
            Optional<AdminModel> adminEncontrada = adminRepository.getAdmin(adminModel.getIdAdmin());
            if (adminEncontrada.isEmpty()){
                return adminRepository.saveAdmin(adminModel);
            }else {
                return adminModel;
            }
        }
    }
    public boolean deleteAdmin(Integer id){
        Boolean respuesta = getAdmin(id).map(elemento ->{
            adminRepository.delete(elemento);
            return true;
        }).orElse(false);
        return respuesta;
    }
    public AdminModel updateAdmin(AdminModel adminModel){
        if (adminModel.getIdAdmin() !=null){
            Optional<AdminModel> adminEncontrado = adminRepository.getAdmin(adminModel.getIdAdmin());
            if (!adminEncontrado.isEmpty()){
                if(adminModel.getPassword() !=null){
                    adminEncontrado.get().setPassword(adminModel.getPassword());
                }
                if (adminModel.getName() !=null){
                    adminEncontrado.get().setName(adminModel.getName());
                }
                return adminRepository.saveAdmin(adminEncontrado.get());
            }
        }
        return adminModel;
    }


}
