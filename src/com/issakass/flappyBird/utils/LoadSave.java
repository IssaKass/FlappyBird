package com.issakass.flappyBird.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadSave {

    public static BufferedImage GetImage(String path) {
        BufferedImage image;
        InputStream inputStream = LoadSave.class.getResourceAsStream("/" + path);
        assert inputStream != null;
        try {
            image = ImageIO.read(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return image;
    }

}
