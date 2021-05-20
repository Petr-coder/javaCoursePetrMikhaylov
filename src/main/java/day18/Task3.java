package day18;

public class Task3 {
    public static void main(String[] args) {

        Node root = new Node(20);

        addNode(14, root);
        addNode(16, root);
        addNode(11, root);
        addNode(5, root);
        addNode(8, root);
        addNode(15, root);
        addNode(18, root);
        addNode(23, root);
        addNode(22, root);
        addNode(27, root);
        addNode(24, root);
        addNode(150, root);

        dfs(root);
    }

    static void dfs(Node node) {

        if (node == null)
            return;

        dfs(node.getLeftOperand());
        System.out.print(node.getValue() + " ");
        dfs(node.getRightOperand());
    }

    static void addNode(int num, Node node) {
        if (node == null){
            throw new IllegalArgumentException("Корневой узел не должен быть равен null");
        }

        if (num < node.getValue()) {
            if (node.getLeftOperand() != null) {
                addNode(num, node.getLeftOperand());
            } else {
                node.setLeftOperand(new Node(num));
            }

        } else {
            if (node.getRightOperand() != null) {
                addNode(num, node.getRightOperand());
            } else {
                node.setRightOperand(new Node(num));
            }

        }
    }
}

