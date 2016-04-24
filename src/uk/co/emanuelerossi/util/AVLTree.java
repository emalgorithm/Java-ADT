package uk.co.emanuelerossi.util;

/**
 * Created by ema on 22/04/16.
 */
public class AVLTree<K extends Comparable, V> implements Map<K, V> {
    Node<K, V> root;

    @Override
    public void add(K key, V value) {
        addHelper(root, null, key, value);
    }

    private Node<K, V> addHelper(Node<K, V> node, Node<K, V> parent, K key, V value) {
        if (node == null) {
            node = new Node<>(key, value);
            node.height = 1;
            node.parent = parent;

            if (this.root == null) {
                this.root = node;
            }
        } else {
            if (node.key == key){
                node.value = value;
            } else if (key.compareTo(node.key) < 0) {
                node.left = addHelper(node.left, node, key, value);
            } else {
                node.right = addHelper(node.right, node, key, value);
            }

            updateHeight(node);
        }

        return rebalance(node);
    }

    @Override
    public void delete(K key) {
        deleteHelper(root, key);
    }

    private Node<K, V> deleteHelper(Node<K, V> node, K key) {
        if (node == null) {
            return node;
        }

        if (key.compareTo(node.key) == 0) {
            Node<K, V> newNode = deleteNode(node);
            if (node == root) {
                root = newNode;
            }
            return newNode;
        } else if (key.compareTo(node.key) < 0) {
            node.left = deleteHelper(node.left, key);
        } else {
            node.right = deleteHelper(node.right, key);
        }

        updateHeight(node);

        return node;
    }

    private Node<K, V> deleteNode(Node<K, V> node) {
        //Case leaf
        if (isLeaf(node)) {
            if (node == root) {
                root = null;
            }

            return null;
        }

        //Case 1 child
        if (node.left != null && node.right == null) {
            node.left.parent = node.parent;
            return node.left;
        } else if (node.right != null && node.left == null) {
            node.right.parent = node.parent;
            return node.right;
        }

        //Case 2 children
        Node<K, V> replacementNode = findLeftMost(node);
        replacementNode.left = deleteHelper(node.left, replacementNode.key);
        replacementNode.right = node.right;
        replacementNode.parent = node.parent;

        return replacementNode;
    }

    //Pre: node != null and b's left subtree is not empty
    private Node<K,V> findLeftMost(Node<K, V> node) {
        if (node == null || node.left == null) {
            throw new RuntimeException();
        }

        Node<K, V> currentNode = node.left;

        while(currentNode.right != null) {
            currentNode = currentNode.right;
        }

        return currentNode;
    }

    private void updateHeight(Node<K, V> node) {
        int leftHeight = node.left == null ? 0 : node.left.height;
        int rightHeight = node.right == null ? 0 : node.right.height;
        node.height = Math.max(leftHeight, rightHeight) + 1;
    }

    private Node<K, V> rebalance(Node<K, V> root) {
        int balanceFactor = root.getBalanceFactor();
        Node<K, V> result = root;

        if (balanceFactor == 2) {

            if (root.left.getBalanceFactor() == -1) {
                //Left-Right Case
                leftRotate(root.left);
            }
            //Left-Left case
            result = root.left;
            rightRotate(root);
        } else if (balanceFactor == -2) {
            if (root.right.getBalanceFactor() == 1) {
                //Right-Left Case
                rightRotate(root.right);
            }
            //Right-Right case
            result = root.right;
            leftRotate(root);
        }

        return result;
    }

    private void leftRotate(Node<K, V> x) {
        Node<K, V> y = x.right;

        x.right = y.left;
        y.left = x;

        if (x.right != null) {
            x.right.parent = x;
        }

        y.parent = x.parent;
        x.parent = y;

        if (x == root) {
            root = y;
        } else if (y.parent.left == x) {
            y.parent.left = y;
        } else {
            y.parent.right = y;
        }

        x.height -= 2;
    }

    private void rightRotate(Node<K, V> x) {
        Node<K, V> y = x.left;

        x.left = y.right;
        y.right = x;

        if (x.left != null) {
            x.left.parent = x;
        }

        y.parent = x.parent;
        x.parent = y;

        if (x == root) {
            y = root;
        } else if (y.parent.left == x) {
            y.parent.left = y;
        } else {
            y.parent.right = y;
        }

        x.height -= 1;
        y.height += 1;

    }

    private boolean isLeaf(Node<K, V> node) {
        return node != null && node.left == null && node.right == null;
    }

    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    @Override
    public V get(K key) {
        return getHelper(root, key);
    }

    private V getHelper(Node<K, V> root, K key) {
        if (root == null) {
            return null;
        }

        if (key == root.key) {
            return root.value;
        } else if (key.compareTo(root.key) < 0) {
            return (V) getHelper(root.left, key);
        } else {
            return (V) getHelper(root.right, key);
        }
    }

    private static class Node<K, V> {
        K key;
        V value;
        Node left;
        Node right;
        Node parent;
        int height;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        private int getBalanceFactor() {
            int leftHeight = left == null ? 0 : left.height;
            int rightHeight = right == null ? 0 : right.height;

            return leftHeight - rightHeight;
        }
    }
}
