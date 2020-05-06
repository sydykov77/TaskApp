package com.erzhan.taskapp.ui.onboard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.erzhan.taskapp.R;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class BoardFragment extends Fragment {

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
        TextView textTitle = view.findViewById(R.id.textTitle);
        TextView textTitle2 = view.findViewById(R.id.textTitle2);
        ImageView imageView = view.findViewById(R.id.imageView);
        int pos = getArguments().getInt("pos");
        switch (pos){
            case 0:
                imageView.setImageResource(R.drawable.bet);
                textTitle.setText("    Ставки на Спорт!");
                textTitle2.setText("Делайте ставки в надёжной букмекерской компании!");
                break;
            case 1:
                imageView.setImageResource(R.drawable.bet);
                textTitle.setText("Большие Выигрыши!");
                textTitle2.setText("Ставки на спорт в Live и по линии");
                break;
            case 2:
                imageView.setImageResource(R.drawable.bet);
                textTitle.setText("Высокие коэффициенты!");
                textTitle2.setText("Лучшие коэффициенты!");
                break;
        }
    }
}
