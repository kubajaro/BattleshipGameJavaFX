package com.kodilla.battleship;

import java.util.ArrayList;
import java.util.Random;

public class EnemyMove {
    public Board playerBoard = new Board();
    Random random = new Random();
    Board.Cell cell;
    boolean enemyTurn;

    private Board.Cell getCellFromPlayerBoard(){
        Board.Cell cell;

        int x = random.nextInt(10);
        int y = random.nextInt(10);

        cell = playerBoard.getCell(x, y);

        if(cell.wasShot)
            getCellFromPlayerBoard();

        return cell;
    }

    public ArrayList<Board.Cell> createCellList(int x, int y){
        ArrayList<Board.Cell> cellList = new ArrayList<>();

        if(!playerBoard.getCell(x - 1, y).wasShot && playerBoard.isValidPoint(x-1, y)){
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

    public void enemyMove(Board playerBoard){
        this.playerBoard = playerBoard;
        cell = getCellFromPlayerBoard();

        enemyTurn = cell.shoot();
        System.out.println("First shot: " + cell.x + " " + cell.y);

        while(enemyTurn){
            ArrayList<Board.Cell> possibleNextMoves = createCellList(cell.x, cell.y);
            if(!possibleNextMoves.isEmpty()) {
                cell = possibleNextMoves.get(random.nextInt(possibleNextMoves.size()));
            }else{
                cell = getCellFromPlayerBoard();
            }
            enemyTurn = cell.shoot();
            System.out.println("Second shot: " + cell.x + " " + cell.y);
        }
    }

}
