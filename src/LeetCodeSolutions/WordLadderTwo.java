package LeetCodeSolutions;

import java.util.HashSet;
import java.util.*;

public class WordLadderTwo {
	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        Queue<String> q1 = new LinkedList<String>(), q2 = new LinkedList<String>();
        Queue<ArrayList<String>> l1 = new LinkedList<ArrayList<String>>(), l2 = new LinkedList<ArrayList<String>>();
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        boolean found = false;
        
        q1.offer(start);
        ArrayList<String> l = new ArrayList<String>();
        l.add(start);
        l1.offer(l);
        
        HashSet<String> remove = new HashSet<String>();
        
        while(q1.size() > 0){
            String s = q1.poll();
            ArrayList<String> r = l1.poll();
            
            for(int i = 0; i < s.length(); i++){
                for(char c = 'a'; c <= 'z'; c++){
                    char[] temp = s.toCharArray();
                    temp[i] = c;
                    String tempS = new String(temp);
                    
                    if(tempS.equals(end)){
                        ArrayList<String> rr = new ArrayList<String>();
                        rr.addAll(r);
                        rr.add(tempS);
                        res.add(rr);
                        found = true;
                    }else if(!found && !tempS.equals(s) && dict.contains(tempS)){
                        q2.offer(tempS);
                        ArrayList<String> rr = new ArrayList<String>();
                        rr.addAll(r);
                        rr.add(tempS);
                        l2.offer(rr);
                        remove.add(tempS);
                    }
                }
            }
            
            if(q1.size() == 0){
            	q1.addAll(q2);
            	q2.clear();
            	l1.addAll(l2);
            	l2.clear();
            	for(String word : remove){
            		dict.remove(word);
            	}
            	remove.clear();
            }
        }
        
        return res;
    }
    
    public static void main(String[] args){
    	String start = "red", end = "tax";
    	String[] d = {"ted","tex","red","tax","tad","den","rex","pee"};
    	HashSet<String> dict = new HashSet<String>(Arrays.asList(d));
    	
    	WordLadderTwo wlt = new WordLadderTwo();
    	
    	for(ArrayList<String> l : wlt.findLadders(start, end, dict)){
    		Printer.printList(l);
    	}
    }
}
