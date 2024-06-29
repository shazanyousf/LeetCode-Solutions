class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer , HashSet<Integer>> map = new HashMap<>();
        int n =stones.length;
        for(int ele:stones)
        {
            map.put(ele,new HashSet<>());
        }
        map.get(stones[0]).add(1);
        for(int i=0;i<n-1;i++)
        {
            int num=stones[i];
            HashSet<Integer> jumps = map.get(num);
            for(int k:jumps)
            {
                int vs=num+k;
                if(vs==stones[n-1])return true;
                if(map.containsKey(vs))
                {
                    if(k-1>0)map.get(vs).add(k-1);
                        map.get(vs).add(k);
                        map.get(vs).add(k+1);


                  
                }
            }
        }
        return false;
    }
}