package Controller;


import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import Model.Member;
import Model.Porder;
import Factory.Fact;
import Factory.ImplFactory;

@Controller
@RequestMapping("/porder")
public class PorderController {
	
	Fact f=ImplFactory.a.getBean("sf",Fact.class);
	
	//轉頁
	@RequestMapping("/pordermanager")
	public String Pordermanager()
	{
		return "porder/pordermanager";
	}
	@RequestMapping("/addporder")
	public String addPorder()
	{
		return "porder/addporder";
	}
	@RequestMapping("/queryporder")
	public String queryPorder()
	{
		return "porder/queryporder";
	}
	@RequestMapping("/updateporder")
	public String updatePorder()
	{
		return "porder/updateporder";
	}
	@RequestMapping("/deleteporder")
	public String deletePorder()
	{
		return "porder/deleteporder";
	}
	//新增
	@RequestMapping("/add")
	public String add(HttpSession session,HttpServletRequest request) throws IOException
	{
		request.setCharacterEncoding("BIG5");
		
		int P1 = Integer.parseInt(request.getParameter("arabica"));
		int P2 = Integer.parseInt(request.getParameter("mandheling"));
		int P3 = Integer.parseInt(request.getParameter("yirgacheffe"));
		Member m = (Member)session.getAttribute("M");
		f.getPd().add(new Porder(m.getName(),P1,P2,P3,new Date()));
		return "porder/pordermanager";
	}
	//查詢範圍
	@RequestMapping("/selectRange")
	public String selectRange(HttpSession session,Integer start,Integer end) throws IOException
	{
		if(start != null && end != null)
		{
			List<Porder> l = f.getPd().selectRange(start,end);
			Porder[] p = l.toArray(new Porder[l.size()]);
			session.setAttribute("P", p);
		}
			return "porder/queryporder";
	}
	//修改
		@RequestMapping("/updateId")
		public String updateId(HttpServletRequest request,Integer id)throws Exception{
		   
			int P1 = Integer.parseInt((request.getParameter("arabica")));
			int P2 = Integer.parseInt((request.getParameter("mandheling")));
			int P3 = Integer.parseInt((request.getParameter("yirgacheffe")));
			List<Object> pp = f.getPd().selectId(id);	
			Porder[] p = pp.toArray(new Porder[pp.size()]);
			p[0].setArabica(P1);
		    p[0].setMandheling(P2);
			p[0].setYirgacheffe(P3);
			p[0].getSum();
			f.getPd().update(p[0]);
			return "porder/updateporder";  
		}
		
	    //刪除
		@RequestMapping("/deleteId")
	   public String deleteId(HttpServletRequest request,Integer id)throws Exception{
			List<Object> pp = f.getPd().selectId(id);	
			Porder[] p = pp.toArray(new Porder[pp.size()]);
		    f.getPd().delete(p[0]);
		    return "porder/deleteporder";  
				
		
		}		
	}