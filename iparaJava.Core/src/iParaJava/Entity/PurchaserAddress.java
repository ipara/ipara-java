/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iParaJava.Entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 *
 * @author fcoskun
 */
public class PurchaserAddress {
       
        @XmlElement(name="name")
        public String Name ;

        
        @XmlElement(name="surname")
        public String SurName ;

          
        @XmlElement(name="address")
        public String Address ;

          @XmlElement(name="zipcode")
        public String ZipCode ;

          @XmlElement(name="city")        
        public String CityCode ;
                
          @XmlElement(name="tcCertificate")
        public String IdentityNumber ;

          @XmlElement(name="country")
        public String CountryCode ;
        
          @XmlElement(name="taxNumber")
        public String TaxNumber ;
               
          @XmlElement(name="taxOffice")
        public String TaxOffice ;
        
          @XmlElement(name="companyName")
        public String CompanyName ;

          @XmlElement(name="phoneNumber")
        public String PhoneNumber ;
}
