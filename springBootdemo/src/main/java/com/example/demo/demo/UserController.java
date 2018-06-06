//package com.example.demo.demo;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.chamc.dao.UserDao;
//import com.chamc.model.User;
//import com.chamc.util.JsonUtil;
//import com.google.gson.Gson;
//
//@Controller
//public class UserController {
//	
//	@Autowired
//	private UserDao userMapper;
//	
//	@RequestMapping(value="/list")
//	@ResponseBody
//	public String list(){
//		User user = userMapper.selectUserById(1);
//		Gson gson =new Gson();
//		String userStr = gson.toJson(user);
//		return "spring boot mybatis :"+userStr;
//	}
//	
//	
//	
//	
//	@RequestMapping(value="/user")
//	@ResponseBody
//	public String test(){
//		/*User user = userMapper.selectUserById(1);
//		Gson gson =new Gson();
//		String userStr = gson.toJson(user);
//		return "spring boot mybatis :"+userStr;*/
//		User user = new User();
//		user.setName("张三");
//		String res=JsonUtil.toJsonString(user);
//        return res;
//	}
//	
//	
//	@RequestMapping(value = "/init", method = RequestMethod.GET)
//    public String doView(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
//		
//		User user = new User();
//		user.setName("张三");
//		map.addAttribute("user",user);
//		
//		return "index";
//    }
//	
//	
//	/**
//	 * 页面跳转并传递对象
//	 * @return
//	 */
//	@RequestMapping(value={"/doit"}, method = {RequestMethod.GET})
//	public ModelAndView doit(HttpServletRequest request,HttpServletResponse response)
//	{
//		//构建ModelAndView实例，并设置跳转地址
//		ModelAndView view = new ModelAndView("/index");
//		//将数据放置到ModelAndView对象view中,第二个参数可以是任何java类型
//		User user = new User();
//		user.setName("张三");
//		view.addObject("user",user);
//		//返回ModelAndView对象view
//		return view;
//	}
//	
//	
//}
