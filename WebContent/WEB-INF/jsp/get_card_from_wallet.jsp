<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="ipara.core.response.BankCardInquryResponse"%>
<%@page import="ipara.core.request.BankCardInquiryRequest"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="ipara.core.Settings"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="layout.jsp" />

<form method="post" class="form-horizontal">
	<fieldset>
		<!-- Form Name -->
		<legend>Cüzdandaki Kartları Listele</legend>
		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="">Kullanıcı Id:</label>
			<div class="col-md-4">
				<input name="userId" type="text" value="123456" class="form-control input-md" required="">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label" for=""> Kart ID (Opsiyonel):</label>
			<div class="col-md-4">
				<input value="" name="cardId" class="form-control input-md">
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

	
	<%-- Cüzdandaki kartları listelemek için kullanıclan sayfadır. Setting ayarlarımızı alıyoruz. Formdan gelen bilgilerle BankCardInquiryRequest sınıfımızı dolduruyoruz.BankCardInquiryRequest ve Setting ayarlarımızla sayfamızı post ediyoruz. %>

		Settings settings = new Settings();
		settings.publicKey = ""; //"Public Magaza Anahtarı - size mağaza başvurunuz sonucunda gönderilen publik key (açık anahtar) bilgisini kullanınız.",
		settings.privateKey = ""; //"Private Magaza Anahtarı  - size mağaza başvurunuz sonucunda gönderilen privaye key (gizli anahtar) bilgisini kullanınız.",
		settings.baseUrl = "https://api.ipara.com/"; //iPara web servisleri API url'lerinin başlangıç bilgisidir. Restful web servis isteklerini takip eden kodlar halinde bulacaksınız.
		// Örneğin "https://api.ipara.com/" + "/rest/payment/auth"  = "https://api.ipara.com/rest/payment/auth" 
		settings.version = "1.0";// 	"Kullandığınız iPara API versiyonudur. "	
		settings.mode = "T"; // "Test -> T, entegrasyon testlerinin sırasında "T" modunu, canlı sisteme entegre olarak ödeme almaya başlamak için ise Prod -> "P" modunu kullanınız."
		settings.hashString = ""; // "Kullanacağınız hash bilgisini, bağlanmak istediğiniz web servis bilgisine göre doldurulmalıdır. Bu bilgileri Entegrasyon rehberinin ilgili web servise ait bölümde bulabilirsiniz."

		BankCardInquiryRequest bankCardInquiryRequest = new BankCardInquiryRequest();
		bankCardInquiryRequest.userId = request.getParameter("userId");
		bankCardInquiryRequest.cardId = request.getParameter("cardId");
		bankCardInquiryRequest.clientIp = "127.0.0.1";
		BankCardInquryResponse bankCardInquiryResponse = BankCardInquiryRequest.execute(bankCardInquiryRequest,settings); // "Cüzdandaki kartları listelemek için servis çağrısının yapıldığı kısımdır."

		out.println("  <h1>Sonuç</h1>");
		Gson g = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
		out.println("<pre>" + g.toJson(bankCardInquiryResponse) + "</pre>"); //"Cüzdandaki kartları listelemek için yapılan servis çağırısı sonucunda servis çıktı parametrelerinin ekranda gösterildiği kısımdır."

	}
%>

<jsp:include page="footer.jsp" />

