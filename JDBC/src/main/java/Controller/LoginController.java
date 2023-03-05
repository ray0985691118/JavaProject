package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.member.ImplMemberDao;
import Model.Member;


public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	/*
		 * 1.request-->接收-->username,password
		 * 2.判斷帳號密碼--->queryuser(帳號,密碼)
		 * 3.response-->true-->loginSuccess
		 * 4.response--->false-->loginError
		 */
    	String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		
		/*List<Member> l = new ImplMemberDao().selectUser(username,password);
		Member[] m = l.toArray(new Member[l.size()]);*/
		Member  m = new ImplMemberDao().selectUser2(username,password);
		if(m != null)
		{
			session.setAttribute("M",m);
			response.sendRedirect("member/loginSuccess.jsp");
		}else
		{
			response.sendRedirect("member/loginError.jsp");
		}
	}

}
