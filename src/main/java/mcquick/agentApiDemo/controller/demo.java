package mcquick.agentApiDemo.controller;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
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

    @PostMapping("/payCallback")
    public String payCallback(@RequestBody String resp) {
        System.out.println("~~~~~~~~~~~~~~~~~~~/payCallback start~~~~~~~~~~~~~~~~~~~~~~~");
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
            return "SUCCESS";
        } catch (CheckException e) {
            //验签失败
            return "验签失败";
        }
    }


    @PostMapping("/upCallback")
    public String upCallback(@RequestBody String resp) {
        System.out.println("~~~~~~~~~~~~~~~~~~~/upCallback start~~~~~~~~~~~~~~~~~~~~~~~");
        //处理返回值
        MerUpCallBack data = null;
        try {
            BaseRsp<MerUpCallBack> result = agentApiClient.afterSend(MerUpCallBack.class, resp);

            //订单支付异步通知
            System.out.println("accept success");
            data = result.getData();
            System.out.println(JSON.toJSONString(result));
            System.out.println(JSON.toJSONString(data));

            //业务处理。。。

            //验签成功
            return "SUCCESS";
        } catch (CheckException e) {
            //验签失败
            return "验签失败";
        }
    }


    @PostMapping("/bindCallback")
    public String bindCallback(@RequestBody String resp) {
        System.out.println("~~~~~~~~~~~~~~~~~~~/bindCallback start~~~~~~~~~~~~~~~~~~~~~~~");
        //处理返回值
        MerBindSnCallBack data = null;
        try {
            BaseRsp<MerBindSnCallBack> result = agentApiClient.afterSend(MerBindSnCallBack.class, resp);

            //订单支付异步通知
            System.out.println("accept success");
            data = result.getData();
            System.out.println(JSON.toJSONString(result));
            System.out.println(JSON.toJSONString(data));

            //业务处理。。。

            //验签成功
            return "SUCCESS";
        } catch (CheckException e) {
            //验签失败
            return "验签失败";
        }
    }

    @PostMapping("/merSvipOpenNotify")
    public String merSvipOpenNotify(@RequestBody String resp) {
        System.out.println("~~~~~~~~~~~~~~~~~~~/merSvipOpenNotify start~~~~~~~~~~~~~~~~~~~~~~~");
        //处理返回值
        MerSvipOpenNotifyVo data = null;
        try {
            BaseRsp<MerSvipOpenNotifyVo> result = agentApiClient.afterSend(MerSvipOpenNotifyVo.class, resp);

            //订单支付异步通知
            System.out.println("accept success");
            data = result.getData();
            System.out.println(JSON.toJSONString(result));
            System.out.println(JSON.toJSONString(data));

            //业务处理。。。

            //验签成功
            return "SUCCESS";
        } catch (CheckException e) {
            //验签失败
            return "验签失败";
        }
    }

    @PostMapping("/merCardData")
    public String merCardData(@RequestBody String resp) {
        System.out.println("~~~~~~~~~~~~~~~~~~~/merCardData start~~~~~~~~~~~~~~~~~~~~~~~");
        //处理返回值
        MerCardDataVo data = null;
        try {
            BaseRsp<MerCardDataVo> result = agentApiClient.afterSend(MerCardDataVo.class, resp);

            //订单支付异步通知
            System.out.println("accept success");
            data = result.getData();
            System.out.println(JSON.toJSONString(result));
            System.out.println(JSON.toJSONString(data));

            //业务处理。。。

            //验签成功
            return "SUCCESS";
        } catch (CheckException e) {
            //验签失败
            return "验签失败";
        }
    }

    @PostMapping("/merLoanData")
    public String merLoanData(@RequestBody String resp) {
        System.out.println("~~~~~~~~~~~~~~~~~~~/merLoanData start~~~~~~~~~~~~~~~~~~~~~~~");
        //处理返回值
        MerLoanDataVo data = null;
        try {
            BaseRsp<MerLoanDataVo> result = agentApiClient.afterSend(MerLoanDataVo.class, resp);

            //订单支付异步通知
            System.out.println("accept success");
            data = result.getData();
            System.out.println(JSON.toJSONString(result));
            System.out.println(JSON.toJSONString(data));

            //业务处理。。。

            //验签成功
            return "SUCCESS";
        } catch (CheckException e) {
            //验签失败
            return "验签失败";
        }
    }

    @PostMapping("/merPayData")
    public String merPayData(@RequestBody String resp) {
        System.out.println("~~~~~~~~~~~~~~~~~~~/merPayData start~~~~~~~~~~~~~~~~~~~~~~~");
        //处理返回值
        MerPayDataVo data = null;
        try {
            BaseRsp<MerPayDataVo> result = agentApiClient.afterSend(MerPayDataVo.class, resp);

            //订单支付异步通知
            System.out.println("accept success");
            data = result.getData();
            System.out.println(JSON.toJSONString(result));
            System.out.println(JSON.toJSONString(data));

            //业务处理。。。

            //验签成功
            return "SUCCESS";
        } catch (CheckException e) {
            //验签失败
            return "验签失败";
        }
    }

    @PostMapping("/commOrderCallback")
    public String commOrderCallback(@RequestBody String resp) {
        System.out.println("~~~~~~~~~~~~~~~~~~~/commOrderCallback start~~~~~~~~~~~~~~~~~~~~~~~");
        //处理返回值
        OrderCallbackMsgVo data = null;
        try {
            BaseRsp<OrderCallbackMsgVo> result = agentApiClient.afterSend(OrderCallbackMsgVo.class, resp);

            //订单支付异步通知
            System.out.println("accept success");
            data = result.getData();
            System.out.println(JSON.toJSONString(result));
            System.out.println(JSON.toJSONString(data));

            //业务处理。。。

            //验签成功
            return "SUCCESS";
        } catch (CheckException e) {
            //验签失败
            return "验签失败";
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
                case 8:
                    //绑定交易卡
                    bindMerTradeCard(agentApiClient);
                    break;
                case 9:
                    //绑定交易卡确定
                    bindMerTradeCardConfirm(agentApiClient);
                    break;
                case 10:
                    //查询交易卡列表
                    queryMerTradeCard(agentApiClient);
                    break;
                case 11:
                    //通讯卡不选卡下单
                    commNoPikeSubmitOrder(agentApiClient);
                    break;
            }
        } catch (CheckException e) {
            e.printStackTrace();
        }
        return "success";
    }

    private void commNoPikeSubmitOrder(AgentApiClient client) {
        CommSubmitOrderReq req = new CommSubmitOrderReq();
        req.tradeNo = RandomUtil.randomString(32);
//        req.tradeNo = "qpylierhye9hc6y33dackwttskt49lk9";
        req.itemId = 2622;
        req.idCardNo = "420101199807170328";
        req.idCardName = "秦阿一";
        req.contactor = "秦阿一";
        req.contactTel = "13446534436";
        req.contactProv = "黑龙江省";
        req.contactCity = "齐齐哈尔市";
        req.contactArea = "甘南县";
        req.contactAddr = "测试地址请勿发货aaaaaaa";
        req.idCardPicFront = "http://oss-test.99kypay.com/message/d7b24fa81f9e4d1cba3dedcfef888afb.jpg";
        req.idCardPicBack = "http://oss-test.99kypay.com/message/5e1b785582d443e6a4e7e02b6763d07a.jpg";
        req.idCardPicHand = "http://oss-test.99kypay.com/message/d7b24fa81f9e4d1cba3dedcfef888afb.jpg";
        req.platParams = "https://page.test-ld.com/card/pop?custom=1001";
        req.extMsg = "test123";
        req.userIp = "10.4.23.61";
        CommSubmitOrderReq.UserParams userParams = new CommSubmitOrderReq.UserParams();
        userParams.numberProvinceNo = 51;
        userParams.numberCityNo = 5105;
        userParams.postProvinceNo = 51;
        userParams.postCityNo = 5105;
        userParams.postAreaNo = 510502;
        req.userParams = JSONUtil.toJsonStr(userParams);

        BaseRsp<CommSubmitOrderRsp> result = client.send(req, CommSubmitOrderRsp.class);
        CommSubmitOrderRsp data = result.getData();
        System.out.println(JSON.toJSONString(result));
        System.out.println(JSON.toJSONString(data));
    }

    private void queryMerTradeCard(AgentApiClient client) {
        QueryTradeCardReq req = new QueryTradeCardReq();
        req.merchantCode = 344480975587237888L;
//        req.bankCardNo = "6222021211886745951";
        BaseRsp<QueryTradeCardRsp> result = client.send(req, QueryTradeCardRsp.class);
        QueryTradeCardRsp data = result.getData();
        System.out.println(JSON.toJSONString(result));
        System.out.println(JSON.toJSONString(data));
    }

    private void bindMerTradeCardConfirm(AgentApiClient client) {
        BindTradeCardConfirmReq req = new BindTradeCardConfirmReq();
        req.merchantCode = 344480975587237888L;
        req.bankCardNo = "6222021211886745951";
        req.smsCode = "123456";
        req.payChannel = 900;
        BaseRsp<BindTradeCardConfirmRsp> result = client.send(req, BindTradeCardConfirmRsp.class);
        BindTradeCardConfirmRsp data = result.getData();
        System.out.println(JSON.toJSONString(result));
        System.out.println(JSON.toJSONString(data));
    }

    private void bindMerTradeCard(AgentApiClient client) {
        BindTradeCardReq req = new BindTradeCardReq();
        req.merchantCode = 344480975587237888L;
        req.bankCardNo = "6222021211886745951";
        req.phone = "15574775840";
        req.valiDate = "0830";
        req.checkNo = "123";
        req.payChannel = 900;
        BaseRsp<BindTradeCardRsp> result = client.send(req, BindTradeCardRsp.class);
        BindTradeCardRsp data = result.getData();
        System.out.println(JSON.toJSONString(result));
        System.out.println(JSON.toJSONString(data));
    }

    private void queryOrder(AgentApiClient client) {
        QueryOrderReq req = new QueryOrderReq();
        req.merchantCode = 344480975587237888L;
        req.orderNo = "AA20230809886682797740294145";
        req.agentOrderNo = "125chhovz516zvt3m6";
        req.payOrderTime = 20230809123014L;
        BaseRsp<QueryOrderRsp> result = client.send(req, QueryOrderRsp.class);
        QueryOrderRsp data = result.getData();
        System.out.println(JSON.toJSONString(result));
        System.out.println(JSON.toJSONString(data));
    }

    private void pay(AgentApiClient client) {
        TransPayReq req = new TransPayReq();
        req.merchantCode = 344480975587237888L;
        req.smsCode = "123456";
        req.orderNo = "AA20230809886682797740294145";
        BaseRsp<TransPayRsp> result = client.send(req, TransPayRsp.class);
        TransPayRsp data = result.getData();
        System.out.println(JSON.toJSONString(result));
        System.out.println(JSON.toJSONString(data));
    }

    private void sendMsg(AgentApiClient client) {
        TransSendMsgReq req = new TransSendMsgReq();
        req.merchantCode = 344480975587237888L;
        req.amount = 10200L;
        req.tradeRate = 6100L;
        req.settleFee = 150L;
        req.agentOrderNo = RandomUtil.randomString(18);
        req.cardNo = "4897348709886569";
        req.validPeriod = "0827";
        req.cvn = "569";
        req.phone = "15574775840";
        BaseRsp<TransSendMsgRsp> result = client.send(req, TransSendMsgRsp.class);
        TransSendMsgRsp data = result.getData();
        System.out.println(JSON.toJSONString(result));
        System.out.println(JSON.toJSONString(data));
    }

    private void modifyMerSettleCard(AgentApiClient client) {
        ModifyMerSettleCardReq req = new ModifyMerSettleCardReq();
        req.merchantCode = 344480975587237888L;
        req.bankCardNo = "6222024698416586806";
        req.phone = "15574775840";
        BaseRsp<ModifyMerSettleCardRsp> result = client.send(req, ModifyMerSettleCardRsp.class);
        ModifyMerSettleCardRsp data = result.getData();
        System.out.println(JSON.toJSONString(result));
        System.out.println(JSON.toJSONString(data));
    }

    private void queryMerUpStatus(AgentApiClient client) {
        MerUpStatusReq req = new MerUpStatusReq();
        req.merchantCode = 344480975587237888L;
        BaseRsp<MerUpStatusRsp> result = client.send(req, MerUpStatusRsp.class);
        MerUpStatusRsp data = result.getData();
        System.out.println(JSON.toJSONString(result));
        System.out.println(JSON.toJSONString(data));
    }

    private void testMerchantUp(AgentApiClient client) {
        MerchantUpReq req = new MerchantUpReq();
        //商户基本信息
        req.merPhone = "15843584970";

        //身份证信息
        req.idCardFrontFilepath = "http://oss-test.99kypay.com/mer_idcard_front/205b08b6ccf14387ad0f4e03825e4235.jpg";
        req.idCardBackFilepath = "http://oss-test.99kypay.com/mer_idcard_back/b5dcb74d3d3f47648757c6bae69d54e5.jpg";
        req.realName = "柏桂英";
        req.idCardNo = "152602198405148262";
        req.idCardValidRange = "20081121-20281121";

        //结算卡信息
        req.bankCardNo = "6222028595281655644";
        req.phone = "15843584970";

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
