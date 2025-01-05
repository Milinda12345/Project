package com.example.New.Domain.Service;

import com.example.New.DTO.Request.CreatrCustomerDTO;
import com.example.New.DTO.Responst.CustomerResponseDTO;
import com.example.New.Domain.Entity.Customer;
import com.example.New.External.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor

public class CustomerService {

    private final CustomerRepository customerRepository;

    public ResponseEntity<CustomerResponseDTO> getcustomer(Integer id) {

        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if (optionalCustomer.isPresent()) {

            Customer customer = optionalCustomer.get();
            customerResponseDTO.setCustomerId(customer.getId());
            customerResponseDTO.setCustomerName(customer.getName());
            customerResponseDTO.setCustomerEmail(customer.getEmail());
            customerResponseDTO.setCustomerAddress(customer.getAddress());
            customerResponseDTO.setCustomerPhone(customer.getPhone());
            return ResponseEntity.ok(customerResponseDTO);

        }else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Customer> addcustomer(CreatrCustomerDTO creatrCustomerDTO) {

        Customer customer = new Customer();
        customer.setId(creatrCustomerDTO.getId());
        customer.setName(creatrCustomerDTO.getName());
        customer.setEmail(creatrCustomerDTO.getEmail());
        customer.setAddress(creatrCustomerDTO.getAddress());
        customer.setPhone(creatrCustomerDTO.getPhone());
        customer.setAccountnumber(creatrCustomerDTO.getAccountnumber());
        customer.setGender(creatrCustomerDTO.getGender());
        customer.setAge(creatrCustomerDTO.getAge());
        customer.setCity(creatrCustomerDTO.getCity());
        customer.setPassword(creatrCustomerDTO.getPassword());
        customerRepository.save(customer);
        return ResponseEntity.ok(customer);


    }

    public ResponseEntity<String> deletecustomer(Integer id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            customerRepository.deleteById(id);
            return ResponseEntity.ok("Customer deleted successfully");
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> updatecustomer(Integer id, String newname) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setName(newname);
            customerRepository.save(customer);
            return ResponseEntity.ok("Customer updated successfully");
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
