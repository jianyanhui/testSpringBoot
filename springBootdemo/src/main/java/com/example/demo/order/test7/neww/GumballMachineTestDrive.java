package com.example.demo.order.test7.neww;
/*这样做的优点:
1. 将每个状态的行为局部化到自己的类中
2. 将容易产生问题的if语句删除,以方便日后的维护
3. 让每个状态"对修改关闭",让糖果机"对拓展开放",因为可以加入新的状态类
4. 创建一个新的代码基和类结构,这更能映射糖果的图,而且容易阅读和理解*/
public class GumballMachineTestDrive {  
	  
    public static void main(String[] args) {  
        GumballMachine gumballMachine = new GumballMachine(5);  //状态机上下文
  
        System.out.println(gumballMachine);  
  
        gumballMachine.insertQuarter();  
        gumballMachine.turnCrank();  
  
        System.out.println(gumballMachine);  
  
        gumballMachine.insertQuarter();  
        gumballMachine.turnCrank();  
        gumballMachine.insertQuarter();  
        gumballMachine.turnCrank();  
  
        System.out.println(gumballMachine);  
    }  
}  