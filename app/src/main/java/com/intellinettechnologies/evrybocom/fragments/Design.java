package com.intellinettechnologies.evrybocom.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.intellinettechnologies.evrybocom.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Design extends Fragment {
View mainView;

    public Design() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView =  inflater.inflate(R.layout.fragment_design, container, false);
        return mainView;
    }

}
