package persons;

import persons.Person;

public class Main extends Person{
	
	Person p=new Person();

	public String createPerson(int id,String name,int age,String state){
		return create(new Person(id,name,age,state));
	}

	
	public String readPerson(int id){
		return p.read(id);
	}
	
	public String updatePerson(int id,String name,int age,String state){
		return p.update(id, name, age, state);
	}
	
	public String deletePerson(int id){
		return p.delete(id);
	}
	
	
}
