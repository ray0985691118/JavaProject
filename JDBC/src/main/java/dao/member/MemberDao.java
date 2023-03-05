package dao.member;

import java.util.List;

import Model.Member;

public interface MemberDao {
	
	void add(Member m);
	
	List<Member> selectAll();
	boolean selectUser(String username);
	List<Member> selectUser(String username,String password);
	
	Member selectUser2(String username,String password);
	
	int sendEmail(String email);
}
