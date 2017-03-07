package colordecoder.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ImageDecodeEncodeMain {
	public static String getCurrentDateandTime(){
		SimpleDateFormat DateFormat = new SimpleDateFormat("dd.MM.YYYY_HH.mm.ss");
		Date date = new Date();
		String strCurrentDate = DateFormat.format(date);
		return strCurrentDate;
	}
	public static void main(String args[]){
		ColorDecoder CR = new ColorDecoder();
		ColorEncoder CE = new ColorEncoder();
		System.out.println(getCurrentDateandTime());
		int[] rgb = CR.getColor("TestNG 1.png");
		CE.encodeColor(rgb);
		System.out.println(getCurrentDateandTime());
	}
}