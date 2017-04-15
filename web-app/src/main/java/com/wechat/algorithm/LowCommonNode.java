package com.wechat.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by chengen.gu on 2017/4/3.
 */
public class LowCommonNode {

    private class BinaryNode{
        BinaryNode left;
        BinaryNode right;
        int ele;

        public BinaryNode(int ele) {
            this.ele = ele;
            left = right = null;
        }
    }

    private BinaryNode root;

    private void buildTree(Integer[] arr){
        for (int i : arr) {
            insert(i);
        }
    }
    private void insert(int ele){
        root = insert(root, ele);
    }
    private BinaryNode insert(BinaryNode root, int ele){
        if(root == null)
            return new BinaryNode(ele);

        if(root.ele > ele)//insert left
            root.left = insert(root.left, ele);
        else if(root.ele < ele)
            root.right = insert(root.right, ele);
        else
            root.left = insert(root.left, ele);//相等时,放在左边
        return root;
    }

    /**
     * 求解二叉查找树中  node1 和 node2 代表的节点的 最低公共祖先结点
     * 首先让node1总是代表权值较小的那个结点.
     * 对于二叉查找树而言:
     * 如果根的权值处于 node1 和 node2 之间,则根就是它们的最低公共祖先结点
     * 如果根的权值比 node1 和 node2 都大,则它们的最低公共祖先结点在根的左子树中
     * 如果根的权值比 node1 和 node2 都小,则它们的最低公共祖先结点在根的右子树中
     */
    public int lowestCommonParentNode(BinaryNode root, int node1, int node2)
    {
        if(node1 > node2)
        {
            int tmp = node1;
            node1 = node2;
            node2 = tmp;
        }
        assert node1 < node2;

        if(root == null)
            throw new IllegalArgumentException(" neither node1 nor node2 contains in binary search tree ");

        if(root.ele > node1 && root.ele < node2)
            return root.ele;

        if(root.ele > node1 && root.ele > node2)//if(root.ele > node2)
            //在左子树中查找最低公共祖先结点
            return lowestCommonParentNode(root.left, node1, node2);
        else//root.ele < node1
            //在右子树中查找最低公共祖先结点
            return lowestCommonParentNode(root.right, node1, node2);
    }

    //hapjin test
    public static void main(String[] args) {
        LowCommonNode lcn = new LowCommonNode();
        Scanner scanner = new Scanner(System.in);
        String k = scanner.next();
        int index = Integer.valueOf(k);
//        int[] arr = new int[]
//        int[] arr = {20,10,30,5,15,25,40,12,18};
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < Math.pow(2,index ) -1 ; i++){
            list.add(i);
        }
        Integer[] arr =  new Integer[list.size()];
        list.toArray(arr);
        lcn.buildTree(arr);//build a binary search tree

        // node1 and node2 should exist in arr,or will throw IllegalArgumentException
        int node1 = 13;
        int node2 = 15;

        //should build Tree before invoke lowestCommonParentNode
        System.out.println(lcn.lowestCommonParentNode(lcn.root, node1, node2));
    }
}

