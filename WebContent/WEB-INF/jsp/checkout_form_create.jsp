<%@page import="com.google.gson.GsonBuilder" %>
<%@page import="com.google.gson.Gson" %>
<%@page import="ipara.core.Settings" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="ipara.core.entity.*" %>
<%@ page import="ipara.core.response.CheckoutFormCreateResponse" %>
<%@ page import="ipara.core.request.CheckoutFormCreateRequest" %>
<%@ page import="java.util.*" %>

<%@page
        contentType="text/html"
        pageEncoding="UTF-8"
%>

<jsp:include page="layout.jsp"/>

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
<form
        method="post"
        class="form-horizontal"
>
    <fieldset>
        <!-- Form Name -->
        <legend>
            <label style="font-weight: bold; width: 250px;">Form Bilgileri</label>
        </legend>
        <!-- Text input-->
        <label style="font-weight: bold;">Threed :</label> false<br>
        <label style="font-weight: bold;">Amount :</label> 100000<br>
        <label style="font-weight: bold;">Allowed Installments :</label> 1,2,3,4,5,6,7,8,9,10,11,12<br>
        <label style="font-weight: bold;">CallbackUrl :</label>
        https://apitest.ipara.com/rest/payment/threed/test/result<br>
    </fieldset>

    <!-- Button -->
    <div class="form-group">
        <label
                class="col-md-4 control-label"
                for=""
        ></label>
        <div class="col-md-4">
            <button
                    type="submit"
                    id=""
                    name=""
                    class="btn btn-success"
            >Checkout Formu Oluştur
            </button>
        </div>
    </div>
</form>

<%
    request.setCharacterEncoding("UTF-8");
    if ("POST".equalsIgnoreCase(request.getMethod())) {

        Settings settings = new Settings();
        String SIMPLE_DATE_FORMAT = "yyyy-MM-dd";
        String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

        CheckoutFormCreateRequest dto = new CheckoutFormCreateRequest();
        UUID uuid = UUID.randomUUID();

        dto.setOrderId(uuid.toString());
        dto.setAmount(10000D);
        dto.setCallbackUrl("https://apitest.ipara.com/rest/payment/threed/test/result");
        dto.setThreed(false);

        dto.setAllowedInstallments(new HashSet<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12")));
        dto.setMode(settings.mode);

        Purchaser purchaser = new Purchaser();
        purchaser.name = "Murat";
        purchaser.surname = "Kaya";
        purchaser.email = "murat@kaya.com";
        purchaser.birthDate = new SimpleDateFormat(SIMPLE_DATE_FORMAT).format(new Date());
        purchaser.gsmNumber = "5400343434";
        purchaser.clientIp = "192.168.0.54";
        purchaser.tcCertificate = "99999999999";

        PurchaserAddress invoiceAddress = new PurchaserAddress();
        invoiceAddress.name = "Murat";
        invoiceAddress.surname = "Kaya";
        invoiceAddress.address = "Mevlüt Pehlivan Mah. Multinet Plaza Şişli";
        invoiceAddress.zipcode = "34782";
        invoiceAddress.city = "34";
        invoiceAddress.country = "TR";
        invoiceAddress.tcCertificate = "1234567890";
        invoiceAddress.taxNumber = "9999999999";
        invoiceAddress.taxOffice = "Kozyatağı";
        invoiceAddress.companyName = "iPara";
        invoiceAddress.phoneNumber = "2122222222";

        PurchaserAddress shippingAddress = new PurchaserAddress();
        shippingAddress.name = "Murat";
        shippingAddress.surname = "Kaya";
        shippingAddress.address = "Mevlüt Pehlivan Mah. Multinet Plaza Şişli";
        shippingAddress.zipcode = "34782";
        shippingAddress.city = "34";
        shippingAddress.country = "TR";
        shippingAddress.phoneNumber = "2122222222";

        purchaser.invoiceAddress = invoiceAddress;
        purchaser.shippingAddress = shippingAddress;

        dto.setPurchaser(purchaser);
        dto.setEcho("Echo");
        dto.setVersion("1.0");
        dto.setTransactionDate(new SimpleDateFormat(DATE_FORMAT).format(new Date()));
        dto.setVendorId("10100");

        List<Product> products = new ArrayList<>();
        Product p = new Product();
        p.price = "5000";
        p.code = "TLF0001";
        p.title = "Telefon";
        p.quantity = "1";
        products.add(p);
        Product p1 = new Product();
        p1.price = "5000";
        p1.code = "BLG0001";
        p1.title = "Bilgisayar";
        p1.quantity = "1";
        products.add(p1);
        dto.setProducts(products);

        CheckoutFormCreateResponse checkoutFormCreateResponse = dto.execute(dto, settings);

        Gson g = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
        out.println("  <h1>Sonuç</h1>");
        out.println("<pre>" + g.toJson(checkoutFormCreateResponse)
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;") + "</pre>");
    }
%>

<jsp:include page="footer.jsp"/>
