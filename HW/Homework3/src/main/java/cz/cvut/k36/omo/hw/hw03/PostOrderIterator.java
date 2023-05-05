package cz.cvut.k36.omo.hw.hw03;

public class PostOrderIterator implements CustomIterator {
    Node current = null;

    public PostOrderIterator(Node root) {
        postOrder(root);
    }

    public void postOrder(Node root) {
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
        if (current.parent == null) {
            current = null;
        } else {
            if (current == current.parent.left) {
                if (current.parent.right == null) {
                    current = current.parent;
                } else {
                    current = nextNode(current.parent.right);
                }
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
            return nextNode(node.right);
        }
        return node;
    }
}