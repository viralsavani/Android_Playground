package android.csulb.edu.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by VIRAL on 2/24/2015.
 */
public class Fragment1 extends Fragment {

    @Nullable
    @Override
    /**
     * Inflate layout for Fragment 1
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment1,container,false);
    }


}
