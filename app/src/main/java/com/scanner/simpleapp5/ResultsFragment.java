package com.scanner.simpleapp5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ResultsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.result_game, container, false);
        TextView text = view.findViewById(R.id.resultText);

        int winner = getArguments() != null ? getArguments().getInt("winner", 0) : 0;
        if (winner == 0) {
            text.setText("It's a tie!");
        } else {
            text.setText("Player " + (winner == 1 ? "X" : "O") + " wins!");
        }
        return view;
    }
}