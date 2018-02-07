package ipara.core;

import ipara.core.request.ThreeDPaymentInitRequest;

/*
	Tüm çağrılarda kullanılacak ayarların tutulduğu sınıftır. 
	Bu sınıf üzerinde size özel parametreler fonksiyonlar arasında taşınabilir.
	Bu sınıf üzerinde tüm sistemde kullanacağımız ayarları tutar ve bunlara göre işlem yaparız.
	Bu sınıf örnek projemizde BaseController içerisinde kullanılmıştır. Ve tüm ayarların kullanılacağı yerde karşımıza çıkmaktadır.
*/


public class Settings {
	
	public String echo;
	public String publicKey  = "3X2TECC0KO81PKG"; //"Public Magaza Anahtarı - size mağaza başvurunuz sonucunda gönderilen publik key (açık anahtar) bilgisini kullanınız.",;
	public String privateKey  = "3X2TECC0KO81PKGZTKCSO2ANJ"; //"Private Magaza Anahtarı  - size mağaza başvurunuz sonucunda gönderilen privaye key (gizli anahtar) bilgisini kullanınız.",;
	public String baseUrl = "https://api.ipara.com/"; //"iPara web servisleri API url'lerinin başlangıç bilgisidir. Restful web servis isteklerini takip eden kodlar halinde bulacaksınız."
													  // Örneğin "https://api.ipara.com/" + "/rest/payment/auth"  = "https://api.ipara.com/rest/payment/auth";
	/**
	 * @see ThreeDPaymentInitRequest#createThreeDPaymentForm(ThreeDPaymentInitRequest, Settings)
	 */	
	public String threeDInquiryUrl = "https://www.ipara.com/3dgate"; //3D ödemelerde ödeme öncesi güvenlik sorgulaması için kullanılan URL'dir
	public String mode = "T"; // "Test -> T, entegrasyon testlerinin sırasında "T" modunu, canlı sisteme entegre olarak ödeme almaya başlamak için ise Prod -> "P" modunu kullanınız."
	public String version = "1.0";// "Kullandığınız iPara API versiyonudur. "
	public String hashString = ""; // "Kullanacağınız hash bilgisini, bağlanmak istediğiniz web servis bilgisine göre doldurulmalıdır. Bu bilgileri Entegrasyon rehberinin ilgili web servise ait bölümde bulabilirsiniz."
	/**
	 * @see Helper#getTransactionDateString()
	 */
	public String transactionDate; //transaction'in yapıldığı tarihi belirtir. Helper#getTransactionDate()
}
