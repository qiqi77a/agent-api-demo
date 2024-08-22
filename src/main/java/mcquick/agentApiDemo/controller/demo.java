package mcquick.agentApiDemo.controller;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson2.JSON;
import mcquick.agentApiDemo.entity.request.comm.CommSubmitOrderReq;
import mcquick.agentApiDemo.entity.request.credit.ApplyCardReq;
import mcquick.agentApiDemo.entity.request.credit.ProductListReq;
import mcquick.agentApiDemo.entity.request.credit.QueryOrderReq;
import mcquick.agentApiDemo.entity.response.base.BaseRsp;
import mcquick.agentApiDemo.entity.response.comm.CommSubmitOrderRsp;
import mcquick.agentApiDemo.entity.response.comm.OrderCallbackMsgVo;
import mcquick.agentApiDemo.entity.response.credit.ApplyCardRsp;
import mcquick.agentApiDemo.entity.response.credit.ProductListRsp;
import mcquick.agentApiDemo.entity.response.credit.QueryOrderRsp;
import mcquick.agentApiDemo.exception.CheckException;
import mcquick.agentApiDemo.util.AgentApiClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class demo {

    @Resource
    private AgentApiClient agentApiClient;

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
    public String test() {
        try {
            //通讯卡不选卡下单
//            commNoPikeSubmitOrder(agentApiClient);
            //查询办卡产品
//            queryProductList(agentApiClient);
            //办卡申请
//            applyCard(agentApiClient);
            //查询办卡订单
            queryApplyCardOrder(agentApiClient);
        } catch (CheckException e) {
            e.printStackTrace();
        }
        return "success";
    }

    private void queryApplyCardOrder(AgentApiClient client) {
        QueryOrderReq req = new QueryOrderReq();
        req.orderNo = "7l2986ma9vpkexhfsllwm1wi6vpbob1z";
        BaseRsp<QueryOrderRsp> result = client.send(req, QueryOrderRsp.class);
        QueryOrderRsp data = result.getData();
        System.out.println(JSON.toJSONString(result));
        System.out.println(JSON.toJSONString(data));
    }

    private void applyCard(AgentApiClient client) {
        ApplyCardReq req = new ApplyCardReq();
        req.orderNo = RandomUtil.randomString(32);
        req.itemId = "200003";
        req.idCardNo = "420101198302114000";
        req.idCardName = "章易太";
        req.contactTel = "13865235994";
        req.contactProv = "广东省";
        req.contactCity = "深圳市";
        BaseRsp<ApplyCardRsp> result = client.send(req, ApplyCardRsp.class);
        ApplyCardRsp data = result.getData();
        System.out.println(JSON.toJSONString(result));
        System.out.println(JSON.toJSONString(data));
    }

    private void queryProductList(AgentApiClient client) {
        ProductListReq req = new ProductListReq();
        req.agentId = client.getAgentId();
        BaseRsp<ProductListRsp> result = client.send(req, ProductListRsp.class);
        ProductListRsp data = result.getData();
        System.out.println(JSON.toJSONString(result));
        System.out.println(JSON.toJSONString(data));
    }

    private void commNoPikeSubmitOrder(AgentApiClient client) {
        CommSubmitOrderReq req = new CommSubmitOrderReq();
        req.tradeNo = RandomUtil.randomString(32);
//        req.tradeNo = "qpylierhye9hc6y33dackwttskt49lk9";
        req.itemId = 1660;
        req.idCardNo = "420101199807170328";
        req.idCardName = "秦阿";
        req.contactor = "秦阿";
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
}
