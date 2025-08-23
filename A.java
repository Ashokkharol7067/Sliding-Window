// Brute force to find maxSubArraySum of size K---

// public class A 
// {
//     public static void main(String[] args) {
//         int nums[] = {1,2,3,4,5,6,7,8,9};
//         int k = 3;
//         int ans = Integer.MIN_VALUE, sum=0;
//         for(int i=0; i<nums.length-k+1 ; i++){
//             for(int j=i; j<i+k; j++)
//                sum += nums[j];
//             ans = Math.max(ans, sum);
//             sum = 0;   
//         }
//         System.out.println(ans);
//     }
// } 

// Optimized code -- Sliding Window Approach 

public class A {

    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6,7,8,9};
        int k=3;
        int j=0, i=0, n=nums.length, sum = 0;
        int ans = Integer.MIN_VALUE;
        while (j < n) {
            sum += nums[j];
            if(j-i+1 < k) j++;
            else if(j-i+1 == k){
                ans = Math.max(ans, sum);
                sum -= nums[i];
                j++;
                i++;
            }
        }
        System.out.println(ans);
    }
}