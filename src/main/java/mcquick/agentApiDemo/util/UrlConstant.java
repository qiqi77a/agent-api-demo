package mcquick.agentApiDemo.util;

import mcquick.agentApiDemo.entity.request.comm.CommSubmitOrderReq;
import mcquick.agentApiDemo.entity.request.credit.ApplyCardReq;
import mcquick.agentApiDemo.entity.request.credit.ProductListReq;
import mcquick.agentApiDemo.entity.request.credit.QueryOrderReq;
import mcquick.agentApiDemo.entity.response.comm.CommSubmitOrderRsp;
import mcquick.agentApiDemo.entity.response.credit.ApplyCardRsp;
import mcquick.agentApiDemo.entity.response.credit.ProductListRsp;
import mcquick.agentApiDemo.entity.response.credit.QueryOrderRsp;
import mcquick.agentApiDemo.enums.RequestType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum UrlConstant {
    COMM_NO_PIKE_SUBMIT_ORDER(CommSubmitOrderReq.class, "/comm/submitOrder", RequestType.POST, CommSubmitOrderRsp.class, false),
    CREDIT_PRODUCT_LIST(ProductListReq.class, "/credit/productList", RequestType.POST, ProductListRsp.class, false),
    CREDIT_APPLY_CARD(ApplyCardReq.class, "/credit/applyCard", RequestType.POST, ApplyCardRsp.class, false),
    CREDIT_QUERY_CARD_ORDER(QueryOrderReq.class, "/credit/queryCardOrder", RequestType.POST, QueryOrderRsp.class, false),
    ;

    private Class<?> req;
    private String url;
    private RequestType type;
    private Class<?> rsp;
    /**
     * 返回类型是否是List
     */
    private Boolean isRspList;

    UrlConstant(Class<?> req, String url, RequestType type, Class<?> rsp, Boolean isRspList){
        this.req = req;
        this.url = url;
        this.type = type;
        this.rsp = rsp;
        this.isRspList = isRspList;
    }

    public static String getUrlByReq(Class<?> req) {
        List<UrlConstant> collect = Arrays.stream(UrlConstant.values()).filter(i -> i.req == req).collect(Collectors.toList());
        return collect.size()>0 ? collect.get(0).url : null;
    }

    public static Class<?> getRspByReq(Class<?> req) {
        List<UrlConstant> collect = Arrays.stream(UrlConstant.values()).filter(i -> i.req == req).collect(Collectors.toList());
        return collect.size()>0 ? collect.get(0).rsp : null;
    }

    public static String getUrlByRsp(Class<?> rsp) {
        List<UrlConstant> collect = Arrays.stream(UrlConstant.values()).filter(i -> i.rsp == rsp).collect(Collectors.toList());
        return collect.size()>0 ? collect.get(0).url : null;
    }

    public static UrlConstant getUrlConstantByReq(Class<?> req){
        List<UrlConstant> collect = Arrays.stream(UrlConstant.values()).filter(i -> i.req == req).collect(Collectors.toList());
        return collect.size()>0 ? collect.get(0) : null;
    }

    public static UrlConstant getUrlConstantByRsp(Class<?> rsp){
        List<UrlConstant> collect = Arrays.stream(UrlConstant.values()).filter(i -> i.rsp == rsp).collect(Collectors.toList());
        return collect.size()>0 ? collect.get(0) : null;
    }


    public Class<?> getReq() {
        return req;
    }

    public void setReq(Class<?> req) {
        this.req = req;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public RequestType getType() {
        return type;
    }

    public void setType(RequestType type) {
        this.type = type;
    }

    public Class<?> getRsp() {
        return rsp;
    }

    public void setRsp(Class<?> rsp) {
        this.rsp = rsp;
    }

    public Boolean getRspList() {
        return isRspList;
    }

    public void setRspList(Boolean rspList) {
        isRspList = rspList;
    }
}
