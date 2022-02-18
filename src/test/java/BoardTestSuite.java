import com.kodilla.battleship.Board;
import com.kodilla.battleship.EnemyMove;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.powermock.reflect.Whitebox;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class BoardTestSuite {

    @Mock
    private Board.Cell cellMock;

    @Test
    void isValidPointTest() throws Exception {
        //given
        Board board = new Board();
        double a = 2, b = 2;
        double c = 11, d = 3;
        double e = 12, f = 12;

        //when
        boolean trueResult = Whitebox.invokeMethod(board, "isValidPoint", a, b);
        boolean resultFalse = Whitebox.invokeMethod(board, "isValidPoint", c, d);
        boolean resultFalse2 = Whitebox.invokeMethod(board, "isValidPoint", e, f);

        //then
        assertTrue(trueResult);
        assertFalse(resultFalse);
        assertFalse(resultFalse2);
    }

    @Test
    void createCellListTest(){
        //given
        EnemyMove enemyMove = new EnemyMove();
        int a = 9, b = 0;
        int c = 0, d = 0;
        int e = 9, f = 9;
        int g = 0, h = 9;
        //when(cellMock.wasShot).thenReturn(false);

        //when
        List<Board.Cell> list1 = enemyMove.createCellList(a, b);
        list1.forEach(cell -> {
            System.out.println("----------LIST 1");
            int i = 1;
            System.out.println(i +". x: " + cell.x + " - y: " + cell.y);
            i++;
        });
        List<Board.Cell> list2 = enemyMove.createCellList(c, d);
        list2.forEach(cell -> {
            System.out.println("----------LIST 2");
            int i = 1;
            System.out.println(i +". x: " + cell.x + " - y: " + cell.y);
            i++;
        });
        List<Board.Cell> list3 = enemyMove.createCellList(e, f);
        list3.forEach(cell -> {
            System.out.println("----------LIST 3");
            int i = 1;
            System.out.println(i +". x: " + cell.x + " - y: " + cell.y);
            i++;
        });
        List<Board.Cell> list4 = enemyMove.createCellList(g, h);
        list4.forEach(cell -> {
            System.out.println("----------LIST 4");
            int i = 1;
            System.out.println(i +". x: " + cell.x + " - y: " + cell.y);
            i++;
        });

        //then
        assertEquals(2, list1.size());
        assertEquals(2, list2.size());
        assertEquals(2, list3.size());
        assertEquals(2, list4.size());
    }

}
