package Graph;

import java.util.*;

public class P841 {
    boolean[] visit;
    
    //邻接表的深度优先搜索
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visit = new boolean[rooms.size()];
        dfs(rooms, 0);
        for (int i = 0; i < visit.length; i++) {
            if (!visit[i])
                return false;
        }
        return true;
    }

    public void dfs(List<List<Integer>> rooms, int index) {
        visit[index] = true;
        ArrayList<Integer> tmp = new ArrayList<>(rooms.get(index));
        for (int i = 0; i < tmp.size(); i++) {
            if (!visit[tmp.get(i)])
                dfs(rooms,tmp.get(i));
        }
    }
}
