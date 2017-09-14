/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iParaJava.Core.Response;

import iParaJava.Core.BaseResponse;
import java.util.List;

/**
 *
 * @author fcoskun
 */
public class BinNumberInquiryResponse extends BaseResponse   {
    
     public String bankId ;
        public String bankName ;

        public String cardFamilyName ;

        public String supportsInstallment ;
        public List<String> supportedInstallments ;
        public String type ;

        public String serviceProvider ;

        public String cardThreeDSecureMandatory ;
        public String merchantThreeDSecureMandatory ;
        public String cvcMandatory ;

        public String businessCard ;
}
