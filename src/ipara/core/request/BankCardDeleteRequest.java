package ipara.core.request;

import ipara.core.Constants;
import ipara.core.CoreRequest;
import ipara.core.Helper;
import ipara.core.RestHttpCaller;
import ipara.core.Settings;
import ipara.core.response.BankCardDeleteResponse;

public class BankCardDeleteRequest extends CoreRequest {

	public String userId;
	public String cardId;
	public String clientIp;

	public static BankCardDeleteResponse execute(BankCardDeleteRequest request, Settings settings) throws Exception {

		settings.transactionDate = Helper.getTransactionDateString();
		settings.hashString = settings.privateKey
				+ request.userId
				+ request.cardId
				+ request.clientIp
				+ settings.transactionDate;
		return RestHttpCaller.getInstance().postJson(settings.baseUrl + "/bankcard/delete",
				Helper.getHttpHeaders(settings, Constants.ContentTypes.APPLICATION_JSON_UTF8), request,
				BankCardDeleteResponse.class);

	}

}
