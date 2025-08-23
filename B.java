// First Negative Number in every Window of Size K | Sliding Window

import java.util.LinkedList;
import java.util.Queue;

public class B {
    public static void main(String[] args) {
        int nums[] = {-8, 2, 3, -6, 10};
        int k=2;
        int i=0,j=0,n=nums.length;
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> ans = new LinkedList<>();
        while (j < n) {
            if(nums[j] < 0) q.add(nums[j]);
            if(j-i+1 < k) j++;
            else if(j-i+1 == k){
                if(!q.isEmpty()){
                    ans.add(q.peek());
                }else ans.add(0);
                if(!q.isEmpty() && nums[i] == q.peek()) q.poll();
                i++;
                j++;
            }
        }
        System.out.println("Ans is "+ ans);
    }
}

/*
  Brute approach forloop
...........................................  
for(int i=0; i<nums.length-k+1; i++){
    boolean b = true;
    for(int j=i; j<i+k; j++){
        if(nums[j]<0){
            System.out.print(nums[j]+" ");
            b = false;
            break;
        }                  
    }
    if(b)
        System.out.print(0+" ");
} 
............................................

 */