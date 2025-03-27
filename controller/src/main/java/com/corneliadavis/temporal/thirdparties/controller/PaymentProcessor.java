package com.corneliadavis.temporal.thirdparties.controller;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class PaymentProcessor {

    private static final Logger logger = LoggerFactory.getLogger(PaymentProcessor.class);

    // Simulate various error conditions
    boolean isPaymentRejected = false; // Replace with actual logic
    boolean isTooManyRequests = false; // Replace with actual logic
    boolean isTimeout = false; // Replace with actual logic
    boolean isInternalError = false; // Replace with actual logic

    @RequestMapping(method = RequestMethod.POST, value = "/processpayment")
    public ResponseEntity<?> processPayment(@RequestBody PaymentProcessingInput paymentInput,
            HttpServletResponse response) {

        try {
            logger.info("processing payment for " + paymentInput.getName());

            if (isPaymentRejected) {
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Payment rejected");
            } else if (isTooManyRequests) {
                return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("Too many requests");
            } else if (isTimeout) {
                return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body("Request timed out");
            } else if (isInternalError) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
            }

            // If successful
            PaymentProcessingResult result = new PaymentProcessingResult(
                    paymentInput.getName(),
                    paymentInput.getOrderNumber());
            return ResponseEntity.ok(result);

        } catch (Exception e) {
            logger.error("Internal server error while processing payment", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/setstatus")
    public ResponseEntity<?> setStatus(@RequestParam boolean clearErrors) {
        if (clearErrors) {
            isPaymentRejected = false;
            isTooManyRequests = false;
            isTimeout = false;
            isInternalError = false;
            logger.info("All error conditions cleared.");
        } else {
            Random random = new Random();
            int errorCondition = random.nextInt(4);
            isPaymentRejected = errorCondition == 0;
            isTooManyRequests = errorCondition == 1;
            isTimeout = errorCondition == 2;
            isInternalError = errorCondition == 3;
            logger.info("Random error condition set.");
        }
        return ResponseEntity.ok("Status updated successfully.");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/haserrors")
    public ResponseEntity<Boolean> hasErrors() {
        boolean hasErrors = isPaymentRejected || isTooManyRequests || isTimeout || isInternalError;
        logger.info("Error status checked: " + hasErrors);
        return ResponseEntity.ok(hasErrors);
    }

}
