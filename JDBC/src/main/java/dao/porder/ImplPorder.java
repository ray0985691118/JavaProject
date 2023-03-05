package dao.porder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Porder;
import dao.DbConnection;

public class ImplPorder implements PorderDao{

	public static void main(String[] args) {
		/*Porder p=new Porder("A桌",5,5,6);
		new ImplPorder().add(p);*/
		
		//System.out.println(new ImplPorder().selectAll1());
		System.out.println(new ImplPorder().selectAll2());
	}

	@Override
	public void add(Porder p) {
		Connection con=DbConnection.getDB();
		//String SQL="insert into Porder(address,A,B,C,sum) value(?,?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement("insert into Porder(address,A,B,C,sum) value(?,?,?,?,?)");
			ps.setString(1, p.getAddress());
			ps.setInt(2, p.getA());
			ps.setInt(3, p.getB());
			ps.setInt(4, p.getC());
			ps.setInt(5, p.getSum());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public String selectAll1() {
		Connection con=DbConnection.getDB();
		//String SQL="select * from Porder";
		String show="";
		try {
			PreparedStatement ps=con.prepareStatement("select * from Porder");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				show=show+"<tr><td>"+rs.getInt("id")+
						"<td>"+rs.getString("address")+
						"<td>"+rs.getInt("A")+
						"<td>"+rs.getInt("B")+
						"<td>"+rs.getInt("C")+
						"<td>"+rs.getInt("sum");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return show;
	}
	@Override
	public List<Porder> selectAll2() {
		Connection con=DbConnection.getDB();
		//String SQL="select * from Porder";
		List<Porder> l=new ArrayList();
		
		try {
			PreparedStatement ps=con.prepareStatement("select * from Porder");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Porder p=new Porder();
				p.setId(rs.getInt("id"));
				p.setAddress(rs.getString("address"));
				p.setA(rs.getInt("A"));
				p.setB(rs.getInt("B"));
				p.setC(rs.getInt("C"));
				p.setSum(rs.getInt("sum"));
				
				l.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return l;
	}

	@Override
	public List<Porder> selectSum(int s, int e) {
		Connection con = DbConnection.getDB();
		//String SQL = "select * from Porder where sum>=? and sum<=?";
		List<Porder> l = new ArrayList();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from Porder where sum>=? and sum<=?");
			ps.setInt(1, s);
			ps.setInt(2, e);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Porder p=new Porder();
				p.setId(rs.getInt("id"));
				p.setAddress(rs.getString("address"));
				p.setA(rs.getInt("A"));
				p.setB(rs.getInt("B"));
				p.setC(rs.getInt("C"));
				p.setSum(rs.getInt("sum"));
				
				l.add(p);
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		}	
		return l;
	}
	@Override
	public List<Porder> selectId(int id) {
		Connection con=DbConnection.getDB();
		//String sql="select * from Porder where id=?";
		List<Porder> l=null;
		
		try {
			PreparedStatement ps=con.prepareStatement("select * from Porder where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				l=new ArrayList();
				
				Porder p=new Porder();
				p.setId(rs.getInt("id"));
				p.setAddress(rs.getString("address"));
				p.setA(rs.getInt("A"));
				p.setB(rs.getInt("B"));
				p.setC(rs.getInt("C"));
				p.setSum(rs.getInt("sum"));
				
				l.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return l;
	}

	@Override
	public void update(Porder p) {
		Connection con=DbConnection.getDB();
		//String SQL="update Porder set address=?,A=?,B=?,C=?,sum=? where id=?";
		
		try {
			PreparedStatement ps=con.prepareStatement("update Porder set address=?,A=?,B=?,C=?,sum=? where id=?");
			ps.setString(1, p.getAddress());
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
		Connection con=DbConnection.getDB();
		//String Sql="delete from Porder where id=?";
		
		try {
			PreparedStatement ps=con.prepareStatement("delete from Porder where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public Porder selectSum2(int start, int end) {

		Connection con = DbConnection.getDB();
		//String SQL = "select * from Porder where sum>=? and sum<=? ";
		Porder p = null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from Porder where sum>=? and sum<=? ");
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				p = new Porder();
				p.setId(rs.getInt("id"));
				p.setAddress(rs.getString("address"));
				p.setA(rs.getInt("A"));
				p.setB(rs.getInt("B"));
				p.setC(rs.getInt("C"));
				p.setSum(rs.getInt("sum"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
}