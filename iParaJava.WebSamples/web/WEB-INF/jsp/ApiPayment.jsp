<%-- 
    Document   : ApiPayment
    Created on : Sep 13, 2017, 11:02:00 AM
    Author     : fcoskun
--%>

<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="iParaJava.Core.Response.ApiPaymentResponse"%>
<%@page import="java.util.UUID"%>
<%@page import="iParaJava.Entity.Purchaser"%>
<%@page import="iParaJava.Entity.PurchaserAddress"%>
<%@page import="java.util.ArrayList"%>
<%@page import="iParaJava.Entity.Product"%>
<%@page import="iParaJava.Core.Request.ApiPaymentRequest"%>
<%@page import="iParaJava.Core.Settings"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="layout.jsp"/>

  <fieldset>
        <legend><label style="font-weight:bold;width:250px;">Sepet Bilgileri</label></legend>
        <table class="table">
            <thead>
                <tr>
                    <th>
                        Ürün
                    </th>
                    <th>
                        Kod
                    </th>
                    <th>
                        Adet
                    </th>
                    <th>
                        Birim Fiyat
                    </th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        Telefon
                    </td>
                    <td>
                        TLF0001
                    </td>
                    <td>
                        1
                    </td>
                    <td>
                        50.00 TL
                    </td>
                </tr>
                <tr>
                    <td>
                        Bilgisayar
                    </td>
                    <td>
                        BLG0001
                    </td>
                    <td>
                        1
                    </td>
                    <td>
                        50.00 TL
                    </td>
                </tr>

                <tr>
                    <td colspan="3">
                        Toplam Tutar
                    </td>

                    <td>
                        100.00 TL
                    </td>
                </tr>
            </tbody>
        </table>
    </fieldset>
    <fieldset>
        <legend><label style="font-weight:bold;width:250px;">Kargo Adresi Bilgileri</label></legend>
        <label style="font-weight:bold;">Ad :</label> Murat<br>
        <label style="font-weight:bold;">Soyad :</label> Kaya <br>
        <label style="font-weight:bold;">Adres :</label> Mevlüt Pehlivan Mah. Multinet Plaza Şişli <br>
        <label style="font-weight:bold;">Posta Kodu :</label> 34782 <br>
        <label style="font-weight:bold;">Şehir :</label> İstanbul <br>
        <label style="font-weight:bold;">Ülke :</label> Türkiye <br>
        <label style="font-weight:bold;">Telefon Numarası:</label> 2123886600 <br>
    </fieldset>
    <fieldset>
        <legend><label style="font-weight:bold;width:250px;">Fatura Adresi Bilgileri</label></legend>
        <label style="font-weight:bold;">Ad :</label> Murat<br>
        <label style="font-weight:bold;">Soyad :</label> Kaya<br>
        <label style="font-weight:bold;">Adres :</label> Mevlüt Pehlivan Mah. Multinet Plaza Şişli<br>
        <label style="font-weight:bold;">Posta Kodu :</label> 34782<br>
        <label style="font-weight:bold;">Şehir :</label> İstanbul<br>
        <label style="font-weight:bold;">Ülke :</label> Türkiye<br>
        <label style="font-weight:bold;">TC Kimlik Numarası :</label> 1234567890<br>
        <label style="font-weight:bold;">Telefon Numarası:</label> 2123886600<br>
        <label style="font-weight:bold;">Vergi Numarası :</label> 123456<br>
        <label style="font-weight:bold;">Vergi Dairesi Adı :</label> Kozyatağı<br>
        <label style="font-weight:bold;">Firma Adı:</label> iPara
    </fieldset>
<form action="" method="post" class="form-horizontal">
    <fieldset>

        <!-- Form Name -->
        <legend><label style="font-weight:bold;width:250px;">Kart Bilgileriyle Ödeme</label></legend>
 

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="">Kart Sahibi Adı Soyadı:</label>
            <div class="col-md-4">
                <input value="Fatih Coskun" name="nameSurname" class="form-control input-md" >

            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label" for="">  Kart Numarası:</label>
            <div class="col-md-4">
                <input value="4282209027132016" name="cardNumber" class="form-control input-md" >

            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="">  Son Kullanma Tarihi Ay/Yıl: </label>
            <div class="col-md-4">
                <input value="05" name="month" class="form-control input-md" width="50px" >
                <input value="18" name="year" class="form-control input-md" width="50px" >

            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="">  CVC: </label>
            <div class="col-md-4">
                <input value="000" name="cvc" class="form-control input-md">

            </div>
        </div>


    </fieldset>

  
    
    Taksit Sayısı
    <select name="installment">
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10">10</option>
        <option value="11">11</option>
        <option value="12">12</option>
    </select>

    <!-- Button -->
    <div class="form-group">
        <label class="col-md-4 control-label" for=""></label>
        <div class="col-md-4">
            <button type="submit" id="" name="" class="btn btn-success">API Payment ile Ödeme</button>
        </div>
    </div>
