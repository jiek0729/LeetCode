package LeetCodeSolutions;

import java.util.List;

public class Printer {

    public static <E> void printList(Iterable<E> list){
    	for(E item : list){
    		System.out.print(item + " ");
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
