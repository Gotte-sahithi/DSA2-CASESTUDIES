class Node {
    int bookId, height;
    Node left, right;
    Node(int id) { bookId = id; height = 1; }
}
class AVLTree {
    int height(Node n) { return (n == null) ? 0 : n.height; }
    int getBalance(Node n) { return (n == null) ? 0 : height(n.left) - height(n.right); }
    Node rightRotate(Node y) {
        Node x = y.left; Node T2 = x.right;
        x.right = y; y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }
    Node leftRotate(Node x) {
        Node y = x.right; Node T2 = y.left;
        y.left = x; x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }
    Node insert(Node node, int id) {
        if (node == null) return new Node(id);
        if (id < node.bookId) node.left = insert(node.left, id);
        else if (id > node.bookId) node.right = insert(node.right, id);
        else return node;
        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);
        if (balance > 1 && id < node.left.bookId) return rightRotate(node);
        if (balance < -1 && id > node.right.bookId) return leftRotate(node);
        if (balance > 1 && id > node.left.bookId) { node.left = leftRotate(node.left); return rightRotate(node); }
        if (balance < -1 && id < node.right.bookId) { node.right = rightRotate(node.right); return leftRotate(node); }
        return node;
    }
    void inorder(Node root) {
        if (root != null) { inorder(root.left); System.out.print(root.bookId + " "); inorder(root.right); }
    }
    public static void main(String[] args) {
        AVLTree tree = new AVLTree(); Node root = null;
        int[] books = {30, 10, 20, 50, 40, 60};
        for (int id : books) root = tree.insert(root, id);
        System.out.print("Books in order: "); tree.inorder(root);
    }
}
//CO1 CODE
