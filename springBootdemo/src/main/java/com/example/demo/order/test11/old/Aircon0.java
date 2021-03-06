package com.example.demo.order.test11.old;
//import static tool.Print.*;//System.out.println 
/** 
 * 空调Aircon。简单的模型： 
 * 遥控器有两个按钮(更多的按钮在下面的例子中引入)，power电源键和cool制冷键。 
 * 空调的运行呈现3个状态，0-停止/Off、1-仅送风/FanOnly、2-制冷/Cool。 
 * 起始状态为Off 
 * @author (yqj2065)  
 * @version 0.1 
 */  
public class Aircon0{  
    // off，FanOnly，AC  
    private int state=0;//起始状态为Off  
    public int getState(){return state;}  
    //两个Action  
    public void power(){//按power键 事件 ，事件控制状态转换
    	System.out.println();
        if(state==0){//off  
            state=1;  
            System.out.println("start Fan");   
        }else if(state==1){//FanOnly  
            state=0;  
            System.out.println("stop Fan");   
        }else{  
            state=0;  
            System.out.println("stop Cool");   
        }  
    }  
  
    public void cool(){//按制冷键  事件，事件控制状态转换
        if(state==0){//off  
            System.out.println("nothing");  
        }else if(state==1){//FanOnly  
            state=2;  
            System.out.println("start Cool");   
        }else{  
            state=1;  
            System.out.println("stop Cool");   
        }  
    }  
}  

