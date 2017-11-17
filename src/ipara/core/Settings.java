package ipara.core;
/*
	Tüm çağrılarda kullanılacak ayarların tutulduğu sınıftır. 
	Bu sınıf üzerinde size özel parametreler fonksiyonlar arasında taşınabilir.
	Bu sınıf üzerinde tüm sistemde kullanacağımız ayarları tutar ve bunlara göre işlem yaparız.
	Bu sınıf örnek projemizde BaseController içerisinde kullanılmıştır. Ve tüm ayarların kullanılacağı yerde karşımıza çıkmaktadır.
*/

public class Settings {
	public String echo;
	public String publicKey;
	public String privateKey;
	public String baseUrl;
	public String mode;
	public String version;
	public String hashString;
	public String transactionDate;

}
