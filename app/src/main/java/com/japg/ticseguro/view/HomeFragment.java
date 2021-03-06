package com.japg.ticseguro.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.japg.ticseguro.R;

import java.util.ArrayList;

/**
 * ---------------------------------------------------------------------------------------
 * TICSeguro
 * App de Enseñanza de Conceptos de Seguridad Informática para Usuarios Regulares
 * Por Julio Poveda
 * Versión 1.0 - Mayo 2019
 * ---------------------------------------------------------------------------------------
 *
 * Clase HomeFragment
 *
 * Representa el controlador de la vista fragment_home.xml
 */
public class HomeFragment extends Fragment {

    //------------------------------------------------------------------------------------
    // Atributos
    //------------------------------------------------------------------------------------

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    //------------------------------------------------------------------------------------
    // Métodos Ciclo de Vida de la Actividad
    //------------------------------------------------------------------------------------

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        initImageBitmaps();

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        RecyclerViewLeccionesAdapter adapter = new RecyclerViewLeccionesAdapter(view.getContext(), mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ScrollView scrollView = (ScrollView) getView().findViewById(R.id.home_scroll_view);
        scrollView.setFocusableInTouchMode(true);
        scrollView.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);

    }

    //------------------------------------------------------------------------------------
    // Métodos
    //------------------------------------------------------------------------------------

    private void initImageBitmaps() {

        mImageUrls.add("https://images.pexels.com/photos/34577/pexels-photo.jpg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
        mNames.add("Phishing");

        mImageUrls.add("https://images.pexels.com/photos/533446/pexels-photo-533446.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
        mNames.add("Redes Sociales");

        mImageUrls.add("https://images.pexels.com/photos/1549003/pexels-photo-1549003.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
        mNames.add("Internet");

        mImageUrls.add("https://images.pexels.com/photos/1419924/pexels-photo-1419924.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
        mNames.add("Contraseñas");
    }
}
