package co.ke.payless.ms_payless_test_api.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PayRequest {
    private Double amount;
    private String nonce;
}
