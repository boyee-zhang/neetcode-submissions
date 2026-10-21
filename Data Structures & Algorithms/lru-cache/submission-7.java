class LRUCache {

    HashMap<Integer,Node> map;
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        public Node (int k,int v)
        {
            key = k;
            val = v;
        }
    }
    private Node head;
    private Node tail;
    private int totalCapacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();

        head = new Node(0,0);
        tail = new Node(0,0);
        totalCapacity = capacity;
        
        head.next = tail;
        tail.next = head;

        head.prev = tail;
        tail.prev = head;
    }
    
    public void addHead(Node node)
    {      
        System.out.println("[addHead] adding to head " + node.val);

        node.next = head.next.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;

        map.put(node.key,node);
    }

    public void addTail(Node node)
    {
        System.out.println("[addTail] adding to tail " + node.key);
        map.put(node.key,node);

        node.next = tail;
        tail.prev.next = node;

        node.prev = tail.prev;
        tail.prev = node;
    }

    public void removeNode(Node node)
    {   
        System.out.println("[removeNode] removing node " + node.key);

        node.prev.next = node.next;
        node.next.prev = node.prev;

        map.remove(node.key);
    }


    public int get(int key) {
        
        if(!map.containsKey(key))
        {
            return -1;
        }

        // return value and update element position 
        Node node = map.get(key);
        removeNode(node);
        addTail(node);
        return node.val;
    }
    
    public void put(int key, int value) {

        if(map.containsKey(key))
        {
            Node node = map.get(key);
            node.val = value;
            removeNode(node);
            addTail(node);
        }
        else
        {
            Node node = new Node(key,value);
            addTail(node);
        }   

        if(map.size() > totalCapacity)
        {
            removeNode(head.next);
        }     
    }
}
