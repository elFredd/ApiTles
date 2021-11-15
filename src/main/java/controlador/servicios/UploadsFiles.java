package controlador.servicios;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

/**
 * @created 14/11/2021 - 06:30 p. m.
 * @project ApiTles
 * @autor alfre
 */
public class UploadsFiles {
    public void uploadImagenDataUrl(String folder,String file, String dataUrl){
        dataUrl="data:image/png;base64,"+dataUrl;
        String finalDataUrl = dataUrl;
        Thread thread = new Thread(){
            public void run(){
                try {
                    File path = new File(folder);
                    File fichero = new File(folder + "/" + file);
                    if (!path.exists())
                        path.mkdirs();
                    if (!fichero.exists()) {
                        fichero.delete();
                        byte[] imagedata = DatatypeConverter.parseBase64Binary(finalDataUrl.substring(finalDataUrl.indexOf(",") + 1));
                        BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(imagedata));
                        ImageIO.write(bufferedImage, "png", new File(folder + "/" + file));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}
