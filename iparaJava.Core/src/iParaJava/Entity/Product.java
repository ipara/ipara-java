/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iParaJava.Entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fcoskun
 */
@XmlRootElement(name="product")
public class Product {
        @XmlElement(name="productCode")
        public String Code ;

  @XmlElement(name="productName")
        public String Title ;
      
            @XmlElement(name="quantity")
        public String Quantity ;

       @XmlElement(name="price")
        public String Price ;
}
