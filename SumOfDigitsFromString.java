package Week2.Day2;

public class SumOfDigitsFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "Tes12Le79af65";
		int sum = 0;
		String replaceAllAlphabets = text.replaceAll("\\D", "");
		System.out.println(replaceAllAlphabets);
		char[] charArray = replaceAllAlphabets.toCharArray();
		for (char c : charArray) {
			sum = sum + Character.getNumericValue(c); 
		}
		System.out.println("The Sum of the Digits in the given text is : " + sum);
	}

}
