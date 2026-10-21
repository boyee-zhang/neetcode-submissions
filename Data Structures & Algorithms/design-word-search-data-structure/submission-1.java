class WordDictionary {

    class TrieNode {
        TrieNode [] children = new TrieNode[26];
        boolean isEnd;
    }

    class Trie{
        public TrieNode root;

        public Trie()
        {
            root = new TrieNode();
        }

        public void add (String s)
        {
            TrieNode cur = root;

            for(char c : s.toCharArray())
            {
                int index = c - 'a';

                if(cur.children[index] == null)
                {
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
            }
            
            cur.isEnd = true;
        }

        public boolean search(String s, TrieNode cur, int start)
        {   
            if(cur == null)
            {
                return false;
            }
            
            if(start >= s.length())
            {
                return cur.isEnd;
            }

            int index = s.charAt(start) - 'a';

            if(cur == null)
            {
                return false;
            }

            if(s.charAt(start) == '.')
            {    
                for(int i = 0; i < 26; i ++)
                {
                    if(search(s,cur.children[i],start + 1))
                    {
                        return true;
                    }
                }
            }
            else
            {
                if(cur.children[index] == null)
                {
                    return false;
                }
                else
                {
                    return search(s,cur.children[index],start + 1);
                }
            }

            return false;
        }
    }

    public Trie t;
    public WordDictionary() {
        t = new Trie();
    }

    public void addWord(String word) {
        t.add(word);
    }

    public boolean search(String word) {
        return t.search(word,t.root,0);
    }
}
