package ipara.core.response;

import java.util.List;

import ipara.core.CoreResponse;

public class BankCardCreateResponse extends CoreResponse {

	public String cardId;

	public String maskNumber;

	public String alias;

	public String bankId;

	public String bankName;

	public String cardFamilyName;

	public String supportsInstallment;

	public List<String> supportedInstallments;

	public String type;

	public String serviceProvider;

	public String threeDSecureMandatory;

	public String cvcMandatory;

}
