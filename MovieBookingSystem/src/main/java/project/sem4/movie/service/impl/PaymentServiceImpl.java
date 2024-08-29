package project.sem4.movie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.sem4.movie.entities.Payments;
import project.sem4.movie.repository.PaymentRepository;
import project.sem4.movie.service.PaymentService;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payments> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payments getPaymentById(int paymentId) {
        Optional<Payments> optionalPayment = paymentRepository.findById(paymentId);
        return optionalPayment.orElse(null);
    }

    @Override
    public Payments pushPayment(Payments newPayment) {
        return paymentRepository.save(newPayment);
    }

    @Override
    public Payments updatePayment(Payments updatePayment, int paymentId) {
        Optional<Payments> optionalPayment = paymentRepository.findById(paymentId);
        if (optionalPayment.isPresent()) {
            Payments existingPayment = optionalPayment.get();
            existingPayment.setAmount(updatePayment.getAmount());
            existingPayment.setPaymentDate(updatePayment.getPaymentDate());
            // Update other attributes as needed

            return paymentRepository.save(existingPayment);
        }
        return null; // Payment with given ID not found
    }

    @Override
    public void deletePaymentById(int paymentId) {
        paymentRepository.deleteById(paymentId);
    }
}
