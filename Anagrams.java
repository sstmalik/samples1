/**
 * @author Sheik Thamby Malik. S
 */

package come.nyse.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Anagrams {

	public static void main(String[] args) {
		
		//sample input data to be checked for anagrams
		String inputStr = "abc cab abd dab bac abcd dcba bca efh hij klm hfe";
		
		//convert the input to a list of values. 
		
		List<String> inputStringList = new ArrayList<String>();
		
		
		AnagramFinder(inputStr);
		
	}
	
	public static void AnagramFinder(String inputStr){
		Map<String,String> anaKeyMap = new HashMap<String,String>();
		
		StringBuilder valueBuilder = new StringBuilder("");
		String keyWord = "";
		
		//split the input string and check for anagrams
		StringTokenizer tokenizer = new StringTokenizer(inputStr, " ");
		String inputWord = "";
		while(tokenizer.hasMoreTokens()){
			
			/*create a key for each anagram which is the ordered string. 
			for example. for abc and cab , the orderded key will be abc*/
			inputWord = tokenizer.nextToken();
			char[] charArrayWord = inputWord.toCharArray();
			Arrays.sort(charArrayWord);
			keyWord = String.valueOf(charArrayWord);
			
			//put the keys and their anagrams in a hashmap
			if(anaKeyMap.get(keyWord) == null){
				anaKeyMap.put(keyWord, inputWord);
			} else {
				valueBuilder = new StringBuilder().append(anaKeyMap.get(keyWord)).append(",").append(inputWord);
				anaKeyMap.put(keyWord, valueBuilder.toString());
			}
			 			
			
		}
		
		
		//print the results -  
		 
		anaKeyMap.entrySet().stream().forEach(e-> System.out.println(e));
	}
}
