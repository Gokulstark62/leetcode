class Solution {
    public int minimumChairs(String s) {
        int chair=0;
        int people=0;
        for(char ch:s.toCharArray()){
            if(ch=='E'){
                people+=1;
                if(chair < people){
                    chair+=1;
                }
            }
            else{
                people-=1;
            }
        }
        return chair;
    }
}