package se.plilja.modularjava.customer.customers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import se.plilja.modularjava.api.config.payment.PaymentCreatedEvent;

@Slf4j
@Service
class CustomerPaymentListener implements ApplicationListener<PaymentCreatedEvent> {
    @Override
    public void onApplicationEvent(PaymentCreatedEvent event) {
        /*
        No real logic here. Just showcasing how messages can be sent between modules of the system.
         */
        log.info("Payment received for [customerId={}]", event.getPayment().getCustomerId());
    }
}
