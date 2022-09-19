package se.plilja.modularjava.payment.payments;

import org.springframework.stereotype.Service;
import se.plilja.modularjava.api.config.payment.Payment;

@Service
public class PaymentConverter {
    public PaymentEntity toEntity(Payment payment) {
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setId(payment.getId());
        paymentEntity.setPaymentMethod(payment.getPaymentMethod());
        paymentEntity.setAmount(payment.getAmount());
        paymentEntity.setCustomerId(payment.getCustomerId());
        return paymentEntity;
    }

    public Payment fromEntity(PaymentEntity paymentEntity) {
        Payment payment = new Payment();
        payment.setId(paymentEntity.getId());
        payment.setPaymentMethod(paymentEntity.getPaymentMethod());
        payment.setAmount(paymentEntity.getAmount());
        payment.setCustomerId(paymentEntity.getCustomerId());
        return payment;
    }
}
