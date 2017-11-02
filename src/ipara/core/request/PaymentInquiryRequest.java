package ipara.core.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ipara.core.Constants;
import ipara.core.CoreRequest;
import ipara.core.Helper;
import ipara.core.RestHttpCaller;
import ipara.core.Settings;
import ipara.core.response.PaymentInquiryResponse;

@XmlRootElement(name = "inquiry")
public class PaymentInquiryRequest  extends CoreRequest{

	@XmlElement(name = "orderId")
	public String orderId;

	public static PaymentInquiryResponse execute(PaymentInquiryRequest request, Settings settings) throws Exception {

		settings.transactionDate = Helper.getTransactionDateString();
		settings.hashString = settings.privateKey + request.orderId + settings.mode + settings.transactionDate;
		return RestHttpCaller.getInstance().postXML(settings.baseUrl + "rest/payment/inquiry",
				Helper.getHttpHeaders(settings, Constants.ContentTypes.APPLICATION_XML_UTF8), request,
				PaymentInquiryResponse.class);

	}

}
