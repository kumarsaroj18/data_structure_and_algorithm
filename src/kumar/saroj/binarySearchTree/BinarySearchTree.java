package kumar.saroj.binarySearchTree;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {
    private Node<T> root;

    @Override
    public void insert(T data) {
        if (root == null) {
            this.root = new Node<>(data);
        } else {
            insertNode(data, root);
        }
    }

    @Override
    public T getMinValue() {
        if (root == null) {
            return null;
        }else {
            return getMin(root);
        }
    }

    @Override
    public T getMaxValue() {
        if (root == null) {
            return null;
        }

        return getMax(root);
    }

    @Override
    public void traverse() {
        if (root != null) {
            inOrderTraversal(root);
        }
    }

    private void inOrderTraversal(Node<T> node) {

        if (node != null) {
            inOrderTraversal(node.getLeftChild());
            System.out.print(node.getData() + " ------> ");
            inOrderTraversal(node.getRightChild());
        }
    }

    private void insertNode(T newData, Node<T> node) {
        if (newData.compareTo(node.getData()) < 0) {
            if (node.getLeftChild() != null) {
                insertNode(newData, node.getLeftChild());
            } else {
                node.setLeftChild(new Node<>(newData));
            }
        } else {
            if (node.getRightChild() != null) {
                insertNode(newData, node.getRightChild());
            } else {
                node.setRightChild(new Node<>(newData));
            }
        }
    }

    @Override
    public void delete(T data) {

    }

    private T getMax(Node<T> node) {
        if (node.getRightChild() != null) {
            return getMax(node.getRightChild());
        }else {
            return node.getData();
        }
    }

    private T getMin(Node<T> node) {
        if (node.getLeftChild() != null) {
            return getMin(node.getLeftChild());
        }else {
            return node.getData();
        }
    }
}
