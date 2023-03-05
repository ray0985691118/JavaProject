package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Member;
import dao.member.ImplMemberDao;


public class CheckEmailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CheckEmailController() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int num = new ImplMemberDao().generate();
		System.out.println(num+"CheckEmailController");
		int code = Integer.parseInt(request.getParameter("code"));
		HttpSession session = request.getSession();
		
		if(num == code) {
			String name = (String) session.getAttribute("NAME");
			String username = (String) session.getAttribute("USERNAME");
			String password = (String) session.getAttribute("PASSWORD");
			String address = (String) session.getAttribute("ADDRESS");
			String phone = (String) session.getAttribute("PHONE");
			String email = (String) session.getAttribute("EMAIL");
    		
    		Member m=new Member(name,username,password,address,phone,email);
    		new ImplMemberDao().add(m);
			response.sendRedirect("member/addMemberSuccess.jsp");
		}else {
			response.sendRedirect("member/emailCodeError.jsp");
		}
	}

}
