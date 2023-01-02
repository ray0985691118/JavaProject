package Factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Dao.memberDao;
import Dao.porderDao;
import Model.member;
import Model.porder;

@Configuration
public class SpFactory {
	
	@Bean(name="m")
	public member getM()
	{
		return new member();
	}
	@Bean(name="p")
	public porder getP() {
		return new porder();
	}
	@Bean(name="md")
	public memberDao getMD() {
		return new memberDao();
	}
	@Bean(name="pd")
	public porderDao getPD() {
		return new porderDao();
	}
	@Bean(name="sf")
	public fact getSF() {
		fact f=new fact(getM(),getP(),getMD(),getPD());
		return f;
	}
}
