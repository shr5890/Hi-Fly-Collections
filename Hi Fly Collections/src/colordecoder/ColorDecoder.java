package colordecoder;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ColorDecoder {
	public Color[][] retrieveColor(File file) throws IOException{
		Color[][] colors = null;
		try{
			BufferedImage brImage = ImageIO.read(file);
			System.out.println(brImage.getWidth());
			System.out.println(brImage.getHeight());
			colors = new Color[brImage.getWidth()][brImage.getHeight()];
			for(int x = 0; x < brImage.getWidth(); x++){
				for(int y = 0; y < brImage.getHeight(); y++){
					colors[x][y] = new Color(brImage.getRGB(x, y));
					System.out.println(colors[x][y] + " Pixel : ("+x+" , "+y+")");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return colors;
	}
	public Color[][] getColor(){
		Color[][] colors = null;
		try{
			File file = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Koala.jpg");
			colors  = retrieveColor(file);
		}catch(IOException e){
			e.printStackTrace();
		}
		return colors;
	}
}
