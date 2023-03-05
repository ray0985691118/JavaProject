package Controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.member.ImplMemberDao;
import Model.Member;

public class AddMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddMemberController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	/*1.檢查帳號-->username-->重複
		 *2.true-->addMemberError
		 *3.false-->request所有-->new Member-->add(m) 
		 *4.addMembersuccess
		 */
    	request.setCharacterEncoding("BIG5");
    	String name = request.getParameter("name");
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	String address = request.getParameter("address");
    	String phone = request.getParameter("phone");
    	String email = request.getParameter("email");
    	HttpSession session = request.getSession();
    	
    	if(new ImplMemberDao().selectUser(username)){
    		if(email != null){
        		
        		session.setAttribute("NAME", name);
        		session.setAttribute("USERNAME", username);
        		session.setAttribute("PASSWORD", password);
        		session.setAttribute("ADDRESS", address);
        		session.setAttribute("PHONE", phone);
        		session.setAttribute("EMAIL", email);
        		
        		new ImplMemberDao().sendEmail(email);
        		response.sendRedirect("member/checkEmail.jsp");
    		}
    	}else {
    		response.sendRedirect("member/addMemberError.jsp");
    	}  	
	}
}
