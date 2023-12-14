import com.bst.BST;
import com.exceptions.DepthException;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws DepthException {
        BST bst= new BST();
        ArrayList list= new ArrayList();
        BST subtree = bst.getSubTree(bst.search(0));
        System.out.println(bst.toList());
        System.out.println(subtree.toList());

    }
}
