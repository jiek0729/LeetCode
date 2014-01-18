package LeetCodeSolutions;

public class PermutationSequence {
    //Design reverse carefully.
    public String getPermutation(int n, int k) {
        char[] chars = new char[n];
        initializes(chars);
        
        for(int i = 2; i <= k; i++){
            next(chars);
        }
        
        return new String(chars);
    }
    
    private void initializes(char[] chars){
        for(int i = 0; i < chars.length; i++){
            chars[i] = (char)('1' + i);
        }
    }
    
    private void next(char[] chars){
        int runner = chars.length - 1;
        int starter = 0, newStarter = 0;
        
        for(; runner > 0 && chars[runner] < chars[runner - 1]; runner--);
        starter = runner - 1;
        for(; runner < chars.length - 1 && chars[runner + 1] > chars[starter]; runner++);
        newStarter = runner;
        
        swap(chars, starter, newStarter);
        reverse(chars, starter + 1, chars.length - 1);
    }
    
    private void reverse(char[] chars, int start, int end){
        while(start < end){
            swap(chars, start, end);
            start++;
            end--;
        }
    }
    
    private void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
    
    public static void main(String[] args){
    	PermutationSequence ps = new PermutationSequence();
    	
    	ps.getPermutation(3, 7);
    }
}
