<%-- 
    Document   : ThreeDResultFail
    Created on : Aug 29, 2017, 12:10:54 PM
    Author     : fcoskun
--%>

<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="iParaJava.Core.Response.ThreeDPaymentInitResponse"%>
<%@page import="com.google.gson.Gson" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="layout.jsp" />
        <h1>3D Başarısız!</h1>
        <pre>
        <%
                request.setCharacterEncoding("UTF-8");
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
      
            
       
   Gson g = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
             out.println( "  <h1>Sonuç</h1>");
      out.println(g.toJson(paymentResponse).toString());
         
    %>

    </pre>
<jsp:include page="footer.jsp"/>