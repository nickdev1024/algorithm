package TopInterview;

class Q124BinaryTreeMaximumPathSum {
    /**
     * Definition for a binary tree node.
     */
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    private static class Info {
        int maxSum;
        int maxSumHead;

        public Info(int maxSum, int maxSumHead) {
            this.maxSum = maxSum;
            this.maxSumHead = maxSumHead;
        }
    }

    // 树形结构的动态规划，从父节点归纳出最后结果，树形路径中累计和最大的路劲，返回累加和，需要向左树和右树索要信息
    // 向子树索要信息：
    // 1. 左树的路径最大累加和，2种情况，不包含父节点的路径 和 包含父节点的路径
    // 2. 右树的路径最大累加和，2种情况，不包含父节点的路径 和 包含父节点的路径
    // 3. 拿到 左树信息 和 右树信息 后，计算 只包含 父节点和左树 的累计和，计算 只包含 父节点和右树 的累计和，最后 计算包含 父节点，左树 和 右树 的整体累加和
    // 4. 将 步骤3 的最后结果进行比较，取最大值 返回
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return process(root).maxSum;
    }

    private Info process(TreeNode node) {
        if (null == node) {
            return null;
        }
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);

        int p1 = Integer.MIN_VALUE;
        int p2 = Integer.MIN_VALUE;
        if (null != leftInfo) {
            p1 = leftInfo.maxSum;
            p2 = node.val + leftInfo.maxSumHead;
        }

        int p3 = Integer.MIN_VALUE;
        int p4 = Integer.MIN_VALUE;
        if (null != rightInfo) {
            p3 = rightInfo.maxSum;
            p4 = node.val + rightInfo.maxSumHead;
        }
        int p5 = node.val;
        int p6 = Integer.MIN_VALUE;
        if (null != leftInfo && null != rightInfo) {
            p6 = node.val + leftInfo.maxSumHead + rightInfo.maxSumHead;
        }
        int maxSum = Math.max(Math.max(Math.max(p1, p2), Math.max(p5, p6)), Math.max(p3, p4));
        int maxSumHead = Math.max(p5, Math.max(p2, p4));
        return new Info(maxSum, maxSumHead);
    }

    static public void main(String... args) {

    }
}