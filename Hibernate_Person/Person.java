package com.hibernate.test.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person implements Serializable {
	

	@Id
	@Column(name="personId")
//	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer personId;

	@Column(name="personName")
	public String personName;

	@Column(name="personAge")
	public Integer personAge;

	
	  @OneToMany(mappedBy="personId", fetch=FetchType.EAGER) public List<Skill>
	  skill;
	 
	
	  
	
	
	
	
	public Integer getPersonId() {
		return personId;
	}







	public void setPersonId(Integer personId) {
		this.personId = personId;
	}







	public String getPersonName() {
		return personName;
	}







	public void setPersonName(String personName) {
		this.personName = personName;
	}







	public Integer getPersonAge() {
		return personAge;
	}







	public void setPersonAge(Integer personAge) {
		this.personAge = personAge;
	}







	public List<Skill> getSkill() {
		return skill;
	}







	public void setSkill(List<Skill> skill) {
		this.skill = skill;
	}






	public String toString() {
		return this.getPersonName()+" "+this.getPersonAge();
	}
	
	
}
