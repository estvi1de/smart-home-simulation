package cz.cvut.k36.omo.hw.hw03;

public class PreOrderIterator implements CustomIterator {
    Node current = null;

    public PreOrderIterator(Node root) {
        preOrder(root);
    }

    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        current = root;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public int next() {
        int returned = current.contents;
        if (current.left != null) {
            current = current.left;
            return returned;
        }
        if (current.right != null) {
            current = current.right;
            return returned;
        }
        while (current.parent != null && (current.parent.right == null || current.parent.right == current)) {
            current = current.parent;
        }
        if (current.parent == null) {
            current = null;
        } else {
            current = current.parent.right;
        }
        return returned;
    }
}