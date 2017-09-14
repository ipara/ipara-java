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
public class BankCardCreateRequest {
    
    
        public String userId ;
        public String cardOwnerName ;
        public String cardNumber ;

        public String cardAlias ;

        public String cardExpireMonth ;

        public String cardExpireYear ;

        public String clientIp ;


        public static BankCardCreateResponse Execute(BankCardCreateRequest request, Settings settings) throws Exception
        {
            settings.transactionDate = Helper.GetTransactionDateString();
            settings.HashString = settings.PrivateKey + request.userId + request.cardOwnerName + request.cardNumber +
                                 request.cardExpireMonth + request.cardExpireYear + request.clientIp +
                                 settings.transactionDate;
            
              return RestHttpCaller.Create().PostJson(settings.BaseUrl + "/bankcard/create", Helper.GetHttpHeaders(settings,Helper.application_json),
                request, BankCardCreateResponse.class);
            
         
        }
}
