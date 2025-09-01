import java.util.HashMap;

public class E {
    public static void main(String[] args) {
        int nums[] = {0,1};
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        int i=0, j=0, ans = 0, windowUC = 0;

        while(j < n)
        {
            map.put(nums[j], map.getOrDefault(nums[j], 0)+1);

            if(map.get(nums[j]) == 1)
                windowUC++;

            if(windowUC < 2) j++;    

            else if(windowUC == 2)
            {
                ans = Math.max(ans, (j-i+1));
                j++;
            }

            else if(windowUC > 2)
            {
                while(windowUC > 2)
                {
                    map.put(nums[i], map.getOrDefault(nums[i], 0)-1);
                    if(map.get(nums[i]) == 0)
                    {
                        windowUC--;
                        map.remove(nums[i]);
                    }
                    i++;
                }
                j++;
            }    
        }
        if(windowUC == 1) 
            System.out.println(nums.length+"hii");
        System.out.println(ans+"hlo");
    }
}
