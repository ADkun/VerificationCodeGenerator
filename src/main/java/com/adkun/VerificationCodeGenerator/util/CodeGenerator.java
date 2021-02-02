package com.adkun.VerificationCodeGenerator.util;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

@Component
public class CodeGenerator {

    @Autowired
    private Producer kaptchaProducer;

    public List<BufferedImage> generate(int n) {
        List<BufferedImage> list = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            String text = kaptchaProducer.createText();
            BufferedImage image = kaptchaProducer.createImage(text);
            list.add(image);
        }
        return list;
    }
}
