package com.example.New.Application;

import com.example.New.DTO.Request.CreatrCustomerDTO;
import com.example.New.DTO.Responst.CustomerResponseDTO;
import com.example.New.Domain.Entity.Customer;
import com.example.New.Domain.Service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/New")
@AllArgsConstructor

public class CustomerControl {

    private final CustomerService customerService;

    @GetMapping("/getcustomer")
    public ResponseEntity <CustomerResponseDTO> getcustomer(@RequestParam Integer id) {
        return customerService.getcustomer(id);
    }
    @PostMapping("/addcustomer")
    public ResponseEntity <Customer> addcustomer(@RequestBody CreatrCustomerDTO creatrCustomerDTO) {
        return customerService.addcustomer(creatrCustomerDTO);
    }
    @DeleteMapping("/deletecustomer")
    public ResponseEntity <String> deletecustomer(@RequestParam Integer id) {
        return customerService.deletecustomer(id);
    }
    @PutMapping("/updatecustomer")
    public ResponseEntity <String> updatecustomer(@RequestParam Integer id, @RequestParam String newname) {
        return customerService.updatecustomer(id,newname);
    }
}
