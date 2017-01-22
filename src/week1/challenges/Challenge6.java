package week1.challenges;

import java.util.ArrayList;

public class Challenge6 {
	public static void main(String args[]) {
		Challenge6 c = new Challenge6();
	}

	public String longestCommonPrefix(ArrayList<String> a) {
	    String commonPrefix = null;
	    String firstString = a.get(0);
	    int index = 0;
	    while (commonPrefix == null) {
	        char c = firstString.charAt(index);
	        
    	    for (int i = 1; i < a.size(); i++) {
    	        String s = a.get(i);
    	        if (s.length() >= index || s.charAt(index) != c) {
    	            if (index > 0) {
    	                commonPrefix = firstString.substring(0, index);
    	            }
    	            else
    	            {
    	                commonPrefix = "";
    	            }
    	        }
    	    }
    	    
    	    index++;
	    }
	    return commonPrefix;
	}
}
