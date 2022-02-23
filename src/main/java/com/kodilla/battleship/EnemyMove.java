package com.kodilla.battleship;

import java.util.ArrayList;
import java.util.Random;

public class EnemyMove {
    public Board playerBoard = new Board();
    Random random = new Random();
    Board.Cell cell;
    boolean enemyTurn;

    private Board.Cell getCellFromPlayerBoard(){
        int x = random.nextInt(10);
        int y = random.nextInt(10);

        cell = playerBoard.getCell(x, y);

        if(cell.wasShot)
            getCellFromPlayerBoard();

        return cell;
    }

    public ArrayList<Board.Cell> createCellList(int x, int y){
        ArrayList<Board.Cell> cellList = new ArrayList<>();

        if(playerBoard.isValidPoint(x - 1, y) && !playerBoard.getCell(x - 1, y).wasShot){
            cellList.add(playerBoard.getCell(x - 1, y));
            System.out.println("First check");
        }

        if(playerBoard.isValidPoint(x+1, y) && !playerBoard.getCell(x + 1, y).wasShot){
            cellList.add(playerBoard.getCell(x + 1, y));
            System.out.println("Second check");
        }

        if(playerBoard.isValidPoint(x, y - 1) && !playerBoard.getCell(x, y - 1).wasShot){
            cellList.add(playerBoard.getCell(x, y - 1));
            System.out.println("Third check");
        }

        if(playerBoard.isValidPoint(x, y + 1) && !playerBoard.getCell(x, y + 1).wasShot){
            cellList.add(playerBoard.getCell(x, y + 1));
            System.out.println("Fourth check");
        }

        return cellList;
    }

    public void followUpShot(boolean wasShipDown, Board.Cell shotCell){

        boolean enemyTurn = wasShipDown;
        if(enemyTurn){
            ArrayList<Board.Cell> possibleNextMoves = createCellList(shotCell.x, shotCell.y);
            if(!possibleNextMoves.isEmpty()) {
                cell = possibleNextMoves.get(random.nextInt(possibleNextMoves.size()));
            }else{
                cell = getCellFromPlayerBoard();
            }
            enemyTurn = cell.enemyShot();
            System.out.println("Second shot x: " + cell.x + " y: " + cell.y);

            if(enemyTurn){
                System.out.println("Follow up shot");
                followUpShot(enemyTurn, cell);
            }

        }
    }

    public void enemyMove(Board playerBoard){

        this.playerBoard = playerBoard;
        cell = getCellFromPlayerBoard();

        enemyTurn = cell.enemyShot();
        System.out.println("First shot: " + cell.x + " " + cell.y);

        followUpShot(enemyTurn, cell);

        if (playerBoard.ships == 0) {
            System.out.println("YOU LOSE");
            PopupWindow.endGamePopup("YOU LOSE", "You can do better");
        }
    }
}