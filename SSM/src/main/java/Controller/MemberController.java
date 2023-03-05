package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import Model.Member;
import Factory.Fact;
import Factory.ImplFactory;

@Controller
@RequestMapping("/member")
public class MemberController {
	Fact f = ImplFactory.a.getBean("sf",Fact.class);
	
	//轉成json格式，但pom要掛jackson套件
	@RequestMapping("/json")
	@ResponseBody
	public List<Object> getJson() throws IOException{
		List<Object> l = f.getMd().selectAll();
		return l;
	}
	
	//轉頁
	@RequestMapping("/addmember")
	public String addMember()
	{
		return "member/addmember";
	}
	@RequestMapping("/pordermanager")
	public String pordermanager()
	{
		return "porder/pordermanager";
	}
	@RequestMapping("/checkEmail")
	public String checkEmail()
	{
		return "member/checkEmail";
	}
	@RequestMapping("/emailCodeError")
	public String emailCodeError()
	{
		return "member/emailCodeError";
	}
	
	//判斷帳密
	@RequestMapping("/selectUser")
	public String loginuser(HttpSession session,String username,String password) throws IOException
	{
		List<Object> l = f.getMd().selectUser(username,password);
			if(l.size()==0)
			{
				return "member/addmember";
			}else
			{
				Member[] m=l.toArray(new Member[l.size()]);
				session.setAttribute("M",m[0]);
				return "porder/pordermanager";
			}
	}
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request,String username) throws Exception
	{
		List<Object> l = f.getMd().selectUser2(username);
		
		String name = request.getParameter("name");
    	String password = request.getParameter("password");
    	String address = request.getParameter("address");
    	String phone = request.getParameter("phone");
    	String admin = request.getParameter("admin");
		String email = request.getParameter("email");
		HttpSession session = request.getSession();
		
		if(l.size()==0){
			if(email!=null) {
				session.setAttribute("NAME", name);
        		session.setAttribute("USERNAME", username);
        		session.setAttribute("PASSWORD", password);
        		session.setAttribute("ADDRESS", address);
        		session.setAttribute("PHONE", phone);
        		session.setAttribute("ADMIN", admin);
        		session.setAttribute("EMAIL", email);
				f.getMd().sendEmail(email);
				return "member/checkEmail";
			}	
			return "member/emailCodeError";
		}
		return "member/error";
	}
	@RequestMapping("/sendEmail")
	public String checkEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int num = f.getMd().generate();
		System.out.println(num+"CheckEmailController");
		int code = Integer.parseInt(request.getParameter("code"));
		
		HttpSession session = request.getSession();
		request.setCharacterEncoding("BIG5");
		String N = (String)session.getAttribute("NAME");
		String U = (String)session.getAttribute("USERNAME");
		String P = (String)session.getAttribute("PASSWORD");
		String PH = (String)session.getAttribute("PHONE");
		String A = (String)session.getAttribute("ADDRESS");
		String ADMIN = (String)session.getAttribute("ADMIN");
		String E = (String)session.getAttribute("EMAIL");
		boolean AD = Boolean.parseBoolean("ADMIN");
		
		if(num == code) {
			
			   f.getMd().add(new Member(N,U,P,PH,A,AD,E));
			   return "member/success";
		}else {
			return "member/emailCodeError";
		}
	}
}
