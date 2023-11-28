package vn.edu.iuh.fit.w4.www_tuan4_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.w4.www_tuan4_spring.dao.StudentDao;
import vn.edu.iuh.fit.w4.www_tuan4_spring.etities.Student;

@SpringBootApplication
public class WwwTuan4SpringApplication {

	@Autowired
	private StudentDao studentDao;

	public static void main(String[] args) {
		SpringApplication.run(WwwTuan4SpringApplication.class, args);
	}

	@Bean
	CommandLineRunner test1(){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				for (int i = 0; i < 10; i++) {
					Student student = new Student(i,"name #" +i);
					studentDao.insert(student);
				}
				studentDao.getAll().forEach(System.out::println);
			}
		};
	}
}
