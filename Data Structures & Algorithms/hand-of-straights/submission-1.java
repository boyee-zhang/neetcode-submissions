class Solution {

    // time complexity O(N * groudSize)
    //
    public boolean isNStraightHand(int[] hand, int groupSize) {

        int n = hand.length;

        if(n % groupSize != 0)
        {
            return false;
        }

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : hand)
        {
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        Arrays.sort(hand);

        for(int num : hand)
        {    
            if(map.get(num) > 0)
            {
                for(int i = num; i < num + groupSize; i ++)
                {   
                    System.out.println("current map " + map);
                    if(map.getOrDefault(i,0) == 0) return false;
                    map.put(i,map.get(i) - 1);
                }
            }

        }

        return true;
    }
}
