package se.plilja.modularjava.payment.payments;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import se.plilja.modularjava.api.config.customer.CustomerApi;
import se.plilja.modularjava.api.config.payment.Payment;
import se.plilja.modularjava.api.config.payment.PaymentCreatedEvent;
import se.plilja.modularjava.common.request.CommonRequestParams;
import se.plilja.modularjava.common.request.Paginated;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
class PaymentController {
    private final PaymentRepository paymentRepository;
    private final CustomerApi customerApi;
    private final PaymentConverter paymentConverter;
    private final ApplicationEventPublisher applicationEventPublisher;

    @GetMapping("")
    Paginated<Payment> getPayments(
            @RequestParam(CommonRequestParams.PAGE_NUMBER) int pageNumber,
            @RequestParam(CommonRequestParams.PAGE_SIZE) int pageSize
    ) {
        Page<PaymentEntity> pageEntities = paymentRepository.findAll(Pageable.ofSize(pageSize).withPage(pageNumber));
        Page<Payment> pagePayments = pageEntities.map(paymentConverter::fromEntity);
        return Paginated.fromPage(pagePayments);
    }

    @GetMapping("/{id}")
    Payment getPaymentById(@RequestParam("id") long id) {
        return paymentRepository.findById(id)
                .map(paymentConverter::fromEntity)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    Payment makePayment(@RequestBody Payment payment) {
        PaymentEntity newEntity = paymentConverter.toEntity(payment);
        verifyCustomerExists(newEntity.getCustomerId());
        newEntity.setCreated(LocalDateTime.now());
        PaymentEntity savedEntity = paymentRepository.save(newEntity);
        Payment result = paymentConverter.fromEntity(savedEntity);
        applicationEventPublisher.publishEvent(new PaymentCreatedEvent(this, result));
        return result;
    }

    private void verifyCustomerExists(long customerId) {
        try {
            customerApi.getCustomer(customerId);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer does not exist");
        }
    }

}
