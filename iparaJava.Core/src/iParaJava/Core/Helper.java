/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iParaJava.Core;
import iParaJava.Core.Response.ThreeDPaymentInitResponse;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Base64;

/**
 *
 * @author fcoskun
 */
public class Helper {
        private static final String  transactionDate = "transactionDate";
        private static final String version = "version";
        private static final String token = "token";
        private static final String Accept = "Accept";
        public static final String application_xml = "application/xml";
        public static final String application_json = "application/json";
    
        public static String GetTransactionDateString()
        {
            String pattern = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            return  simpleDateFormat.format(new Date());

        }
        public static String CreateToken(String publicKey, String hashString) throws Exception
        {
          try {  
            MessageDigest sha1 = MessageDigest.getInstance("SHA1");
            String hash= DatatypeConverter.printBase64Binary((sha1.digest(hashString.getBytes("UTF-8"))));
            return publicKey + ":" + hash;
        }
           catch (NoSuchAlgorithmException e) {
            throw new Exception("Hash cannot be generated");
        }
     
    }

        public static String ComputeHash( String hashString) throws Exception
        {
          MessageDigest sha1 = MessageDigest.getInstance("SHA1");
             return DatatypeConverter.printBase64Binary(sha1.digest(hashString.getBytes("UTF-8")));
       
        }
        
            public  static Map<String, String> GetHttpHeaders(Settings settings,String acceptType ) throws Exception {

                Map<String, String> headers = new HashMap<String, String>();
                headers.put(Accept,acceptType);
                headers.put(version,settings.Version);
                headers.put(token,CreateToken(settings.PublicKey,settings.HashString));
                headers.put(transactionDate,settings.transactionDate);
                return headers;
    }

            

        public static boolean Validate3DReturn(ThreeDPaymentInitResponse paymentResponse, Settings settings) throws Exception
        {
            if (paymentResponse.hash==null)
            {
                throw new Exception("Ödeme cevabı hash bilgisi boş. [result : " + paymentResponse.result + ",error_code : " + paymentResponse.errorCode + ",error_message : " + paymentResponse.errorMessage + "]");
            }
            String hashText = paymentResponse.orderId + paymentResponse.result + paymentResponse.amount + paymentResponse.mode + paymentResponse.errorCode +
     paymentResponse.errorMessage + paymentResponse.transactionDate + settings.PublicKey + settings.PrivateKey;
            String hashedText = Helper.ComputeHash(hashText);
            System.out.println(paymentResponse.hash);
            System.out.println(hashedText);
            if (!hashedText.equals(paymentResponse.hash))
            {
                throw new Exception("Ödeme cevabı hash doğrulaması hatalı. [result : " + paymentResponse.result + ",error_code : " + paymentResponse.errorCode + ",error_message : " + paymentResponse.errorMessage + "]");
            }
            return true;
        }
}
