import com.bst.BST;
import com.bst.Node;
import com.exceptions.DepthException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Pruebas {

    BST tree;
    @BeforeEach
    void setup(){
        tree= new BST();
    }

    /*Probamos los valores de limite de la función insert*/
    @ParameterizedTest
    @ValueSource(ints = {-2500,-2499,344,2499,2500, -2501,2501})
    void insertLimitValuesRange(int value) throws DepthException {
        if(value>2500 || value<-2500){
            assertThrows(Exception.class,() ->{
                tree.insert(value,true);
            });
        }
        else{
            tree.insert(value,true);
            assertTrue(value >= -2500 && value <= 2500);
        }
    }
    @Test
    void insertLimitValuesDepth() throws DepthException {
        for (int i = 0; i < 50; i++) {
            tree.insert(i,true);
        }
        assertThrows(Exception.class,() ->{
           tree.insert(51,true);
        });
    }

    /*PRUEBAS VALOR LIMITE SEARCH()*/
    @Test
    void searchLimitValuesDepth() throws DepthException {
        /*BUSCAMOS QUE LA PROFUNDIDA NO SEA MENOR QUE 50*/
        assertThrows(Exception.class,() ->{
            for (int i = 0; i < 50; i++) {
                tree.insert(i,true);
            }
            tree.insert(51,true);

        });
        Node resul = tree.search(51);
        assertNull(resul);
    }
    @ParameterizedTest
    @ValueSource(ints = {-2500,-2499,344,2499,2500,-2501,2501})
    void searchLimitValuesRange(int value) throws DepthException {
        if(value>2500 || value<-2500){
            assertThrows(Exception.class,() ->{
                tree.insert(value,true);
            });
        }
        else{
            tree.insert(value,true);
            assertTrue(value >= -2500 && value <= 2500);
        }
        Node case1 = tree.search(2501);
        assertNull(case1);
        Node case2 = tree.search(-2501);
        assertNull(case2);
    }






}
