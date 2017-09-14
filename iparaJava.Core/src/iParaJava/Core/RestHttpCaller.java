/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iParaJava.Core;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Map;
import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.*;

/**
 *
 * @author fcoskun
 */

public class RestHttpCaller {
    
        public static RestHttpCaller Create() {
        return new RestHttpCaller();
    }
  
        public <T> T PostJson(String url, Map<String, String> headers, Object request, Class<T> responseType) {
           Gson gson = new Gson();
        String body = gson.toJson(request);
        try {
            String response = send(url, new ByteArrayInputStream(body.getBytes("UTF-8")), headers,Helper.application_json);
          
            return gson.fromJson(response, responseType);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
        
      public <T> T PostXML(String url, Map<String, String> headers, Object request, Class<T> responseType) {
        StringWriter sw = new StringWriter();
         JAXB.marshal(request, sw);
         String xmlString = sw.toString();
         String body= sw.toString();
          
        try {
            String response = send(url, new ByteArrayInputStream(body.getBytes("UTF-8")), headers,Helper.application_xml);
        return JAXB.unmarshal(new StringReader(response), responseType);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

  
                  
     private String send(String url,  InputStream content, Map<String, String> headers,String appType) {
        URLConnection raw;
        HttpURLConnection conn = null;
        try {
            raw = new URL(url).openConnection();
            conn = HttpURLConnection.class.cast(raw);

            conn.setRequestMethod("POST");

            conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);
            conn.setUseCaches(false);
            conn.setInstanceFollowRedirects(false);

             for (Map.Entry<String, String> header : headers.entrySet()) {
                 conn.addRequestProperty(header.getKey(), header.getValue());
             }
             conn.addRequestProperty("Content-Type", appType);
             prepareRequestBody(content, conn);
             return new String(body(conn), Charset.forName("UTF-8"));
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        } 
        finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }
     
         private void prepareRequestBody( InputStream content, HttpURLConnection conn) throws IOException {
        
            conn.setDoOutput(true);
            final OutputStream output = conn.getOutputStream();
            try {
                prepareOutputStream(content, output);
            } finally {
                output.close();
                content.close();
            }
        
    }
         
          private void prepareOutputStream(InputStream content, OutputStream output) throws IOException {
        final byte[] buffer = new byte[8192];
        for (int bytes = content.read(buffer); bytes != -1;
             bytes = content.read(buffer)) {
            output.write(buffer, 0, bytes);
        }
    }

                  
     private byte[] body(HttpURLConnection conn) throws IOException {
        final InputStream input;
        if (conn.getResponseCode() >= HttpURLConnection.HTTP_BAD_REQUEST) {
            input = conn.getErrorStream();
        } else {
            input = conn.getInputStream();
        }
        final byte[] body;
        if (input == null) {
            body = new byte[0];
        } else {
            try {

                final byte[] buffer = new byte[8192];
                final ByteArrayOutputStream output = new ByteArrayOutputStream();
                for (int bytes = input.read(buffer); bytes != -1;
                     bytes = input.read(buffer)) {
                    output.write(buffer, 0, bytes);
                }
                body = output.toByteArray();
            } finally {
                input.close();
            }
        }
        return body;
    }
}
