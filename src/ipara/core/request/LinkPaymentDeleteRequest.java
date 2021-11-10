package ipara.core.request;

import ipara.core.*;
import ipara.core.response.LinkPaymentCreateResponse;
import ipara.core.response.LinkPaymentDeleteResponse;

public class LinkPaymentDeleteRequest extends CoreRequest {
    public String linkId;
    public String clientIp;

    /*
     *	Link ile Ödeme Link Silme Servis çağrısını temsil eder.
     *	@request Link ile Ödeme Link Silme gerekli olan servis girdi parametrelerini temsil eder.
     *	@options Kullanıcıya özel olarak belirlenen ayarları temsil eder.
     */

    public static LinkPaymentDeleteResponse execute(LinkPaymentDeleteRequest request, Settings settings) throws Exception {

        settings.transactionDate = Helper.getTransactionDateString();
        settings.hashString = settings.privateKey
                +request.clientIp
                +settings.transactionDate;
        return RestHttpCaller.getInstance().postJson(settings.baseUrl + "corporate/merchant/linkpayment/delete",
                Helper.getHttpHeaders(settings, Constants.ContentTypes.APPLICATION_JSON_UTF8),
                request, LinkPaymentDeleteResponse.class);

    }
}
