package ipara.core.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ipara.core.CoreResponse;

@XmlRootElement(name = "authResponse")
public class ThreeDPaymentCompleteResponse extends CoreResponse {

	@XmlElement(name = "amount")
	public String amount;

	@XmlElement(name = "orderId")
	public String orderId;

}
