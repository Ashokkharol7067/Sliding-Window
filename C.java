// Counting Occurrences Of Anagrams -- Sliding Winding.
import java.util.HashMap;

public class C {

    public static void main(String[] args) {
        String str = "aabaabaa";
        String ptr = "aaba";

        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: ptr.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0)+1); 
   
        int count = map.size(), k = ptr.length(); 

        int ans=0, i=0,j=0;

        while(j < str.length()){
            if(map.containsKey(str.charAt(j))){
                map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0)-1);
                if(map.get(str.charAt(j)) == 0) count--;
            }

            if((j-i+1) < k) j++;
            
            else if((j-i+1) == k){
                if(count == 0) {ans++;}

                if(map.containsKey(str.charAt(i))){
                    if(map.get(str.charAt(i)) == 0) count++;
                    map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
                }
        
                i++;
                j++;
            }
        }
        System.out.println(ans);
    }
}
