package LeetCodeSolutions;

import java.util.List;

public class Printer {

    public static <E> void printList(List<E> list){
    	for(int i = 0; i < list.size(); i++){
    		System.out.print(list.get(i));
    	}
    	
    	System.out.println();
    }
}
