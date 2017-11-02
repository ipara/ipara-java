package ipara.core.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ipara.core.CoreResponse;

@XmlRootElement(name = "inquiryResponse")
public class PaymentInquiryResponse extends CoreResponse {

	@XmlElement(name = "amount")
	public String amount;

	@XmlElement(name = "orderId")
	public String orderId;

}
