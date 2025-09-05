// Minimum Window Substring..................
import java.util.HashMap;

public class F {
    public static String minWindow(String s, String t) {
        if(t.length()==1){
            for(int i=0; i<s.length(); i++){
                if(t.charAt(0) == s.charAt(i)) return t;
            }
        }
        if(t.length() > s.length()) return "";
        if(t.length()==1 && s.length()==1)
        {
            if(s.equals(t)) return t;
            else return "";
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch:t.toCharArray())
            map.put(ch, map.getOrDefault(ch,0)+1);
        int count = map.size();

        int i=0,j=0,st=0,en=0,length=Integer.MAX_VALUE;

        while(j < s.length())
        {
            char ch1 = s.charAt(j);
            if(map.containsKey(ch1))
            {
                map.put(ch1, map.getOrDefault(ch1,0)-1);
                if(map.get(ch1) == 0) count--;
            }
            if(! (count == 0)) j++;
            else if(count == 0)
            {
                while(count == 0)
                {
                    if(length > (j-i+1)) {length = j-i+1; st=i; en=j; }
                    if(map.containsKey(s.charAt(i)))
                    {
                        map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
                        if(map.get(s.charAt(i)) > 0) count++;
                    }
                    i++;
                }
                j++;
            }
        }
        if(st==0 && en==0) return "";
        else return s.substring(st,en+1);    
    }
    public static void main(String[] args)
    {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String ans = minWindow(s, t);
        System.out.println(ans);
    }
}
