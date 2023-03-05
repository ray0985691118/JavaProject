package Model;

public class Porder {
	private Integer id;
	private String address;
	private Integer A;
	private Integer B;
	private Integer C;
	private Integer sum;
	public Porder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Porder(String address, Integer a, Integer b, Integer c) {
		super();
		this.address = address;
		A = a;
		B = b;
		C = c;
		sum=A*120+B*130+C*140;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getA() {
		return A;
	}
	public void setA(Integer a) {
		A = a;
	}
	public Integer getB() {
		return B;
	}
	public void setB(Integer b) {
		B = b;
	}
	public Integer getC() {
		return C;
	}
	public void setC(Integer c) {
		C = c;
	}
	public Integer getSum() {
		sum=A*120+B*130+C*140;
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
	}
	
}
