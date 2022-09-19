package se.plilja.modularjava.payment.payments;

import lombok.Data;
import se.plilja.modularjava.api.config.customer.Customer;
import se.plilja.modularjava.api.config.payment.PaymentMethod;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Table(name = "PAYMENT", schema = "PAYMENT")
@Entity
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "CUSTOMER_ID", nullable = false)
    private long customerId;

    @Column(name = "AMOUNT", nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "PAYMENT_METHOD", nullable = false)
    private PaymentMethod paymentMethod;

    @Column(name = "CREATED")
    private LocalDateTime created;
}
