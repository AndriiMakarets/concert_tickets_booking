package com.example.paymentservice.mappers;

import com.example.paymentservice.dto.PaymentDTO;
import com.example.paymentservice.models.Payment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaymentMapperImpl implements PaymentMapper {
    @Override
    public Payment toPayment(PaymentDTO paymentDTO) {
        return null;
    }

    @Override
    public PaymentDTO toDTO(Payment payment) {
        return null;
    }

    @Override
    public List<PaymentDTO> listToDTO(List<Payment> payments) {
        return null;
    }
}
