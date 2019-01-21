package com.hibernate.test.pojo;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="skill")
public class Skill implements Serializable{

	@Id
	@Column(name="skillId")
//	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer skillId;

	@Column(name="skillName")
	public String skillName;

	@Column(name="personId")
	public Integer personId;


	
	
	
	public Integer getSkillId() {
		return skillId;
	}





	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}





	public String getSkillName() {
		return skillName;
	}





	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}





	public Integer getPersonId() {
		return personId;
	}





	public void setPersonId(Integer personId) {
		this.personId = personId;
	}





	public String toString() {
		return this.getSkillName()+" "+this.getPersonId();
	}

}
