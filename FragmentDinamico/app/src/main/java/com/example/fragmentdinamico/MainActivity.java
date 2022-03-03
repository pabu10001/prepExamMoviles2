package com.example.fragmentdinamico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.fragmentdinamico.fragmentos.FragmentoBlanco;
import com.example.fragmentdinamico.fragmentos.FragmentoRojo;
import com.example.fragmentdinamico.fragmentos.FragmentoVerde;

public class MainActivity extends AppCompatActivity {

    FragmentTransaction transaction;
    Fragment fragmentBlanco, fragmentRojo, fragmentVerde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentBlanco = new FragmentoBlanco();
        fragmentRojo = new FragmentoRojo();
        fragmentVerde = new FragmentoVerde();

        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerView, fragmentBlanco).commit();
    }

    public void onClick (View view) {
        transaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()) {
            case R.id.btnRojo:
                transaction.replace(R.id.fragmentContainerView, fragmentRojo);
                transaction.addToBackStack(null);
                break;
            case R.id.btnVerde:
                transaction.replace(R.id.fragmentContainerView, fragmentVerde);
                transaction.addToBackStack(null);
                break;
        }
        transaction.commit();
    }
}