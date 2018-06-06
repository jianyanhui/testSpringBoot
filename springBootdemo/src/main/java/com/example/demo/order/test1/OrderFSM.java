package com.example.demo.order.test1;

/**
 * 订单简明状态机
 *
 * @author <a href="dongjianxing@aliyun.com">jeff</a>
 * @version 2017/1/22 13:37
 */
public class OrderFSM {
    private SpaceOrderFSMState fsmSpaceState = SpaceOrderFSMState.NOPAY_NOORDER;

    private OrderFSMContextData contextData;

    public static OrderFSM init(OrderFSMContextData contextData) {
        return new OrderFSM(contextData);
    }

    public OrderFSM(OrderFSMContextData contextData) {
        this.contextData = contextData;
    }

    public OrderFSM fire(FSMEvent event) throws TongaException {
        OrderFSM fsm = null;

        switch (event) {
            case ORDER_CREATE:
                fsm = orderCreate(contextData);
                break;
//            ...略...
            default:
                throw new TongaException("订单FSM不支持的事件类型");
        }
        return fsm;
     }

     public SpaceOrderFSMState getFsmSpaceState() {
        return fsmSpaceState;
     }
     public enum SpaceOrderFSMState {

        NOPAY_NOORDER,//(1020,"待支付待下单")
        NOPAY_ORDERFAILED,//(1023,"待支付下单失败")
        NOPAY_NOCONFIRM;//(1010,"待支付待确认")
//        ... 略...
     }
     public enum FSMEvent {

        ORDER_CREATE, //订单创建
        BUSINOTIFY_ORDERFAILED;//业务结果通知，下单失败
//        ... 略...
     }
     //以订单创建为例
     private OrderFSM orderCreate(OrderFSMContextData contextData) throws TongaException {
        if (fsmSpaceState != SpaceOrderFSMState.NOPAY_NOORDER) {//待支付待下单
            throw new TongaException("OTHER_ERROR", "FSM:当前状态不允许 ORDER_CREATE 事件");
        }
        //分销
        if (contextData.isDistribute()) {//是否为分销
            if (contextData.isPayed()) {//是否已经支付成功
            	//是否自营
//                this.fsmSpaceState = contextData.isSelfSupport() ? SpaceOrderFSMState.PAYED_NOCONFIRM : SpaceOrderFSMState.PAYED_NOORDER;
            } else {//未支付
            	//是否自营，自营为待支付待确认，非自营为待支付待下单
                this.fsmSpaceState = contextData.isSelfSupport() ? SpaceOrderFSMState.NOPAY_NOCONFIRM : SpaceOrderFSMState.NOPAY_NOORDER;
            }
        } else { //非分销
           
            this.fsmSpaceState = contextData.isSelfSupport() ? SpaceOrderFSMState.NOPAY_NOCONFIRM : SpaceOrderFSMState.NOPAY_NOORDER;
        }
        return this;
    }
// ... 略...
}