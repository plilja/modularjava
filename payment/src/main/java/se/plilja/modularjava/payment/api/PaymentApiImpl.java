package se.plilja.modularjava.payment.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.plilja.modularjava.api.config.payment.Payment;
import se.plilja.modularjava.api.config.payment.PaymentApi;
import se.plilja.modularjava.payment.payments.PaymentConverter;
import se.plilja.modularjava.payment.payments.PaymentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentApiImpl implements PaymentApi {
    private final PaymentRepository paymentRepository;
    private final PaymentConverter paymentConverter;

    @Override
    public List<Payment> getPaymentsForCustomer(long customerId) {
        return paymentRepository.findPaymentByCustomerId(customerId).stream()
                .map(paymentConverter::fromEntity)
                .toList();
    }
}
