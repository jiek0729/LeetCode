package LeetCodeSolutions;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationTwo {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        permuteUnique(num, 0, num.length, result);
        
        return result;
    }
    
    private void permuteUnique(int[] num, int s, int e, ArrayList<ArrayList<Integer>> result){
        if(s == e){
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < num.length; i++){
                list.add(num[i]);
            }
            
            result.add(list);
        }
        
        for(int i = s; i < e; i++){
            if(!noSwap(num, s, i)){
                swap(num, s, i);
                permuteUnique(num, s + 1, e, result);
                swap(num, s, i);
            }
        }
    }
    
    private void swap(int[] num, int index1, int index2){
        int temp = num[index1];
        num[index1] = num[index2];
        num[index2] = temp;
    }
    
    private boolean noSwap(int[] num, int s, int e){
    	for(int i = s; i < e; i++){
    		if(num[i] == num[s]){
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    public static void main(String[] args){
    	PermutationTwo instance = new PermutationTwo();
    	
    	int[] nums = {-1, -1, 3, 1};
    	
    	for(ArrayList<Integer> list : instance.permuteUnique(nums)){
    		Printer.printList(list);
    	}
    }
}
