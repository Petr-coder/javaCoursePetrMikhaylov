package day18;

public class Node {
    private int value;
    private Node leftOperand;
    private Node rightOperand;


    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getLeftOperand() {
        return leftOperand;
    }

    public Node getRightOperand() {
        return rightOperand;
    }


    public void setLeftOperand(Node leftOperand) {
        this.leftOperand = leftOperand;
    }

    public void setRightOperand(Node rightOperand) {
        this.rightOperand = rightOperand;
    }
}
