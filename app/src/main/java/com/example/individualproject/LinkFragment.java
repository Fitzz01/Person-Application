package com.example.individualproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class LinkFragment extends Fragment {

    Button uitm, student;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_link, container, false);

        uitm    = rootView.findViewById(R.id.uitm_website);
        student = rootView.findViewById(R.id.istudent);

        uitm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLink("https://www.uitm.edu.my");
            }
        });

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLink("https://istudent.uitm.edu.my");
            }
        });
        return rootView;
    }

    private void goToLink(String s){
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}