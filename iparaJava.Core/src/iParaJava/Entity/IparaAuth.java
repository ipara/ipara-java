/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iParaJava.Entity;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;



/**
 *
 * @author fcoskun
 */

@XmlRootElement(name="auth")
public class IparaAuth{ 
              
           @XmlElement(name="threeD")
        public String ThreeD ;

            @XmlElement(name="orderId")
        public String OrderId ;

            @XmlElement(name="amount")
        public String Amount ;
      
            @XmlElement(name="echo")
        public String Echo ;

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

            @XmlElement(name="mode")
        public String Mode ;

            @XmlElement(name="vendorId")
        public String VendorId ;

            @XmlElement(name="threeDSecureCode")
        public String ThreeDSecureCode ;
  
             @XmlElementWrapper             
        @XmlElement(name="products")
        public ArrayList<Product> Product ;

            @XmlElement(name="purchaser")
        public Purchaser Purchaser ;
}
