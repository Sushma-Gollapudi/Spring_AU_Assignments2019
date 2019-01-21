package com.hibernate.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transaction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.hibernate.test.pojo.Skill;
import com.hibernate.test.pojo.Person;



public class App {

	public static void main(String[] args) {
		
		List<Person> PersonList= new ArrayList<Person>();

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		
		
		Person p1=new Person();
		p1.setPersonId(11);
		p1.setPersonName("Joy");
		p1.setPersonAge(23);
		session.save(p1);
	
		Person p2=new Person();
		p2.setPersonId(12);
		p2.setPersonName("Scarlet");
		p2.setPersonAge(28);
		session.save(p2);
		
		Person p3=new Person();
		p3.setPersonId(13);
		p3.setPersonName("Hannah");
		p3.setPersonAge(21);
		session.save(p3);
	
		
		Criteria persons = session.createCriteria(Person.class); 
		persons.add(Restrictions.gt("personId", 11)).add(Restrictions.gt("personAge",22));
		
		
		PersonList= persons.list();

		System.out.println(PersonList);
		  
		  Skill s1=new Skill();
		  s1.setSkillId(2);
		  s1.setPersonId(11);
		  s1.setSkillName("Yoga");
		  session.save(s1);
		  
		  Skill s3=new Skill();
		  s3.setSkillId(1);
		  s3.setPersonId(11);
		  s3.setSkillName("Sing");
		  session.save(s3);
		  
		  Skill s2=new Skill();
		  s2.setSkillId(3);
		  s2.setPersonId(13);
		  s2.setSkillName("Dance");
		  session.save(s2);
		  
		  Criteria skills = session.createCriteria(Skill.class); 
			skills.add(Restrictions.eq("personId",11));
			System.out.println(skills.list());
//			
		
		Criteria join = session.createCriteria(Person.class); 
		PersonList= join.list();
			for(Person p: PersonList) {
				  System.out.println("\n\nname: "+ p.getPersonName()+"\nAge: " 
				  +p.getPersonAge()+"\nId: "
				  +p.getPersonId()+"\nfirst Skill: "
				  +(!p.getSkill().isEmpty()?p.getSkill().get(0).getSkillName()
				  :"NO DATA") ); }
	
		session.getTransaction().commit();
		
		
		
	}
	
	
}



