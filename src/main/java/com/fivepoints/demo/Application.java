package com.fivepoints.demo;

import com.fivepoints.demo.models.About;
import com.fivepoints.demo.models.ERole;
import com.fivepoints.demo.models.Role;
import com.fivepoints.demo.models.User;
import com.fivepoints.demo.repositories.AboutRepository;
import com.fivepoints.demo.repositories.RoleRepository;
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
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableScheduling
@EnableSwagger2
public class Application implements ApplicationRunner {
    @Autowired
    SendEmailService sendEmailService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AboutRepository aboutRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    private ApplicationContext applicationContext;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }



    // this bean used to crypt the password
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder passwordEncoderBean = new BCryptPasswordEncoder();
        return passwordEncoderBean;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {



        // Save roles
//        this.roleRepository.deleteAllInBatch();
//        Role superAdminRole = this.roleRepository.save(new Role(ERole.SUPER_ADMIN));
//        Role adminRole = this.roleRepository.save(new Role(ERole.ADMIN));
//        Role userRole = this.roleRepository.save(new Role(ERole.USER));
//        Role guestRole = this.roleRepository.save(new Role(ERole.GUEST));
/*
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
        this.aboutRepository.save(about1);*/
 }






  /* code sending mail test with main
  @EventListener(ApplicationReadyEvent.class)
   public  void triggerWhenStarts(){
        sendEmailService.sendEmail("javamaster194@gmail.com","hi there","test");
   }*/
}
