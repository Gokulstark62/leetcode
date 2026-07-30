class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int []count = new int[2];
        for(int i:students)
        count[i]++;
        int rem=sandwiches.length;
        for(int j:sandwiches){
        if(count[j]==0)
        break;
        if(rem--==0)
        break;
        count[j]--;
        }
        return rem;
    }
}