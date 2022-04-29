import java.util.LinkedList;

public class WhileTreeNode extends TopTreeNode {
    Token operator;
    TopTreeNode leftNode;
    TopTreeNode rightNode;
    public LinkedList<TopTreeNode> operations = new LinkedList<>();

    public WhileTreeNode(Token operator, TopTreeNode leftNode, TopTreeNode rightNode) {
        this.operator = operator;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
    public void addOperations(TopTreeNode op){
        operations.add(op);
    }
}
