package Tree;

class Trie {
    //定一个节点初始化及类型
    class TrieNode {
        public int path;
        public int end;
        public TrieNode[] map;

        public TrieNode() {
            path = 0;
            end = 0;
            map = new TrieNode[26];
        }
    }

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        //初始化根节点
        root = new TrieNode();
    }
    //添加word可以重复添加

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null) {
            return;
        }
        //让node指向根节点并加1
        char[] chs = word.toCharArray();
        TrieNode node = root;
        node.path++;
        int index;
        //下面for循环式判断这个元素为空就创建个节点，并让指针指向这个节点，并path加1，否则不创建节点只统计
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.map[index] == null) {
                node.map[index] = new TrieNode();
            }
            //指向下个节点
            node = node.map[index];
            //对应节点加1，这个使用的链表每个节点对应自己的path
            node.path++;
        }
        //最后以这个节点结束加1
        node.end++;
    }
    //查找单词word是否存在字典树里

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        char[] chs = word.toCharArray();
        TrieNode node = root;
        int index;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.map[index] == null) {
                return false;
            }
            node = node.map[index];
        }
        //找到尾结点了且这个end不为0证明以前有以这个几点结束的节点
        return node.end != 0;
    }
    //返回是否存在有以prefix为前缀的单词

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return false;
        }
        char[] chs = prefix.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.map[index] == null) {
                return false;
            }
            node = node.map[index];
        }
        //如果在上述查找在都没有返回false证明有以这为前缀的返回true
        return true;
    }
}