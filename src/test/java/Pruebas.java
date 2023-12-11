import com.bst.BST;
import com.exceptions.DepthException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Pruebas {
    BST tree= new BST<>();

    @Test
    void insert(){
        ArrayList resul = new ArrayList<>();


        try {
            tree.insert(0,true);
            tree.insert(-2,true);
            tree.insert(3,true);
            ArrayList arr = tree.toList();

        } catch (DepthException e) {
            e.printStackTrace();
        }



    }

}
