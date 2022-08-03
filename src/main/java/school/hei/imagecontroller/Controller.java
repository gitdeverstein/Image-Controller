package school.hei.imagecontroller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;

@RestController
public class Controller {
    private Image Img;

    @PostMapping(
            value= "/image",
            produces = {MediaType.IMAGE_JPEG_VALUE}
    )
    public @ResponseBody byte[] postBody(@RequestBody byte[] file) {
        BufferedImage bufferedColoredImage = Img.toBufferedImage(file);
        BufferedImage bufferedBNWImage = Img.toBnW(bufferedColoredImage);
        return Img.toBytes(bufferedBNWImage);
    }
}
