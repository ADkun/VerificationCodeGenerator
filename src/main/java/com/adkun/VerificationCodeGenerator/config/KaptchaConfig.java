package com.adkun.VerificationCodeGenerator.config;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KaptchaConfig {

    @Bean
    public Producer producer() {
        Properties properties = new Properties();
        properties.setProperty("kaptcha.image.width", "100"); //设置宽度，默认单位px
        properties.setProperty("kaptcha.image.height", "40"); //设置高度
        properties.setProperty("kaptcha.textproducer.font.size", "40");
        properties.setProperty("kaptcha.textproducer.font.color", "0,0,0");//可以写RGB r,g,b 也可以写16进制 也可以写black
        properties.setProperty("kaptcha.textproducer.char.string", "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        properties.setProperty("kaptcha.noise.impl", "com.google.code.kaptcha.impl.NoNoise"); //使用哪个噪声干扰类，默认就是防破解的，不需要噪声


        // 所有的配置项都是通过Config配的，Config需要依赖于Properties对象
        DefaultKaptcha kaptcha = new DefaultKaptcha();
        Config config = new Config(properties);
        kaptcha.setConfig(config);
        return kaptcha;
    }
}
