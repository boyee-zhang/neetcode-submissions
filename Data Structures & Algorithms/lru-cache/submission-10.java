class LRUCache {
    

    /*
        require:
            - contain a kv data structure,could retrival key return value / key is not existed return -1 (O(1))
            - able to insert a key-value (O(1))
            - if insert a new kv and the exceed whole capacity, remove the LEAST rencetly used key
        
        invariant:
            - the new element insert,would add to the head of the container
            - any remove should have only in the tail of the container and clear the key-value in map
            - any operation would update a element position in this container to the head

            ① map 的键集 = 链表中真实节点（不含两个哨兵）的 key 集合
            且 map.get(k) 与链表里那个 key 为 k 的节点是同一个对象
            ② 链表 head→tail 的顺序 = 最近使用 → 最久未使用
            ③ map.get(k).val = 最后一次 put(k, v) 的那个 v
            ④ map.size() == nq.size ≤ capacity
    */

    class Node
    {
        Node prev;
        Node next;
        int key;
        int val;

        Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
    }

    class NodeQueue{
        Node head = new Node(-1,0);
        Node tail = new Node(-2,0);

        int size = 0;
        NodeQueue()
        {
            head.next = tail;
            tail.prev = head;
        }

        private void insertHead(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;

            size++;
        }

        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            size--;
        }

        private Node removeTail() {
            if (size == 0) {
                return null;
            }

            Node node = tail.prev;
            removeNode(node);

            return node;
        }
    }

    HashMap<Integer,Node> map = new HashMap<>();
    NodeQueue nq;
    int cap;
    public LRUCache(int capacity) {
        
        //initial the NodeQueue;
        nq = new NodeQueue();
        cap = capacity;

    }
    
    // 两边都加
    private void addFresh(int key, int value) {
        Node node = new Node(key, value);
        nq.insertHead(node);
        map.put(key, node);
    }

    // 两边都删
    private void evictOldest() {
        Node node = nq.removeTail();
        if (node != null) map.remove(node.key);
    }

    // 只动顺序，不动键集
    private void touch(Node node) {
        nq.removeNode(node);
        nq.insertHead(node);
    }

    public int get(int key) {
        
        if(map.containsKey(key))
        {   
            Node node = map.get(key);
            touch(node);
            return node.val;
        }
        else
        {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {   
            Node node = map.get(key);
            node.val = value;
            touch(node);
        }
        else
        {
            if(nq.size >= cap)
            {
                evictOldest();
                Node newNode = new Node(key,value);
            }
            addFresh(key,value);
        }

    }
}
