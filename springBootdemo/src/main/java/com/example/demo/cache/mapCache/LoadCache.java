package com.example.demo.cache.mapCache;

import java.util.Date;  
import javax.servlet.http.HttpServlet;  

/** 
 * 项目启动时默认加载缓存数据类 
 * 自动加载缓存的类　LoadCache.java
 * @author Administrator 
 */  
public class LoadCache extends HttpServlet{  
      
  
    public void init(){  
        addData();  
    }  
      
    /** 
     * 项目启动时加载缓存 
     */  
    public void addData(){  
        System.out.println("进入加载缓存addData()………………。");  
        CacheMgr cm=CacheMgr.getInstance();  
        CacheConfModel cModel=new CacheConfModel();  
        Date d=new Date();  
        cModel.setBeginTime(d.getTime());  
        cModel.setDurableTime(60);  
        cModel.setForever(true);  
        cm.addCache("kk", "123", cModel);//在缓存加值  
    }  
      
}  