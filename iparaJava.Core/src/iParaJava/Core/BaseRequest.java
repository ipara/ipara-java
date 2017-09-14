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
 public class BaseRequest extends Base
    {
       
       @SerializedName("echo")  
          public String echo;
       
       @SerializedName("mode")  
        public String mode ;
    }