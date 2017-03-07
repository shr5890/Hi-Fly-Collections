package colordecoder;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ColorEncoder {
	public void encodeColor(Color[][] color){
		try{
		int intWidth = color.length;
		int intHeight = color[0].length;
		BufferedImage img = new BufferedImage(intWidth, intHeight, BufferedImage.TYPE_INT_RGB);
		for(int x = 0 ; x < intWidth ; x++){
			for(int y = 0 ; y < intHeight ; y++){
				Color pixelcolor = color[x][y];
				int rgb = pixelcolor.getRGB();
				img.setRGB(x, y, rgb);
			}
		}
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
