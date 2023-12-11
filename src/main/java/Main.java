import com.bst.BST;
import com.exceptions.DepthException;

public class Main {
    public static void main(String[] args) {
        BST bst= new BST();
        try {
            bst.insert(23,true);
            bst.insert(33,true);
        } catch (DepthException e) {
            e.printStackTrace();
        }
        System.out.println(bst.toList());

    }
}
