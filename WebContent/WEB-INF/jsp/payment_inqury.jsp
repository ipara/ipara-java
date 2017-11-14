<%@page import="ipara.core.Helper"%>
<%@page import="javax.xml.bind.JAXB"%>
<%@page import="java.io.StringWriter"%>
<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="ipara.core.response.PaymentInquiryResponse"%>
<%@page import="ipara.core.request.PaymentInquiryRequest"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="ipara.core.Settings"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="layout.jsp" />

<form method="post" class="form-horizontal">
	<fieldset>
		<!-- Form Name -->
		<legend>Ödeme Sorgulama</legend>
		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="">Sipariş Numarası:</label>
			<div class="col-md-4">
				<input name="orderId" type="text" value="58e1e9f22690b" class="form-control input-md" required>
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

	
	<%-- Setting ayarlarımızı alıyoruz. Formdan gelen bilgilerle PaymentInquiryRequest sınıfımızı dolduruyoruz. PaymentInquiryRequest ve Setting ayarlarımızla sayfamızı post ediyoruz.%>
		Settings settings = new Settings();
		settings.publicKey = ""; //"Public Magaza Anahtarı - size mağaza başvurunuz sonucunda gönderilen publik key (açık anahtar) bilgisini kullanınız.",
		settings.privateKey = ""; //"Private Magaza Anahtarı  - size mağaza başvurunuz sonucunda gönderilen privaye key (gizli anahtar) bilgisini kullanınız.",
		settings.baseUrl = "https://api.ipara.com/"; //"iPara web servisleri API url'lerinin başlangıç bilgisidir. Restful web servis isteklerini takip eden kodlar halinde bulacaksınız."
		// Örneğin "https://api.ipara.com/" + "/rest/payment/auth"  = "https://api.ipara.com/rest/payment/auth" 
		settings.version = "1.0";// "Kullandığınız iPara API versiyonudur." 
		settings.mode = "T"; // "Test -> T, entegrasyon testlerinin sırasında "T" modunu, canlı sisteme entegre olarak ödeme almaya başlamak için ise Prod -> "P" modunu kullanınız."
		settings.hashString = ""; // "Kullanacağınız hash bilgisini, bağlanmak istediğiniz web servis bilgisine göre doldurulmalıdır. Bu bilgileri Entegrasyon rehberinin ilgili web servise ait bölümde bulabilirsiniz."

		PaymentInquiryRequest paymentInquiryRequest = new PaymentInquiryRequest();
		paymentInquiryRequest.orderId = request.getParameter("orderId");
		paymentInquiryRequest.echo = "Echo";
		paymentInquiryRequest.mode = settings.mode;
		PaymentInquiryResponse paymnentInquiryResponse = PaymentInquiryRequest.execute(paymentInquiryRequest,
				settings); //"Ödeme sorgulama servisi başlatılması için gerekli servis çağırısını temsil eder."

		    StringWriter sw = new StringWriter();
                 JAXB.marshal(paymnentInquiryResponse, sw);
		
		out.println("  <h1>Sonuç</h1>");
		out.println("<pre>" + Helper.prettyPrintXml(sw.toString()) + "</pre>"); //"Ödeme sorgulama servis çağrısı sonucunda oluşan servis çıktı parametrelerinin ekranda gösterilmesini sağlar"
	}
%>

<jsp:include page="footer.jsp" />