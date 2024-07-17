package com.example.individualproject;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class HobbyFragment extends Fragment {

    TextView volleyDetail;
    TextView badmintonDetail;
    TextView takrawDetail;

    LinearLayout layout_volley;
    LinearLayout layout_badminton;
    LinearLayout layout_takraw;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_hobby, container, false);

        volleyDetail  = rootView.findViewById(R.id.volley_detail);
        layout_volley = rootView.findViewById(R.id.layout_volley);
        layout_volley.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        layout_volley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v = (volleyDetail.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;
                TransitionManager.beginDelayedTransition(layout_volley, new AutoTransition());
                volleyDetail.setVisibility(v);
            }
        });
        //------------------------- volley end --------------------------------

        badmintonDetail  = rootView.findViewById(R.id.badminton_detail);
        layout_badminton = rootView.findViewById(R.id.layout_badminton);
        layout_badminton.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        layout_badminton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v = (badmintonDetail.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;
                TransitionManager.beginDelayedTransition(layout_badminton, new AutoTransition());
                badmintonDetail.setVisibility(v);
            }
        });
        //------------------------- badminton end --------------------------------

        takrawDetail  = rootView.findViewById(R.id.takraw_detail);
        layout_takraw = rootView.findViewById(R.id.layout_takraw);
        layout_takraw.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        layout_takraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v = (takrawDetail.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;
                TransitionManager.beginDelayedTransition(layout_takraw, new AutoTransition());
                takrawDetail.setVisibility(v);
            }
        });
        //------------------------- takraw end --------------------------------

        return rootView;
    }

}