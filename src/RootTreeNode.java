import java.util.LinkedList;

public class RootTreeNode extends TopTreeNode {
    LinkedList<TopTreeNode> codeStrings = new LinkedList<>();
    public void addNode(TopTreeNode node){
        codeStrings.add(node);
    }
}
