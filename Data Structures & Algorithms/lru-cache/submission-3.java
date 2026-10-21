class LRUCache {
    int curCapacity;
    Map<Integer,Node> map;
    Node head;
    Node tail;

    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }
    
    
    public LRUCache(int capacity) {
        head = new Node(0,0);
        tail = new Node(0,0);
        head.prev = tail;
        tail.next = head;
        head.next = tail;
        tail.prev = head;

        curCapacity = capacity;
        map = new HashMap<>();
    }
    
    public void addToHead(Node node)
    {   
        map.put(node.key,node);
        head.next.next.prev = node;
        node.next = head.next.next;
        head.next = node;
        node.prev = head;
    }

    public void deleteNode (Node node)
    {   
        node.prev.next = node.next;
        node.next.prev = node.prev;

        map.remove(node.key);
        System.out.println("Deleting: " + node.key);
        node.prev = null;
        node.next = null;

        //return Node value
    }

    public void removeHead()
    {   
        System.out.println("Deleting to head: " + head.next.key);
        map.remove(head.next.key);

        head.next.next.prev = head;
        head.next = head.next.next;

    }

    public void addTail(Node node)
    {   
        map.put(node.key,node);

        tail.prev.next = node;
        node.prev = tail.prev;

        node.next = tail;
        tail.prev = node;

        System.out.println("Adding to tail: " + node.key);
    }

    public int get(int key) {
        //update queue 
        if(map.containsKey(key))
        {   
            Node node = map.get(key);
            deleteNode(node);
            addTail(node);
            return node.value;
        }
        else
        {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        
        if(curCapacity > 0 && !map.containsKey(key))
        {   
            Node node = new Node(key,value);
            map.put(key,node);
            addTail(node);
            curCapacity --;
        }
        else if(curCapacity > 0 && map.containsKey(key))
        {
            // remove elements from queue need O(N)
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addTail(node);
            
        }
        else if(curCapacity <= 0 && map.containsKey(key))
        {   
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addTail(node);
        }
        else
        {
            Node node = new Node(key,value);
            map.put(key,node);
            removeHead();
            addTail(node);
        }

    }
}
