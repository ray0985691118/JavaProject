package Dao.member;

import java.util.List;

import Model.member;

public interface memberDao {
		//create
		void add(member m);
		
		//read
		List<member> selectAll();
		boolean selectUser(String username);
		List<member> selectUser(String username,String password);
		
		//update
		void update(member m);
		
		//delete
		void delete(int id);
}
