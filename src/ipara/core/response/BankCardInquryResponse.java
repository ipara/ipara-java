package ipara.core.response;

import java.util.List;

import ipara.core.CoreResponse;
import ipara.core.entity.BankCard;
// Cüzdanda bulunan kartları getirmek için kullanılan servis çıktı parametrelerini temsil etmektedir.
public class BankCardInquryResponse extends CoreResponse {

	public List<BankCard> cards;

}
