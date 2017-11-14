package ipara.core.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ipara.core.CoreResponse;

// 3D secure 1. Adımı sonucunda oluşan servis çıktı parametrelerini temsil etmektedir.
@XmlRootElement(name = "authResponse")
public class ThreeDPaymentInitResponse extends CoreResponse{

	@XmlElement(name = "amount")
	public String amount;

	@XmlElement(name = "orderId")
	public String orderId;

}
