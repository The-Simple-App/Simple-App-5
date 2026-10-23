package com.scanner.simpleapp5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class GameFragment extends Fragment {

    private TicTacToeGame game;
    private TextView title;
    private final Button[] board = new Button[9];

    private static final int[] BOARD_IDS = {
            R.id.button1, R.id.button2, R.id.button3,
            R.id.button4, R.id.button5, R.id.button6,
            R.id.button7, R.id.button8, R.id.button9
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tic_tac_toe, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        game = new TicTacToeGame();
        title = view.findViewById(R.id.textViewTitle);

        for (int i = 0; i < board.length; i++) {
            final int tileNumber = i + 1;
            board[i] = view.findViewById(BOARD_IDS[i]);
            board[i].setOnClickListener(v -> handleTileClick(tileNumber, board[tileNumber - 1]));
        }
    }

    private void handleTileClick(int tileNumber, Button button) {
        if (game.checkForWinner()) return;

        if (game.setToken(tileNumber, button)) {
            if (game.checkForWinner()) {
                showResult(game.getWinnerNumber());      // 1 or 2
            } else if (game.getTurnCount() == 9) {
                showResult(0);                            // 0 = tie
            } else {
                title.setText("Player " + (game.getPlayerTurn() == 1 ? "X" : "O") + "'s turn");
            }
        }
    }

    private void showResult(int winner) {
        Bundle args = new Bundle();
        args.putInt("winner", winner);
        NavHostFragment.findNavController(this)
                .navigate(R.id.resultsFragment, args);
    }
}