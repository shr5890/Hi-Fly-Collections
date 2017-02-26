package textencryptor;

import java.util.HashMap;

public class TextWriter {
	public void decryptMessage(String strMessage, String strKey){
		StringBuilder sbDecryptMessage = new StringBuilder();
		HashMap<String, String> hmLetter = decryptKey(strMessage, strKey);
		for(int i = 0 ; i < strMessage.length() ; i++){
			sbDecryptMessage.append(hmLetter.get(Character.toString(strMessage.charAt(i)))); 
		}
		System.out.println("Decrypted Message");
		System.out.println(" ========================================================== ");
		System.out.println(sbDecryptMessage.substring(96));
	}
	public HashMap<String, String> decryptKey(String strMessage, String strKey){
		HashMap<String, String> hmLetter = new HashMap<String, String>(); 
		for(int i = 0 ; i < strKey.length() ; i++){
			hmLetter.put(Character.toString(strMessage.charAt(i)), Character.toString(strKey.charAt(i)));
		}
		return hmLetter;
	}
}