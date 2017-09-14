/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iParaJava.Entity;

import javax.xml.bind.annotation.*;

/**
 *
 * @author fcoskun
 */
@XmlRootElement(name="purchaser")
public class Purchaser {
         @XmlElement(name="name")
        public String Name ;

          @XmlElement(name="surname")
        public String SurName ;

          @XmlElement(name="birthDate")
        public String BirthDate ;

          @XmlElement(name="email")
        public String Email ;

          @XmlElement(name="gsmNumber")
        public String GsmPhone ;

          @XmlElement(name="tcCertificate")
        public String IdentityNumber ;

          @XmlElement(name="clientIp")
        public String ClientIp ;

          @XmlElement(name="invoiceAddress")
        public PurchaserAddress InvoiceAddress ;

          @XmlElement(name="shippingAddress")
        public PurchaserAddress ShippingAddress ;

                
}
