package mcquick.agentApiDemo.entity.response.credit;

import java.util.List;

public class ProductListRsp {
    
    /**
     * 产品数量
     */
    public Long nums;
    /**
     * 产品详情
     */
    public List<ProductDetailVo> productDetailVos;

    public static class ProductDetailVo {
        /**
         * 激活价格，单位分
         */
        public String activePrice;
        /**
         * 申请流程图
         */
        public String applyProcessUrl;
        /**
         * 核卡价格，单位分
         */
        public String approvePrice;
        /**
         * 注意事项
         */
        public String attention;
        /**
         * 银行名称
         */
        public String bankName;
        /**
         * 卡片描述
         */
        public String cardDesc;
        /**
         * 首刷价格，单位分
         */
        public String firstUsedPrice;
        /**
         * 产品Id
         */
        public String id;
        /**
         * 银行logo地址
         */
        public String logo;
        /**
         * 产品名称
         */
        public String productName;
        /**
         * 产品图片地址
         */
        public String productPicUrl;
        /**
         * 地区限制，若有限制则传，如下格式：广东省#深圳市
         */
        public String region;
        /**
         * 地域限制类型，0-地区不可以办理 1-地区可办理 null-无限制
         */
        public String regionType;
        /**
         * 结算条件
         */
        public String settleCondition;
        /**
         * 结算周期
         */
        public Long settleCycle;
        /**
         * 结算规则
         */
        public String settleRule;
        /**
         * 结算类型（100：非周期，200：周期；当结算类型为周期时，approvePrice、activePrice、firstUsedPrice 失效）
         */
        public Integer settleType;
        /**
         * 结算方式（settle_type = 200时有值，100：核卡，200：激活，300：首刷）
         */
        public String settleMethod1;
        /**
         * 结算方式（settle_type = 200时有值，100：核卡，200：激活，300：首刷）
         */
        public List<String> settleMethod;
        /**
         * 核卡结算时间
         */
        public Integer nuclearType;
        /**
         * 激活结算时间
         */
        public Integer activationType;
        /**
         * 首刷结算时间
         */
        public Integer brushType;

        /**
         * 核卡第一时间阶段界限
         */
        public Integer nuclearDay1;
        /**
         * 核卡第一时间阶段结算价格
         */
        public Long nuclearCost1;
        /**
         * 核卡第二时间阶段界限
         */
        public Integer nuclearDay2;
        /**
         * 核卡第二时间阶段结算价格
         */
        public Long nuclearCost2;
        /**
         * 核卡第三时间阶段界限
         */
        public Integer nuclearDay3;
        /**
         * 核卡第三时间阶段结算价格
         */
        public Long nuclearCost3;

        /**
         * 激活第一时间阶段界限
         */
        public Integer activationDay1;
        /**
         * 激活第一时间阶段结算价格
         */
        public Long activationCost1;
        /**
         * 激活第二时间阶段界限
         */
        public Integer activationDay2;
        /**
         * 激活第二时间阶段结算价格
         */
        public Long activationCost2;
        /**
         * 激活第三时间阶段界限
         */
        public Integer activationDay3;
        /**
         * 激活第三时间阶段结算价格
         */
        public Long activationCost3;

        /**
         * 首刷第一阶段界限
         */
        public Integer brushDay1;
        /**
         * 首刷第一阶段结算价格
         */
        public Long brushCost1;
        /**
         * 首刷第二阶段界限
         */
        public Integer brushDay2;
        /**
         * 首刷第二阶段结算价格
         */
        public Long brushCost2;
        /**
         * 首刷第三阶段界限
         */
        public Integer brushDay3;
        /**
         * 首刷第三阶段结算价格
         */
        public Long brushCost3;
    }
}
