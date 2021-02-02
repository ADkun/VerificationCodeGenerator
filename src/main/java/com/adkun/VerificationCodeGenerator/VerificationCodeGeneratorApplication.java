package com.adkun.VerificationCodeGenerator;

import com.adkun.VerificationCodeGenerator.util.ImageSaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class VerificationCodeGeneratorApplication {


    public static void main(String[] args) throws IOException {

        SpringApplication.run(VerificationCodeGeneratorApplication.class, args);

        ApplicationContext context=SpringUtil.getApplicationContext();
        ImageSaver imageSaver=context.getBean(ImageSaver.class);
        int n=Integer.parseInt(args[0]);
        imageSaver.save(n);
    }

}
