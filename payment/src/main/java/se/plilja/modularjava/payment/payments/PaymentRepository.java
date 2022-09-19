package se.plilja.modularjava.payment.payments;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends PagingAndSortingRepository<PaymentEntity, Long> {
    List<PaymentEntity> findPaymentByCustomerId(long customerId);
}
