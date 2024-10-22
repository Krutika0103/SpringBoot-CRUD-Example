package com.krutika.springbootproject;

import com.krutika.springbootproject.model.Employee;
import com.krutika.springbootproject.repository.UserRepository;
import com.krutika.springbootproject.service.EmailSenderService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.io.IOException;

@SpringBootApplication
public class SpringbootProjectApplication implements CommandLineRunner {

	@Autowired
	private EmailSenderService senderService;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootProjectApplication.class, args);
	}

/*	@EventListener(ApplicationReadyEvent.class)
	public void sendEmail() throws MessagingException, IOException {
	     senderService.sendMail();
	}*/

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
   /* Employee employee= new Employee();
	employee.setId(1);
	employee.setName("krutika");
	employee.setEmail("kt0103@gmail.com");
	employee.setPassword("kt789");
	userRepository.save(employee);

		Employee employee1= new Employee();
		employee1.setId(2);
		employee1.setName("tanvi");
		employee1.setEmail("tanvit093@gmail.com");
		employee1.setPassword("msdhoni");
		userRepository.save(employee1);*/
	}
}
