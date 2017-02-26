package textencryptor;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;

public class TextReader {
	private LinkedHashMap<String,String> lhmKeyText = new LinkedHashMap<String,String>();
	private int[] intArrRandom = new int[96];
	public StringBuilder sbEncryptedMessage;
	public StringBuilder sbMessageKey;
	public void runEncryptor(String strText){
		sbEncryptedMessage = new StringBuilder();
		sbMessageKey = new StringBuilder();
		strText = randomizeString(getEncryptors()) + strText;
		char[] charArrText = strText.toCharArray();
		for(int i = 0 ; i < charArrText.length ; i++){
			if(i<95){
				if(!(lhmKeyText.containsKey(Character.toString(charArrText[i])))){
					char charEncyrptedLetter = encyrptMessage(i);
					lhmKeyText.put(Character.toString(charArrText[i]), Character.toString(charEncyrptedLetter));
					sbMessageKey.append(charArrText[i]);
				}
			}else if(i==95){
				lhmKeyText.put(Character.toString(charArrText[i]), Character.toString('A'));
				sbMessageKey.append(charArrText[i]);
			}
			sbEncryptedMessage.append(lhmKeyText.get(Character.toString(charArrText[i])));
		}
		System.out.println("Key : " + sbMessageKey.toString());
		System.out.println("Key Length : " + sbMessageKey.toString().length());		
		System.out.println("Message : " + sbEncryptedMessage.toString());
	}
	private char encyrptMessage(int intAcess){
		char[] charArrLetters = getEncryptors();
		int[] intarrRandomNumbers = assignValues(96);
		int intRandom = 0;
		intRandom = generateRandomNumber(intarrRandomNumbers);
		intArrRandom[intAcess] = intRandom;
		return charArrLetters[intArrRandom[intAcess]];
	}
	public int generateRandomNumber(int[] intarrRandomNumbers){
		int[] intarrRandomRange =  getRandomRange(intarrRandomNumbers);
		int intRandom = 0;
		Random random = new Random();
		intRandom = random.nextInt(intarrRandomRange.length);
		return intarrRandomRange[intRandom];		
	}
	public String randomizeString(char[] charArrLetters){
		StringBuilder sb = new StringBuilder(charArrLetters.length);
		double random;
		for(char c : charArrLetters){
			random = Math.random();
			if(random < 0.34)
				sb.append(c);
			else if(random < 0.67)
				sb.insert(sb.length()/2, c);
			else
				sb.insert(0, c);
		}
		return sb.toString();
	}
	private char[] getEncryptors(){
		char[] charArrLetters = {'A','B','C','D','E','F','G','H','I','J','K','L','M',
				'N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
				'a','b','c','d','e','f','g','h','i','j','k','l','m',
				'n','o','p','q','r','s','t','u','v','w','x','y','z',
				'0','1','2','3','4','5','6','7','8','9',
				'!','@','#','$','%','^','&','*','(',')',
				'<','>','?',',','.','/',':',';','[',']',
				'{','}','_','+','|','-','=',
				'\'','"','\\','\n','`','~',' '};
		return charArrLetters;
	}
	private int[] getRandomRange(int[] intarrRandomNumbers){
		ArrayList<Integer> intlistExistingRandoms = new ArrayList<Integer>(intarrRandomNumbers.length);
		for(int j = 0 ; j < intarrRandomNumbers.length ; j++)
			intlistExistingRandoms.add(Integer.valueOf(intarrRandomNumbers[j]));
		for(int i = 0; i < intArrRandom.length; i++){
			for(int j = 0; j < intlistExistingRandoms.size(); j++){
				if(intArrRandom[i]==intlistExistingRandoms.get(j)){
					intlistExistingRandoms.remove(j);
					break;
				}
			}
		}
		return intlistExistingRandoms.stream().mapToInt(i->i).toArray();
	}
	public int[] assignValues(int intlength){
		int[] intarrValues = new int[intlength];
		for(int i = 0; i < intlength ; i++){
			intarrValues[i] = i;
		}
		return intarrValues;
	}
}