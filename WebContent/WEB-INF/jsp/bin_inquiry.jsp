<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="ipara.core.response.BinNumberInquiryResponse"%>
<%@page import="ipara.core.request.BinNumberInquiryRequest"%>
<%@page import="java.util.UUID"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="ipara.core.Settings"%>
<%@page import="ipara.core.request.*"%>

<jsp:include page="layout.jsp" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<form method="post" class="form-horizontal">
	<fieldset>
		<!-- Form Name -->
		<legend>Bin Sorgulama</legend>
		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="binNumber">Bin Numarası</label>
			<div class="col-md-4">
				<input id="binNumber" name="binNumber" type="text" placeholder="" value="492130" class="form-control input-md"
					required=""
				>
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
<br />

<%
	request.setCharacterEncoding("UTF-8");

	if ("POST".equalsIgnoreCase(request.getMethod())) {

	
		/* Setting ayarlarımızı alıyoruz. Bin numarası Kredi Kartının üzerindeki ilk 6 hanedir. 
		   Formdan gelen bilgi ile bin numarasını ve Setting ayarlarımızı post ediyoruz
		*/

		Settings settings = new Settings();

		BinNumberInquiryRequest binRequest = new BinNumberInquiryRequest();
		binRequest.binNumber = request.getParameter("binNumber");
		BinNumberInquiryResponse binResponse = BinNumberInquiryRequest.execute(binRequest, settings); // "Bin sorgulama servisinin başlatıldığı kısım"

		Gson g = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
		out.println("  <h1>Sonuç</h1>");
		out.println("<pre>" + g.toJson(binResponse) + "</pre>"); //"Bin sorgulama servisi sonucunda oluşan çıktı parametrelerinin ekranda gösterildiği kısımdır."

	}
%>

<jsp:include page="footer.jsp" />
