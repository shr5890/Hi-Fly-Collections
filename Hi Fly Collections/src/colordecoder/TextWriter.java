package colordecoder;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class TextWriter {
	public static Writer createTextFile(){
		Writer writer = null;
		try{
			String currentDate = ImageDecodeEncodeMain.getCurrentDateandTime();
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(System.getProperty("user.dir")+"\\textCollections\\"+currentDate+".txt"), "utf-8"));
			writer.write("something");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return writer;
	}
}