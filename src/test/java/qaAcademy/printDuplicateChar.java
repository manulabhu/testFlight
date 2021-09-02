package qaAcademy;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class printDuplicateChar {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		printDuplicateChar("s");
	}

	public static void printDuplicateChar(String st) {
		if(st==null) {
			System.out.println("string is null");
		}
		
		if(st.isEmpty()) {
			System.out.println("string is empty");
		
		}
		 if(st.length()==1) {
			 System.out.println("single char string");
		 }
		
		 char word[] = st.toCharArray();
		 
		 HashMap<Character, Integer> charMap= new HashMap<Character, Integer>();
		 
		 for(Character ch : word) {
			 if(charMap.containsKey(ch)){
				 charMap.put(ch, charMap.get(ch)+1);
			 }
			 else {
				 charMap.put(ch, 1);
				 
			 }
		 }
		
		 //print the map
		  Set<Map.Entry<Character, Integer>> entrySets = charMap.entrySet();
		  for(Map.Entry<Character, Integer> entrySet : entrySets) {
			  if(entrySet.getValue()>1) {
				  System.out.println(entrySet.getKey() + ":" + entrySet.getValue());
				  
				  
			  }
		  }
			  
		 
	}
	
}
