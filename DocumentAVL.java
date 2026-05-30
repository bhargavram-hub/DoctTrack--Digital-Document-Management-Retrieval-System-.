class AVLNode {
    int key, height;
    AVLNode left, right;

    AVLNode(int key) {
        this.key = key;
        height = 1;
    }
}

public class DocumentAVL {

    AVLNode root;

    int height(AVLNode n) {
        return n == null ? 0 : n.height;
    }

    int getBalance(AVLNode n) {
        return n == null ? 0 : height(n.left) - height(n.right);
    }

    AVLNode rightRotate(AVLNode y) {

        System.out.println("Right Rotation at Node " + y.key);

        AVLNode x = y.left;
        AVLNode t2 = x.right;

        x.right = y;
        y.left = t2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    AVLNode leftRotate(AVLNode x) {

        System.out.println("Left Rotation at Node " + x.key);

        AVLNode y = x.right;
        AVLNode t2 = y.left;

        y.left = x;
        x.right = t2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    AVLNode insert(AVLNode node, int key) {

        if (node == null) {
            System.out.println("Insert " + key + " -> No Rotation");
            return new AVLNode(key);
        }

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    void inorder(AVLNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    boolean search(AVLNode node, int key) {

        if (node == null)
            return false;

        if (node.key == key)
            return true;

        if (key < node.key)
            return search(node.left, key);

        return search(node.right, key);
    }

    void printTree(AVLNode root, int space) {

        if (root == null)
            return;

        space += 8;

        printTree(root.right, space);

        System.out.println();

        for (int i = 8; i < space; i++)
            System.out.print(" ");

        System.out.println(root.key);

        printTree(root.left, space);
    }

    public static void main(String[] args) {

        DocumentAVL tree = new DocumentAVL();

        int docs[] = {101,102,103,104,105,106,107,108};

        System.out.println("===== DocuTrack AVL Indexing =====\n");

        for(int doc : docs)
            tree.root = tree.insert(tree.root, doc);

        System.out.println("\n===== FINAL AVL TREE =====");

        tree.printTree(tree.root,0);

        System.out.println("\nInorder Traversal:");
        tree.inorder(tree.root);

        System.out.println("\n\nSearch 105 : "
                + (tree.search(tree.root,105) ?
                "Document Found" :
                "Document Not Found"));

        System.out.println("Search 120 : "
                + (tree.search(tree.root,120) ?
                "Document Found" :
                "Document Not Found"));
    }
}