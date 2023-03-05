package Factory;

import Model.Member;
import Model.Porder;
import dao.MemberDao;
import dao.PorderDao;

public class Fact {
	
	private Member m;
	private Porder p;
	private MemberDao md;
	private PorderDao pd;
	
	public Fact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fact(Member m, Porder p, MemberDao md, PorderDao pd) {
		super();
		this.m = m;
		this.p = p;
		this.md = md;
		this.pd = pd;
	}
	public Member getM() {
		return m;
	}
	public void setM(Member m) {
		this.m = m;
	}
	public Porder getP() {
		return p;
	}
	public void setP(Porder p) {
		this.p = p;
	}
	public MemberDao getMd() {
		return md;
	}
	public void setMd(MemberDao md) {
		this.md = md;
	}
	public PorderDao getPd() {
		return pd;
	}
	public void setPd(PorderDao pd) {
		this.pd = pd;
	}
	
}
