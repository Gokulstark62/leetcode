class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int max=-11,currMax=1,currMin=1;
        for(int num:nums){
            if(num<0){
                int temp=currMax;
                currMax=currMin;
                currMin=temp;
            }
            currMax=Math.max(num,num*currMax);
            currMin=Math.min(num,num*currMin);
            max=Math.max(max,currMax);
        }
        return max;
    }
}
