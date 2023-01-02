package Dao.porder;

import java.util.List;

import Model.porder;

public interface porderDao {
	
    	void add(porder p);
    	
	
    	String selectAll1();
    	List<porder> selectAll2();
    	List<porder> selectSum(int start,int end); 
    	List<porder> selectId(int id);
    	
	
    	void update(porder p);
    	
	
    	void delete(int id);
}
