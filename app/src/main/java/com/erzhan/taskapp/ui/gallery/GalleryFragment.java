package com.erzhan.taskapp.ui.gallery;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.erzhan.taskapp.R;

import java.io.File;
import java.util.ArrayList;

public class GalleryFragment extends Fragment {
    ArrayList<String> list;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getPermissions();
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_gallery);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        GalleryAdapter adapter = new GalleryAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    private void getPermissions() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            getFiles();
        } else {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 77);

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 77) {
            getPermissions();
        }
    }

    private void getFiles() {
        File folder = new File(Environment.getExternalStorageDirectory(), "DCIM/TaskApp");
        list = new ArrayList<>();
        for (File file : folder.listFiles()) {
            list.add(file.getName());
        }
    }

}
