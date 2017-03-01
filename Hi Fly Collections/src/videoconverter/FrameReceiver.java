package videoconverter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.jcodec.api.FrameGrab;
import org.jcodec.api.JCodecException;
import org.jcodec.common.FileChannelWrapper;
import org.jcodec.common.NIOUtils;

public class FrameReceiver {
	private static FrameGrab grab;
	public static void main(String args []) throws IOException, JCodecException{
		int frameNumber = 150;
		BufferedImage frame = getFrame(new File("C:\\Users\\Admin\\Documents\\Video Converter\\custom.mp4"), frameNumber);
		ImageIO.write(frame, "png", new File("frame_150.png"));
	}
	public static BufferedImage getFrame(File file, double sec) throws IOException, JCodecException {
		FileChannelWrapper ch = null;
		try {
			ch = NIOUtils.readableFileChannel(file);
			return ((FrameGrab) new FrameGrab(ch).seekToSecondPrecise(sec)).getFrame();//Error Spot - getFrame method doesnt exist in 0.1.9
		} finally {
			NIOUtils.closeQuietly(ch);
		}
	}
}