package Factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Model.Member;
import Model.Porder;
import dao.MemberDao;
import dao.PorderDao;

@Configuration
public class SpFactory {
	
	@Bean(name="m")
	public Member getM()
	{
		return new Member();
	}
	@Bean(name="p")
	public Porder getP() {
		return new Porder();
	}
	@Bean(name="md")
	public MemberDao getMD() {
		return new MemberDao();
	}
	@Bean(name="pd")
	public PorderDao getPD() {
		return new PorderDao();
	}
	@Bean(name="sf")
	public Fact getSF() {
		Fact f=new Fact(getM(),getP(),getMD(),getPD());
		return f;
	}
}
