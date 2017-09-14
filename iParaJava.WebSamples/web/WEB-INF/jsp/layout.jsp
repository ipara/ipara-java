<%@page import="java.util.UUID"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="iParaJava.Core.Settings"%>
<%@page import="iParaJava.Core.Request.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
         <title>iPara Developer Portal</title>
        <link href="${pageContext.request.contextPath}/Content/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/Content/Site.css" rel="stylesheet" type="text/css"/>
        
    </head>

    <body>
     
          <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="navbar-collapse collapse">

                <img src="${pageContext.request.contextPath}/Content/iPara_disi-01.png" width="10%" height="10%" />
                <ul class="nav navbar-nav">
                   <li><a href="index.htm">3d Ödeme</a></li>
                   <li><a href="ApiPayment.htm">(Non-3d) Ödeme</a></li>
                   <li><a href="PaymentInqury.htm">Ödeme Sorgulama</a></li>
                   <li><a href="binInquiry.htm">Bin Sorgulama</a></li>
                   <li><a href="AddCardToWallet.htm">Cüzdana Kart Ekle </a></li>
                   <li><a href="GetCardFromWallet.htm">Cüzdandaki Kartları Listele</a></li>
                   <li><a href="DeleteCardFromWallet.htm">Cüzdandan Kart Sil</a></li>
                   <li><a href="ApiPaymentWithWallet.htm">Cüzdandaki Kart (Tek Tıkla) İle Ödeme</a></li>
              
                </ul>
            </div>
        </div>
    </div>
<div class="container body-content">

    <br />
    <br />
    <br />
    
     