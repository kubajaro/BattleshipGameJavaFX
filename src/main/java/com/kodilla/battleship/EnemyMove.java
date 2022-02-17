package com.kodilla.battleship;

import java.util.Random;

public class EnemyMove {
    public Board playerBoard;
    Random random = new Random();

    public Board.Cell getCellFromPlayerBoard(){
        Board.Cell cell;

        int x = random.nextInt(10);
        int y = random.nextInt(10);

        cell = playerBoard.getCell(x, y);

        if(!cell.wasShot)
            getCellFromPlayerBoard();

        return cell;
    }


}
