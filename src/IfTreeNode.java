import java.util.LinkedList;

public class IfTreeNode extends TopTreeNode {
    Token operator;
    TopTreeNode leftNode;
    TopTreeNode rightNode;
    public LinkedList<TopTreeNode> operations = new LinkedList<>();

    public IfTreeNode(Token operator, TopTreeNode leftNode, TopTreeNode rightNode) {
        this.operator = operator;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
    public void addOperations(TopTreeNode op){
        operations.add(op);
    }
}
