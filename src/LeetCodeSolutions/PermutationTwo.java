package LeetCodeSolutions;

import java.util.ArrayList;

public class PermutationTwo {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        return permuteUnique(num, 0);
    }
    
    private ArrayList<ArrayList<Integer>> permuteUnique(int[] num, int index){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if(index == num.length){
            result.add(new ArrayList<Integer>());
            return result;
        }
        
        ArrayList<ArrayList<Integer>> sub = permuteUnique(num, index + 1);
        
        for(ArrayList<Integer> base : sub){
            for(int i = 0; i <= base.size(); i++){
                if(i == base.size() || (i < base.size() && num[index] != base.get(i))){
                    result.add(insert(base, num[index], i));
                }
            }
        }
        
        return result;
    }
    
    private ArrayList<Integer> insert(ArrayList<Integer> list, int num, int index){
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        result.addAll(list);
        result.add(index, num);
        
        return result;
    }
    
    public static void main(String[] args){
    	PermutationTwo instance = new PermutationTwo();
    	
    	int[] nums = {-1, -1, 3, 1};
    	
    	for(ArrayList<Integer> list : instance.permuteUnique(nums)){
    		Printer.printList(list);
    	}
    }
}
