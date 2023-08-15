package mcquick.agentApiDemo.entity.response;

import java.util.List;

public class QueryTradeCardRsp {
    /**
     * 商户编号
     */
    public Long merchantCode;
    /**
     * 交易卡列表
     */
    public List<MerBindTradeCardVo> tradeCards;

    public static class MerBindTradeCardVo {
        /**
         * 绑定状态  1 待签约确认  2 绑定成功 3 短信验证 4-绑定失败
         */
        private String bindStatus;
        /**
         * 绑卡标识
         */
        private String bindCardId;
        /**
         * 银行卡号
         */
        private String bankCardNo;
        /**
         * 拓展字段
         */
        private String extField;
    }
}
