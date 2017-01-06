import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Telegram {

	public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String accStr; 
		String input = "In the addition program that we have written we have initialised the variables firstNumber and secondNumber with 3 and 4.\n" + 
				"Wouldn't it be better if you could ask your friend to enter his own values and then display the sum of those two numbers?\n" + 
				"There are several ways to do it in Java.\n" +
				"But here we shall look at one simple way by using the Scanner class.";
		ArrayList<String> output = new ArrayList<String>();
		int n = 50;
		
		//System.out.println("Enter a number: ");
		//accStr = br.readLine();
		//int n = Integer.parseInt(accStr);
		//System.out.println("Enter the text: ");
		//String input = br.readLine();
		
		System.out.println("n:" + n);
		System.out.println("Input:\n" + input);
		System.out.println("---------------------------------------------------------------------");
		
		//break character stream to nearest NL or BL
		while(input.length() > 0){
			if(input.length() > n) {
				String newLine = findOptimum(n, input);
				output.add(newLine);
				input = input.substring(newLine.length() + 1);
			} else {
				output.add(input);
				break;
			}
		}
		String strOutput = "";
		for (String string : output) {
			strOutput += string + " ";
		}
		System.out.println("Output:\n" +strOutput);
	}
	
	public static String findOptimum(int n, String input){
		String retString = "";
		String buffer = "";
		String[] terms = input.split("[\n,\\s+]");
		for (String string : terms) {
			if(string.length() < n && buffer.length() < n) {
				if(buffer.length() + string.length() < n) {
					buffer += string + " ";
				} else {
					retString = buffer.trim();
					break;
				}
			} else {
				//System.out.println("error: string bigger than n or buffer full");
				break;
			}
		}
		return retString;
	}

}
