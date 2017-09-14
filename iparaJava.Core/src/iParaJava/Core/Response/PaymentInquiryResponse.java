/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iParaJava.Core.Response;

import iParaJava.Core.BaseResponse;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fcoskun
 */

  @XmlRootElement(name= "inquiryResponse")
public class PaymentInquiryResponse extends BaseResponse {
    
    
         @XmlElement(name="amount")
        public String amount ;
@XmlElement(name="orderId")
        public String orderId ;
      

}
