package ByteDance;

import java.util.*;

public class lowestCommonAncestor {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    ArrayList<TreeNode> list = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findList(root, p);
        int lengthP = list.size();
        findList(root, q);
        int k = 0;
        for (int i = 0; i < lengthP; i++) {
            //若p为最近公共节点时,不会进行到break,会一直循环完毕;
            //前面一个判断条件是为了避免q所在的二叉树路径较短，且q为最近公共节点时，比如[1,2] 2;1;
            if (i + lengthP >= list.size() || list.get(i) != list.get(i + lengthP)) break;
            k = i;//这里也可为k=i+lengthP;
        }
        return list.get(k);
    }

    //保存从根节点到目标节点的路径，包括目标节点，使用前序遍历
    public boolean findList(TreeNode root, TreeNode target) {
        if (root == null)
            return false;//这条路径无法找到target,显然null也不需要加入list中
        //这两句代码不可交换顺序，否则目标节点无法加入list
        list.add(root);
        if (root == target)
            return true;//找到了从根节点到target的路径
        //回溯过程
        //if(!(findlist(root.left,target)||findlist(root.right,target))){
        //下面这样的写法有一些剪枝的过程,更推荐
        //如果root.left和root.right都没有能找到target,则root也需要被删除
        if (!findList(root.left, target) && !findList(root.right, target)) {
            list.remove(list.size() - 1);//root为当前list的最后一个值,root.left和root.right在之前的迭代中已经进行删除了;
            return false;//显然此时没有找到到达target的路径，返回false;
        }
        return true;//找到路径后的回溯语句
    }
}
