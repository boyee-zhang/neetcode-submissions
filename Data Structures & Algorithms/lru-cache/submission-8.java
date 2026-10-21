class LRUCache {
    
    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        public Node(int key, int val)
        {
            this.key = key;
            this.val = val;
        }
    }

    public void removeNode(Node node)
    {   

        System.out.printf("[removeNode] removing node %d\n",node.key);
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToTail(Node node)
    {

        System.out.printf("[addToTail] add node %d to Tail \n",node.key);
        map.put(node.key,node);

        tail.prev.next = node;
        node.prev = tail.prev;

        node.next = tail;
        tail.prev = node;
    }

    HashMap<Integer,Node> map;
    Node tail;
    Node head;
    int totalCapacity;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        totalCapacity = capacity;

        head = new Node(0,0);
        tail = new Node(0,0);

        head.next = tail;
        head.prev = tail;

        tail.next = head;
        tail.prev = head;
    }
    
    public int get(int key) {
        
        if(!map.containsKey(key))
        {
            return -1;
        }

        // the the node val and update node position 

        Node node = map.get(key);
        
        removeNode(node);
        addToTail(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        
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
