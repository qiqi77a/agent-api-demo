package mcquick.agentApiDemo.controller;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson2.JSON;
import mcquick.agentApiDemo.entity.request.*;
import mcquick.agentApiDemo.entity.response.*;
import mcquick.agentApiDemo.entity.response.base.BaseRsp;
import mcquick.agentApiDemo.enums.FileUploadType;
import mcquick.agentApiDemo.enums.Gender;
import mcquick.agentApiDemo.exception.CheckException;
import mcquick.agentApiDemo.util.AgentApiClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.File;

@RestController
public class demo {

    @Resource
    private AgentApiClient agentApiClient;

    @PostMapping("/callback")
    public String callBack(@RequestBody String resp) {
        System.out.println("~~~~~~~~~~~~~~~~~~~/callback start~~~~~~~~~~~~~~~~~~~~~~~");
        //处理返回值
        PayCallBack data = null;
        try {
            BaseRsp<PayCallBack> result = agentApiClient.afterSend(PayCallBack.class, resp);

            //订单支付异步通知
            System.out.println("accept success");
            data = result.getData();
            System.out.println(JSON.toJSONString(result));
            System.out.println(JSON.toJSONString(data));

            //业务处理。。。

            //验签成功
            PayCallBackRsp backRsp = new PayCallBackRsp();
            backRsp.setReqNo(data.ReqNo);
            backRsp.setStatus(100);
            return agentApiClient.buildCall(backRsp);
        } catch (CheckException e) {
            //验签失败
            PayCallBackRsp backRsp = new PayCallBackRsp();
            backRsp.setReqNo(data == null ? "" : data.ReqNo);
            backRsp.setStatus(200);
            return agentApiClient.buildCall(backRsp);
        }
    }

    @PostMapping("/test")
    public String test(@RequestParam(name = "num") Integer num) {
        try {
            switch (num) {
                case 1:
                    //上传图片
                    testFileUpload(agentApiClient);
                    break;
                case 2:
                    //商户进件
                    testMerchantUp(agentApiClient);
                    break;
                case 3:
                    //商户进件记录查询
                    queryMerUpStatus(agentApiClient);
                    break;
                case 4:
                    //修改结算卡
                    modifyMerSettleCard(agentApiClient);
                    break;
                case 5:
                    //快捷发送短信验证码
                    sendMsg(agentApiClient);
                    break;
                case 6:
                    //快捷确认支付
                    pay(agentApiClient);
                    break;
                case 7:
                    //订单查询
                    queryOrder(agentApiClient);
                    break;
            }
        } catch (CheckException e) {
            e.printStackTrace();
        }
        return "success";
    }

    private void queryOrder(AgentApiClient client) {
        QueryOrderReq req = new QueryOrderReq();
        req.merchantCode = 862017372775649280L;
        req.orderNo = "AA20230602861987138965737473";
        req.agentOrderNo = "hmu2gf3yo0sm2tvgmf";
        req.payOrderTime = "20230602123014";
        BaseRsp<QueryOrderRsp> result = client.send(req, QueryOrderRsp.class);
        QueryOrderRsp data = result.getData();
        System.out.println(JSON.toJSONString(result));
        System.out.println(JSON.toJSONString(data));
    }

    private void pay(AgentApiClient client) {
        TransPayReq req = new TransPayReq();
        req.merchantCode = 862017372775649280L;
        req.smsCode = "123456";
        req.orderNo = "AA20230602861987138965737473";
        BaseRsp<TransPayRsp> result = client.send(req, TransPayRsp.class);
        TransPayRsp data = result.getData();
        System.out.println(JSON.toJSONString(result));
        System.out.println(JSON.toJSONString(data));
    }

    private void sendMsg(AgentApiClient client) {
        TransSendMsgReq req = new TransSendMsgReq();
        req.merchantCode = 862017372775649280L;
        req.amount = 10200L;
        req.tradeRate = 6100L;
        req.settleFee = 150L;
        req.agentOrderNo = RandomUtil.randomString(18);
        req.cardNo = "5525344864174609";
        req.validPeriod = "0827";
        req.cvn = "764";
        req.phone = "13498652013";
        BaseRsp<TransSendMsgRsp> result = client.send(req, TransSendMsgRsp.class);
        TransSendMsgRsp data = result.getData();
        System.out.println(JSON.toJSONString(result));
        System.out.println(JSON.toJSONString(data));
    }

