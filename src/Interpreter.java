import java.math.BigInteger;
import java.util.HashMap;

public class Interpreter {
    HashMap<String,String> storage = new HashMap<>();

    public String run(TopTreeNode node) {
        if (node.getClass() == UnarOperationTreeNode.class) {
            if (((UnarOperationTreeNode) node).operator.type.name.equals("PRINT")) {
                System.out.println(this.run(((UnarOperationTreeNode) node).operandNode));
            }
        }
        if (node.getClass() == BinOperationTreeNode.class) {
            if (((BinOperationTreeNode) node).operator.type.name.equals("ASSIGN")) {
                String res = this.run(((BinOperationTreeNode) node).rightNode); // формула, которая присваивается переменной
                VarTreeNode varNode = (VarTreeNode) (((BinOperationTreeNode) node).leftNode);
                this.storage.put(varNode.var.text, res);
                return res;
            }
            else {
                int left = Integer.parseInt(this.run(((BinOperationTreeNode) node).leftNode));
                int right = Integer.parseInt(this.run(((BinOperationTreeNode) node).rightNode));
                switch (((BinOperationTreeNode) node).operator.type.name){
                    case "PLUS":
                        return String.valueOf(left+right);
                    case "MINUS":
                        return String.valueOf(left-right);
                    case "MULTIPLY":
                        return String.valueOf(left*right);
                    case "DIVIDE":
                        return String.valueOf(left/right);
                    case "POW":
                        return String.valueOf(pow(left,right));
                    case "ASSIGN":
                }
            }
        }
        if (node.getClass() == VarTreeNode.class) {
            return storage.get(((VarTreeNode) node).var.text);
        }
        if (node.getClass() == NumberTreeNode.class) {
            return ((NumberTreeNode) node).number.text;
        }
        if (node.getClass() == WhileTreeNode.class) {
            int left = Integer.parseInt(this.run(((WhileTreeNode) node).leftNode));
            int right = Integer.parseInt(this.run(((WhileTreeNode) node).rightNode));
            switch (((WhileTreeNode) node).operator.type.name) {
                case "LESS":
                    while (left < right) {
                        for (int i = 0; i < ((WhileTreeNode) node).operations.size(); i++)
                            this.run(((WhileTreeNode) node).operations.get(i));
                        left = Integer.parseInt(this.run(((WhileTreeNode) node).leftNode));
                        right = Integer.parseInt(this.run(((WhileTreeNode) node).rightNode));
                    }
                    break;
                case "MORE":
                    while (left > right) {
                        for (int i = 0; i < ((WhileTreeNode) node).operations.size(); i++)
                            this.run(((WhileTreeNode) node).operations.get(i));
                        left = Integer.parseInt(this.run(((WhileTreeNode) node).leftNode));
                        right = Integer.parseInt(this.run(((WhileTreeNode) node).rightNode));
                    }
                    break;
                case "EQUALS":
                    while (left == right) {
                        for (int i = 0; i < ((WhileTreeNode) node).operations.size(); i++)
                            this.run(((WhileTreeNode) node).operations.get(i));
                        left = Integer.parseInt(this.run(((WhileTreeNode) node).leftNode));
                        right = Integer.parseInt(this.run(((WhileTreeNode) node).rightNode));
                    }
                    break;
            }
        }
        if (node.getClass() == IfTreeNode.class) {
            int left = Integer.parseInt(this.run(((IfTreeNode) node).leftNode));
            int right = Integer.parseInt(this.run(((IfTreeNode) node).rightNode));
            switch (((IfTreeNode) node).operator.type.name) {
                case "LESS":
                    if (left < right) {
                        for (int i = 0; i < ((IfTreeNode) node).operations.size(); i++)
                            this.run(((IfTreeNode) node).operations.get(i));
                    }
                    break;
                case "MORE":
                    if (left > right) {
                        for (int i = 0; i < ((IfTreeNode) node).operations.size(); i++)
                            this.run(((IfTreeNode) node).operations.get(i));
                    }
                    break;
                case "EQUALS":
                    if (left == right) {
                        for (int i = 0; i < ((IfTreeNode) node).operations.size(); i++)
                            this.run(((IfTreeNode) node).operations.get(i));
                    }
                    break;
            }
        }
        if (node.getClass()== ForTreeNode.class){
            int left = Integer.parseInt(this.run(((ForTreeNode) node).leftNode));
            int right = Integer.parseInt(this.run(((ForTreeNode) node).rightNode));
            switch (((ForTreeNode) node).operator.type.name) {
                case "LESS":
                    while (left < right) {
                        for (int i = 0; i < ((ForTreeNode) node).operations.size(); i++)
                            this.run(((ForTreeNode) node).operations.get(i));
                        this.run(((ForTreeNode) node).action);
                        left = Integer.parseInt(this.run(((ForTreeNode) node).leftNode));
                        right = Integer.parseInt(this.run(((ForTreeNode) node).rightNode));
                    }
                    break;
                case "MORE":
                    while (left > right) {
                        for (int i = 0; i < ((ForTreeNode) node).operations.size(); i++)
                            this.run(((ForTreeNode) node).operations.get(i));
                        this.run(((ForTreeNode) node).action);
                        left = Integer.parseInt(this.run(((ForTreeNode) node).leftNode));
                        right = Integer.parseInt(this.run(((ForTreeNode) node).rightNode));
                    }
                    break;
                case "EQUALS":
                    while (left == right) {
                        for (int i = 0; i < ((ForTreeNode) node).operations.size(); i++)
                            this.run(((ForTreeNode) node).operations.get(i));
                        this.run(((ForTreeNode) node).action);
                        left = Integer.parseInt(this.run(((ForTreeNode) node).leftNode));
                        right = Integer.parseInt(this.run(((ForTreeNode) node).rightNode));
                    }
                    break;
            }
        }
        return "";
    }

    public static int pow(int value, int powValue) {
        BigInteger a = new BigInteger(String.valueOf(value));
        return a.pow(powValue).intValue();
    }
}
