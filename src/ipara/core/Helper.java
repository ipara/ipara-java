package ipara.core;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import ipara.core.response.ThreeDPaymentInitResponse;

import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import javax.xml.bind.JAXB;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;

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
 
    public static String xmlFormatter(String xml) {

        try {
            final InputSource src = new InputSource(new StringReader(xml));
            final Node document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(src).getDocumentElement();
            final Boolean keepDeclaration = Boolean.valueOf(xml.startsWith("<?xml"));

        //May need this: System.setProperty(DOMImplementationRegistry.PROPERTY,"com.sun.org.apache.xerces.internal.dom.DOMImplementationSourceImpl");


            final DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
            final DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
            final LSSerializer writer = impl.createLSSerializer();

            writer.getDomConfig().setParameter("format-pretty-print", Boolean.TRUE); // Set this to true if the output needs to be beautified.
            writer.getDomConfig().setParameter("xml-declaration", keepDeclaration); // Set this to true if the declaration is needed to be outputted.

            return writer.writeToString(document);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
}
    
   public static  String prettyPrintXml(String xmlString)  throws Exception  {

     try 
        {  
            xmlString=xmlFormatter(xmlString);
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
        DocumentBuilder builder;  
        Document doc ;
        
            builder = factory.newDocumentBuilder();  
             doc = builder.parse( new InputSource( new StringReader( xmlString )) ); 

       
        Transformer tf = TransformerFactory.newInstance().newTransformer();
       
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
          tf.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
      
        Writer out = new StringWriter();
        tf.transform(new DOMSource(doc), new StreamResult(out));
         return out.toString().replace("<", "&lt;");
       } catch (Exception e) {  
            e.printStackTrace();  
            return null;
        } 
    }


