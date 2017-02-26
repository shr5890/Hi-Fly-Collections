package textencryptor;

public class TextEncrytorMain {
	public static void main(String[] args){
		TextReader TR = new TextReader();
		TR.runEncryptor("hi helllo ho u doin??\nwhats up bro?\nHow is ur family?\nTC see ya:)\nPoda poda poda porambokku");
		new TextWriter().decryptMessage(TR.sbEncryptedMessage.toString(), TR.sbMessageKey.toString());
	}
}