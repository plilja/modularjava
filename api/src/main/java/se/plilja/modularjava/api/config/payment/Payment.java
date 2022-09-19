package se.plilja.modularjava.api.config.payment;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
public class Payment {
    private Long id;
    private long customerId;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
}
