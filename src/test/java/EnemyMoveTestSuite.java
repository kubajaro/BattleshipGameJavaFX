import com.kodilla.battleship.Board;
import com.kodilla.battleship.Cell;
import com.kodilla.battleship.EnemyMove;
import javafx.animation.FillTransition;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith({MockitoExtension.class})
public class EnemyMoveTestSuite {
    EnemyMove enemyMove = new EnemyMove();

    @Mock
    Cell cellMock;

    @Mock
    Board boardMock;

    @Mock
    private FillTransition transitionMock;

    @Test
    void enemyMoveTest(){
        //given
        Board board = new Board(true, event -> {});
        when(cellMock.shoot()).thenReturn(false);
        doNothing().when(transitionMock).play();

        //when
        enemyMove.enemyMove(board);

        //then
        verify(cellMock, times(1)).shoot();
    }

    @Test
    void createCellListTest(){
        //given
        int x = 2, y = 2;
        when(boardMock.getCell(x, y)).thenReturn(new Cell(x, y, boardMock));

        //when
        ArrayList<Cell> result = enemyMove.createCellList(x, y);

        //then
        assertEquals(2, result.size());
    }


}
