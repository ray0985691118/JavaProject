package Model;

import java.util.Date;

public class Porder {
   private Integer id;
   private String name;
   private Integer arabica;
   private Integer mandheling;
   private Integer yirgacheffe;
   private Integer sum;
   private Integer discountprice;
   private Date date;
   
public Porder() {
	super();
	// TODO Auto-generated constructor stub
}
public Porder(String name, Integer arabica, Integer mandheling, Integer yirgacheffe, Date date) {
	super();
	this.name = name;
	this.arabica = arabica;
	this.mandheling = mandheling;
	this.yirgacheffe = yirgacheffe;
	this.date = date;
	sum=arabica*100+mandheling*200+yirgacheffe*300;
	if(sum>1000)
	{
		discountprice=(int) (sum*0.9);
	}else {
		discountprice=0;
	}
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getArabica() {
	return arabica;
}
public void setArabica(Integer arabica) {
	this.arabica = arabica;
}
public Integer getMandheling() {
	return mandheling;
}
public void setMandheling(Integer mandheling) {
	this.mandheling = mandheling;
}
public Integer getYirgacheffe() {
	return yirgacheffe;
}
public void setYirgacheffe(Integer yirgacheffe) {
	this.yirgacheffe = yirgacheffe;
}
public Integer getSum() {
	sum=arabica*100+mandheling*200+yirgacheffe*300;
	return sum;
}
public void setSum(Integer sum) {
	this.sum = sum;
}
public Integer getDiscountprice() {
	if(sum>1000)
	{
		discountprice=(int) (sum*0.9);
	}else {
		discountprice=0;
	}
	return discountprice;
}
public void setDiscountprice(Integer discountprice) {
	this.discountprice = discountprice;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
   

}