</form>


    
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
      
      
             ApiPaymentRequest apiPaymentRequest = new ApiPaymentRequest();
             UUID uuid = UUID.randomUUID();

            apiPaymentRequest.OrderId = uuid.toString();
            apiPaymentRequest.echo = "Echo";
            apiPaymentRequest.mode = settings.Mode;
            apiPaymentRequest.Amount = "10000"; // 100 tL
            apiPaymentRequest.CardOwnerName = request.getParameter("nameSurname");
            apiPaymentRequest.CardNumber = request.getParameter("cardNumber");
            apiPaymentRequest.CardExpireMonth = request.getParameter("month");
            apiPaymentRequest.CardExpireYear = request.getParameter("year");
            apiPaymentRequest.Installment = request.getParameter("installment");
            apiPaymentRequest.Cvc = request.getParameter("cvc");
            apiPaymentRequest.CardId = "";
            apiPaymentRequest.UserId = "";
            apiPaymentRequest.ThreeD = "false";



            apiPaymentRequest.Purchaser = new Purchaser();
            apiPaymentRequest.Purchaser.Name = "Murat";
            apiPaymentRequest.Purchaser.SurName = "Kaya";
            apiPaymentRequest.Purchaser.BirthDate = "1986-07-11";
            apiPaymentRequest.Purchaser.Email = "murat@kaya.com";
            apiPaymentRequest.Purchaser.GsmPhone = "5881231212";
            apiPaymentRequest.Purchaser.IdentityNumber = "1234567890";
            apiPaymentRequest.Purchaser.ClientIp = "127.0.0.1";
          
            apiPaymentRequest.Purchaser.InvoiceAddress = new PurchaserAddress();
            apiPaymentRequest.Purchaser.InvoiceAddress.Name = "Murat";
            apiPaymentRequest.Purchaser.InvoiceAddress.SurName = "Kaya";
            apiPaymentRequest.Purchaser.InvoiceAddress.Address = "Mevlüt Pehlivan Mah. Multinet Plaza Şişli";
            apiPaymentRequest.Purchaser.InvoiceAddress.ZipCode = "34782";
            apiPaymentRequest.Purchaser.InvoiceAddress.CityCode = "34";
            apiPaymentRequest.Purchaser.InvoiceAddress.IdentityNumber = "1234567890";
            apiPaymentRequest.Purchaser.InvoiceAddress.CountryCode = "TR";
            apiPaymentRequest.Purchaser.InvoiceAddress.TaxNumber = "123456";
            apiPaymentRequest.Purchaser.InvoiceAddress.TaxOffice = "Kozyatağı";
            apiPaymentRequest.Purchaser.InvoiceAddress.CompanyName = "iPara";
            apiPaymentRequest.Purchaser.InvoiceAddress.PhoneNumber = "2122222222";

         
            apiPaymentRequest.Purchaser.ShippingAddress = new PurchaserAddress();
            apiPaymentRequest.Purchaser.ShippingAddress.Name = "Murat";
            apiPaymentRequest.Purchaser.ShippingAddress.SurName = "Kaya";
            apiPaymentRequest.Purchaser.ShippingAddress.Address = "Mevlüt Pehlivan Mah. Multinet Plaza Şişli";
            apiPaymentRequest.Purchaser.ShippingAddress.ZipCode = "34782";
            apiPaymentRequest.Purchaser.ShippingAddress.CityCode = "34";
            apiPaymentRequest.Purchaser.ShippingAddress.IdentityNumber = "1234567890";
            apiPaymentRequest.Purchaser.ShippingAddress.CountryCode = "TR";
            apiPaymentRequest.Purchaser.ShippingAddress.PhoneNumber = "2122222222";

         
            apiPaymentRequest.product = new ArrayList<Product>();
            Product p = new Product();
            p.Title = "Telefon";
            p.Code = "TLF0001";
            p.Price = "5000";
            p.Quantity = "1";
            apiPaymentRequest.product.add(p);
            p = new Product();
            p.Title = "Bilgisayar";
            p.Code = "BLG0001";
            p.Price = "5000";
            p.Quantity = "1";
            apiPaymentRequest.product.add(p);

            ApiPaymentResponse apiPaymentResponse = ApiPaymentRequest.Execute(apiPaymentRequest, settings);
            
   Gson g = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
           out.println( "  <h1>Sonuç</h1>");
         out.println("<pre>"+g.toJson(apiPaymentResponse)+"</pre>");     
}
%>


<jsp:include page="footer.jsp"/>
      