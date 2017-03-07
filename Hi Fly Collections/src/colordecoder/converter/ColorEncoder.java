package colordecoder.converter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ColorEncoder {
	
	public void encodeColor(int[] rgb){
		try{
			BufferedImage img = new BufferedImage(ColorDecoder.width, ColorDecoder.height, BufferedImage.TYPE_INT_RGB);
			img.setRGB(0, 0, ColorDecoder.width, ColorDecoder.height, rgb, 0, ColorDecoder.width);
			createImage(img);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public static void createImage(BufferedImage img) throws IOException{
		File outputFile = new File("image-output\\sampleoutput.jpg");
		ImageIO.write(img, "jpg", outputFile);
		System.out.println("Image Created");
	}
}
