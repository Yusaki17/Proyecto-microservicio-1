    package com.irojas.microservices.customer_microservice.customer;
    
    import jakarta.validation.Valid;
    import lombok.RequiredArgsConstructor;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    
    import java.util.List;
    
    @RestController
    @RequestMapping("/api/v1/customers")
    @RequiredArgsConstructor
    @Slf4j
    public class CustomerController {
        private final CustomerService service;
    
        @PostMapping
        public ResponseEntity<Integer> createCustomer(@Valid @RequestBody CustomerRequest request){
            return ResponseEntity.ok(service.createCustomer(request));
        }
        // 1. Cambiado String a Integer
        @GetMapping("/{customerId}")
        public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable("customerId") Integer customerId) {
            return ResponseEntity.ok(service.getCustomerById(customerId));
        }
    
        @GetMapping
        public ResponseEntity<List<CustomerResponse>> getCustomers() {
            return ResponseEntity.ok(service.getCustomers());
        }
    
        @PutMapping
        public ResponseEntity<Void> updateCustomer(@Valid @RequestBody CustomerRequest request) {
            service.updateCustomer(request); // Asegúrate que el método en service coincida
            return ResponseEntity.accepted().build();
        }
    
        // 2. Cambiado String a Integer
        @DeleteMapping("/{customerId}")
        public ResponseEntity<Void> deleteCustomerById(@PathVariable("customerId") Integer customerId) {
            service.deleteCustomerById(customerId);
            return ResponseEntity.accepted().build();
        }
    
    }
