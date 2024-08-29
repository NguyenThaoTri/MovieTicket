/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package project.sem4.movie.service;

import java.util.List;
import project.sem4.movie.entities.Payments;

/**
 *
 * @author NTT
 */
public interface PaymentService {
    List<Payments> getAllPayments();
    
    Payments getPaymentById(int payment_id);
    
    Payments pushPayment(Payments newPayment);
    
    Payments updatePayment(Payments updatePayment, int payment_id);
    
    void deletePaymentById(int payment_id);
}
