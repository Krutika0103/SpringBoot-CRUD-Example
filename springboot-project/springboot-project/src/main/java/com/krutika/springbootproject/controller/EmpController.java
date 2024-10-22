package com.krutika.springbootproject.controller;

import com.krutika.springbootproject.dto.MailRequest;
import com.krutika.springbootproject.exception.ResourceNotFoundException;
import com.krutika.springbootproject.model.Adress;
import com.krutika.springbootproject.model.Employee;
import com.krutika.springbootproject.repository.AdressRepo;
import com.krutika.springbootproject.repository.UserRepository;
import com.krutika.springbootproject.service.EmailSenderService;
import com.krutika.springbootproject.service.EmployeeService;
import jakarta.mail.Address;
import jakarta.mail.MessagingException;
import org.antlr.v4.runtime.atn.AmbiguityInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/employee")
public class EmpController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private AdressRepo addressRepo;

    public EmpController(AdressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return userRepository.findAll();

    }

    @PostMapping("/saveEmp")
    public ResponseEntity<String> saveEmployees(@RequestBody Employee empData) {
        userRepository.save(empData);
        return ResponseEntity.ok("Data Saved");
    }

    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee empObj){
        employeeService.saveEmployees(empObj);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = {"/getEmp", "/{id}"})
    public List<Employee> getEmployee(@PathVariable(required = false)Long id){
        return employeeService.getEmployeeDetails(id);
    }

    @PutMapping("/{id}/adress/{addressId}")
    public Employee assignAddressToEmployee(
        @PathVariable Long id,
        @PathVariable Long addressId)  {
        return employeeService.assignAddressToEmployee(id, addressId);
    }

    //Here created emp REST API
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {

        return userRepository.save(employee);
    }

    //Developed get employee by ID REST API
    @GetMapping("{id}")

    public ResponseEntity<Employee> getEmpById(@PathVariable Long id) {
        Employee employee = userRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException("employee not exists"));
        return ResponseEntity.ok(employee);
    }

    //code for update emp REST API
   @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Employee updateEmployee = userRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException("employee not exists"));
        updateEmployee.setName(employeeDetails.getName());
        updateEmployee.setEmail(employeeDetails.getEmail());
        updateEmployee.setPassword(employeeDetails.getPassword());

        userRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }

    // build delete emp REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id) {
        Employee employee = userRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException("employee not exists"));
        userRepository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/sendEmail")
    public String sendMail() throws MessagingException, IOException {
        emailSenderService.sendMail(null);
        return "Mail send successfully!";
    }

    @PostMapping("/mailSend")
    public ResponseEntity<HttpStatus> mailRequest(@ModelAttribute MailRequest mailRequest) throws MessagingException, IOException {
        emailSenderService.sendMail(mailRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public AdressRepo getAddressRepo() {
        return addressRepo;
    }
}
