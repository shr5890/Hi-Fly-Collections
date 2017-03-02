package colordecoder;

import java.awt.Color;
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
		String strStartDate = getCurrentDateandTime();
		ColorDecoder CR = new ColorDecoder();
		ColorEncoder CE = new ColorEncoder();
		Color[][] color = CR.getColor();
//		CE.encodeColor(color);
		System.out.println(strStartDate);
		System.out.println(getCurrentDateandTime());
	}
}
