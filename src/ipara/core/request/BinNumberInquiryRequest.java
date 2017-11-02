package ipara.core.request;

import ipara.core.Constants;
import ipara.core.CoreRequest;
import ipara.core.Helper;
import ipara.core.RestHttpCaller;
import ipara.core.Settings;
import ipara.core.response.BinNumberInquiryResponse;

public class BinNumberInquiryRequest  extends CoreRequest{

    public String binNumber;

    public static BinNumberInquiryResponse execute(BinNumberInquiryRequest request, Settings settings) throws Exception {

        settings.transactionDate = Helper.getTransactionDateString();
        settings.hashString = settings.privateKey
                + request.binNumber
                + settings.transactionDate;
        return RestHttpCaller.getInstance().postJson(settings.baseUrl + "rest/payment/bin/lookup",
                Helper.getHttpHeaders(settings, Constants.ContentTypes.APPLICATION_JSON_UTF8),
                request, BinNumberInquiryResponse.class);

    }

}
