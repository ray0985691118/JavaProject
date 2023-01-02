package Dao.porder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.DbConnection;
import Model.porder;

public class implPorder implements porderDao{

	public static void main(String[] args) {
		/*porder p=new porder("A桌",5,5,6);
		new implPorder().add(p);*/
		
		//System.out.println(new implPorder().selectAll1());
		System.out.println(new implPorder().selectAll2());
	}

	@Override
	public void add(porder p) {
		Connection con=DbConnection.getDb();
		String SQL="insert into porder(desk,A,B,C,sum) value(?,?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(SQL);
			ps.setString(1, p.getDesk());
			ps.setInt(2, p.getA());
			ps.setInt(3, p.getB());
			ps.setInt(4, p.getC());
			ps.setInt(5, p.getSum());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String selectAll1() {
		Connection con=DbConnection.getDb();
		String SQL="select * from porder";
		String show="";
		try {
			PreparedStatement ps=con.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				show=show+"<tr><td>:"+rs.getInt("id")+
						"<td>"+rs.getString("desk")+
						"<td>"+rs.getInt("A")+
						"<td>"+rs.getInt("B")+
						"<td>"+rs.getInt("C")+
						"<td>"+rs.getInt("sum");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return show;
	}
	@Override
	public List<porder> selectAll2() {
		Connection con=DbConnection.getDb();
		String SQL="select * from porder";
		List<porder> l=new ArrayList();
		
		try {
			PreparedStatement ps=con.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				porder p=new porder();
				p.setId(rs.getInt("id"));
				p.setDesk(rs.getString("desk"));
				p.setA(rs.getInt("A"));
				p.setB(rs.getInt("B"));
				p.setC(rs.getInt("C"));
				p.setSum(rs.getInt("sum"));
				
				l.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<porder> selectSum(int start, int end) {
		Connection con=DbConnection.getDb();
		String SQL="select * from porder where sum>=? and sum<=?";
		List<porder> l=new ArrayList();
		
		try {
			PreparedStatement ps=con.prepareStatement(SQL);
			ps.setInt(1	,start);
			ps.setInt(2, end);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				porder p=new porder();
				p.setId(rs.getInt("id"));
				p.setDesk(rs.getString("desk"));
				p.setA(rs.getInt("A"));
				p.setB(rs.getInt("B"));
				p.setC(rs.getInt("C"));
				p.setSum(rs.getInt("sum"));
				
				l.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}
	@Override
	public List<porder> selectId(int id) {
		Connection conn=DbConnection.getDb();
		String sql="select * from porder where id=?";
		List<porder> l=null;
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				l=new ArrayList();
				
				porder p=new porder();
				p.setId(rs.getInt("id"));
				p.setDesk(rs.getString("desk"));
				p.setA(rs.getInt("A"));
				p.setB(rs.getInt("B"));
				p.setC(rs.getInt("C"));
				p.setSum(rs.getInt("sum"));
				
				l.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return l;
	}

	@Override
	public void update(porder p) {
		Connection con=DbConnection.getDb();
		String SQL="update porder set desk=?,A=?,B=?,C=?,sum=? where id=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(SQL);
			ps.setString(1, p.getDesk());
			ps.setInt(2, p.getA());
			ps.setInt(3, p.getB());
			ps.setInt(4, p.getC());
			ps.setInt(5, p.getSum());
			ps.setInt(6, p.getId());
			
			ps.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}		

	@Override
	public void delete(int id) {
		Connection conn=DbConnection.getDb();
		String Sql="delete from porder where id=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(Sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}