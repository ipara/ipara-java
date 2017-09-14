/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iParaJava.Core.Request;

import iParaJava.Core.*;
import iParaJava.Core.Response.*;

/**
 *
 * @author fcoskun
 */
public class BinNumberInquiryRequest extends BaseRequest{
    
       public String binNumber;
       
        public static BinNumberInquiryResponse execute(BinNumberInquiryRequest request, Settings settings) throws Exception 
        {
            settings.transactionDate = Helper.GetTransactionDateString();
            settings.HashString = settings.PrivateKey + request.binNumber + settings.transactionDate;
          
        return RestHttpCaller.Create().PostJson(settings.BaseUrl + "rest/payment/bin/lookup", Helper.GetHttpHeaders( settings,Helper.application_json),
                request, BinNumberInquiryResponse.class);
          }
}
