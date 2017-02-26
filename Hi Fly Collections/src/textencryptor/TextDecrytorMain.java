package textencryptor;

public class TextDecrytorMain {
	public static void main(String[] args){
		TextWriter TW = new TextWriter();
		final String strMessage = "";
		final String strKey= "=|}];?&^$#@!64zsrfYTSROLKHGDAUWacPikntvx*),/{:>(0%732wupqomQNIFECBJMVXZbdeghjly1589<.[_+-";
		TW.decryptMessage(strMessage, strKey);
	}
}