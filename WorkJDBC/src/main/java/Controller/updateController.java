package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.porder.implPorder;
import Model.porder;

public class updateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public updateController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override //如果不確定是用超連接或表單就用service,超連結用doGet,表單用doPost
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	/*
		 * 1.接收-->request
		 * 2.if判斷-->!=null && !=""
		 * 3.轉型-->id,A,B,C-->int
		 * 4.執行修改
		 * 5.切換回到--->update.jsp
		 */
    	request.setCharacterEncoding("UTF-8");
    	String ID=request.getParameter("id");
    	String Desk=request.getParameter("desk");
    	String A=request.getParameter("A");
    	String B=request.getParameter("B");
    	String C=request.getParameter("C");
    	
    	if(ID!=null && ID!="" && A!=null && A!="" && B!=null && B!="" && C!=null && C!="")
    	{
    		int id=Integer.parseInt(ID);
    		int a=Integer.parseInt(A);
    		int b=Integer.parseInt(B);
    		int c=Integer.parseInt(C);
    		
    		List<porder> l=new implPorder().selectId(id);
    		porder[] p=l.toArray(new porder[l.size()]);
    		
    		p[0].setDesk(Desk);
    		p[0].setA(a);
    		p[0].setB(b);
    		p[0].setC(c);
    		
    		new implPorder().update(p[0]);
    	}
    	response.sendRedirect("porder/update.jsp");
	}

}
