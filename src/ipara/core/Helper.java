package ipara.core;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import ipara.core.response.ThreeDPaymentInitResponse;

public class Helper {	

    public static String getTransactionDateString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(new Date());
    }

    public static String createToken(String publicKey, String hashString) throws Exception {
        try {
            MessageDigest sha1 = MessageDigest.getInstance(Constants.Formats.SHA1);
            String hash = DatatypeConverter.printBase64Binary((sha1.digest(hashString.getBytes(Constants.Formats.UTF8))));
            return publicKey + ":" + hash;
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("Hash cannot be generated");
        }
    }

    public static String computeHash(String hashString) throws Exception {
        MessageDigest sha1 = MessageDigest.getInstance(Constants.Formats.SHA1);
        return DatatypeConverter.printBase64Binary(sha1.digest(hashString.getBytes(Constants.Formats.UTF8)));
    }

    public static Map<String, String> getHttpHeaders(Settings settings, String acceptType) throws Exception {
        Map<String, String> headers = new HashMap<>();
        headers.put(Constants.StandardHTTPHeaders.ACCEPT, acceptType);
        headers.put(Constants.IparaHTTPHeaders.TOKEN, settings.version);
        headers.put(Constants.IparaHTTPHeaders.TOKEN, createToken(settings.publicKey, settings.hashString));
        headers.put(Constants.IparaHTTPHeaders.TRANSACTION_DATE, settings.transactionDate);
        return headers;
    }

    public static boolean validate3DReturn(ThreeDPaymentInitResponse paymentResponse, Settings settings) throws Exception {
        if (paymentResponse.hash == null) {
            throw new Exception("Ödeme cevabı hash bilgisi boş. [result : " + paymentResponse.result + ",error_code : " + paymentResponse.errorCode + ",error_message : " + paymentResponse.errorMessage + "]");
        }
        String hashText = paymentResponse.orderId
                + paymentResponse.result
                + paymentResponse.amount
                + paymentResponse.mode
                + paymentResponse.errorCode
                + paymentResponse.errorMessage
                + paymentResponse.transactionDate
                + settings.publicKey
                + settings.privateKey;
        String hashedText = computeHash(hashText);
        System.out.println(paymentResponse.hash);
        System.out.println(hashedText);
        if (!hashedText.equals(paymentResponse.hash)) {
            throw new Exception("Ödeme cevabı hash doğrulaması hatalı. [result : " + paymentResponse.result + ",error_code : " + paymentResponse.errorCode + ",error_message : " + paymentResponse.errorMessage + "]");
        }
        return true;
    }

}
