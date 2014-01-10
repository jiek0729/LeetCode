package LeetCodeSolutions;

import java.util.List;

public class Printer {

    public static <E> void printList(List<E> list){
    	for(int i = 0; i < list.size(); i++){
    		System.out.print(list.get(i));
    	}
    	
    	System.out.println();
    }
    
    public static void printCharArray(char[] chars){
    	for(int i = 0; i < chars.length; i++){
    		System.out.print(chars[i] + " ");
    	}
    	System.out.println();
    }
}
