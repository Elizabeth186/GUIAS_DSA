package com.example.fragmentsalario;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Informacion#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Informacion extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Informacion() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Informacion.
     */
    // TODO: Rename and change types and number of parameters
    public static Informacion newInstance(String param1, String param2) {
        Informacion fragment = new Informacion();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    EditText EditextNombre, EditextHoras;
    Button btnClacular;
    TextView TextViewRespuesta, TextViewAFP, TextViewISS, TextViewRenta;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_informacion, container, false);

        EditextNombre = (EditText) view.findViewById(R.id.nombre);
        EditextHoras = (EditText) view.findViewById(R.id.horas);
        btnClacular = (Button) view.findViewById(R.id.btn_calculo);
        TextViewRespuesta = (TextView) view.findViewById(R.id.repuesta);
        TextViewAFP = (TextView)view.findViewById(R.id.AFP);
        TextViewRenta = (TextView)view.findViewById(R.id.RENTA) ;
        TextViewISS = (TextView)view.findViewById(R.id.ISSS);

        btnClacular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = EditextNombre.toString(),
                        horas = EditextHoras.getText().toString();
                if (nombre.isEmpty() || horas.isEmpty()) return;

                int horaTrabajo = Integer.parseInt(horas);

                final double ValorHoras = 8.50;

                double horatotal = horaTrabajo * ValorHoras;
                double descuentoAFP = horatotal * 0.04;
                double descuentoISS = horatotal * 0.03;
                double descuentoRenta = horatotal * 0.05;
                double totalsalario = horatotal - descuentoAFP - descuentoISS - descuentoRenta;

                TextViewRespuesta.setText("su salaio total es $" + totalsalario);
                TextViewAFP.setText("Descunto AFP $"+descuentoAFP);
                TextViewISS.setText("Descuento ISSS $"+descuentoISS);
                TextViewRenta.setText("Descuento Renta $"+descuentoRenta);


            }
        });
        return view;
    }
    }
