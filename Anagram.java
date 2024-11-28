/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// // Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		// Replace the following statement with your code

		String new1 = preProcess(str1);
		String new2 = preProcess(str2);
		char letter1;

		String new1WhithoutSpaces = "";

		for(int i = 0; i < new1.length(); i++){
			if(new1.charAt(i) != ' '){
				new1WhithoutSpaces = new1WhithoutSpaces.concat(String.valueOf(new1.charAt(i)));
			}
		}

		String new2WhithoutSpaces = "";

		for(int i = 0; i < new2.length(); i++){
			if(new2.charAt(i) != ' '){
				new2WhithoutSpaces = new2WhithoutSpaces.concat(String.valueOf(new2.charAt(i)));
			}
		}


		if (new1WhithoutSpaces.length() != new2WhithoutSpaces.length()){
			return false;
		}
		for (int i = 0; i < new1WhithoutSpaces.length(); i++) {
			letter1 = new1WhithoutSpaces.charAt(i);
			for (int j = 0; j < new2WhithoutSpaces.length(); j++) {
				if (letter1 == new2WhithoutSpaces.charAt(j)){
					new2WhithoutSpaces = new2WhithoutSpaces.substring(0, j) + new2WhithoutSpaces.substring(j+1, new2WhithoutSpaces.length());
					break;
				}
			}
		}
		if (new2WhithoutSpaces.length() == 0){
			return true;
		} 

		return false;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// Replace the following statement with your code

		String newStr = "";
		char c;
		for(int i = 0; i < str.length(); i++){
			c = str.charAt(i);
			if((int)c >= 97 && (int)c <= 122){
				newStr += c;
			}
			if ((int)c >= 65 && (int)c <= 90){
				newStr += (char)(int)(c+32);
			}
			if (c == ' '){ 
				newStr += ' ';
			} 
		}
		return newStr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		str = preProcess(str);
		String newStr = "";
		int num;
		int lenght = str.length();

		for(int i = 0; i < lenght; i++){
			num = (int) (Math.random() * (str.length() -1));
			newStr += str.charAt(num);
			str = str.substring(0, num) + str.substring(num+1, str.length());
		}
		return newStr;
	}
}
