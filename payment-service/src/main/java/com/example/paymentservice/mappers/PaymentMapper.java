package com.example.paymentservice.mappers;

import com.example.paymentservice.dto.PaymentDTO;
import com.example.paymentservice.models.Payment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PaymentMapper {
    Payment toPayment(PaymentDTO paymentDTO);
    PaymentDTO toDTO(Payment concert);
    List<PaymentDTO> listToDTO (List<Payment> payments);
}
