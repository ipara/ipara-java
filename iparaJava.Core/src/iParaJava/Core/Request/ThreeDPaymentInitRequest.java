/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iParaJava.Core.Request;

import iParaJava.Core.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author fcoskun
 */
 @XmlRootElement(name= "auth")
    public class ThreeDPaymentInitRequest extends BaseRequest
    {

          @XmlElement(name="orderId")
        public String OrderId ;

          @XmlElement(name="amount")
        public String Amount ;
          @XmlElement(name="userId")
        public String UserId ;
          @XmlElement(name="cardId")
        public String CardId ;

          @XmlElement(name="cardOwnerName")
        public String CardOwnerName ;

          @XmlElement(name="cardNumber")
        public String CardNumber ;

          @XmlElement(name="cardExpireMonth")
        public String CardExpireMonth ;

          @XmlElement(name="cardExpireYear")
        public String CardExpireYear ;

          @XmlElement(name="installment")
        public String Installment ;

          @XmlElement(name="cardCvc")
        public String Cvc ;

          @XmlElement(name="purchaserName")
        public String PurchaserName ;

          @XmlElement(name="purchaserSurname")
        public String PurchaserSurname ;


          @XmlElement(name="purchaserEmail")
        public String PurchaserEmail ;
          @XmlElement(name="successUrl")
        public String SuccessUrl ;
          @XmlElement(name="failUrl")
        public String FailUrl ;


          @XmlElement(name="version")
        public String Version ;
          @XmlElement(name="transactionDate")
        public String TransactionDate ;
          @XmlElement(name="token")
        public String Token ;

        public static String CreateThreeDPaymentForm(ThreeDPaymentInitRequest request, Settings options)
        {
            StringBuilder builder = new StringBuilder();

            builder.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">");
            builder.append("<html>");
            builder.append("<body>");
            builder.append("<form //action=\"" + options.BaseUrl + "\" method=\"post\" id=\"three_d_form\" >");
            builder.append("<input type=\"hidden\" name=\"orderId\" value=\"" + request.OrderId + "\"/>");
            builder.append("<input type=\"hidden\" name=\"amount\" value=\"" + request.Amount + "\"/>");
            builder.append("<input type=\"hidden\" name=\"cardOwnerName\" value=\"" + request.CardOwnerName + "\"/>");
            builder.append("<input type=\"hidden\" name=\"cardNumber\" value=\"" + request.CardNumber + "\"/>");
            builder.append("<input type=\"hidden\" name=\"userId\" value=\"" + request.UserId + "\"/>");
            builder.append("<input type=\"hidden\" name=\"cardId\" value=\"" + request.CardId + "\"/>");
            builder.append("<input type=\"hidden\" name=\"cardExpireMonth\" value=\"" + request.CardExpireMonth + "\"/>");
            builder.append("<input type=\"hidden\" name=\"cardExpireYear\" value=\"" + request.CardExpireYear + "\"/>");
            builder.append("<input type=\"hidden\" name=\"installment\" value=\"" + request.Installment + "\"/>");
            builder.append("<input type=\"hidden\" name=\"cardCvc\" value=\"" + request.Cvc + "\"/>");
            builder.append("<input type=\"hidden\" name=\"mode\" value=\"" + request.mode + "\"/>");
            builder.append("<input type=\"hidden\" name=\"purchaserName\" value=\"" + request.PurchaserName + "\"/>");
            builder.append("<input type=\"hidden\" name=\"purchaserSurname\" value=\"" + request.PurchaserSurname + "\"/>");
            builder.append("<input type=\"hidden\" name=\"purchaserEmail\" value=\"" + request.PurchaserEmail + "\"/>");
            builder.append("<input type=\"hidden\" name=\"successUrl\" value=\"" + request.SuccessUrl + "\"/>");
            builder.append("<input type=\"hidden\" name=\"failureUrl\" value=\"" + request.FailUrl + "\"/>");
            builder.append("<input type=\"hidden\" name=\"echo\" value=\"" + request.echo + "\"/>");
            builder.append("<input type=\"hidden\" name=\"version\" value=\"" + request.Version + "\"/>");
            builder.append("<input type=\"hidden\" name=\"transactionDate\" value=\"" + request.TransactionDate + "\"/>");
            builder.append("<input type=\"hidden\" name=\"token\" value=\"" + request.Token + "\"/>");
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
        public static String Execute(ThreeDPaymentInitRequest request, Settings settings) throws Exception
        {
            request.TransactionDate = Helper.GetTransactionDateString();
            settings.HashString = settings.PrivateKey + request.OrderId + request.Amount + request.mode + request.CardOwnerName + request.CardNumber + request.CardExpireMonth + request.CardExpireYear + request.Cvc + request.UserId + request.CardId + request.PurchaserName + request.PurchaserSurname + request.PurchaserEmail + request.TransactionDate;
            request.Token = Helper.CreateToken(settings.PublicKey, settings.HashString);
            return CreateThreeDPaymentForm(request, settings);
        }
    }