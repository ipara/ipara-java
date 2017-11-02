package ipara.core.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ipara.core.CoreRequest;
import ipara.core.Helper;
import ipara.core.Settings;

@XmlRootElement(name = "auth")
public class ThreeDPaymentInitRequest extends CoreRequest{

    @XmlElement(name = "orderId")
    public String orderId;

    @XmlElement(name = "amount")
    public String amount;

    @XmlElement(name = "userId")
    public String userId;

    @XmlElement(name = "cardId")
    public String cardId;

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

    @XmlElement(name = "purchaserName")
    public String purchaserName;

    @XmlElement(name = "purchaserSurname")
    public String purchaserSurname;

    @XmlElement(name = "purchaserEmail")
    public String purchaserEmail;

    @XmlElement(name = "successUrl")
    public String successUrl;

    @XmlElement(name = "failUrl")
    public String failUrl;

    @XmlElement(name = "version")
    public String version;

    @XmlElement(name = "transactionDate")
    public String transactionDate;

    @XmlElement(name = "token")
    public String token;

    public static String createThreeDPaymentForm(ThreeDPaymentInitRequest request, Settings settings) {

        StringBuilder builder = new StringBuilder();
        builder.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">");
        builder.append("<html>");
        builder.append("<body>");
        builder.append("<form //action=\"" + settings.baseUrl + "\" method=\"post\" id=\"three_d_form\" >");
        builder.append("<input type=\"hidden\" name=\"orderId\" value=\"" + request.orderId + "\"/>");
        builder.append("<input type=\"hidden\" name=\"amount\" value=\"" + request.amount + "\"/>");
        builder.append("<input type=\"hidden\" name=\"cardOwnerName\" value=\"" + request.cardOwnerName + "\"/>");
        builder.append("<input type=\"hidden\" name=\"cardNumber\" value=\"" + request.cardNumber + "\"/>");
        builder.append("<input type=\"hidden\" name=\"userId\" value=\"" + request.userId + "\"/>");
        builder.append("<input type=\"hidden\" name=\"cardId\" value=\"" + request.cardId + "\"/>");
        builder.append("<input type=\"hidden\" name=\"cardExpireMonth\" value=\"" + request.cardExpireMonth + "\"/>");
        builder.append("<input type=\"hidden\" name=\"cardExpireYear\" value=\"" + request.cardExpireYear + "\"/>");
        builder.append("<input type=\"hidden\" name=\"installment\" value=\"" + request.installment + "\"/>");
        builder.append("<input type=\"hidden\" name=\"cardCvc\" value=\"" + request.cvc + "\"/>");
        builder.append("<input type=\"hidden\" name=\"mode\" value=\"" + request.mode + "\"/>");
        builder.append("<input type=\"hidden\" name=\"purchaserName\" value=\"" + request.purchaserName + "\"/>");
        builder.append("<input type=\"hidden\" name=\"purchaserSurname\" value=\"" + request.purchaserSurname + "\"/>");
        builder.append("<input type=\"hidden\" name=\"purchaserEmail\" value=\"" + request.purchaserEmail + "\"/>");
        builder.append("<input type=\"hidden\" name=\"successUrl\" value=\"" + request.successUrl + "\"/>");
        builder.append("<input type=\"hidden\" name=\"failureUrl\" value=\"" + request.failUrl + "\"/>");
        builder.append("<input type=\"hidden\" name=\"echo\" value=\"" + request.echo + "\"/>");
        builder.append("<input type=\"hidden\" name=\"version\" value=\"" + request.version + "\"/>");
        builder.append("<input type=\"hidden\" name=\"transactionDate\" value=\"" + request.transactionDate + "\"/>");
        builder.append("<input type=\"hidden\" name=\"token\" value=\"" + request.token + "\"/>");
        builder.append("<input type=\"submit\" value=\"Öde\" style=\"display:none;\"/>");
        builder.append("<noscript>");
        builder.append("<br/>");
        builder.append("<br/>");
        builder.append("<center>");
        builder.append("<h1>3D Secure Yönlendirme İşlemi</h1>");
        builder.append("<h2>Javascript internet tarayıcınızda kapatılmış veya desteklenmiyor.<br/></h2>");
        builder.append("<h3>Lütfen banka 3D Secure sayfasına yönlenmek için tıklayınız.</h3>");
        builder.append("<input type=\"submit\" value=\"3D Secure Sayfasına Yönlen\">");
        builder.append("</center>");
        builder.append("</noscript>");
        builder.append("</form>");
        builder.append("</body>");
        builder.append("<script>document.getElementById(\"three_d_form\").submit();</script>");
        builder.append("</html>");
        return builder.toString();

    }

    public static String execute(ThreeDPaymentInitRequest request, Settings settings) throws Exception {

        request.transactionDate = Helper.getTransactionDateString();
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
                + request.purchaserName
                + request.purchaserSurname
                + request.purchaserEmail
                + request.transactionDate;
        request.token = Helper.createToken(settings.publicKey, settings.hashString);
        return createThreeDPaymentForm(request, settings);

    }
}
