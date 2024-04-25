package com.example.paymentservice.controllers;

import java.util.List;
import com.example.paymentservice.dto.PaymentDTO;
import com.example.paymentservice.exceptions.ResourceNotFoundException;
import com.example.paymentservice.mappers.PaymentMapper;
import com.example.paymentservice.models.Payment;
import com.example.paymentservice.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/ticket-booking/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;
    private final PaymentMapper paymentMapper;

    @GetMapping()
    public ResponseEntity<List<Payment>> getPayments() {
        List<Payment> payments = paymentService.getAll();
        return ResponseEntity.ok().body(payments);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment, @PathVariable Long id) {

        Payment paymentToUpdate = paymentService.getById(id).orElseThrow(() -> new ResourceNotFoundException("Payment doesn't exist"));
        payment.setId(id);
        Payment updatedPayment = paymentService.updatePayment(payment);
        return ResponseEntity.ok(updatedPayment);

    }
    @Transactional
    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment savedPayment = paymentService.createPayment(payment);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPayment);
    }
    @Transactional
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getById(@PathVariable Long id) {
        System.out.println("GET BY ID");
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.getById(id).orElseThrow(() -> new ResourceNotFoundException("Payment doesn't exist")));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable Long id) {
        paymentService.deleteById(id);
        return ResponseEntity.ok().body("object deleted: " + id);
    }
}
