package com.example.demo.order.test4;

abstract class OrderState {  
	/**订单确认*/
    abstract void confirm(OrderContext orderContext);  
    /**订单修改*/
    abstract void modify(OrderContext orderContext);  
    /**订单支付*/
    abstract void pay(OrderContext orderContext);  
}  
