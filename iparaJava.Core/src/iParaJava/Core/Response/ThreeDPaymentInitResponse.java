/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iParaJava.Core.Response;

import iParaJava.Core.BaseResponse;
import javax.xml.bind.annotation.*;

/**
 *
 * @author fcoskun
 */
 @XmlRootElement(name= "authResponse")
public class ThreeDPaymentInitResponse extends BaseResponse {
    
       @XmlElement(name="amount")
        public String amount ;
@XmlElement(name="orderId")
        public String orderId ;
}
