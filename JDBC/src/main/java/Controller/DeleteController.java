package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.porder.ImplPorder;

public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	/*
		 * 1.接收-->request
		 * 2.if判斷-->!=null && !=""
		 * 3.轉型-->id->int
		 * 4.執行刪除-->delete(id);
		 * 5.response切換回到--->delete.jsp
		 */
    	String ID=request.getParameter("id");
    	if(ID!=null && ID!="")
    	{
    		int id=Integer.parseInt(ID);
    		new ImplPorder().delete(id);
    	}
    	response.sendRedirect("porder/delete.jsp");
	}

}
