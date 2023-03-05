package dao.porder;

import java.util.List;

import Model.Porder;

public interface PorderDao {
	
    	void add(Porder p);
    	
	
    	String selectAll1();
    	List<Porder> selectAll2();
    	List<Porder> selectSum(int s,int e); 
    	List<Porder> selectId(int id);
    	Porder selectSum2(int start,int end);
	
    	void update(Porder p);
    	
	
    	void delete(int id);
}
