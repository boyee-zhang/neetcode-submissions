class FileSystem {
    
    class Node{
        String str;
        HashMap<String,Node> children;
        String content;
        boolean isFile;
        public Node(String s)
        {   
            children = new HashMap<>();
            str = s;
            content = "";
        }
    }
    
    Node root;
    public FileSystem() {
        root = new Node("/");
        root.children = new HashMap<>();
    }
    
    public List<String> ls(String path) {
        List<String> res = new LinkedList<>();

        String[] strs = path.split("/");

        Node node = root;
        String fileName = "";
        for(String str : strs)
        {
            if(str.equals(""))
            {
                continue;
            }

            if(!node.children.containsKey(str))
            {
                return res;
            }

            node = node.children.get(str);
            fileName = str;
        }

        if(node.isFile)
        {
            res.add(fileName);
        }
        else
        {
            for(String file : node.children.keySet())
            {
                res.add(file);
            }
            Collections.sort(res);
        }

        return res;
    }
    
    public void mkdir(String path) {
        String[] strs = path.split("/");

        Node node = root;

        for(String s : strs)
        {   
            if(s.equals(""))
            {
                continue;
            }

            if(node.children.containsKey(s))
            {
                node = node.children.get(s);
            }
            else
            {
                node.children.put(s,new Node(s));
                node = node.children.get(s);
            }
        }

        node.isFile = false;
    }
    
    public void addContentToFile(String filePath, String content) {
        String[] strs = filePath.split("/");

        Node node = root;
        for(String s : strs)
        {
            if(s.equals(""))
            {
                continue;
            }

            if(node.children.containsKey(s))
            {
                node = node.children.get(s);
            }
            else
            {
                node.children.put(s,new Node(s));
                node = node.children.get(s);
            }
        }

        node.content += content;
        node.isFile = true;
    }
    
    public String readContentFromFile(String filePath) {
        String[] strs = filePath.split("/");

        Node node = root;

        for(String s : strs)
        {
            if(s.equals(""))
            {
                continue;
            }

            if(node.children.containsKey(s))
            {
                node = node.children.get(s);
            }
            else
            {
                return "";
            }
        }

        if(!node.isFile)
        {
            return "";
        }
        else
        {
            return node.content;
        }
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
