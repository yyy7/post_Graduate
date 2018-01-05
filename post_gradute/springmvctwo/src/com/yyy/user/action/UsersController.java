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

		// �ͻ���������....N����PC���ֻ���
		// PC��������������user_query.do ����ֱ�ӷ���ModelAndView
		// �ֻ��ͻ��˷��������user_query.do ���ص�����JSON|XML

		// ͬһ���������ܹ�ͬʱ��������ͬ���͵�ǰ��
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
		  System.out.println("�������ֻ�������");
		  json.put("result", "mobile");
		 
		  
		  
		  //�������ݣ�������ʹ��springmvc�ĺ����ͼ������������response���������͡�
		  //���ݵĸ�ʽ����ʹ��json.
	  }
	  else
	  {
		  System.out.println("������PC�����������");
		  json.put("result", "pc");
		  
		  //ֱ�ӽ���springmvc�ĺ����ͼ��������������·������ͼ��ֱ�Ӳ���ModelAndView�������
	  }
	  
	  //springaop,�������ϵͳ�������ֻ��ķ�������PC�ķ������Ĵ�������Mongodb��
	  
	  //ǰ��֪ͨ�������ֻ����ԣ����Ǿ�ֱ�Ӱѱ��е����������¡�
	  pw.write(json.toString());
	  pw.flush();
	  pw.close();;
		
		return null;
	}

}
