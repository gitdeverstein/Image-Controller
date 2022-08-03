package school.hei.imagecontroller;


import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class Image {
    public static BufferedImage toBufferedImage(byte[] grayImage) {
        InputStream control = new ByteArrayInputStream(grayImage);
        try {
            BufferedImage jpg = ImageIO.read(control);
            return jpg;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static BufferedImage toBnW(BufferedImage img){
        ColorSpace gris = ColorSpace.getInstance(ColorSpace.CS_GRAY);
        ColorConvertOp OpConvertion = new ColorConvertOp(gris, null);
        return OpConvertion.filter(img, null);
    }

    public static byte[] toBytes(BufferedImage img){
        ByteArrayOutputStream Buffer = new ByteArrayOutputStream();
        try {
            ImageIO.write(img, "jpg", Buffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        byte[] bytes = Buffer.toByteArray();
        return bytes;
    }
}
