import java.util.LinkedList;

public class ForTreeNode extends TopTreeNode {
    Token operator;
    TopTreeNode leftNode;
    TopTreeNode rightNode;
    TopTreeNode action;
    public LinkedList<TopTreeNode> operations = new LinkedList<>();

    public ForTreeNode(Token operator, TopTreeNode leftNode, TopTreeNode rightNode, TopTreeNode action) {
        this.operator = operator;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.action = action;
    }
    public void addOperations(TopTreeNode op){
        operations.add(op);
    }
}
