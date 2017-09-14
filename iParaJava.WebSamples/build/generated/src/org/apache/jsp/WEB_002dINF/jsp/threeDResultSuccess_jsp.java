package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import iParaJava.Entity.Product;
import java.util.ArrayList;
import java.util.List;
import iParaJava.Entity.PurchaserAddress;
import iParaJava.Entity.Purchaser;
import iParaJava.Core.Request.ThreeDPaymentCompleteRequest;
import iParaJava.Core.Helper;
import java.util.UUID;
import iParaJava.Core.Settings;
import iParaJava.Core.Response.*;

public final class threeDResultSuccess_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>3D Başarılı</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("          ");

              Settings  settings = new Settings ();
            
            settings.PublicKey = "SVD40N0BEHZVY4D"; //"Public Magaza Anahtarı",
            settings.PrivateKey = "SVD40N0BEHZVY4D8L9GMQXMDU"; //"Private Magaza Anahtarı",
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

                completeRequest.Products = new ArrayList<Product>();
                Product p = new Product();
                p.Title = "Telefon";
                p.Code = "TLF0001";
                p.Price = "5000";
                p.Quantity = "1";
                completeRequest.Products.add(p);
                p = new Product();
                p.Title = "Bilgisayar";
                p.Code = "BLG0001";
                p.Price = "5000";
                p.Quantity = "1";
                completeRequest.Products.add(p);

               ThreeDPaymentCompleteResponse response = ThreeDPaymentCompleteRequest.Execute(completeRequest, settings);
      
        
      out.write("  \n");
      out.write("        <h1>3d Başarılı!</h1>\n");
      out.write("    \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
