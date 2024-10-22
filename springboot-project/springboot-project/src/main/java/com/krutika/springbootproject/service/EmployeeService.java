package com.krutika.springbootproject.service;

import com.krutika.springbootproject.model.Adress;
import com.krutika.springbootproject.model.Employee;
import com.krutika.springbootproject.repository.AdressRepo;
import com.krutika.springbootproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdressRepo adressRepo ;

    public void saveEmployees(Employee empObj) {
        userRepository.save(empObj);
    }

    public List<Employee> getEmployeeDetails() {
        return getEmployeeDetails(null);
    }

    public List<Employee> getEmployeeDetails(Long id){
        if (null!=id){
            return userRepository.findAllById(Collections.singleton(id));
        } else {
            return userRepository.findAll();
        }
    }

    public Employee assignAddressToEmployee(Long id, Long addressId) {
        Set<Adress>adressSet=null;
        Employee employee= userRepository.findById(id).get();
        Adress adress = adressRepo.findById(addressId).get();
        adressSet=employee.getAdress();
        adressSet.add(adress);
        employee.setAdress(adressSet);
        return userRepository.save(employee);
    }
}
