package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Porder;
import dao.porder.ImplPorder;

public class QueryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public QueryController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	String start = request.getParameter("start");
     	String end = request.getParameter("end");
     	HttpSession session = request.getSession();
     	
     	Object o = session.getAttribute("L");
     	if(o!=null) {
     		session.removeAttribute("L");
     	}
     	
     	if(start != null && start != "" && end != null && end != "")
     		{
     			int s = Integer.parseInt(start);
     			int e = Integer.parseInt(end);
     		
     			List<Porder> l = new ImplPorder().selectSum(s,e);
     			//Porder[] p = l.toArray(new Porder[l.size()]);
     			//Porder p = new ImplPorder().selectSum2(s, e);
     			session.setAttribute("L", l);
     			response.sendRedirect("porder/query.jsp");
     		}else{
     			response.sendRedirect("porder/query.jsp");
     		}
	}

}
