package com.example.paymentservice.services;

import com.example.paymentservice.models.Payment;
import com.example.paymentservice.repositories.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }
    public Optional<Payment> getById(Long id) {
        return paymentRepository.findById(id);
    }

    public Payment updatePayment(Payment payment){
        return paymentRepository.save(payment);
    }

    public void deleteById(Long id){
        paymentRepository.deleteById(id);
    }
    public Payment createPayment(Payment contact){
        return paymentRepository.save(contact);
    }
}
