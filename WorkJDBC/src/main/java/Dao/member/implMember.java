package Dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.DbConnection;
import Model.member;

public class implMember implements memberDao{

	public static void main(String[] args) {
		/*member m=new member("ray","ray123","1234","台北","000","345");
		new implMember().add(m);*/
		
		//System.out.println(new implMember().selectAll());
		
		//System.out.println(new implMember().selectUser("rrrr"));
		
		System.out.println(new implMember().selectUser("rrrr","1111"));
	}

	@Override
	public void add(member m) {
		Connection con=DbConnection.getDb();
		String SQL="insert into member(name,username,password,address,phone,mobile) "
				+ "value(?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=con.prepareStatement(SQL);
			ps.setString(1,m.getName());
			ps.setString(2, m.getUsername());
			ps.setString(3, m.getPassword());
			ps.setString(4, m.getAddress());
			ps.setString(5, m.getPhone());
			ps.setString(6, m.getMobile());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<member> selectAll() {
		Connection con=DbConnection.getDb();
		String SQL="select * from member";
		
		try {
			PreparedStatement ps=con.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				System.out.println(rs.getString("name")+"\t"+rs.getString("username")
				+"\t"+rs.getString("password")+"\t"+rs.getString("address")
				+"\t"+rs.getString("phone")+"\t"+rs.getString("mobile"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean selectUser(String username) {
		Connection con=DbConnection.getDb();
		String SQL="select * from member where username=?";
		boolean ans=false;
		try {
			PreparedStatement ps=con.prepareStatement(SQL);
			ps.setString(1, username);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) ans=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}

	@Override
	public List<member> selectUser(String username,String password) {
		Connection con=DbConnection.getDb();
		String SQL="select * from member where username=? and password=?";
		List<member> l=new ArrayList();
		
		try {
			PreparedStatement ps=con.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				member m=new member();
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				l.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public void update(member m) {
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
