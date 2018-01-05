package com.yyy.user.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import com.alibaba.fastjson.JSONObject;
import com.yyy.user.util.HttpRequestDeviceUtils;

public class UsersController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("UsersController IS   handleRequest  start...");

		// 客户端有两个....N个【PC，手机】
		// PC浏览器发起的请求user_query.do 可以直接返回ModelAndView
		// 手机客户端发起的请求user_query.do 返回的数据JSON|XML

		// 同一个服务器能够同时服务多个不同类型的前端
	  arg1.setHeader("Access-Control-Allow-Origin", "*");
	  arg1.setHeader("Access-Control-Allow-Methods", "GET,POST");
	  arg1.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
	  arg1.setHeader("Access-Control-Allow-Credentials", "true");
	  arg1.setCharacterEncoding("UTF-8");
	  boolean flag = HttpRequestDeviceUtils.isMobileDevice(arg0);
	  PrintWriter printwriter=null;
      PrintWriter pw = arg1.getWriter();
      JSONObject json =new JSONObject();

	  if(flag)
	  {
		  System.out.println("来自于手机的请求");
		  json.put("result", "mobile");
		 
		  
		  
		  //返回数据，不可能使用springmvc的后端视图解析器，采用response对象来发送。
		  //数据的格式建议使用json.
	  }
	  else
	  {
		  System.out.println("来自于PC浏览器的请求");
		  json.put("result", "pc");
		  
		  //直接借用springmvc的后端视图解析器，来返回路径和视图，直接采用ModelAndView这个对象。
	  }
	  
	  //springaop,我们这个系统到底收手机的访问量和PC的访问量的次数。【Mongodb】
	  
	  //前置通知，命中手机特性，我们就直接把表中的数量作更新。
	  pw.write(json.toString());
	  pw.flush();
	  pw.close();;
		
		return null;
	}

}
