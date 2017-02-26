package videoconverter;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber.Exception;
import org.bytedeco.javacpp.opencv_core.IplImage;


public class VideoConverter {
	Java2DFrameConverter JFC = new Java2DFrameConverter();
	public void convertVideo() throws Exception, IOException{
		FFmpegFrameGrabber g = new FFmpegFrameGrabber("C:\\Users\\Admin\\Documents\\Video Converter\\custom.mp4");
		g.start();
		IplImage j;
		for (int i = 0 ; i < 50 ; i++) {
			Frame frame = g.grab();
			ImageIO.write(JFC.convert(frame), "png", new File("frame-dump/video-frame-" + System.currentTimeMillis() + ".png"));
		}
		g.stop();
	}
	
	public void getFrameData(){
	}
	
	public static void main(String args[]) throws Exception, IOException{
		VideoConverter VC = new VideoConverter();
		VC.convertVideo();
	}
}
