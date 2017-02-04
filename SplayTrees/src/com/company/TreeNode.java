package com.company;

public class TreeNode implements Comparable<TreeNode> {
    private TreeNode parent;
    private TreeNode leftChild;
    private TreeNode rightChild;
    private Entry entry;

    public TreeNode(Entry entry) {
        this.entry = entry;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    @Override
    public int compareTo(TreeNode that) {
        return this.entry.compareTo(that.entry);

    }

    public void inOrder() {
        if (this.getLeftChild() != null) {
            this.getLeftChild().inOrder();
        }
        this.visit();
        if (this.getRightChild() != null) {
            this.getRightChild().inOrder();
        }
    }


    private void visit() {
        System.out.println(this.entry);
    }

    public WhichChild findWhichChild() {
        TreeNode parent = this.getParent();
        if (parent == null) {
            return WhichChild.NOT_A_CHILD;
        }

        if (parent.getLeftChild()!=null &&  parent.getLeftChild().equals(this)) {
            return WhichChild.LEFTCHILD;
        } else {
            return WhichChild.RIGHTCHILD;
        }

    }

    public boolean hasGrandParent() {
        boolean hasGrandParent = false;
        TreeNode parent = this.getParent();
        if (parent != null) {
            hasGrandParent = parent.getParent() != null ? true : false;
        }
        return hasGrandParent;
    }

    @Override
    public String toString() {
        return this.entry.toString();
    }


}
