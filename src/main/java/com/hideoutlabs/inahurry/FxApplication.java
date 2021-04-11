package com.hideoutlabs.inahurry;

import com.hideoutlabs.inahurry.config.AppJavaConfig;
import com.hideoutlabs.inahurry.config.StageManagerConfig;
import com.hideoutlabs.inahurry.controller.LoginController;
import com.hideoutlabs.inahurry.controller.MyController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;


    public class FxApplication extends Application {

        private ConfigurableApplicationContext applicationContext;





        @Override
        public void init() {
            String[] args = getParameters().getRaw().toArray(new String[0]);

            this.applicationContext = new SpringApplicationBuilder()
                    .sources(InahurryApplication.class)
                    .run(args);
        }

        @Override
        public void start(Stage stage) {
            FxWeaver fxWeaver = applicationContext.getBean(FxWeaver.class);
            Parent root = (Parent) fxWeaver.loadView(MyController.class);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        @Override
        public void stop() {
          this.applicationContext.close();
            Platform.exit();
        }

    }

