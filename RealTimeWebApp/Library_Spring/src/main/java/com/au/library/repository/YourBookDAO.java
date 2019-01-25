//package com.au.library.repository;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//
//import com.au.library.model.YourBooks;
//
//@Repository
//public class YourBookDAO {
//	@Autowired
//	JdbcTemplate jdbcTemplate;
//	
//	public List<YourBooks> all(){
//		return jdbcTemplate.query("select * from yourBooks",(rs,i)->{
//			return new YourBooks(rs.getString("id"),
//					rs.getString("book_name"),
//					rs.getString("author_name"),
//					rs.getDouble("price"),
//					rs.getString("descript")
//					);
//		});
//	}
//	
//	public YourBooks create(YourBooks book) {
//		System.out.println(book.getBookName());
//		jdbcTemplate.update("insert into yourBooks(id,book_name,author_name,price,descript)"+ "values(?,?,?,?,?)",new Object[] {
//				book.getId(),
//				book.getBookName(),
//				book.getAuthorName(),
//				book.getPrice(),
//				book.getDescription()});
//		
//		
//		return book;
//	}
//	
//	public String getId(String id){
//		return jdbcTemplate.queryForObject("select book_name from book where id=\""+id+"\";",String.class);
//	}
//}
