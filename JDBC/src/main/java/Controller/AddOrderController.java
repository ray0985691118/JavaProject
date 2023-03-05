package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.porder.ImplPorder;
import Model.Porder;

public class AddOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override //使用@Override這樣service如果打錯也可以檢測出來
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	/*
		 * 1.接收訂單物件-->前一頁
		 * 2.新增資料庫
		 * 3.切換到finish
		 */
    	HttpSession session=request.getSession();//HttpSession是介面不能new所以要用request.getSession抓下來
    	Porder p=(Porder) session.getAttribute("P");//session.getAttribute("P")是物件要轉型成跟Porder同類型
    	new ImplPorder().add(p);
    	response.sendRedirect("porder/finish.jsp");
	}

}
