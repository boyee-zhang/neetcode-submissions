class Solution {

    /*
        require:
            - if at any time point, the curr load is less than cap return true
            - otherwise return false
        
        invariant:
            - at any time point i, current load = previous load number + new coming load number 
            
    */
    public boolean carPooling(int[][] trips, int capacity) {
        int curLoad = 0; 

        int[] delta = new int [10001];


        for (int[] t : trips) { delta[t[1]] += t[0]; delta[t[2]] -= t[0]; }
        int cur = 0;
        for (int d : delta) { cur += d; if (cur > capacity) return false; }

        return true;
    }
}