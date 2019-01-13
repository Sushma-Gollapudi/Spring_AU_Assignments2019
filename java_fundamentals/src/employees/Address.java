/* This class is used as address template in Employee class
 * This demonstrates constructor overloading*/



package employees;

public class Address {
	private int hno;
	private String area;
	private String street;
	private String city;
	private String state;
	private String country;
	private int pincode;
	
	//Constructor overloading
	
	//constructor with all properties as arguments
	Address(int hno,String area,String street,String city,String state,String country,int pincode) {
		this.hno=hno;
		this.area=area;
		this.street=street;
		this.city=city;
		this.state=state;
		this.country=country;
		this.pincode=pincode;
	}
	
	//constructor without pincode and house no
		Address(String area,String street,String city,String state,String country) {
			this.area=area;
			this.street=street;
			this.city=city;
			this.state=state;
			this.country=country;
		}
		
		int getHno()
		{
			return this.hno;
		}
		
		String getArea() {
			return this.area;
		}
		
		String getStreet() {
			return this.street;
		}
		
		String getCity() {
			return this.city;
		}
		
		String getState() {
			return this.state;
		}
		
		String getCountry() {
			return this.country;
		}
		
		int getPincode()
		{
			return this.pincode;
		}
		
}
