public class UnarOperationTreeNode extends TopTreeNode {
    Token operator;
    TopTreeNode operandNode;

    public UnarOperationTreeNode(Token operator, TopTreeNode operandNode) {
        this.operator = operator;
        this.operandNode = operandNode;
    }
}
