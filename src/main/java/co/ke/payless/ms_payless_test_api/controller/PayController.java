package co.ke.payless.ms_payless_test_api.controller;


import co.ke.payless.ms_payless_test_api.model.PayRequest;
import co.ke.payless.ms_payless_test_api.model.PayResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payments")
public class PayController {
    @PostMapping(value = "/transaction", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PayResponse makePayment(@RequestBody PayRequest payRequest) {
        return new PayResponse(200, "Payment successful for " );
    }

    @PostMapping(value = "/bills", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PayResponse makeBill(@RequestBody PayRequest payRequest) {
        return new PayResponse(200, "Payment successful for " );
    }
}
