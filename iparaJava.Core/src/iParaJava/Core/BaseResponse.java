package iParaJava.Core;

import com.google.gson.annotations.SerializedName;
import javax.xml.bind.annotation.XmlElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fcoskun
 */
  public class BaseResponse extends Base
    {
         @XmlElement(name="result")  
       
         public String result;
       
         @XmlElement(name="errorCode")  
        public String errorCode ;
       
         @XmlElement(name="errorMessage")  
        public String errorMessage ;

         @XmlElement(name="responseMessage")  
        public String responseMessage ;

        //XML Servisler için Gerekli
        
         @XmlElement(name="mode")  
       public String mode ;
       
         @XmlElement(name="echo")  
        public String echo ;
       
         @XmlElement(name="hash")  
        public String hash ;
       
         @XmlElement(name="transactionDate")  
        public String transactionDate ;

    }