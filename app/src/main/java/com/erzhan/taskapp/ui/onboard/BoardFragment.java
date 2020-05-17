package com.erzhan.taskapp.ui.onboard;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.erzhan.taskapp.MainActivity;
import com.erzhan.taskapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BoardFragment extends Fragment {

    TextView textTitle, textDesc;
    Button button;
    LinearLayout linearLayout;


    public BoardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_board, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textTitle = view.findViewById(R.id.textTitle);
        linearLayout = view.findViewById(R.id.liner);
        textDesc = view.findViewById(R.id.textDesc);
        button = view.findViewById(R.id.button_Getstart);
        ImageView imageView = view.findViewById(R.id.imageView);
        int pos = getArguments().getInt("pos");
        switch (pos) {
            case 0:
                imageView.setImageResource(R.drawable.bet);
                textTitle.setText("    Ставки на Спорт!");
                textDesc.setText("Делайте ставки в надёжной букмекерской компании!");
                button.setVisibility(View.GONE);
                break;
            case 1:
                imageView.setImageResource(R.drawable.bet);
                textTitle.setText("Большие Выигрыши!");
                textDesc.setText("Ставки на спорт в Live и по линии");
                button.setVisibility(View.GONE);
                view.setBackgroundColor(Color.BLUE);

                break;
            case 2:
                imageView.setImageResource(R.drawable.bet);
                textTitle.setText("Высокие коэффициенты!");
                textDesc.setText("Лучшие коэффициенты!");
                button.setVisibility(View.VISIBLE);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        saveIsShown();
                        Intent intent = new Intent(getContext(), MainActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                    }
                });
                view.setBackgroundColor(Color.BLACK);
                break;
        }
    }

    private void saveIsShown() {
        SharedPreferences preferences = getActivity()
                .getSharedPreferences("settings", Context.MODE_PRIVATE);
        preferences.edit()
                .putBoolean("isShown", true)
                .apply();
    }
}
