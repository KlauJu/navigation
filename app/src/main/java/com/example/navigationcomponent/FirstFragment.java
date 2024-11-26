package com.example.navigationcomponent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.navigationcomponent.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

     public FirstFragment(){
         //required empty public constructor
     }

     @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState){
         return inflater.inflate(R.layout.fragment_first, container, false);

     }

     @Override
     public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
          super.onViewCreated(view, savedInstanceState);

          Button btnAtras=view.findViewById(R.id.btnAtras);

          btnAtras.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                    Navigation.findNavController(view).navigate(R.id.inicioFragment);
               }
          });

     }
}