class LRUCache {
    

    //Queue to store the sequence of operation 
    // update the order according to the sequence of operation 
    //  key <-> value

    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val)
        {
            this.key = key;
            this.val = val;
        }
    }

    Node head;
    Node tail;
    HashMap<Integer,Node> map;
    int totalCapacity;
    public LRUCache(int capacity) {
        totalCapacity = capacity;

        head = new Node(0,0);
        tail = new Node(0,0);

        map = new HashMap<>();
        head.next = tail;
        tail.next = head;

        head.prev = tail;
        tail.prev = head;
    }
    
    public void addToTail(Node node)
    {      
        System.out.println("add to Tail " + node.key);
        map.put(node.key,node);
        node.next = tail;
        node.prev = tail.prev;

        tail.prev.next = node;
        tail.prev = node;
    }

    public void removeNode(Node node)
    {   
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        //return the node val and update the node postion to list tail 
        if(!map.containsKey(key))
        {
            return -1;
        }

        Node node = map.get(key);
        removeNode(node);
        addToTail(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        //put node to the tail if over the capacity remove the first node of list
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            node.val = value;
            removeNode(node);
            addToTail(node);
        }
        else
        {
            Node node = new Node(key,value);
            addToTail(node);
        }

        if(map.size() > totalCapacity)
        {
            removeNode(head.next);
        }
    }
}
