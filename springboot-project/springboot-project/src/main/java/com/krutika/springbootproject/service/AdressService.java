package com.krutika.springbootproject.service;

import com.krutika.springbootproject.model.Adress;
import com.krutika.springbootproject.repository.AdressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdressService {

    @Autowired
    private AdressRepo adressRepo;

    public AdressService(AdressRepo adressRepo) {
        this.adressRepo = adressRepo;
    }

    public void saveAdress(Adress adressObj){
        adressRepo.save(adressObj);
    }

    public List<Adress> getAdressDetails(Long addressId){
        if (null!= addressId) {
            return adressRepo.findAllByAddressId(addressId);
        } else {
            return adressRepo.findAll();
        }
    }


}
