package com.kodilla.battleship;

import java.util.ArrayList;
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

    public ArrayList<Board.Cell> createCellList(int x, int y){
        ArrayList<Board.Cell> cellList = new ArrayList<>();

        if(!playerBoard.getCell(x-1, y).wasShot && playerBoard.isValidPoint(x-1, y)){
            cellList.add(playerBoard.getCell(x - 1, y));
        }

        if(!playerBoard.getCell(x + 1, y).wasShot && playerBoard.isValidPoint(x+1, y)){
            cellList.add(playerBoard.getCell(x + 1, y));
        }

        if(!playerBoard.getCell(x, y - 1).wasShot && playerBoard.isValidPoint(x, y - 1)){
            cellList.add(playerBoard.getCell(x, y - 1));
        }

        if(!playerBoard.getCell(x, y + 1).wasShot && playerBoard.isValidPoint(x, y + 1)){
            cellList.add(playerBoard.getCell(x, y + 1));
        }

        return cellList;
    }

}
