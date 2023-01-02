package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import Factory.fact;
import Factory.implFactory;
import Model.member;

@Controller
@RequestMapping("/member")
public class memberController {
	fact f=implFactory.a.getBean("sf",fact.class);
	
	//轉頁
	@RequestMapping("/addmember")
	public String addmember()
	{
		return "member/addmember";
	}
	@RequestMapping("/pordermanager")
	public String pordermanager()
	{
		return "porder/pordermanager";
	}
	
	//判斷帳密
	@RequestMapping("/loginuser")
	public String loginuser(HttpSession session,String username,String password) throws IOException
	{
		List<Object> l=f.getMd().queryuser(username,password);
			if(l.size()==0)
			{
				return "member/addmember";
			}else
			{
				member[] m=l.toArray(new member[l.size()]);
				session.setAttribute("M",m[0]);
				return "porder/pordermanager";
			}
	}
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request,String username) throws Exception
	{
		request.setCharacterEncoding("BIG5");
		
		List<Object> l=f.getMd().queryuser2(username);
		if(l.size()!=0)
		{
			return "member/error";
		}else
		{
			String N=request.getParameter("name");
			String P=request.getParameter("password");
			String PH=request.getParameter("phone");
			String A=request.getParameter("address");
			String ADMIN=request.getParameter("admin");
			boolean AD=Boolean.parseBoolean("ADMIN");
			
			   f.getMd().add(new member(N,username,P,PH,A,AD));
			   return "member/success";
		}
	}
}
