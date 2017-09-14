/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iParaJava.Core.Request;

import iParaJava.Core.BaseRequest;
import iParaJava.Core.Helper;
import iParaJava.Core.Response.BankCardDeleteResponse;
import iParaJava.Core.RestHttpCaller;
import iParaJava.Core.Settings;

/**
 *
 * @author fcoskun
 */
 public class BankCardDeleteRequest extends BaseRequest
    {
        public String userId ;
        public String cardId ;
        public String clientIp ;


        public static BankCardDeleteResponse Execute(BankCardDeleteRequest request, Settings settings) throws Exception
        {
            settings.transactionDate = Helper.GetTransactionDateString();
            settings.HashString = settings.PrivateKey + request.userId + request.cardId + request.clientIp + settings.transactionDate;
                return RestHttpCaller.Create().PostJson(settings.BaseUrl + "/bankcard/delete", Helper.GetHttpHeaders(settings,Helper.application_json),request, BankCardDeleteResponse.class);
        }
    }