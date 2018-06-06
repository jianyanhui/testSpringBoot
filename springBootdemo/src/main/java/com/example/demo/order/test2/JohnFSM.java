package com.example.demo.order.test2;

import java.io.*;
/*教程：https://download.csdn.net/download/bjgs2004/794295
*/

public class JohnFSM 
{    
	  private static String[] str={"Activated","Deactivated","Stopped","Walking","Running","LeftArmRaised",
                      "LeftArmLowered","RightArmRaised","RightArmLowered","HeadTurned","Talking"};
    private static int m_curState=1;
	
    private static int m_InputEvents; 
	
	
    public static void  bootUp()
    {
    	m_curState=0;
    	m_InputEvents=0; 
    	System.out.println("John is turning on");
    }
    public static void  goWalk()
    {
    	m_curState=3;
    	m_InputEvents=3;
    	System.out.println("John will begin to walk");
    }
    public static void  goRun()
    {
    	m_curState=4;
    	m_InputEvents=4;
    	System.out.println("John will begin to run");
    }
    public static void  say(String text)
    {
    	m_curState=10;
    	m_InputEvents=10;
    	System.out.println("John will say"+text);
    }
    public static void  turningHead()
    {
    	m_curState=9;
    	m_InputEvents=9;
    	System.out.println("John rotates head ");
    }
    public static void  RaiseleftArm()
    {
    	m_curState=5;
    	m_InputEvents=5;
    	System.out.println("John raise left arm");
    }
    public static void  LowerleftArm()
    {
    	m_curState=6;
    	m_InputEvents=6;
    	System.out.println("John lowers left arm");
    }
    public static void  RaiseRightArm()
    {
    	m_curState=7;
    	m_InputEvents=7;
    	System.out.println("John raises right arm");
    }
    public static void  LowerRightArm()
    {
    	m_curState=8;
    	m_InputEvents=8;
    	System.out.println("John lowers right arm");
    }
    public static void  Stop()
    {
    	m_curState=2;
    	m_InputEvents=2;
    	System.out.println("John stops current action");
    }
    public static void  shutDown()
    {
    	m_curState=1;
    	m_InputEvents=1;
    	System.out.println("John will shut off");
    }
	
    public static void  ProcessEvent(int e )
   {
	   switch( m_curState ) 
    { 

		 case 1:	

		  if( e == 0 ) 
		  {
				bootUp();
				break;
		  }
		  else
		  {
				System.out.println("error");
				break;
		  }
	   case 0:		
	   case 2:        
		   {
			switch( e )
			   { 
				   case  3:
					   {
						goWalk();
						break;
					   }
				   case  4:
					   {

						   goRun();
						   break;
					   }

				   case  5:
					   {

						   goWalk();
						   break;
					   }
				   case  6:
					   {

						   goWalk();
						   break;
					   }

				   case  7:
					   {
						   goWalk();
						   break;
					   }

				   case  8:
					   {
						   goWalk();
						   break;
					   }

				   case  9:
					   {
						   goWalk();
						   break;
					   }

				   case  10:
					   {
						   String text="";
						   System.out.println("Please input a string\n");
						   try{
						     BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
						     text=br.readLine();
						    }catch(Exception ce){System.out.println("IO Exception");}
						   m_curState=10;
						   m_InputEvents=10;
						   say(text);
						   break;
					   }
				   case  1:
					   shutDown();
					   break;
				   default: 
						System.out.println("error");
			   }
			   break;

		   }
	   case 3: 
		   switch( e ) 
		   { 
		   case 2:
			    Stop();
				break;
		   default:
				System.out.println("error");
		   }
		   break;	   
	   case 4:
		   switch( e ) 
		   { 
		   case 2:
			   Stop();
			   break;
		   default: 
				   System.out.println("error");
		   }
		   break;	   
	   case 5: 
		   switch( e ) 
		   { 
		   case 2:
			   Stop();
			   break;
		   default :
				   System.out.println("error");
		   }
		   break;	   
	   case 6:
		   switch( e ) 
		   { 
		   case 2:
			   Stop();
			   break;
		   default :
				   System.out.println("error");
		   }
		   break;	   
	   case 7:
		   switch( e ) 
		   { 
		   case 2:
			   Stop();
			   break;
		   default: 
				   System.out.println("error");
		   }
		   break;	   
	   case 8:
		   switch( e ) 
		   { 
		   case 2:
			   Stop();
			   break;
		   default: 
				   System.out.println("error");
		   }
		   break;	   
	   case 9:
		   switch( e ) 
		   {
		   case 2:
			   Stop();
			   break;
		   default: 
				   System.out.println("error");
		   }
		   break;	   
	   case 10:
		   switch( e ) 
		   { 
		   case 2:
			   Stop();
			   break;
		   default: 
				   System.out.println("error");
		   }
		   break;	   
   }
}						

  public void JohnFSM()
  {
	  m_curState=1;
  }
  /*public int GetCurrentState() 
  { 
  	return m_curState; 
  }*/
  public static void Run()
  {
	   int e=0;
	   System.out.println("当前状态为："+str[m_curState]);
	   System.out.println("请输入事件编号：\r\n turnOn:0,\r\n turnOff:,\r\n stop:2,\r\n walk:3,\r\n run:4,\r\n raiseLeftArm:5,\r\n lowerLeftArm:6,\r\n raiseRightArm:7,\r\n lowerRightArm:8,\r\n turnHead:9,\r\n speak:10\n");
	   while(true)
	   {
		   System.out.println("当前状态为："+str[m_curState]);
		   try
		   {
		     BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		     e=Integer.valueOf(br.readLine()).intValue(); 
		   }catch(Exception de){System.out.println("IO excepton");}
		   ProcessEvent(e);
	  }
  }

  public static void main(String args[])
  {
	   JohnFSM.Run();
  }	
}

