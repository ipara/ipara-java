<%-- 
    Document   : ThreeDResultSuccess
    Created on : Aug 29, 2017, 12:10:45 PM
    Author     : fcoskun
--%>
<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="iParaJava.Entity.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="iParaJava.Entity.PurchaserAddress"%>
<%@page import="iParaJava.Entity.Purchaser"%>
<%@page import="iParaJava.Core.Request.ThreeDPaymentCompleteRequest"%>
<%@page import="iParaJava.Core.Helper"%>
<%@page import="java.util.UUID"%>
<%@page import="iParaJava.Core.Settings"%>
<%@page import="iParaJava.Core.Response.*"%>
<%@page import="com.google.gson.Gson" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! ThreeDPaymentCompleteResponse completeResponse=new ThreeDPaymentCompleteResponse(); %>

<jsp:include page="layout.jsp" />

          <%
     request.setCharacterEncoding("UTF-8");
             Settings  settings = new Settings ();
   
            
            settings.PublicKey = ""; //"Public Magaza Anahtarı",
            settings.PrivateKey = ""; //"Private Magaza Anahtarı",
            settings.BaseUrl = "https://apitest.ipara.com/"; //Test için 
            settings.Version = "1.0";
            settings.Mode = "T"; // Test -> T / Prod -> P
            settings.HashString="";
              
             ThreeDPaymentInitResponse paymentResponse = new ThreeDPaymentInitResponse();
            paymentResponse.orderId = request.getParameter("orderId");
            paymentResponse.result = request.getParameter("result");
            paymentResponse.mode = request.getParameter("mode");
            paymentResponse.amount = request.getParameter("amount");
            
            if (request.getParameter("errorCode") != null)
                paymentResponse.errorCode = request.getParameter("errorCode");

            if (request.getParameter("errorMessage") != null)
                paymentResponse.errorMessage = request.getParameter("errorMessage");

            if (request.getParameter("transactionDate") != null)
                paymentResponse.transactionDate = request.getParameter("transactionDate");

            if (request.getParameter("hash") != null)
                paymentResponse.hash = request.getParameter("hash");
    
            

         if (Helper.Validate3DReturn(paymentResponse, settings))
            {
                ThreeDPaymentCompleteRequest completeRequest = new ThreeDPaymentCompleteRequest();

                completeRequest.OrderId = request.getParameter("orderId");
                completeRequest.echo = "Echo";
                completeRequest.mode = settings.Mode;
                completeRequest.Amount = "10000"; // 100 tL
                completeRequest.CardOwnerName = "Fatih Coşkun";
                completeRequest.CardNumber = "4282209027132016";
                completeRequest.CardExpireMonth = "05";
                completeRequest.CardExpireYear = "18";
                completeRequest.Installment = "1";
                completeRequest.Cvc = "000";
                completeRequest.ThreeD = "true";
                completeRequest.ThreeDSecureCode = request.getParameter("threeDSecureCode");
             
                completeRequest.Purchaser = new Purchaser();
                completeRequest.Purchaser.BirthDate = "1986-07-11";
                completeRequest.Purchaser.GsmPhone = "5881231212";
                completeRequest.Purchaser.IdentityNumber = "1234567890";
             
            
                completeRequest.Purchaser.InvoiceAddress = new PurchaserAddress();
                completeRequest.Purchaser.InvoiceAddress.Name = "Murat";
                completeRequest.Purchaser.InvoiceAddress.SurName = "Kaya";
                completeRequest.Purchaser.InvoiceAddress.Address = "Mevlüt Pehlivan Mah. Multinet Plaza Şişli";
                completeRequest.Purchaser.InvoiceAddress.ZipCode = "34782";
                completeRequest.Purchaser.InvoiceAddress.CityCode = "34";
                completeRequest.Purchaser.InvoiceAddress.IdentityNumber = "1234567890";
                completeRequest.Purchaser.InvoiceAddress.CountryCode = "TR";
                completeRequest.Purchaser.InvoiceAddress.TaxNumber = "123456";
                completeRequest.Purchaser.InvoiceAddress.TaxOffice = "Kozyatağı";
                completeRequest.Purchaser.InvoiceAddress.CompanyName = "iPara";
                completeRequest.Purchaser.InvoiceAddress.PhoneNumber = "2122222222";

        
                completeRequest.Purchaser.ShippingAddress = new PurchaserAddress();
                completeRequest.Purchaser.ShippingAddress.Name = "Murat";
                completeRequest.Purchaser.ShippingAddress.SurName = "Kaya";
                completeRequest.Purchaser.ShippingAddress.Address = "Mevlüt Pehlivan Mah. Multinet Plaza Şişli";
                completeRequest.Purchaser.ShippingAddress.ZipCode = "34782";
                completeRequest.Purchaser.ShippingAddress.CityCode = "34";
                completeRequest.Purchaser.ShippingAddress.IdentityNumber = "1234567890";
                completeRequest.Purchaser.ShippingAddress.CountryCode = "TR";
                completeRequest.Purchaser.ShippingAddress.PhoneNumber = "2122222222";

                completeRequest.product = new ArrayList<Product>();
                Product p = new Product();
                p.Title = "Telefon";
                p.Code = "TLF0001";
                p.Price = "5000";
                p.Quantity = "1";
                completeRequest.product.add(p);
                p = new Product();
                p.Title = "Bilgisayar";
                p.Code = "BLG0001";
                p.Price = "5000";
                p.Quantity = "1";
                completeRequest.product.add(p);

               completeResponse= ThreeDPaymentCompleteRequest.Execute(completeRequest, settings);
            }
       
        %>  
         <h1>3d Başarılı!</h1>
 <pre>
        <%
         
            Gson g = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
         out.println( "  <h1>Sonuç</h1>");
          out.println(g.toJson(completeResponse).toString());
         
    %>

    </pre>
   
         
<jsp:include page="footer.jsp"/>