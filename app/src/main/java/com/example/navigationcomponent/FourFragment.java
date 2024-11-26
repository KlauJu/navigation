package com.example.navigationcomponent;

import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.nfc.Tag;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import java.util.ArrayList;

import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.w3c.dom.Text;

public class FourFragment extends Fragment
        implements GestureOverlayView.OnGesturePerformedListener {

private GestureLibrary gLibrary;
private View viewFragment;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup contain, Bundle savedInstanceState){
    return inflater.inflate(R.layout.fragment_four, contain);
}

public void  onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceState){
    super.onViewCreated(view, savedInstanceState);
    viewFragment = view;
    gestureSetup(viewFragment);
}

private void gestureSetup(View view){
    gLibrary= GestureLibraries.fromRawResource(getActivity(),R.raw.gestures);
    if(!gLibrary.load()){

    }
}


    public FourFragment() {
        // Required empty public constructor
    }


    @Override
    public void onGesturePerformed(GestureOverlayView gestureOverlayView, Gesture gesture) {
        ArrayList<Prediction>predictions=gLibrary.recognize(gesture);
        if (predictions.size()>0 && predictions.get(0).score>1.0){
            String action= predictions.get(0).name;
            Log.i("Gesture", action);

            if(action.equals("configurar")){
                Toast.makeText(getActivity(),
                        "Configurar gesture", Toast.LENGTH_SHORT).show();
                Navigation.findNavController(viewFragment).navigate(R.id.inicioFragment);
            }
        }
    }
}