package se.plilja.modularjava.api.config.payment;

import java.util.List;

public interface PaymentApi {
    List<Payment> getPaymentsForCustomer(long customerId);
}
