package mock;

class Solution {     
	   // time : S + T  space : S + T
	    public static String findMinimumWindow(String s, String t) {
	        // two pointer approach
	        String res = "";
	        if(s == null || t == null || s.length() < t.length()) return res;

	        int[] arr_t = new int[256];
	        for(char c : t.toCharArray()) {
	            arr_t[c]++;
	        }
	        int count = 0;
	        int[] arr_s = new int[256];
	        // find the first valid character
	        int start = findnextvalid(s, arr_t, 0);
	        if(start == s.length()) return "";
	        int end = start;
	        // move end pointer
	        while(end < s.length()) {  
	            int c = s.charAt(end); // If we direct assign char variable to int, it will return ASCII value of given character.
	            if(arr_s[c] < arr_t[c]) {
	                count++;
	            }
	            arr_s[c]++;
	            //move start pointer
	            while(start < s.length() && count == t.length()) {
	                if(res == "" || res.length() > (end - start + 1)) {
	                    res = s.substring(start, end + 1);
	                }
	                
	                int char_start = s.charAt(start);
	                if(arr_s[char_start] <= arr_t[char_start]) { //
	                    count--;
	                }
	                arr_s[char_start]--;
	                start = findnextvalid(s, arr_t, start+1);
	            }
	            end = findnextvalid(s, arr_t, end+1);
	        }
	        return res;
	    }

	    public static int findnextvalid(String s, int[] arr_t, int start) {
	       while(start < s.length()) {
	           char c = s.charAt(start);
	           if(arr_t[c] != 0){
	               return start;
	           }
	           start ++;
	       }
	        return start;
	    }

	public static void main(String[] args) {
	   String s = "ADOBECODEBANC";
	   String t = "ABC";
	   String res = Solution.findMinimumWindow(s, t);
	   System.out.print(res);
	   
	}
	}
