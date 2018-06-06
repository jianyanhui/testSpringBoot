教程：https://blog.csdn.net/u012255097/article/details/53813998

Map实现java缓存机制的简单实例
2016年12月22日 15:07:18
阅读数：10062
缓存是java中主要的内容，主要目的是缓解项目访问数据库的压力以及提升访问数据的效率，以下是通过Map实现java缓存的功能，并没有用cache相关框架。

一、缓存管理类 CacheMgr.java 

[java] view plain copy
package cache.com;  
  
import java.util.Date;  
import java.util.HashMap;  
import java.util.HashSet;  
import java.util.Iterator;  
import java.util.Map;  
import java.util.Set;  
/** 
 *  缓存管理类 
 * @author Administrator 
 * 
 */  
public class CacheMgr {  
      
     private static Map cacheMap = new HashMap();  
     private static Map cacheConfMap = new HashMap();  
       
     private static CacheMgr cm = null;  
       
     //构造方法  
     private CacheMgr(){  
     }  
       
      
       
     public static CacheMgr getInstance(){  
          if(cm==null){  
           cm = new CacheMgr();  
           Thread t = new ClearCache();  
           t.start();  
          }  
          return cm;  
         }  
       
       
     /** 
      * 增加缓存 
      * @param key 
      * @param value 
      * @param ccm 缓存对象 
      * @return  
      */  
     public  boolean addCache(Object key,Object value,CacheConfModel ccm){  
          System.out.println("开始增加缓存－－－－－－－－－－－－－");  
          boolean flag = false;  
          try {  
              cacheMap.put(key, value);  
              cacheConfMap.put(key, ccm);  
              System.out.println("增加缓存结束－－－－－－－－－－－－－");  
              System.out.println("now addcache=="+cacheMap.size());  
              flag=true;  
          } catch (Exception e) {  
            e.printStackTrace();  
          }  
            
          return flag;  
         }  
       
       
       /** 
        * 获取缓存实体 
        */  
     public Object getValue(String key){  
         Object ob=cacheMap.get(key);  
         if(ob!=null){  
             return ob;  
         }else{  
             return null;  
         }  
     }  
       
       
        /** 
         * 获取缓存数据的数量 
         * @return 
         */  
        public int getSize(){  
            return cacheMap.size();  
        }  
       
          
          
       
     /** 
      * 删除缓存 
      * @param key 
      * @return  
      */  
     public  boolean removeCache(Object key){  
         boolean flag=false;  
         try {  
              cacheMap.remove(key);  
              cacheConfMap.remove(key);  
              flag=true;  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
          return flag;  
         }  
       
       
       
     /** 
      * 清除缓存的类 
      * 继承Thread线程类 
      */  
     private static class ClearCache extends Thread{  
          public void run(){  
           while(true){  
            Set tempSet = new HashSet();  
            Set set = cacheConfMap.keySet();  
            Iterator it = set.iterator();  
            while(it.hasNext()){  
             Object key = it.next();  
             CacheConfModel ccm = (CacheConfModel)cacheConfMap.get(key);  
             //比较是否需要清除  
             if(!ccm.isForever()){  
              if((new Date().getTime()-ccm.getBeginTime())>= ccm.getDurableTime()*60*1000){  
               //可以清除，先记录下来  
               tempSet.add(key);  
              }  
             }  
            }  
            //真正清除  
            Iterator tempIt = tempSet.iterator();  
            while(tempIt.hasNext()){  
             Object key = tempIt.next();  
             cacheMap.remove(key);  
             cacheConfMap.remove(key);  
               
            }  
            System.out.println("now thread================>"+cacheMap.size());  
            //休息  
            try {  
             Thread.sleep(60*1000L);  
            } catch (InterruptedException e) {  
             e.printStackTrace();  
            }  
           }  
          }  
         }  
       
       
       
       
}  
二、缓存属性类 CacheConfModel.java

[java] view plain copy
package cache.com;  
/** 
 * 缓存属性类 
 * @author Administrator 
 * 
 */  
public class CacheConfModel implements java.io.Serializable{  
      
     private long beginTime;//缓存开始时间  
     private boolean isForever = false;//是否持久  
     private int durableTime;//持续时间  
       
     public long getBeginTime() {  
          return beginTime;  
         }  
         public void setBeginTime(long beginTime) {  
          this.beginTime = beginTime;  
         }  
         public boolean isForever() {  
          return isForever;  
         }  
         public void setForever(boolean isForever) {  
          this.isForever = isForever;  
         }  
         public int getDurableTime() {  
          return durableTime;  
         }  
         public void setDurableTime(int durableTime) {  
          this.durableTime = durableTime;  
         }  
  
}  

三、配置启动项目时自动加载　web.xml
[html] view plain copy
<?xml version="1.0" encoding="UTF-8"?>  
<web-app version="2.5"   
    xmlns="http://java.sun.com/xml/ns/javaee"   
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"   
    xsi:schemaLocation="http://java.sun.com/xml/ns/javaee   
    http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">  
      
    <servlet>  
      <servlet-name>testCache</servlet-name>  
      <servlet-class>cache.com.Cservlet</servlet-class>  
    </servlet>  
    <servlet-mapping>  
      <servlet-name>testCache</servlet-name>  
      <url-pattern>/testCache.do</url-pattern>  
    </servlet-mapping>  
      
    <servlet>  
        <servlet-name>cacheinitservlet</servlet-name>  
        <servlet-class>cache.com.LoadCache</servlet-class>  
        <load-on-startup>2</load-on-startup>  
    </servlet>  
      
  <welcome-file-list>  
    <welcome-file>index.jsp</welcome-file>  
  </welcome-file-list>  
</web-app>  
四、自动加载缓存的类　LoadCache.java

　　在此类中实现你想要初始化的缓存数据

[java] view plain copy
package cache.com;  
  
import java.util.Date;  
import javax.servlet.http.HttpServlet;  
  
import cache.com.CacheConfModel;  
import cache.com.CacheMgr;  
/** 
 * 项目启动时默认加载缓存数据类 
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
五、写一个测试类　Cservlet.java，我在这里写了一个servlet类进行测试的

[java] view plain copy
package cache.com;  
  
import java.io.PrintWriter;  
  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
/** 
 * 测试读取、添加缓存数据等 
 * @author Administrator 
 */  
public class Cservlet extends HttpServlet{  
      
    public void service(HttpServletRequest request,HttpServletResponse response){  
        try {  
            System.out.println("进入servlet类............");  
            request.setCharacterEncoding("utf-8");  
            response.setContentType("text/html;charset=UTF-8");   //3.设置响应类型  
  
            PrintWriter out = response.getWriter();  
              
              
            CacheMgr cm=CacheMgr.getInstance();  
              
            int numm=cm.getSize();//获取缓存个数  
            Object ob=cm.getValue("kk");  
            System.out.println("numm===========//======"+numm);  
            out.println("缓存个数为："+numm);  
            out.println("缓存数值：value===="+ob);  
              
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
          
      
          
    }  
  
}  

六、写一个简单的按钮页面　index.jsp
[html] view plain copy
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <base href="<%=basePath%>">  
      
    <title>My JSP 'index.jsp' starting page</title>  
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">      
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">  
    <!-- 
    <link rel="stylesheet" type="text/css" href="styles.css"> 
    -->  
  </head>  
    
  <body>  
    <form action="testCache.do" method="post">  
      <button type="submit" >获取缓存数据</button>  
      
    </form>  
  </body>  
</html>  


启动项目后点击按钮　“获取缓存数据”后，出现如下图说明缓存成功并成功取值了



