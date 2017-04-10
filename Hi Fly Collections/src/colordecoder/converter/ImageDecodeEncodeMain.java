package colordecoder.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ImageDecodeEncodeMain {
	public static String getCurrentDateandTime(){
		SimpleDateFormat DateFormat = new SimpleDateFormat("dd.MM.YYYY_HH.mm.ss.SSS");
		Date date = new Date();
		String strCurrentDate = DateFormat.format(date);
		return strCurrentDate;
	}
	public static String getTimeDiff(String StartDate, String EndDate) {
		SimpleDateFormat DateFormat = new SimpleDateFormat("dd.MM.YYYY_HH.mm.ss.SSS");
		Date d1 = null;
		Date d2 = null;
		try {
			d1 = DateFormat.parse(StartDate);
			d2 = DateFormat.parse(EndDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String diff = "";
		long timeDiff = Math.abs(d2.getTime() - d1.getTime());
		diff = String.format("%d day(s) %d hour(s) %d min(s) %d sec(s) %d millisec(s)",
				TimeUnit.MILLISECONDS.toDays(timeDiff),
				TimeUnit.MILLISECONDS.toHours(timeDiff)%24, 
				TimeUnit.MILLISECONDS.toMinutes(timeDiff)%60,
				TimeUnit.MILLISECONDS.toSeconds(timeDiff)%60,
				TimeUnit.MILLISECONDS.toMillis(timeDiff%1000)
				);
		System.out.println("Total Time Taken : "+diff);
		return diff;
	}
	public static void main(String args[]){
		ColorDecoder CR = new ColorDecoder();
		ColorEncoder CE = new ColorEncoder();
		String StartDate = getCurrentDateandTime();
		System.out.println("Start Date & Time : "+StartDate);
		int[] rgb = CR.getColor("Penguins.jpg");
		CE.encodeColor(rgb);
		String EndDate = getCurrentDateandTime();
		System.out.println("End Date & Time : "+EndDate);
		getTimeDiff(StartDate, EndDate);
	}
}