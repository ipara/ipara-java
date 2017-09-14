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
public class BankCardInquiryRequest extends BaseRequest
    {
        public String userId ; 
        public String clientIp ;
        public String cardId ;


        public static BankCardInquryResponse Execute(BankCardInquiryRequest request, Settings settings) throws Exception
        {
            settings.transactionDate = Helper.GetTransactionDateString();
            settings.HashString = settings.PrivateKey + request.userId + request.cardId + request.clientIp + settings.transactionDate;
            return RestHttpCaller.Create().PostJson(settings.BaseUrl + "/bankcard/inquiry", Helper.GetHttpHeaders(settings, Helper.application_json), request,BankCardInquryResponse.class);
        }


    }