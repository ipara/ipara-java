package ipara.core.response;

import java.util.List;

import ipara.core.CoreResponse;

public class BinNumberInquiryResponse extends CoreResponse {

	public String bankId;

	public String bankName;

	public String cardFamilyName;

	public String supportsInstallment;

	public List<String> supportedInstallments;

	public String type;

	public String serviceProvider;

	public String cardThreeDSecureMandatory;

	public String merchantThreeDSecureMandatory;

	public String cvcMandatory;

	public String businessCard;

}
