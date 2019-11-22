package com.wpz.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wangpengzhe
 * @description 二叉搜索树
 * @date 2019/11/21 16:07
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class BTreeDemo {

    TreeNode root = null;

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 3, 7, 20, 16};
        BTreeDemo tree = new BTreeDemo();
        for (int i = 0; i < arr.length; i++) {
            tree.insert(arr[i]);
        }

        tree.midPrint(tree.root);
        System.out.println();
        tree.cnegcePrint(tree.root);
        System.out.println();

        System.out.println(tree.getHeightDiedai(tree.root));

        System.out.println(tree.getCountByLevel());
        System.out.println(tree.isBalanced(tree.root));
        System.out.println(tree.isSymmetry(tree.root));
        tree.show(tree.root);

        tree.mirrorTree(tree.root);
        tree.show(tree.root);
    }

    class TreeNode {

        int data;
        TreeNode leftNode;
        TreeNode rightNode;

        TreeNode(int data) {
            this.data = data;
        }
    }

    private void insert(int data) {
        if (root == null) {
            root = new TreeNode(data);
            return;
        }
        TreeNode tmp = root;
        while (tmp != null) {
            if (tmp.data < data) {
                if (tmp.rightNode == null) {
                    tmp.rightNode = new TreeNode(data);
                    return;
                }
                tmp = tmp.rightNode;
            } else {
                if (tmp.leftNode == null) {
                    tmp.leftNode = new TreeNode(data);
                    return;
                }
                tmp = tmp.leftNode;
            }
        }
    }

    private void prePrint(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + "->");
        prePrint(root.leftNode);
        prePrint(root.rightNode);
    }

    private void midPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        midPrint(root.leftNode);
        System.out.print(root.data + "->");
        midPrint(root.rightNode);
    }

    private void afterPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        afterPrint(root.leftNode);
        afterPrint(root.rightNode);
        System.out.print(root.data + "->");
    }

    /**
     * 层次遍历树
     *
     * @return void
     */
    private void cnegcePrint(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            System.out.print(poll.data + "->");
            if (poll.leftNode != null) {
                queue.offer(poll.leftNode);
            }
            if (poll.rightNode != null) {
                queue.offer(poll.rightNode);
            }
        }
    }

    /**
     * 查找某一节点
     *
     * @return com.wpz.algorithm.BTreeDemo.TreeNode
     */
    private TreeNode find(int data) {
        TreeNode tmp = root;
        while (tmp != null) {
            if (tmp.data < data) {
                tmp = tmp.rightNode;
            } else if (tmp.data > data) {
                tmp = tmp.leftNode;
            } else {
                return tmp;
            }
        }
        return null;
    }

    /**
     * 树高(递归)
     *
     * @return int
     */
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.leftNode) + 1;
        int rightHeight = getHeight(root.rightNode) + 1;

        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }

    /**
     * 树的高度 (迭代)
     *
     * @return int
     */
    private int getHeightDiedai(TreeNode root) {
        int height = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode tmp = root;
        queue.offer(tmp);
        while (!queue.isEmpty()) {
            int size = queue.size();
            height++;
            while (size-- > 0) {
                TreeNode poll = queue.poll();
                if (poll.leftNode != null) {
                    queue.offer(poll.leftNode);
                }
                if (poll.rightNode != null) {
                    queue.offer(poll.rightNode);
                }
            }

        }
        return height;
    }

    /**
     * 获取每一层节点数
     *
     * @return java.util.List<java.lang.Integer>
     */
    private List<Integer> getCountByLevel() {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode tmp = root;
        queue.offer(tmp);
        while (!queue.isEmpty()) {
            int size = queue.size();
            list.add(size);
            while (size-- > 0) {
                TreeNode poll = queue.poll();
                if (poll.leftNode != null) {
                    queue.offer(poll.leftNode);
                }
                if (poll.rightNode != null) {
                    queue.offer(poll.rightNode);
                }
            }
        }
        return list;
    }

    /**
     * 二叉树镜像
     *
     * @return void
     */
    private void mirrorTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root.leftNode;
        root.leftNode = root.rightNode;
        root.rightNode = tmp;
        mirrorTree(root.leftNode);
        mirrorTree(root.rightNode);
    }

    /**
     * 是否为平衡二叉树
     *
     * @return boolean
     */
    private boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = getHeight(root.leftNode);
        int rightHeight = getHeight(root.rightNode);
        if (Math.abs(leftHeight - rightHeight) <= 1) {
            return true;
        }
        return isBalanced(root.leftNode) && isBalanced(root.rightNode);
    }

    /**
     * 是否为对称的树
     *
     * @return boolean
     */
    private boolean isSymmetry(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.leftNode == null && root.rightNode == null) {
            return true;
        }
        if (root.leftNode == null || root.rightNode == null) {
            return false;
        }
        return root.leftNode.data == root.rightNode.data && isSymmetry(root.leftNode) && isSymmetry(root.rightNode);


    }

    /**
     * 树形打印二叉树
     *
     * @return void
     */
    private void show(TreeNode root) {
        if (root == null) {
            System.out.println("EMPTY!");
        }
        // 得到树的深度
        int treeDepth = getHeight(root);

        // 最后一行的宽度为2的（n - 1）次方乘3，再加1
        // 作为整个二维数组的宽度
        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
        // 用一个字符串数组来存储每个位置应显示的元素
        String[][] res = new String[arrayHeight][arrayWidth];
        // 对数组进行初始化，默认为一个空格
        for (int i = 0; i < arrayHeight; i++) {
            for (int j = 0; j < arrayWidth; j++) {
                res[i][j] = " ";
            }
        }

        // 从根节点开始，递归处理整个树
        // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
        writeArray(root, 0, arrayWidth / 2, res, treeDepth);

        // 此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即可
        for (String[] line : res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length; i++) {
                sb.append(line[i]);
                if (line[i].length() > 1 && i <= line.length - 1) {
                    i += line[i].length() > 4 ? 2 : line[i].length() - 1;
                }
            }
            System.out.println(sb.toString());
        }
    }

    private void writeArray(TreeNode currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
        // 保证输入的树不为空
        if (currNode == null) {
            return;
        }
        // 先将当前节点保存到二维数组中
        res[rowIndex][columnIndex] = String.valueOf(currNode.data);

        // 计算当前位于树的第几层
        int currLevel = ((rowIndex + 1) / 2);
        // 若到了最后一层，则返回
        if (currLevel == treeDepth) {
            return;
        }
        // 计算当前行到下一行，每个元素之间的间隔（下一行的列索引与当前元素的列索引之间的间隔）
        int gap = treeDepth - currLevel - 1;

        // 对左儿子进行判断，若有左儿子，则记录相应的"/"与左儿子的值
        if (currNode.leftNode != null) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(currNode.leftNode, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
        }

        // 对右儿子进行判断，若有右儿子，则记录相应的"\"与右儿子的值
        if (currNode.rightNode != null) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(currNode.rightNode, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
        }
    }

}
