
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("jdbcTemplateDao")
public class JDBCTemplateDAO  {
	
@Autowired
	private JdbcTemplate jdbcTemplate;
	
	

public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
}

	public int saveStudent(Student student){
		String query = "insert into student(name,age,major) values "
				+ "("+student.getName()+","+student.getAge()+","+student.getMajor()+")";
		return jdbcTemplate.update(query);
	}
	

		public Boolean saveStudentUsingPreparedStatement(final Student student){
			String query = "insert into student(name,age,major) values (?,?,?)";
			return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

				public Boolean doInPreparedStatement(PreparedStatement ps)
						throws SQLException, DataAccessException {
					ps.setString(1, student.getName());
					ps.setInt(2, student.getAge());
					ps.setString(3, student.getMajor());
					System.out.println("Student record added");
					return ps.execute();
				}
			});
		}
		
		
		
		//Row Mapper
		
		public List<Student> getAllEmployeesRowMapper(){  
			 return jdbcTemplate.query("select * from student",new RowMapper<Student>(){  
				 
				 public Student mapRow(ResultSet rs, int rownumber) throws SQLException {  
			        Student student=new Student();  
			        student.setName(rs.getString(1));
			        student.setAge(rs.getInt(2));  
			        student.setMajor(rs.getString(3));
			        return student;  
			    }  
			 }); 
			
		}
		

/*
 * public List<Student> getAllEmployeesByResultExtractor() { return
 * jdbcTemplate.query("select * from employee",new
 * ResultSetExtractor<List<Student>>(){
 * 
 * public List<Student> extractData(ResultSet rs) throws SQLException,
 * DataAccessException {
 * 
 * List<Student> list=new ArrayList<Student>(); while(rs.next()){ Student e=new
 * Student(); e.setName(rs.getString(1)); e.setAge(rs.getInt(2));
 * e.setMajor(rs.getString(3));
 * 
 * list.add(e); } return list; } }); } 
 */
}	
	
	


