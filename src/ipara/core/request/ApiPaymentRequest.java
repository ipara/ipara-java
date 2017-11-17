package ipara.core.request;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import ipara.core.Constants;
import ipara.core.CoreRequest;
import ipara.core.Helper;
import ipara.core.RestHttpCaller;
import ipara.core.Settings;
import ipara.core.entity.Product;
import ipara.core.entity.Purchaser;
import ipara.core.response.ApiPaymentResponse;

//3D Secure Olmadan Ödeme için gerekli olan servis girdi parametrelerini temsil eder.
@XmlRootElement(name = "auth")
public class ApiPaymentRequest extends CoreRequest {

	@XmlElement(name = "threeD")
	public String threeD;

	@XmlElement(name = "orderId")
	public String orderId;

	@XmlElement(name = "amount")
	public String amount;

	@XmlElement(name = "cardOwnerName")
	public String cardOwnerName;

	@XmlElement(name = "cardNumber")
	public String cardNumber;

	@XmlElement(name = "cardExpireMonth")
	public String cardExpireMonth;

	@XmlElement(name = "cardExpireYear")
	public String cardExpireYear;

	@XmlElement(name = "installment")
	public String installment;

	@XmlElement(name = "cardCvc")
	public String cvc;

	@XmlElement(name = "vendorId")
	public String vendorId;

	@XmlElement(name = "userId")
	public String userId;

	@XmlElement(name = "cardId")
	public String cardId;

	@XmlElement(name = "threeDSecureCode")
	public String threeDSecureCode;

	@XmlElementWrapper(name = "products")
	public List<Product> products;

	@XmlElement(name = "purchaser")
	public Purchaser purchaser;

	/*
	 *	3D Secure Olmadan Ödeme Servis çağrısını temsil eder.
	 *	@request 3D Secure olmadan gerekli olan servis girdi parametrelerini temsil eder.
	 *	@options Kullanıcıya özel olarak belirlenen ayarları temsil eder.
	*/
	public static ApiPaymentResponse execute(ApiPaymentRequest request, Settings settings) throws Exception {
		settings.transactionDate = Helper.getTransactionDateString();
		settings.hashString = settings.privateKey
				+ request.orderId
				+ request.amount
				+ request.mode
				+ request.cardOwnerName
				+ request.cardNumber
				+ request.cardExpireMonth
				+ request.cardExpireYear
				+ request.cvc
				+ request.userId
				+ request.cardId
				+ request.purchaser.name
				+ request.purchaser.surname
				+ request.purchaser.email
				+ settings.transactionDate;
		return RestHttpCaller.getInstance().postXML(settings.baseUrl + "rest/payment/auth",
				Helper.getHttpHeaders(settings, Constants.ContentTypes.APPLICATION_XML_UTF8), request,
				ApiPaymentResponse.class);
	}

}
