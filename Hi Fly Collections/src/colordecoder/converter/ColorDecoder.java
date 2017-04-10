package colordecoder.converter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ColorDecoder{
	public static int height = 0;
	public static int width = 0;

	public int[] retrieveColor2(File file) throws IOException{
		int[] rgbData = null;
		try{
			BufferedImage brImage = ImageIO.read(file);
			height = brImage.getHeight();
			width = brImage.getWidth();
			rgbData = brImage.getRGB(0,0, brImage.getWidth(), brImage.getHeight(),null, 0,brImage.getWidth());
			System.out.println("Image Decoded");
		}catch(Exception e){
			e.printStackTrace();
		}
		return rgbData;
	}

	public int[] getColor(String FileName){
		int[] rgb = null;
		try{
			File file = new File("images\\"+FileName);
			rgb = retrieveColor2(file);
//			ArraySpliter AS = new ArraySpliter();
//			UserDefinedReturns UDR= AS.splitArray(rgb);
//			System.out.println("===============================================");
//			System.out.println("Array Length --> "+UDR.splitArrayContents.length*2147483647);
//			System.out.println("===============================================");
//			System.out.println("Array Length --> "+UDR.lastArrayContents.length);
//			System.out.println("===============================================");
		}catch(Exception e){
			e.printStackTrace();
		}
		return rgb;
	}
}