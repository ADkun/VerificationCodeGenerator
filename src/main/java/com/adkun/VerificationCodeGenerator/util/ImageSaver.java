package com.adkun.VerificationCodeGenerator.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.Buffer;
import java.util.List;

@Component
public class ImageSaver {

    private static final Logger logger = LoggerFactory.getLogger(ImageSaver.class);

    @Autowired
    private CodeGenerator codeGenerator;

    public void save(int n) throws IOException {
        List<BufferedImage> list = codeGenerator.generate(n);

        for (Integer i = 0; i < n; ++i) {
            try {
                String filePath = "/output/" + i.toString() + ".png";
                File imgFile = new File(filePath);
                if (!imgFile.exists()) {
                    imgFile.getParentFile().mkdir();
                    imgFile.createNewFile();
                }

//                OutputStream os = new FileOutputStream(imgFile);
                BufferedImage image = list.get(i);
                ImageIO.write(image, "png", imgFile);
            } catch (IOException e) {
                logger.error("输出错误：" + e.getMessage());
            }
        }

    }
}
