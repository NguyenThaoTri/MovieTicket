package project.sem4.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.sem4.movie.entities.Payments;
import project.sem4.movie.service.PaymentService;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentRestController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentRestController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public ResponseEntity<List<Payments>> getAllPayments() {
        List<Payments> payments = paymentService.getAllPayments();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<Payments> getPaymentById(@PathVariable int paymentId) {
        Payments payment = paymentService.getPaymentById(paymentId);
        if (payment != null) {
            return new ResponseEntity<>(payment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Payments> createPayment(@RequestBody Payments newPayment) {
        Payments createdPayment = paymentService.pushPayment(newPayment);
        return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
    }

    @PutMapping("/{paymentId}")
    public ResponseEntity<Payments> updatePayment(
            @RequestBody Payments updatePayment,
            @PathVariable int paymentId
    ) {
        Payments updatedPayment = paymentService.updatePayment(updatePayment, paymentId);
        if (updatedPayment != null) {
            return new ResponseEntity<>(updatedPayment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{paymentId}")
    public ResponseEntity<Void> deletePaymentById(@PathVariable int paymentId) {
        paymentService.deletePaymentById(paymentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
