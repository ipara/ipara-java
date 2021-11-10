package ipara.core.response;

import ipara.core.CoreResponse;
import ipara.core.entity.PaymentLink;

import java.util.List;

// Link ile Ödeme Link Silme servis çıktı parametre alanlarını temsil etmektedir.
public class LinkPaymentDeleteResponse extends CoreResponse {
    public List<PaymentLink> linkPaymentRecordList;
    public String pageIndex ;
    public String pageSize ;
    public String pageCount ;
}
