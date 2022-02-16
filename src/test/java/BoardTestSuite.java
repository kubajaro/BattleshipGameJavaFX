import com.kodilla.battleship.Board;
import org.junit.jupiter.api.Test;
import org.powermock.reflect.Whitebox;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTestSuite {

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

}
