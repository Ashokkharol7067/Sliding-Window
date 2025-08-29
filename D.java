import java.util.ArrayList;
import java.util.List;

public class D{
    public static int[] maxOfSubArr(int[] nums, int k){
        int arr[] = new int[nums.length-k+1];
        List<Integer> list = new ArrayList<>();
        int i=0, j=0;

        while(j < nums.length){
            while( !list.isEmpty() && list.get(list.size() - 1) < nums[j])
                list.remove(list.size() - 1);
                  
            list.add(nums[j]);
            
            if((j-i+1) < k ) j++;

            else if( (j-i+1) == k){
                arr[i] = list.get(0);
                if(nums[i] == list.get(0))
                    list.remove(0);
                i++;
                j++;    
            }
        }
        return arr;
    } 
    public static void main(String[] args) {
        // TODO code application logic here
        int nums[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int ans[] = maxOfSubArr(nums, k);
        for(int x:ans){
            System.out.print(x+" ");
        }
    }
}