    private void modifyMerSettleCard(AgentApiClient client) {
        ModifyMerSettleCardReq req = new ModifyMerSettleCardReq();
        req.merchantCode = 862017372775649280L;
        req.bankCardNo = "4026586613212588";
        req.phone = "13498652013";
        BaseRsp<ModifyMerSettleCardRsp> result = client.send(req, ModifyMerSettleCardRsp.class);
        ModifyMerSettleCardRsp data = result.getData();
        System.out.println(JSON.toJSONString(result));
        System.out.println(JSON.toJSONString(data));
    }

    private void queryMerUpStatus(AgentApiClient client) {
        MerUpStatusReq req = new MerUpStatusReq();
        req.merchantCode = 862017372775649280L;
        BaseRsp<MerUpStatusRsp> result = client.send(req, MerUpStatusRsp.class);
        MerUpStatusRsp data = result.getData();
        System.out.println(JSON.toJSONString(result));
        System.out.println(JSON.toJSONString(data));
    }

    private void testMerchantUp(AgentApiClient client) {
        MerchantUpReq req = new MerchantUpReq();
        //商户基本信息
        req.merPhone = "13498652013";

        //身份证信息
//        FileUploadReq fileUploadReq = new FileUploadReq();
//        fileUploadReq.file = new File("D:\\Users\\23120\\Pictures\\Saved Pictures\\getCitizenIDImg.jpg");
//        fileUploadReq.fileType = FileUploadType.身份证正面.id;
//        BaseRsp<FileUploadRsp> fileUploadResult = client.send(fileUploadReq, FileUploadRsp.class);
//        req.idCardFrontFilepath = fileUploadResult.getData().getUri();
        req.idCardFrontFilepath = "http://oss-test.99kypay.com/message/7f02b7affb87420fb09cef3233ae938f.jpg";
//        fileUploadReq.file = new File("D:\\Users\\23120\\Pictures\\Saved Pictures\\getCitizenIDImg (1).jpg");
//        fileUploadReq.fileType = FileUploadType.身份证背面.id;
//        fileUploadResult = client.send(fileUploadReq, FileUploadRsp.class);
//        req.idCardBackFilepath = fileUploadResult.getData().getUri();
        req.idCardBackFilepath = "http://oss-test.99kypay.com/message/a7c143dfc7da48f8ba18f9c5fafbaeab.jpg";
        req.realName = "万晧";
        req.idCardNo = "460005198412098950";
        req.idCardValidRange = "20081121-20281121";

        //结算卡信息
        req.bankCardNo = "40551260331390897";
        req.phone = "13498652013";

        BaseRsp<MerchantUpRsp> result = client.send(req, MerchantUpRsp.class);
        MerchantUpRsp data = result.getData();
        System.out.println(JSON.toJSONString(result));
        System.out.println(JSON.toJSONString(data));
    }

    private void testFileUpload(AgentApiClient client) {
//        FileUploadReq req = new FileUploadReq();
////        req.file = new File("D:\\Users\\23120\\Pictures\\Saved Pictures\\古人-正面.jpg");
////        req.fileType = FileUploadType.身份证正面.id;
////        req.file = new File("D:\\Users\\23120\\Pictures\\Saved Pictures\\古人-反面.jpg");
////        req.fileType = FileUploadType.身份证背面.id;
//        req.file = new File("D:\\Users\\23120\\Pictures\\Saved Pictures\\银行卡-正面.jpg");
//        req.fileType = FileUploadType.结算卡.id;
//        BaseRsp<FileUploadRsp> result = client.send(req, FileUploadRsp.class);
//        FileUploadRsp data = result.getData();
//        System.out.println(JSON.toJSONString(result));
//        System.out.println(JSON.toJSONString(data));
    }
}
