package mcquick.agentApiDemo.util;

import cn.hutool.core.img.ImgUtil;
import mcquick.agentApiDemo.exception.CheckException;
import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageUtils {
    private static final int MAX_IMG_SIZE = 1024 * 1024;
    private static final int BIG_MAX_IMG_SIZE = 1024 * 1024 * 3;

    /**
     * jpg图片压缩
     * @param source
     * @return
     */
    public static InputStream squeeze(InputStream source) {
        try {
            while (source.available() > MAX_IMG_SIZE) {
                if (source.available() > BIG_MAX_IMG_SIZE) {
                    throw new CheckException("图片过大，请重新选择");
                }
                BufferedImage scale = Thumbnails.of(source).scale(0.9F).asBufferedImage();
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                try {
                    ImageIO.write(scale, ImgUtil.IMAGE_TYPE_JPG, os);
                    source = new ByteArrayInputStream(os.toByteArray());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return source;
        } catch (IOException e) {
            throw new CheckException(e.getMessage());
        }
    }
}
