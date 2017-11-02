<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.UUID"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="ipara.core.Settings"%>
<%@page import="ipara.core.request.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="layout.jsp" />

<fieldset>
	<legend>
		<label style="font-weight: bold; width: 250px;">Sepet Bilgileri</label>
	</legend>
	<table class="table">
		<thead>
			<tr>
				<th>Ürün</th>
				<th>Kod</th>
				<th>Adet</th>
				<th>Birim Fiyat</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Telefon</td>
				<td>TLF0001</td>
				<td>1</td>
				<td>50.00 TL</td>
			</tr>
			<tr>
				<td>Bilgisayar</td>
				<td>BLG0001</td>
				<td>1</td>
				<td>50.00 TL</td>
			</tr>
			<tr>
				<td colspan="3">Toplam Tutar</td>
				<td>100.00 TL</td>
			</tr>
		</tbody>
	</table>
</fieldset>
<fieldset>
	<legend>
		<label style="font-weight: bold; width: 250px;">Kargo Adresi Bilgileri</label>
	</legend>
	<label style="font-weight: bold;">Ad :</label> Murat<br> <label style="font-weight: bold;">Soyad :</label> Kaya <br>
	<label style="font-weight: bold;">Adres :</label> Mevlüt Pehlivan Mah. Multinet Plaza Şişli <br> <label
		style="font-weight: bold;"
	>Posta Kodu :</label> 34782 <br> <label style="font-weight: bold;">Şehir :</label> İstanbul <br> <label
		style="font-weight: bold;"
	>Ülke :</label> Türkiye <br> <label style="font-weight: bold;">Telefon Numarası:</label> 2123886600 <br>
</fieldset>
<fieldset>
	<legend>
		<label style="font-weight: bold; width: 250px;">Fatura Adresi Bilgileri</label>
	</legend>
	<label style="font-weight: bold;">Ad :</label> Murat<br> <label style="font-weight: bold;">Soyad :</label> Kaya<br>
	<label style="font-weight: bold;">Adres :</label> Mevlüt Pehlivan Mah. Multinet Plaza Şişli<br> <label
		style="font-weight: bold;"
	>Posta Kodu :</label> 34782<br> <label style="font-weight: bold;">Şehir :</label> İstanbul<br> <label
		style="font-weight: bold;"
	>Ülke :</label> Türkiye<br> <label style="font-weight: bold;">TC Kimlik Numarası :</label> 1234567890<br> <label
		style="font-weight: bold;"
	>Telefon Numarası:</label> 2123886600<br> <label style="font-weight: bold;">Vergi Numarası :</label> 123456<br> <label
		style="font-weight: bold;"
	>Vergi Dairesi Adı :</label> Kozyatağı<br> <label style="font-weight: bold;">Firma Adı:</label> iPara
</fieldset>
<form method="post" class="form-horizontal">
	<fieldset>
		<!-- Form Name -->
		<legend>
			<label style="font-weight: bold; width: 250px;">Kart Bilgileriyle Ödeme</label>
		</legend>
		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="">Kart Sahibi Adı Soyadı:</label>
			<div class="col-md-4">
				<input value="Fatih Coskun" name="nameSurname" class="form-control input-md">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label" for=""> Kart Numarası:</label>
			<div class="col-md-4">
				<input value="4282209027132016" name="cardNumber" class="form-control input-md">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label" for=""> Son Kullanma Tarihi Ay/Yıl: </label>
			<div class="col-md-4">
				<input value="05" name="month" class="form-control input-md" width="50px"> <input value="18" name="year"
					class="form-control input-md" width="50px"
				>
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label" for=""> CVC: </label>
			<div class="col-md-4">
				<input value="000" name="cvc" class="form-control input-md">
			</div>
		</div>
	</fieldset>
	Taksit Sayısı <select name="installment">
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
			<button type="submit" id="" name="" class="btn btn-success">3D ile Ödeme</button>
		</div>
	</div>
</form>
<br />

<%
	request.setCharacterEncoding("UTF-8");

	if ("POST".equalsIgnoreCase(request.getMethod())) {

		Settings settings = new Settings();

		settings.publicKey = ""; //"Public Magaza Anahtarı - size mağaza başvurunuz sonucunda gönderilen publik key (açık anahtar) bilgisini kullanınız.",
		settings.privateKey = ""; //"Private Magaza Anahtarı  - size mağaza başvurunuz sonucunda gönderilen privaye key (gizli anahtar) bilgisini kullanınız.",
		settings.baseUrl = "https://www.ipara.com/3dgate";
		settings.version = "1.0";// Kullandığınız iPara API versiyonudur. 
		settings.mode = "T"; // Test -> T, entegrasyon testlerinin sırasında "T" modunu, canlı sisteme entegre olarak ödeme almaya başlamak için ise Prod -> "P" modunu kullanınız.
		settings.hashString = ""; // Kullanacağınız hash bilgisini, bağlanmak istediğiniz web servis bilgisine göre doldurulmalıdır. Bu bilgileri Entegrasyon rehberinin ilgili web servise ait bölümde bulabilirsiniz.

		ThreeDPaymentInitRequest initRequest = new ThreeDPaymentInitRequest();
		UUID uuid = UUID.randomUUID();

		initRequest.orderId = uuid.toString();
		initRequest.echo = "Echo";
		initRequest.mode = settings.mode;
		initRequest.version = settings.version;
		initRequest.amount = "10000"; // 100 TL
		initRequest.cardOwnerName = request.getParameter("nameSurname");
		initRequest.cardNumber = request.getParameter("cardNumber");
		initRequest.cardExpireMonth = request.getParameter("month");
		initRequest.cardExpireYear = request.getParameter("year");
		initRequest.installment = request.getParameter("installment");
		initRequest.cvc = request.getParameter("cvc");
		initRequest.cardId = "";
		initRequest.userId = "";

		initRequest.purchaserName = "Murat";
		initRequest.purchaserSurname = "Kaya";
		initRequest.purchaserEmail = "murat@kaya.com";

		String url = request.getRequestURL().toString();
		String baseURL = url.substring(0, url.length() - request.getRequestURI().length())
				+ request.getContextPath()
				+ "/";

		initRequest.successUrl = baseURL + "three_d_result_success.htm";
		initRequest.failUrl = baseURL + "three_d_result_fail.htm";
		String form = ThreeDPaymentInitRequest.execute(initRequest, settings);
		out.println(form);

	}
%>

<jsp:include page="footer.jsp" />
