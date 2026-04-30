package com.irojas.microservices.customer_microservice.customer;

import com.irojas.microservices.customer_microservice.exceptions.CustomerNotFoundException;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public Integer createCustomer(CustomerRequest request) {
        var customer = mapper.toCustomer(request);
        var savedCustomer = repository.save(customer);
        return savedCustomer.getId();
    }

    public CustomerResponse getCustomerById(Integer customerId) {
        return repository
                .findById(customerId)
                .map(mapper::toCustomerResponse)
                .orElseThrow(() -> new CustomerNotFoundException(
                        String.format("Cliente con ID %d no encontrado", customerId)));
    }

    public List<CustomerResponse> getCustomers() {
        return repository
                .findAll().stream()
                .map(mapper::toCustomerResponse)
                .toList();
    }

    public void updateCustomer(@Valid CustomerRequest request) {
        Customer existingCustomer = repository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        existingCustomer.setNombre(request.nombre());
        existingCustomer.setEmail(request.email());
        existingCustomer.setPais(request.pais());
        existingCustomer.setSaldo(request.saldo());
        existingCustomer.setEstado(request.estado());
        existingCustomer.setUsername(request.username());
        existingCustomer.setPassword(request.password());
        existingCustomer.setFecha_registro(request.fecha_registro());
        repository.save(existingCustomer);
    }

    public void deleteCustomerById(Integer customerId) {
        repository
                .findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(
                        String.format("Cliente con ID %d no encontrado", customerId)));
        repository.deleteById(customerId);
    }
}

