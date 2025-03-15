package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(MainApp.class, args);

	}

//	@Autowired
//	BlogRepository blogRepo;
//	@Autowired
//	CommentRepository commentRepo;

//	@PostConstruct
//	public void methods() {
//		BlogEntity blogEntity = new BlogEntity("JAVA AND USES", "oops");
//		blogEntity = blogRepo.save(blogEntity);
//		System.out.println("blog added with id " + blogEntity.getBlogId());
//
//		CommentEntity c1 = new CommentEntity("Good blog", blogEntity);
//		CommentEntity c2 = new CommentEntity("Good UI", blogEntity);
//		commentRepo.save(c1);
//		commentRepo.save(c2);
//		System.out.println("comments added with ids "+c1.getCommentId()+" & "+c2.getCommentId());
//		
//	}
}
