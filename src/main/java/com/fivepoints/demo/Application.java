package com.fivepoints.demo;

import com.fivepoints.demo.models.About;
import com.fivepoints.demo.models.User;
import com.fivepoints.demo.repositories.AboutRepository;
import com.fivepoints.demo.repositories.UserRepository;
import com.fivepoints.demo.services.AboutService;
import com.fivepoints.demo.services.SendEmailService;
import com.fivepoints.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Application implements ApplicationRunner {
    @Autowired
    SendEmailService sendEmailService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AboutRepository aboutRepository;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // Clean up database tables
        this.aboutRepository.deleteAllInBatch();
        this.userRepository.deleteAllInBatch();

        // creating a user and an about for testing one to one relation between about and user
        User user1 = new User("seif","chourabi","chourabiseif94@gmail.com","123456");
        About about1 = new About("24/02/1994", "Tunisia","tunis","27418511","1475");
        this.userRepository.save(user1);
        this.aboutRepository.save(about1);
         // affecting about1 to user1 and user1 to about 1
        about1.setUser(user1);
        user1.setAbout(about1);
        this.userRepository.save(user1);
        this.aboutRepository.save(about1);



        }






  /* code sending mail test with main
  @EventListener(ApplicationReadyEvent.class)
   public  void triggerWhenStarts(){
        sendEmailService.sendEmail("javamaster194@gmail.com","hi there","test");
   }*/
}
