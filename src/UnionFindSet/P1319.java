package UnionFindSet;

import java.util.*;

public class P1319 {
    /**
     * 1、假设connections数为n，机器个数为k。 则n >= k-1时，该网络一定可以联通；反之则一定不能。
     * 2、其次，如果connections将这k个机器分为了m组，则只需要移动m - 1个connection就可以使整个网络联通。
     */
    List<Integer> bc = new ArrayList<>();

    public int makeConnected(int n, int[][] connections) {
        if (n == 0 || n == 1) return 0;
        for (int i = 0; i < n; i++) {
            bc.add(i);
        }
        int count = connections.length;
        if (count < n - 1)//连接数 小于 顶点个数-1，则一定不连通
            return -1;
        for (int i = 0; i < count; i++) {
            int a = find(connections[i][0]);
            int b = find(connections[i][1]);
            if (a != b) {
                bc.set(a, b);
            }
        }
        return count() - 1;
    }

    // 获取并查集个数
    public int count() {
        int count = 0;
        for (int i = 0; i < bc.size(); i++) {
            if (find(i) == i)
                count++;
        }
        return count;
    }

    //寻根节点
    public int find(int n) {
        int key = bc.get(n);
        while (key != bc.get(key))
            key = bc.get(key);
        return key;
    }
}
