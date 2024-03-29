package ipara.core.request;

import ipara.core.Constants;
import ipara.core.CoreRequest;
import ipara.core.Helper;
import ipara.core.RestHttpCaller;
import ipara.core.Settings;
import ipara.core.response.BinNumberInquiryResponse;

// Bin Sorgulama servisleri içerisinde kullanılacak olan bin numarasını temsil eder.
public class BinNumberInquiryRequest  extends CoreRequest{

    public String binNumber;
    public String amount ;
    public String threeD ="true";

	/*
	 *	Türkiye genelinde tanımlı olan tüm yerli kartlara ait BIN numaraları için sorgulama yapılmasına izin veren servisi temsil eder.
	 *	@request Istek olarak gelen bin numarasını temsil etmektedir.
	 *	@options Kullanıcıya özel olarak belirlenen ayarları temsil eder.		
	
	*/
    public static BinNumberInquiryResponse execute(BinNumberInquiryRequest request, Settings settings) throws Exception {

        settings.transactionDate = Helper.getTransactionDateString();
        settings.hashString = settings.privateKey
                + request.binNumber
                + settings.transactionDate;
        return RestHttpCaller.getInstance().postJson(settings.baseUrl + "rest/payment/bin/lookup/v2",
                Helper.getHttpHeaders(settings, Constants.ContentTypes.APPLICATION_JSON_UTF8),
                request, BinNumberInquiryResponse.class);

    }

}
