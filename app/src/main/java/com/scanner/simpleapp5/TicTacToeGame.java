package com.scanner.simpleapp5;

import android.util.Log;
import android.widget.Button;

public class TicTacToeGame
{
    private int playerTurn;
    private int[][] tiles;
    private int turnCount;

    public int getTurnCount()
    {
        return turnCount;
    }

    public int getPlayerTurn()
    {
        return playerTurn;
    }
    public int[][] getTiles()
    {
        return tiles;
    }

    public TicTacToeGame()
    {
        playerTurn = 1;
        turnCount = 0;
        tiles = new int[3][3];

        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                tiles[i][j] = 0;
            }
        }
    }



    //tiles are numbers 1-9
    public boolean setToken(int tile, Button button)
    {
        tile = tile - 1;
        Log.i("TicTacToe", "Tile " + tile);
        int row = tile / 3;
        int col = tile % 3;

        if(tiles[row][col] == 0)
        {
            tiles[row][col] = playerTurn;
            turnCount++;

            if(playerTurn == 1) {
                button.setText("X");
                playerTurn = 2;
            }
            else {
                button.setText("O");
                playerTurn = 1;
            }
            return true;
        }

        return false;
    }

    public boolean checkForWinner()
    {
        if((tiles[0][0] == tiles[0][1] && tiles[0][1] == tiles[0][2] && tiles[0][0] != 0) ||
                (tiles[1][0] != 0 && tiles[1][0] == tiles[1][1] && tiles[1][1] == tiles[1][2]) ||
                (tiles[2][0] != 0 && tiles[2][0] == tiles[2][1] && tiles[2][1] == tiles[2][2]))
            return true;

        if((tiles[0][0] != 0 && tiles[0][0] == tiles[1][0] && tiles[1][0] == tiles[2][0]) ||
                (tiles[0][1] != 0 && tiles[0][1] == tiles[1][1] && tiles[1][1] == tiles[2][1]) ||
                (tiles[0][2] != 0 && tiles[0][2] == tiles[1][2] && tiles[1][2] == tiles[2][2]))
            return true;

        if((tiles[0][0] != 0 && tiles[0][0] == tiles[1][1] && tiles[1][1] == tiles[2][2]) ||
                (tiles[0][2] != 0 && tiles[0][2] == tiles[1][1] && tiles[1][1] == tiles[2][0]))
            return true;

        return false;
    }

    public int getWinnerNumber()
    {
        if(this.getPlayerTurn() == 1)
            return 2;
        else
            return 1;
    }

}
