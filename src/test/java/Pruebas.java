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
        if(value>=2500 || value<-2500){
            assertThrows(Exception.class,() ->{
                tree.insert(value,true);
            });
        }
        else{
            tree.insert(value,true);
            assertTrue(value >= -2500 && value < 2500);
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
        assertThrows(Exception.class,()->{
            for(int i=0;i<51;i++){
                tree.insert(i,false);
            }
            tree.insert(51,false);
        } );
        Node resul = tree.search(50);
        assertNull(resul);
    }
    @ParameterizedTest
    @ValueSource(ints = {-2500,-2499,344,2499,2500,-2501,2501})
    void searchLimitValuesRange(int value) throws DepthException {
        if(value>=2500 || value<-2500){
            assertThrows(Exception.class,() ->{
                tree.insert(value,true);
            });
        }
        else{
            tree.insert(value,true);
            assertTrue(value >= -2500 && value < 2500);
        }
        Node case1 = tree.search(2501);
        assertNull(case1);
        Node case2 = tree.search(-2501);
        assertNull(case2);
    }

    /*-------------------CLASES DE EQUIVALENCIA--------------------------*/

    /*COMPROBAR QUE EL NODO ESTÁ EN EL ARBOL*/
    @Test
    void searchEqClass() throws DepthException {
        tree.insert(34,true);
        Node notexist= tree.search(45);
        Node exist= tree.search(34);
        assertNull(notexist);
        assertNotNull(exist);
    }

    /*Comprobamos que */
    @Test
    void depthEqClass() throws DepthException {
        assertTrue( tree.depth()==0);

        tree.insert(0,true);
        assertTrue( tree.depth()==1);

        /*Comprobamos que como maximo depth devuelve 50*/
        assertThrows(Exception.class, () ->{
            for (int i = 1; i <50 ; i++) {
                tree.insert(i,true);
            }
            tree.insert(50,true);
            tree.insert(51,true);
            tree.insert(52,true);
        });
        assertTrue(tree.depth()<=50);
    }

    @Test
    void toListEqClass() throws DepthException {
        ArrayList list= new ArrayList();
        assertTrue(tree.toList().equals(list));

        for (int i = 0; i < 12 ; i++) {
            tree.insert(i,true);
            list.add(i);
        }
        assertTrue(tree.toList().equals(list));

        list.add(77);
        assertFalse(tree.toList().equals(list));
    }

    @Test
    void getSubtreeEqClass() throws DepthException {
        BST testTree = new BST<>();
        for (int i = 0; i < 40; i++) {
            tree.insert(i,true);
        }
        BST subTree =tree.getSubTree(tree.search(20));
        for (int i = 20; i <40 ; i++) {
            testTree.insert(i,true);
        }
        assertTrue(testTree.toList().equals(subTree.toList()));
        /*Comprobamos que lanza una excepcion si en nodo no existe*/
        assertThrows(Exception.class, ()->{
            BST subTree2 = tree.getSubTree(tree.search(42));

        });

    }










}
