public class BinOperationTreeNode extends TopTreeNode {
    Token operator;
    TopTreeNode leftNode;
    TopTreeNode rightNode;

    public BinOperationTreeNode(Token operator, TopTreeNode leftNode, TopTreeNode rightNode) {
        super();
        this.operator = operator;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
}
