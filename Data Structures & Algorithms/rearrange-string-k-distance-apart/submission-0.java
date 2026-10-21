class Solution {
    class Node{
        int freq;
        char c;

        public Node(int f, char c)
        {
            freq = f;
            this.c = c;
        }
    }

    public String rearrangeString(String s, int k) {
        
        if(k <= 1)
        {
            return s;
        }

        int[] freq = new int [26];
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> {
            if(a.freq == b.freq)
            {
                return a.c - b.c;
            }
            else
            {
                return b.freq - a.freq;
            }
        }); // [freq,char]

        for(char c : s.toCharArray())
        {
            int idx = c - 'a';
            freq[idx] ++;
        }

        for(int i = 0; i < 26; i ++)
        {   
            int num = freq[i];

            if(num > 0)
            {
                pq.add(new Node(num,(char)('a' + i)));
            }
        }

        // for(Node n : pq)
        // {

        // System.out.println(n.freq);

        // System.out.println(n.c);
        // }



        Queue<int[]> q = new ArrayDeque<>(); // [index, freq, char]

        StringBuilder sb = new StringBuilder();
        int index = 0;
        int n = s.length();

        while(!pq.isEmpty() || !q.isEmpty())
        {   
            if(index >= n)
            {   
                // System.out.println("check here : " + sb);
                return "";
            }

            if(!q.isEmpty() && q.peek()[0] == index)
            {   
                int[] cur = q.poll();

                pq.add(new Node(cur[1], (char)(cur[2] + 'a')));
            }

            if(!pq.isEmpty())
            {
                Node node = pq.poll();

                sb.append(node.c);

                if(node.freq > 1)
                q.add(new int[] {index + k,node.freq - 1,node.c - 'a'});
            }

            index ++;
        }

        return sb.toString();
    }
}
