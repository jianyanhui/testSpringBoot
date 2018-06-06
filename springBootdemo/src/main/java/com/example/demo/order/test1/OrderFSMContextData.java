package com.example.demo.order.test1;

/**
 * 订单简明状态机上下文数据
 *
 * @author <a href="dongjianxing@aliyun.com">jeff</a>
 * @version 2017/1/22 13:40
 */
public class OrderFSMContextData {
    private boolean isPayed;//是否已经支付成功
    private boolean isDistribute;//是否为分销
    private boolean isSelfSupport;//是否自营
    private boolean isInquiry;//是否询单

    public OrderFSMContextData(boolean isPayed, boolean isDistribute, boolean isSelfSupport, boolean isInquiry) {
        this.isPayed = isPayed;
        this.isDistribute = isDistribute;
        this.isSelfSupport = isSelfSupport;
        this.isInquiry = isInquiry;
    }

    public boolean isPayed() {
        return isPayed;
    }

    public boolean isDistribute() {
        return isDistribute;
    }

    public boolean isSelfSupport() {
        return isSelfSupport;
    }

    public boolean isInquiry() {
        return isInquiry;
    }
}