package cz.cvut.k36.omo.hw.hw03;

public class InOrderIterator implements CustomIterator {
    Node current = null;

    public InOrderIterator(Node root) {
        inOrder(root);
    }

    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        current = nextNode(root);
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public int next() {
        int returned = current.contents;

        if (current.right != null) {
            current = nextNode(current.right);
        } else if (current.parent != null && current == current.parent.left) {
            current = current.parent;
        } else {
            while (current.parent != null && current.parent.right == current) {
                current = current.parent;
            }
            if (current.parent == null) {
                current = null;
            } else {
                current = current.parent;
            }
        }
        return returned;
    }

    public Node nextNode(Node node) {
        if (node.left != null) {
            return nextNode(node.left);
        }
        if (node.right != null) {
            return node;
        }
        return node;
    }
}