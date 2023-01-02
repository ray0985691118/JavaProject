package Controller;


import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import Factory.fact;
import Factory.implFactory;
import Model.member;
import Model.porder;

@Controller
@RequestMapping("/porder")
public class porderController {
	
	fact f=implFactory.a.getBean("sf",fact.class);
	
	//轉頁
	@RequestMapping("/pordermanager")
	public String pordermanager()
	{
		return "porder/pordermanager";
	}
	@RequestMapping("/addporder")
	public String addporder()
	{
		return "porder/addporder";
	}
	@RequestMapping("/queryporder")
	public String queryporder()
	{
		return "porder/queryporder";
	}
	@RequestMapping("/updateporder")
	public String updateporder()
	{
		return "porder/updateporder";
	}
	@RequestMapping("/deleteporder")
	public String deleteporder()
	{
		return "porder/deleteporder";
	}
	//新增
	@RequestMapping("/add")
	public String add(HttpSession session,HttpServletRequest request) throws IOException
	{
		request.setCharacterEncoding("BIG5");
		
		int P1=Integer.parseInt(request.getParameter("product1"));
		int P2=Integer.parseInt(request.getParameter("product2"));
		int P3=Integer.parseInt(request.getParameter("product3"));
		member m=(member)session.getAttribute("M");
		f.getPd().add(new porder(m.getName(),P1,P2,P3,new Date()));
		return "porder/pordermanager";
	}
	//查詢範圍
	@RequestMapping("/querysum")
	public String querysum(HttpSession session,Integer start,Integer end) throws IOException
	{
		if(start!=null && end!=null)
		{
			List<porder> l=f.getPd().queryrange(start,end);
			porder[] p=l.toArray(new porder[l.size()]);
			session.setAttribute("P", p);
		}
			return "porder/queryporder";
	}
	//修改
		@RequestMapping("/updateId")
		public String updateId(HttpServletRequest request,Integer id)throws Exception{
		   
			int P1=Integer.parseInt((request.getParameter("product1")));
			int P2=Integer.parseInt((request.getParameter("product2")));
			int P3=Integer.parseInt((request.getParameter("product3")));
			List<Object> pp= f.getPd().query(id);	
			porder[] p=pp.toArray(new porder[pp.size()]);
			p[0].setProduct1(P1);
		    p[0].setProduct2(P2);
			p[0].setProduct3(P3);
			p[0].getSum();
			f.getPd().update(p[0]);
			return "porder/updateporder";  
		}
		
	    //刪除
		@RequestMapping("/deleteId")
	   public String deleteId(HttpServletRequest request,Integer id)throws Exception{
			List<Object> pp= f.getPd().query(id);	
			porder[] p=pp.toArray(new porder[pp.size()]);
		    f.getPd().delete(p[0]);
		    return "porder/deleteporder";  
				
		
		}		
	}