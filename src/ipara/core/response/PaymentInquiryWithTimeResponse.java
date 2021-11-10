package ipara.core.response;

import ipara.core.CoreResponse;

import java.util.List;

public class PaymentInquiryWithTimeResponse extends CoreResponse {
    private List<Payment> payments;
    private String totalPayments;

}
