<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="iParaJava.Core.Response.BinNumberInquiryResponse"%>
<%@page import="iParaJava.Core.Request.BinNumberInquiryRequest"%>
<%@page import="java.util.UUID"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="iParaJava.Core.Settings"%>
<%@page import="iParaJava.Core.Request.*"%>

<jsp:include page="layout.jsp" />

 

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<form action="" method="post" class="form-horizontal">
    <fieldset>

        <!-- Form Name -->
        <legend>Bin Sorgulama</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="binNumber">Bin Numarası</label>
            <div class="col-md-4">
                <input id="binNumber" name="binNumber" type="text" placeholder="" value="492130" class="form-control input-md" required="">

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

<br/>
<%
      request.setCharacterEncoding("UTF-8");  
if ("POST".equalsIgnoreCase(request.getMethod())) {
   
                Settings settings = new Settings(); 
                 settings.PublicKey =  ""; //"Public Magaza Anahtarı - size mağaza başvurunuz sonucunda gönderilen publik key (açık anahtar) bilgisini kullanınız.",
              settings.PrivateKey = ""; //"Private Magaza Anahtarı  - size mağaza başvurunuz sonucunda gönderilen privaye key (gizli anahtar) bilgisini kullanınız.",
            settings.BaseUrl = "https://apitest.ipara.com/";  //iPara web servisleri API url'lerinin başlangıç bilgisidir. Restful web servis isteklerini takip eden kodlar halinde bulacaksınız.
                                                    // Örneğin "https://api.ipara.com/" + "/rest/payment/auth"  = "https://api.ipara.com/rest/payment/auth" 
            settings.Version = "1.0";// Kullandığınız iPara API versiyonudur. 
            settings.Mode = "T";  // Test -> T, entegrasyon testlerinin sırasında "T" modunu, canlı sisteme entegre olarak ödeme almaya başlamak için ise Prod -> "P" modunu kullanınız.
            settings.HashString=""; // Kullanacağınız hash bilgisini, bağlanmak istediğiniz web servis bilgisine göre doldurulmalıdır. Bu bilgileri Entegrasyon rehberinin ilgili web servise ait bölümde bulabilirsiniz.
            
              BinNumberInquiryRequest binRequest = new BinNumberInquiryRequest();
            binRequest.binNumber = request.getParameter("binNumber");
            BinNumberInquiryResponse  binResponse = BinNumberInquiryRequest.execute(binRequest, settings);
          
   Gson g = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
               out.println( "  <h1>Sonuç</h1>");
   
         out.println("<pre>"+g.toJson(binResponse)+"</pre>"); 
}
%>

         
<jsp:include page="footer.jsp"/>
      