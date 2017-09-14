/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iParaJava.Core.Request;

import iParaJava.Core.Helper;
import iParaJava.Core.Response.ThreeDPaymentCompleteResponse;
import iParaJava.Core.*;
import iParaJava.Entity.*;
import java.util.List;
import javax.xml.bind.annotation.*;

/**
 *
 * @author fcoskun
 */
 @XmlRootElement( name="auth")
    public class ThreeDPaymentCompleteRequest extends BaseRequest
    {

          @XmlElement(name="threeD")
        public String ThreeD;

          @XmlElement(name="orderId")
        public String OrderId;

          @XmlElement(name="amount")
        public String Amount;


          @XmlElement(name="cardOwnerName")
        public String CardOwnerName;

          @XmlElement(name="cardNumber")
        public String CardNumber;

          @XmlElement(name="cardExpireMonth")
        public String CardExpireMonth;

          @XmlElement(name="cardExpireYear")
        public String CardExpireYear;

          @XmlElement(name="installment")
        public String Installment;

          @XmlElement(name="cardCvc")
        public String Cvc;


          @XmlElement(name="vendorId")
        public String VendorId;
          @XmlElement(name="userId")
        public String UserId;
          @XmlElement(name="cardId")
        public String CardId;

          @XmlElement(name="threeDSecureCode")
        public String ThreeDSecureCode;

       @XmlElementWrapper(name="products")
        public List<Product> product;

          @XmlElement(name="purchaser")
        public Purchaser Purchaser;
          
          
        public static ThreeDPaymentCompleteResponse Execute(ThreeDPaymentCompleteRequest request, Settings settings) throws Exception
        {
            settings.transactionDate = Helper.GetTransactionDateString();
            settings.HashString = settings.PrivateKey + request.OrderId + request.Amount + request.mode + request.ThreeDSecureCode + settings.transactionDate;
            return RestHttpCaller.Create().PostXML(settings.BaseUrl + "rest/payment/auth", Helper.GetHttpHeaders(settings, Helper.application_xml), request,ThreeDPaymentCompleteResponse.class);
        }
    }