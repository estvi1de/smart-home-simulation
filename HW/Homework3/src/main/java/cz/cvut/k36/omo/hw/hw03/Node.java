package cz.cvut.k36.omo.hw.hw03;

public class Node {
    public final int contents;
    public final Node left, right;
    public Node parent;

    public Node(int contents, Node left, Node right) {
        this.contents = contents;
        this.left = left;
        if (left != null) left.parent = this;
        this.right = right;
        if (right != null) right.parent = this;
    }

    public CustomIterator preorderIterator() {
        return new PreOrderIterator(this);
    }

    public CustomIterator inorderIterator() {
        return new InOrderIterator(this);
    }

    public CustomIterator postorderIterator() {
        return new PostOrderIterator(this);
    }
}
