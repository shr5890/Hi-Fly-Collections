package colordecoder;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

import javax.imageio.ImageIO;

import javafx.util.Pair;

public class ColorDecoder{
	private int height = 0;
	private int width = 0;
	public Color[][] retrieveColor(File file) throws IOException{
		Color[][] colors = null;
		try{
			BufferedImage brImage = ImageIO.read(file);
			System.out.println(brImage.getWidth());
			System.out.println(brImage.getHeight());
			colors = new Color[brImage.getWidth()][brImage.getHeight()];
//			Writer writer = TextWriter.createTextFile();
			for(int x = 0; x < brImage.getWidth(); x++){
				for(int y = 0; y < brImage.getHeight(); y++){
					colors[x][y] = new Color(brImage.getRGB(x, y));
//					new Color(brImage.getRGB(x, y));
//					int rgb = new Color(brImage.getRGB(x, y)).getRGB();
//					System.out.println(new Color(brImage.getRGB(x, y)).getRGB());
					System.out.println(colors[x][y]+" Pixel : ("+x+" , "+y+")");
//					System.out.println("Pixel : ("+x+" , "+y+")");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return colors;
	}
	public int[] retrieveColor2(File file) throws IOException{
		 int[] rgbData = null;
		try{
			BufferedImage brImage = ImageIO.read(file);
			height = brImage.getHeight();
			width = brImage.getWidth();
//			System.out.println(brImage.getWidth());
//			System.out.println(brImage.getHeight());
//			colors = new Color[brImage.getWidth()][brImage.getHeight()];
//			Writer writer = TextWriter.createTextFile();
//			for(int x = 0; x < brImage.getWidth(); x++){
//				for(int y = 0; y < brImage.getHeight(); y++){
//					colors[x][y] = new Color(brImage.getRGB(x, y));
//					new Color(brImage.getRGB(x, y));
//					int rgb = new Color(brImage.getRGB(x, y)).getRGB();
//					 pixel = brImage.getRaster().getPixel(x, y, new int[3]);
					 rgbData = brImage.getRGB(0,0, brImage.getWidth(), brImage.getHeight(),null, 0,brImage.getWidth());
//					 int colorRed=(rgbData[(y*brImage.getWidth())+x] >> 16) & 0xFF; 
//
//					 int colorGreen=(rgbData[(y*brImage.getWidth())+x] >> 8) & 0xFF; 
//
//					 int colorBlue=(rgbData[(y*brImage.getWidth())+x]) & 0xFF; 
//					System.out.println(new Color(brImage.getRGB(x, y)).getRGB());
//					System.out.println("Pixel : ("+x+" , "+y+")");
//					System.out.println("Pixel : ("+x+" , "+y+")");
//				}
//			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return rgbData;
	}
	
	public void encodeColor(int[] rgb){
		try{
//		int intWidth = color.length;
//		int intHeight = color[0].length;
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		int i = 0;
		for(int x = 0 ; x < width ; x++){
			for(int y = 0 ; y < height ; y++){
				img.setRGB(x, y, rgb[i]);
				i++;
			}
		}
		ColorEncoder.createImage(img);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void getSplittedImages(File file) {
		try{
			TreeMap<String,Color[][]> hmColor = new TreeMap<String,Color[][]>();
			BufferedImage brImage = ImageIO.read(file);
			int intWidth = brImage.getWidth();
			int intHeight = brImage.getHeight();
			int WidthDiv = intWidth/1000;
			int WidthMod = intWidth%1000 > 0 ? 1 : 0;
			int HeightCal = intHeight/2000;
			int HeightMod = intHeight%2000 > 0 ? 1 : 0;
			int TotalImages = WidthDiv + WidthMod + HeightCal + HeightMod;
			int AllRange = intWidth/(TotalImages);
			int LastRange = intWidth%(TotalImages);
			HashMap<String,Pair<Integer, Integer>> hmPair = new HashMap<String,Pair<Integer, Integer>>();
			for(int i = 1; i <= TotalImages; i++){
				if(i<TotalImages){
					hmPair.put("Range"+i, getRange(i,AllRange));
				}else{
					Pair<Integer, Integer> pair = getRange(i,AllRange);
					hmPair.put("Range"+i, new Pair<>(pair.getKey(),pair.getValue()+LastRange));
				}
			}
			//			hmPair.put("Range"+(TotalImages+1), new Pair<>(TotalImages*AllRange-1,TotalImages*AllRange+LastRange-1));
			for (HashMap.Entry<String,Pair<Integer, Integer>> entry : hmPair.entrySet()) {
				String key = entry.getKey();
				Pair<Integer, Integer> value = entry.getValue();
				hmColor.put(key, getDivImageColor(brImage, value));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public Pair<Integer, Integer> getRange(int setnumber, int Range){
		int startLimit = (setnumber-1)*Range;
		int endLimit = setnumber*Range-1;
		return new Pair<>(startLimit, endLimit);
	}
	private Color[][] getDivImageColor(BufferedImage brImage, Pair<Integer, Integer> Pair){
		Color[][] colors = null;
//		System.out.println(Pair.getKey());
//		System.out.println(Pair.getValue());
//		System.out.println(Pair.getValue()-Pair.getKey()+1);
		int widthDim = Pair.getValue()-Pair.getKey()+1;
		colors = new Color[widthDim][brImage.getHeight()];
		int i = 0;
		for(int x = Pair.getKey(); x < Pair.getValue(); x++){
			for(int y = 0; y < brImage.getHeight(); y++){
				colors[i][y] = new Color(brImage.getRGB(x, y));
				System.out.println(colors[i][y] + " Pixel : ("+x+" , "+y+")");
			}
			i++;
		}
		return colors;
	}
	public Color[][] getColor(){
		Color[][] colors = null;
		try{
			File file = new File("C:\\Users\\413455\\Pictures\\TestNG 2.jpg");
//			colors  = retrieveColor(file);
			encodeColor(retrieveColor2(file));
//			retrieveColor2(file);
		}catch(Exception e){
			e.printStackTrace();
		}
		return colors;
	}
}
