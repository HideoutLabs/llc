package com.hideoutlabs.inahurry;

import com.hideoutlabs.inahurry.config.StageManagerConfig;
import com.hideoutlabs.inahurry.model.Role;
import com.hideoutlabs.inahurry.model.Users;
import com.hideoutlabs.inahurry.repository.RoleRepository;
import com.hideoutlabs.inahurry.repository.UserRepository;
import com.hideoutlabs.inahurry.view.FxmlView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.sonatype.guice.plexus.config.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import com.hideoutlabs.inahurry.repository.UserRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.boot.builder.SpringApplicationBuilder;
import java.io.IOException;


import javafx.application.Application;




@SpringBootApplication
public class InahurryApplication extends Application {


    protected ConfigurableApplicationContext springContext;
    protected StageManagerConfig stageManager;



    public static void main(String[] args) {
        launch();
     // launch(FxApplication.class, args);
       BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
       System.out.println(bCryptPasswordEncoder.encode("password123"));
   //SpringApplication.run(InahurryApplication.class, args);

  }



    @Bean
    public CommandLineRunner demo1(UserRepository repository) {

        return (args) -> {

            repository.save(new Users("user", "$2a$10$c94cDIEIu/duvJ7DttekW.lBzrsMgYIhYmkTON73wD5NDVf9ThL1G", 1 == 1, "e@ioc.com"));
            repository.save(new Users("linda", "$2a$10$HO94Axcv5Bdh0RFVRRxjue2FdK3Rl2XpP9UGuBFPH2555ZWCBplgu", 1 == 1, "b@ioc.com"));


        };


    }

    @Bean
    public CommandLineRunner demo2(RoleRepository repository) {

        return (args) -> {

         //   Role emp1 = Role.builder().build();



          //Iterable<Role>  roles= repository.saveAll(new Role("ROUTE_READ"),new Role("ROUTE_WRITE"),new Role("CUSTOMER_READ"),new Role("CUSTOMER_WRITE"));

        };


    }


    @Override
    public void init() throws Exception {
        springContext = springBootApplicationContext();
    }

    @Override
    public void start(Stage stage) throws Exception {
        stageManager = springContext.getBean(StageManagerConfig.class, stage);
        displayInitialScene();
    }

    protected void displayInitialScene() throws IOException {


        stageManager.switchScene(FxmlView.LOGIN);
    }

    private ConfigurableApplicationContext springBootApplicationContext() {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(InahurryApplication.class);
        String[] args = getParameters().getRaw().stream().toArray(String[]::new);
        return builder.run(args);
    }

}


