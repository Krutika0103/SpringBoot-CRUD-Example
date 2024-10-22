package com.krutika.springbootproject.controller;

import com.krutika.springbootproject.model.Adress;
import com.krutika.springbootproject.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adress")
public class AdressController {

    @Autowired
    private AdressService adressService;


    @PostMapping("/save")
    public ResponseEntity createAdress(@RequestBody Adress  adressObj){
        adressService.saveAdress(adressObj);
        return new ResponseEntity(HttpStatus.CREATED);
    }


    @GetMapping(value = {"/getAdress", "/{addressId}"})
    public List<Adress> getAdress(@PathVariable (required = false)Long addressId){
        return adressService.getAdressDetails(addressId);
    }

}
