class MedianFinder {

    // container is even return midian
    // if container is odd return the median ot the two middle value
    // how to easy find the midian value 
    PriorityQueue<Integer> small = new PriorityQueue<>((a,b) -> b - a);
    PriorityQueue<Integer> large = new PriorityQueue<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        
        small.add(num);

        large.add(small.poll());

        if(large.size() > small.size())
        {
            small.add(large.poll());
        }
    }
    
    public double findMedian() {

        if(small.isEmpty())
        {
            return 0.0;
        }
        else
        {
            if(small.size() > large.size())
            {   
                return small.peek();
            }
            else
            {
                return (small.peek() + large.peek()) / 2.0;
            }
        }
        
    }
}
