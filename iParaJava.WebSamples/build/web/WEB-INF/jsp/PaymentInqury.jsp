<%-- 
    Document   : PaymentInqury
    Created on : Sep 13, 2017, 11:02:29 AM
    Author     : fcoskun
--%>

<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="iParaJava.Core.Response.PaymentInquiryResponse"%>
<%@page import="iParaJava.Core.Request.PaymentInquiryRequest"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="iParaJava.Core.Settings"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="layout.jsp"/>
<form action="" method="post" class="form-horizontal">
    <fieldset>

        <!-- Form Name -->
        <legend>Ödeme Sorgulama</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="">Sipariş Numarası:</label>
            <div class="col-md-4">
                <input name="orderId" type="text" value="58e1e9f22690b" class="form-control input-md" required="">

            </div>
        </div>
     


        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for=""></label>
            <div class="col-md-4">
                <button type="submit" id="" name="" class="btn btn-success">Sorgula</button>
            </div>
        </div>

    </fieldset>
</form>


<%
        request.setCharacterEncoding("UTF-8");
if ("POST".equalsIgnoreCase(request.getMethod())) {
   
                Settings settings = new Settings(); 
                 settings.PublicKey =  ""; //"Public Magaza Anahtarı - size mağaza başvurunuz sonucunda gönderilen publik key (açık anahtar) bilgisini kullanınız.",
              settings.PrivateKey = ""; //"Private Magaza Anahtarı  - size mağaza başvurunuz sonucunda gönderilen privaye key (gizli anahtar) bilgisini kullanınız.",
            settings.BaseUrl = "https://api.ipara.com/";  //iPara web servisleri API url'lerinin başlangıç bilgisidir. Restful web servis isteklerini takip eden kodlar halinde bulacaksınız.
                                                    // Örneğin "https://api.ipara.com/" + "/rest/payment/auth"  = "https://api.ipara.com/rest/payment/auth" 
            settings.Version = "1.0";// Kullandığınız iPara API versiyonudur. 
            settings.Mode = "T";  // Test -> T, entegrasyon testlerinin sırasında "T" modunu, canlı sisteme entegre olarak ödeme almaya başlamak için ise Prod -> "P" modunu kullanınız.
            settings.HashString=""; // Kullanacağınız hash bilgisini, bağlanmak istediğiniz web servis bilgisine göre doldurulmalıdır. Bu bilgileri Entegrasyon rehberinin ilgili web servise ait bölümde bulabilirsiniz.
            
            PaymentInquiryRequest paymentInquiryRequest = new PaymentInquiryRequest();
            paymentInquiryRequest.orderId = request.getParameter("orderId");
            paymentInquiryRequest.echo="Echo";
            paymentInquiryRequest.mode = settings.Mode;          
            PaymentInquiryResponse paymnentInquiryResponse = PaymentInquiryRequest.Execute(paymentInquiryRequest, settings);
 
           
   Gson g = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
               out.println( "  <h1>Sonuç</h1>");
   
         out.println("<pre>"+g.toJson(paymnentInquiryResponse)+"</pre>"); 
}
%>



<jsp:include page="footer.jsp"/>
