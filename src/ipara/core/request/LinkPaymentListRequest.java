package ipara.core.request;

import ipara.core.*;
import ipara.core.response.LinkPaymentCreateResponse;
import ipara.core.response.LinkPaymentListResponse;

import java.util.List;

public class LinkPaymentListRequest extends CoreRequest {

    public String email;
    public String gsm;
    public String linkState;
    public String startDate;
    public String endDate;
    public String pageSize;
    public String pageIndex;
    public String clientIp;

    /*
     *	Link ile Ödeme Link Listeleme Servis çağrısını temsil eder.
     *	@request Link ile Ödeme Link Listeleme gerekli olan servis girdi parametrelerini temsil eder.
     *	@options Kullanıcıya özel olarak belirlenen ayarları temsil eder.
     */

    public static LinkPaymentListResponse execute(LinkPaymentListRequest request, Settings settings) throws Exception {

        settings.transactionDate = Helper.getTransactionDateString();
        settings.hashString = settings.privateKey
                +request.clientIp
                +settings.transactionDate;
        return RestHttpCaller.getInstance().postJson(settings.baseUrl + "corporate/merchant/linkpayment/list",
                Helper.getHttpHeaders(settings, Constants.ContentTypes.APPLICATION_JSON_UTF8),
                request, LinkPaymentListResponse.class);

    }
}
