package mcquick.agentApiDemo.controller;

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
    public String test() {
        try {
            //上传图片
//            testFileUpload(agentApiClient);

            //商户进件
//            testMerchantUp(agentApiClient);

            //商户进件记录查询
//            queryMerUpStatus(agentApiClient);

            //修改结算卡
//            modifyMerSettleCard(agentApiClient);

            //快捷发送短信验证码
//            sendMsg(agentApiClient);

            //快捷确认支付
//            pay(agentApiClient);

            //订单查询
            queryOrder(agentApiClient);
        } catch (CheckException e) {
            e.printStackTrace();
        }
        return "success";
    }

    private void queryOrder(AgentApiClient client) {
        QueryOrderReq req = new QueryOrderReq();
        req.merchantCode = 793122961732276224L;
        req.orderNo = "MJ20221125793544114284138497";
        BaseRsp<QueryOrderRsp> result = client.send(req, QueryOrderRsp.class);
        QueryOrderRsp data = result.getData();
        System.out.println(JSON.toJSONString(result));
        System.out.println(JSON.toJSONString(data));
    }

    private void pay(AgentApiClient client) {
        TransPayReq req = new TransPayReq();
        req.merchantCode = 793122961732276224L;
        req.smsCode = "123456";
        req.orderNo = "MJ20221125793544114284138497";
        BaseRsp<TransPayRsp> result = client.send(req, TransPayRsp.class);
        TransPayRsp data = result.getData();
        System.out.println(JSON.toJSONString(result));
        System.out.println(JSON.toJSONString(data));
    }

    private void sendMsg(AgentApiClient client) {
        TransSendMsgReq req = new TransSendMsgReq();
        req.merchantCode = 793122961732276224L;
        req.amount = 1000L;
        req.tradeRate = 5500L;
        req.settleFee = 50L;
        req.cardNo = "4563511700882285764";
        req.validPeriod = "0827";
        req.cvn = "764";
        req.phone = "13452146534";
        req.clientIP = "10.45.26.56";
        req.provCode = 440000;
        req.cityCode = 440300;
        BaseRsp<TransSendMsgRsp> result = client.send(req, TransSendMsgRsp.class);
        TransSendMsgRsp data = result.getData();
        System.out.println(JSON.toJSONString(result));
        System.out.println(JSON.toJSONString(data));
    }

    private void modifyMerSettleCard(AgentApiClient client) {
        ModifyMerSettleCardReq req = new ModifyMerSettleCardReq();
        req.merchantCode = 793122961732276224L;

//        FileUploadReq fileUploadReq = new FileUploadReq();
//        fileUploadReq.file = new File("D:\\Users\\23120\\Pictures\\Saved Pictures\\银行卡-正面.jpg");
//        fileUploadReq.fileType = FileUploadType.结算卡.id;
//        BaseRsp<FileUploadRsp> fileUploadResult = client.send(fileUploadReq, FileUploadRsp.class);
//        req.bankCardFilepath = fileUploadResult.getData().getFilepath();

        req.bankCardNo = "4563511700882285654";
        req.phone = "13452146534";
        req.zBankCode = "104241015541";
        req.bankProvinceCode = 440000;
        req.bankCityCode = 440300;
        req.bankDistrictCode = 440305;
        BaseRsp<ModifyMerSettleCardRsp> result = client.send(req, ModifyMerSettleCardRsp.class);
        ModifyMerSettleCardRsp data = result.getData();
        System.out.println(JSON.toJSONString(result));
        System.out.println(JSON.toJSONString(data));
    }

    private void queryMerUpStatus(AgentApiClient client) {
        MerUpStatusReq req = new MerUpStatusReq();
        req.merchantCode = 793122961732276224L;
        BaseRsp<MerUpStatusRsp> result = client.send(req, MerUpStatusRsp.class);
        MerUpStatusRsp data = result.getData();
        System.out.println(JSON.toJSONString(result));
        System.out.println(JSON.toJSONString(data));
    }

    private void testMerchantUp(AgentApiClient client) {
        MerchantUpReq req = new MerchantUpReq();
        //商户基本信息
        req.merPhone = "13452146534";

        //身份证信息
//        FileUploadReq fileUploadReq = new FileUploadReq();
//        fileUploadReq.file = new File("D:\\Users\\23120\\Pictures\\Saved Pictures\\古人-正面.jpg");
//        fileUploadReq.fileType = FileUploadType.身份证正面.id;
//        BaseRsp<FileUploadRsp> fileUploadResult = client.send(fileUploadReq, FileUploadRsp.class);
//        req.idCardFrontFilepath = fileUploadResult.getData().getFilepath();
//        fileUploadReq.file = new File("D:\\Users\\23120\\Pictures\\Saved Pictures\\古人-反面.jpg");
//        fileUploadReq.fileType = FileUploadType.身份证背面.id;
//        fileUploadResult = client.send(fileUploadReq, FileUploadRsp.class);
//        req.idCardBackFilepath = fileUploadResult.getData().getFilepath();
        req.realName = "古人API";
        req.idCardNo = "210604199001017858";
        req.gender = Gender.男.id;
        req.idCardValidRange = "20121021-20231016";
        req.provinceCode = 440000;
        req.cityCode = 440300;
        req.districtCode = 440305;
        req.address = "广东省深圳市深圳湾一号";

        //结算卡信息
//        fileUploadReq.file = new File("D:\\Users\\23120\\Pictures\\Saved Pictures\\银行卡-正面.jpg");
//        fileUploadReq.fileType = FileUploadType.结算卡.id;
//        fileUploadResult = client.send(fileUploadReq, FileUploadRsp.class);
//        req.bankCardFilepath = fileUploadResult.getData().getFilepath();
        req.bankCardNo = "6222621310045659451";
        req.zBankCode = "301421000161";
        req.phone = "13452146534";
        req.bankProvinceCode = 440000;
        req.bankCityCode = 440300;
        req.bankDistrictCode = 440305;


        BaseRsp<MerchantUpRsp> result = client.send(req, MerchantUpRsp.class);
        MerchantUpRsp data = result.getData();
        System.out.println(JSON.toJSONString(result));
        System.out.println(JSON.toJSONString(data));
    }

    private void testFileUpload(AgentApiClient client) {
        FileUploadReq req = new FileUploadReq();
//        req.file = new File("D:\\Users\\23120\\Pictures\\Saved Pictures\\古人-正面.jpg");
//        req.fileType = FileUploadType.身份证正面.id;
//        req.file = new File("D:\\Users\\23120\\Pictures\\Saved Pictures\\古人-反面.jpg");
//        req.fileType = FileUploadType.身份证背面.id;
        req.file = new File("D:\\Users\\23120\\Pictures\\Saved Pictures\\银行卡-正面.jpg");
        req.fileType = FileUploadType.结算卡.id;
        BaseRsp<FileUploadRsp> result = client.send(req, FileUploadRsp.class);
        FileUploadRsp data = result.getData();
        System.out.println(JSON.toJSONString(result));
        System.out.println(JSON.toJSONString(data));
    }
}
