/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iParaJava.Core.Request;

import iParaJava.Core.*;
import iParaJava.Core.Response.PaymentInquiryResponse;
import javax.xml.bind.annotation.*;

/**
 *
 * @author fcoskun
 */

  @XmlRootElement(name= "inquiry")
public class PaymentInquiryRequest extends BaseRequest {
        @XmlElement(name="orderId")
        public String orderId ;

       public static PaymentInquiryResponse Execute(PaymentInquiryRequest request, Settings settings) throws Exception
        {

            settings.transactionDate = Helper.GetTransactionDateString();
            settings.HashString = settings.PrivateKey + request.orderId +settings.Mode + settings.transactionDate;
            return RestHttpCaller.Create().PostXML(settings.BaseUrl + "rest/payment/inquiry", Helper.GetHttpHeaders(settings, Helper.application_xml), request,PaymentInquiryResponse.class);
        }
}
