package textencryptor;

public class TextEncrytorMain {
	public static void main(String[] args){
		TextReader TR = new TextReader();
		TR.runEncryptor("hi helllo ho u doin??\nwhats up bro?\nHow is ur family?\nTC see ya:)\nhell yeah :) :( :> - hey hey jey jey");
		new TextWriter().decryptMessage(TR.sbEncryptedMessage.toString(), TR.sbMessageKey.toString());
	}
}