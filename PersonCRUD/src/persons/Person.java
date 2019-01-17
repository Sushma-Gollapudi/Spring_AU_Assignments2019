package persons;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Person implements Serializable,Comparable<Person>{

	private int id;
	private String name;
	private int age;
	private String state;
	

	static List<Person> list =new LinkedList<>();
	
	
	
	public Person(int id, String name, int age, String state) {

		this.id = id;
		this.name = name;
		this.age = age;
		this.state = state;
	}

	public Person() {
		
		//Sample data
		//list.add(new Person(100,"Sushma",20,"Mysore"));
		//list.add(new Person(101,"Joy",27,"chile"));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String toString() {
		return "\nID: "+id+"\nName: "+name+"\n Age: "+age+"\nState: "+state+"\n";
	}
	
	public String create(Person p){
		
		for(Person o:list) {
			if(o.getId()==p.getId())
				return "Person already exists";
		}
		list.add(p);
		return list.toString();
	}
	
	
	public String read(int id){
		
		for(Person p:list) {
			if(p.getId()==id)
				return "Details:\n "+ p.toString();
		}
		return "Person with id "+id+ " not found!!";
	}
	
	
	public String update(int id,String name,int age,String state){
		
		for(Person p:list) {
			if(p.getId()==id) {
				p.setName(name);
				p.setState(state);
				p.setAge(age);
				return "List after updation:\n"+ list.toString();
			}
		}
		return "Person with id "+id+ " not found!!";
	}
	
	
	public String delete(int id){
		
		for(Person p:list) {
			if(p.getId()==id) {
				list.remove(p);
			return "List after deletion:\n"+ list.toString();}
			}
		return "Person with id "+id+ " not found!!";
	}

	@Override
	public int compareTo(Person o) {
		return (this.id==o.getId())?1:-1;
	}
	

	
}
