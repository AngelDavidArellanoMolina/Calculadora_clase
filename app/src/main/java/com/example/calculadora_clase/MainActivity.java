package com.example.calculadora_clase;

import static java.lang.Double.NaN;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private Spinner elegirConversion;
    private Spinner unidadValorInicial;
    private Spinner unidadValorConvertido;
    private EditText valorInicial;
    private EditText valorConvertido;
    private Button calcular;
    private Button uno;
    private Button dos;
    private Button tres;
    private Button cuatro;
    private Button cinco;
    private Button seis;
    private Button siete;
    private Button ocho;
    private Button nueve;
    private Button cero;
    private Button mas_menos;
    private Button punto;
    private Button borrarTodo;
    private Button eliminarUltDigito;
    private Button intercambiar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] tipoConversion = {"Volumen", "Longitud", "Masa", "Velocidad", "Temperatura", "Presión",
                "Tamaño de Datos"};
        String[] unidadesVolumen = {"Litro", "Mililitro", "Galón Estadounidense", "Metro Cúbico"};
        String[] unidadesLongitud = {"Metro", "Kilómetro", "Centímetro", "Pulgada", "Milla", "Yarda", "Pie"};
        String[] unidadesMasa = {"Kilogramo", "Tonelada", "Gramo", "Miligramo", "Onza", "Libra"};
        String[] unidadesVelocidad = {"Metro por Segundo", "Kilómetro por Hora", "Milla por Hora", "Nudo"};
        String[] unidadesTemperatura = {"Grado Celsius", "Grado Fahrenheit", "Kelvin"};
        String[] unidadesPresion = {"Atmósfera", "Bar", "Pascal"};
        String[] unidadesTamañoDatos = {"Bit", "Byte", "KiloByte", "MegaByte", "GigaByte", "TeraByte"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tipoConversion);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        elegirConversion = findViewById(R.id.spinnerTipoConversion);
        elegirConversion.setAdapter(adapter);
        elegirConversion.setSelection(0);
        unidadValorInicial = findViewById(R.id.spinnerValorInicial);
        unidadValorConvertido = findViewById(R.id.spinnerValorFinal);
        valorInicial = findViewById(R.id.valorParaConvertir);
        valorConvertido = findViewById(R.id.valorConvertido);
        uno = findViewById(R.id.uno);
        dos = findViewById(R.id.dos);
        tres = findViewById(R.id.tres);
        cuatro = findViewById(R.id.cuatro);
        cinco = findViewById(R.id.cinco);
        seis = findViewById(R.id.seis);
        siete = findViewById(R.id.siete);
        ocho = findViewById(R.id.ocho);
        nueve = findViewById(R.id.nueve);
        cero = findViewById(R.id.cero);
        punto = findViewById(R.id.punto);
        mas_menos = findViewById(R.id.mas_menos);
        eliminarUltDigito = findViewById(R.id.eliminarUltDigit);
        borrarTodo = findViewById(R.id.borrarTodo);
        calcular = findViewById(R.id.igual);
        intercambiar = findViewById(R.id.intercambiar);

        elegirConversion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tipoSeleccionado = (String) parent.getItemAtPosition(position);

                switch (Objects.requireNonNull(tipoSeleccionado)) {
                    case "Volumen":
                        unidadValorInicial.setAdapter(new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, unidadesVolumen));
                        unidadValorConvertido.setAdapter(new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, unidadesVolumen));
                        break;

                    case "Longitud":
                        unidadValorInicial.setAdapter(new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, unidadesLongitud));
                        unidadValorConvertido.setAdapter(new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, unidadesLongitud));
                        break;

                    case "Masa":
                        unidadValorInicial.setAdapter(new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, unidadesMasa));
                        unidadValorConvertido.setAdapter(new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, unidadesMasa));
                        break;

                    case "Velocidad":
                        unidadValorInicial.setAdapter(new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, unidadesVelocidad));
                        unidadValorConvertido.setAdapter(new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, unidadesVelocidad));
                        break;

                    case "Temperatura":
                        unidadValorInicial.setAdapter(new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, unidadesTemperatura));
                        unidadValorConvertido.setAdapter(new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, unidadesTemperatura));
                        break;

                    case "Presión":
                        unidadValorInicial.setAdapter(new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, unidadesPresion));
                        unidadValorConvertido.setAdapter(new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, unidadesPresion));
                        break;

                    case "Tamaño de Datos":
                        unidadValorInicial.setAdapter(new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, unidadesTamañoDatos));
                        unidadValorConvertido.setAdapter(new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, unidadesTamañoDatos));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Código para cuando no se selecciona nada
            }
        });

        uno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Botón pulsado: ", uno.getText().toString());
                valorInicial.setText(valorInicial.getText()+"1");
            }
        });
        dos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Botón pulsado: ", dos.getText().toString());
                valorInicial.setText(valorInicial.getText()+"2");
            }
        });
        tres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Botón pulsado: ", tres.getText().toString());
                valorInicial.setText(valorInicial.getText()+"3");
            }
        });
        cuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Botón pulsado: ", cuatro.getText().toString());
                valorInicial.setText(valorInicial.getText()+"4");
            }
        });
        cinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Botón pulsado: ", cinco.getText().toString());
                valorInicial.setText(valorInicial.getText()+"5");
            }
        });
        seis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Botón pulsado: ", seis.getText().toString());
                valorInicial.setText(valorInicial.getText()+"6");
            }
        });
        siete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Botón pulsado: ", siete.getText().toString());
                valorInicial.setText(valorInicial.getText()+"7");
            }
        });
        ocho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Botón pulsado: ", ocho.getText().toString());
                valorInicial.setText(valorInicial.getText()+"8");
            }
        });
        nueve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Botón pulsado: ", nueve.getText().toString());
                valorInicial.setText(valorInicial.getText()+"9");
            }
        });
        cero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Botón pulsado: ", cero.getText().toString());
                valorInicial.setText(valorInicial.getText()+"0");
            }
        });
        eliminarUltDigito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoActual = valorInicial.getText().toString();
                if (textoActual.length() > 0) {
                    textoActual = textoActual.substring(0, textoActual.length() - 1);
                    valorInicial.setText(textoActual);
                }
            }
        });
        borrarTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valorInicial.setText("");
                valorConvertido.setText("");
            }
        });

        punto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!valorInicial.getText().toString().contains(".")) {
                    if (!valorInicial.getText().toString().isEmpty()) {
                        valorInicial.setText(valorInicial.getText().toString() + ".");
                    } else if (valorInicial.getText().toString().isEmpty() ||
                            valorInicial.getText().toString().equals("0")) {
                        valorInicial.setText("0.");
                    }
                }
                valorInicial.requestFocus();
            }
        });
        intercambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String valor1 = valorInicial.getText().toString();
                String valor2 = valorConvertido.getText().toString();
                String tipoSeleccionado1 = (String) unidadValorInicial.getSelectedItem();
                String tipoSeleccionado2 = (String) unidadValorConvertido.getSelectedItem();

                valorInicial.setText(valor2);
                valorConvertido.setText(valor1);
                unidadValorInicial.setSelection(((ArrayAdapter<String>)unidadValorInicial.getAdapter()).getPosition(tipoSeleccionado2));
                unidadValorConvertido.setSelection(((ArrayAdapter<String>)unidadValorConvertido.getAdapter()).getPosition(tipoSeleccionado1));

                valorInicial.requestFocus();
            }
        });

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!valorInicial.getText().toString().isEmpty()) {
                    String tipoConversion = (String) elegirConversion.getSelectedItem();
                    String unidadOrigenSeleccionada = (String) unidadValorInicial.getSelectedItem();
                    String unidadDestinoSeleccionada = (String) unidadValorConvertido.getSelectedItem();
                    double valorIntroducido = Double.parseDouble(valorInicial.getText().toString());
                    double resultado = NaN;

                    switch (Objects.requireNonNull(tipoConversion)) {
                        case "Volumen":
                            switch (Objects.requireNonNull(unidadOrigenSeleccionada)) {
                                case "Litro":
                                    switch (Objects.requireNonNull(unidadDestinoSeleccionada)) {
                                        case "Mililitro":
                                            resultado = valorIntroducido * 1000;
                                            break;
                                        case "Galón Estadounidense":
                                            resultado = valorIntroducido / 3.785;
                                            break;
                                        case "Metro Cúbico":
                                            resultado = valorIntroducido / 1000;
                                            break;
                                        case "Litro":
                                            resultado = valorIntroducido;
                                            break;
                                    }
                                    break;
                                case "Mililitro":
                                    switch (Objects.requireNonNull(unidadDestinoSeleccionada)) {
                                        case "Mililitro":
                                            resultado = valorIntroducido;
                                            break;
                                        case "Galón Estadounidense":
                                            resultado = valorIntroducido / 3785;
                                            break;
                                        case "Metro Cúbico":
                                            resultado = valorIntroducido / 1e+6;
                                            break;
                                        case "Litro":
                                            resultado = valorIntroducido / 1000;
                                            break;
                                    }
                                    break;
                                case "Galón Estadounidense":
                                    switch (Objects.requireNonNull(unidadDestinoSeleccionada)) {
                                        case "Mililitro":
                                            resultado = valorIntroducido * 3785;
                                            break;
                                        case "Galón Estadounidense":
                                            resultado = valorIntroducido;
                                            break;
                                        case "Metro Cúbico":
                                            resultado = valorIntroducido / 264.2;
                                            break;
                                        case "Litro":
                                            resultado = valorIntroducido * 3.785;
                                            break;
                                    }
                                    break;
                                case "Metro Cúbico":
                                    switch (Objects.requireNonNull(unidadDestinoSeleccionada)) {
                                        case "Mililitro":
                                            resultado = valorIntroducido * 1e+6;
                                            break;
                                        case "Galón Estadounidense":
                                            resultado = valorIntroducido * 264.2;
                                            break;
                                        case "Metro Cúbico":
                                            resultado = valorIntroducido;
                                            break;
                                        case "Litro":
                                            resultado = valorIntroducido * 1000;
                                            break;
                                    }
                                    break;
                            }
                            break;

                        case "Longitud":
                            switch (Objects.requireNonNull(unidadOrigenSeleccionada)) {
                                case "Metro":
                                    switch (Objects.requireNonNull(unidadDestinoSeleccionada)) {
                                        case "Metro":
                                            resultado = valorIntroducido;
                                            break;
                                        case "Kilómetro":
                                            resultado = valorIntroducido / 1000;
                                            break;
                                        case "Centímetro":
                                            resultado = valorIntroducido * 100;
                                            break;
                                        case "Pulgada":
                                            resultado = valorIntroducido * 39.37;
                                            break;
                                        case "Milla":
                                            resultado = valorIntroducido / 1609;
                                            break;
                                        case "Yarda":
                                            resultado = valorIntroducido * 1.094;
                                            break;
                                        case "Pie":
                                            resultado = valorIntroducido * 3.281;
                                            break;
                                    }
                                    break;
                                case "Kilómetro":
                                    switch (Objects.requireNonNull(unidadDestinoSeleccionada)) {
                                        case "Metro":
                                            resultado = valorIntroducido * 1000;
                                            break;
                                        case "Kilómetro":
                                            resultado = valorIntroducido;
                                            break;
                                        case "Centímetro":
                                            resultado = valorIntroducido * 100000;
                                            break;
                                        case "Pulgada":
                                            resultado = valorIntroducido * 39370;
                                            break;
                                        case "Milla":
                                            resultado = valorIntroducido / 1.609;
                                            break;
                                        case "Yarda":
                                            resultado = valorIntroducido * 1094;
                                            break;
                                        case "Pie":
                                            resultado = valorIntroducido * 3281;
                                            break;
                                    }
                                    break;
                                case "Centímetro":
                                    switch (Objects.requireNonNull(unidadDestinoSeleccionada)) {
                                        case "Metro":
                                            resultado = valorIntroducido / 100;
                                            break;
                                        case "Kilómetro":
                                            resultado = valorIntroducido / 100000;
                                            ;
                                            break;
                                        case "Centímetro":
                                            resultado = valorIntroducido;
                                            break;
                                        case "Pulgada":
                                            resultado = valorIntroducido / 2.54;
                                            break;
                                        case "Milla":
                                            resultado = valorIntroducido / 160900;
                                            break;
                                        case "Yarda":
                                            resultado = valorIntroducido / 91.44;
                                            break;
                                        case "Pie":
                                            resultado = valorIntroducido / 30.48;
                                            break;
                                    }
                                    break;
                                case "Pulgada":
                                    switch (Objects.requireNonNull(unidadDestinoSeleccionada)) {
                                        case "Metro":
                                            resultado = valorIntroducido / 30.37;
                                            break;
                                        case "Kilómetro":
                                            resultado = valorIntroducido / 39370;
                                            ;
                                            break;
                                        case "Centímetro":
                                            resultado = valorIntroducido * 2.54;
                                            break;
                                        case "Pulgada":
                                            resultado = valorIntroducido;
                                            break;
                                        case "Milla":
                                            resultado = valorIntroducido / 63360;
                                            break;
                                        case "Yarda":
                                            resultado = valorIntroducido / 36;
                                            break;
                                        case "Pie":
                                            resultado = valorIntroducido / 12;
                                            break;
                                    }
                                    break;
                                case "Milla":
                                    switch (Objects.requireNonNull(unidadDestinoSeleccionada)) {
                                        case "Metro":
                                            resultado = valorIntroducido * 1609;
                                            break;
                                        case "Kilómetro":
                                            resultado = valorIntroducido * 1.609;
                                            ;
                                            break;
                                        case "Centímetro":
                                            resultado = valorIntroducido * 160900;
                                            break;
                                        case "Pulgada":
                                            resultado = valorIntroducido * 63360;
                                            break;
                                        case "Milla":
                                            resultado = valorIntroducido;
                                            break;
                                        case "Yarda":
                                            resultado = valorIntroducido * 1760;
                                            break;
                                        case "Pie":
                                            resultado = valorIntroducido * 5280;
                                            break;
                                    }
                                    break;
                                case "Yarda":
                                    switch (Objects.requireNonNull(unidadDestinoSeleccionada)) {
                                        case "Metro":
                                            resultado = valorIntroducido / 1.094;
                                            break;
                                        case "Kilómetro":
                                            resultado = valorIntroducido / 1094;
                                            ;
                                            break;
                                        case "Centímetro":
                                            resultado = valorIntroducido * 91.44;
                                            break;
                                        case "Pulgada":
                                            resultado = valorIntroducido * 36;
                                            break;
                                        case "Milla":
                                            resultado = valorIntroducido / 1760;
                                            break;
                                        case "Yarda":
                                            resultado = valorIntroducido;
                                            break;
                                        case "Pie":
                                            resultado = valorIntroducido * 3;
                                            break;
                                    }
                                    break;
                                case "Pie":
                                    switch (Objects.requireNonNull(unidadDestinoSeleccionada)) {
                                        case "Metro":
                                            resultado = valorIntroducido / 3.281;
                                            break;
                                        case "Kilómetro":
                                            resultado = valorIntroducido / 3281;
                                            break;
                                        case "Centímetro":
                                            resultado = valorIntroducido * 30.48;
                                            break;
                                        case "Pulgada":
                                            resultado = valorIntroducido * 12;
                                            break;
                                        case "Milla":
                                            resultado = valorIntroducido / 5280;
                                            break;
                                        case "Yarda":
                                            resultado = valorIntroducido / 3;
                                            break;
                                        case "Pie":
                                            resultado = valorIntroducido;
                                            break;
                                    }
                                    break;
                            }
                            break;

                        case "Masa":
                            switch (Objects.requireNonNull(unidadOrigenSeleccionada)) {
                                case "Kilogramo":
                                    switch (Objects.requireNonNull(unidadDestinoSeleccionada)) {
                                        case "Kilogramo":
                                            resultado = valorIntroducido;
                                            break;
                                        case "Tonelada":
                                            resultado = valorIntroducido / 1000;
                                            break;
                                        case "Gramo":
                                            resultado = valorIntroducido * 100;
                                            break;
                                        case "Miligramo":
                                            resultado = valorIntroducido * 1e+6;
                                            break;
                                        case "Onza":
                                            resultado = valorIntroducido * 35.274;
                                            break;
                                        case "Libra":
                                            resultado = valorIntroducido * 2.205;
                                            break;
                                    }
                                    break;
                                case "Tonelada":
                                    switch (Objects.requireNonNull(unidadDestinoSeleccionada)) {
                                        case "Kilogramo":
                                            resultado = valorIntroducido * 1000;
                                            break;
                                        case "Tonelada":
                                            resultado = valorIntroducido;
                                            break;
                                        case "Gramo":
                                            resultado = valorIntroducido * 1e+6;
                                            break;
                                        case "Miligramo":
                                            resultado = valorIntroducido * 1e+9;
                                            break;
                                        case "Onza":
                                            resultado = valorIntroducido * 35270;
                                            break;
                                        case "Libra":
                                            resultado = valorIntroducido * 2205;
                                            break;
                                    }
                                    break;
                                case "Gramo":
                                    switch (Objects.requireNonNull(unidadDestinoSeleccionada)) {
                                        case "Kilogramo":
                                            resultado = valorIntroducido / 1000;
                                            break;
                                        case "Tonelada":
                                            resultado = valorIntroducido / 1e+6;
                                            break;
                                        case "Gramo":
                                            resultado = valorIntroducido;
                                            break;
                                        case "Miligramo":
                                            resultado = valorIntroducido * 1000;
                                            break;
                                        case "Onza":
                                            resultado = valorIntroducido / 28.35;
                                            break;
                                        case "Libra":
                                            resultado = valorIntroducido * 2205;
                                            break;
                                    }
                                    break;
                                case "Miligramo":
                                    switch (Objects.requireNonNull(unidadDestinoSeleccionada)) {
                                        case "Kilogramo":
                                            resultado = valorIntroducido / 1e+6;
                                            break;
                                        case "Tonelada":
                                            resultado = valorIntroducido / 1e+9;
                                            break;
                                        case "Gramo":
                                            resultado = valorIntroducido / 1000;
                                            break;
                                        case "Miligramo":
                                            resultado = valorIntroducido;
                                            break;
                                        case "Onza":
                                            resultado = valorIntroducido / 28350;
                                            break;
                                        case "Libra":
                                            resultado = valorIntroducido / 453600;
                                            break;
                                    }
                                    break;
                                case "Onza":
                                    switch (Objects.requireNonNull(unidadDestinoSeleccionada)) {
                                        case "Kilogramo":
                                            resultado = valorIntroducido / 35.274;
                                            break;
                                        case "Tonelada":
                                            resultado = valorIntroducido / 35270;
                                            break;
                                        case "Gramo":
                                            resultado = valorIntroducido * 28.35;
                                            break;
                                        case "Miligramo":
                                            resultado = valorIntroducido * 28350;
                                            break;
                                        case "Onza":
                                            resultado = valorIntroducido / 28350;
                                            break;
                                        case "Libra":
                                            resultado = valorIntroducido / 16;
                                            break;
                                    }
                                    break;
                                case "Libra":
                                    switch (Objects.requireNonNull(unidadDestinoSeleccionada)) {
                                        case "Kilogramo":
                                            resultado = valorIntroducido / 2.205;
                                            break;
                                        case "Tonelada":
                                            resultado = valorIntroducido / 2205;
                                            break;
                                        case "Gramo":
                                            resultado = valorIntroducido * 453.6;
                                            break;
                                        case "Miligramo":
                                            resultado = valorIntroducido * 453600;
                                            break;
                                        case "Onza":
                                            resultado = valorIntroducido * 16;
                                            break;
                                        case "Libra":
                                            resultado = valorIntroducido;
                                            break;
                                    }
                                    break;
                            }
                            break;

                        case "Velocidad":
                            switch (Objects.requireNonNull(unidadOrigenSeleccionada)) {
                                case "Metro por Segundo":
                                    switch (Objects.requireNonNull(unidadDestinoSeleccionada)) {
                                        case "Metro por Segundo":
                                            resultado = valorIntroducido;
                                            break;
                                        case "Kilómetro por Hora":
                                            resultado = valorIntroducido * 3.6;
                                            break;
                                        case "Milla por Hora":
                                            resultado = valorIntroducido * 2.237;
                                            break;
                                        case "Nudo":
                                            resultado = valorIntroducido * 1.944;
                                            break;
                                    }
                                    break;
                                case "Kilómetro por Hora":
                                    switch (Objects.requireNonNull(unidadDestinoSeleccionada)) {
                                        case "Metro por Segundo":
                                            resultado = valorIntroducido / 3.6;
                                            break;
                                        case "Kilómetro por Hora":
                                            resultado = valorIntroducido;
                                            break;
                                        case "Milla por Hora":
                                            resultado = valorIntroducido / 1.609;
                                            break;
                                        case "Nudo":
                                            resultado = valorIntroducido / 1.852;
                                            break;
                                    }
                                    break;
                                case "Milla por Hora":
                                    switch (Objects.requireNonNull(unidadDestinoSeleccionada)) {
                                        case "Metro por Segundo":
                                            resultado = valorIntroducido / 2.237;
                                            break;
                                        case "Kilómetro por Hora":
                                            resultado = valorIntroducido * 1.609;
                                            break;
                                        case "Milla por Hora":
                                            resultado = valorIntroducido;
                                            break;
                                        case "Nudo":
                                            resultado = valorIntroducido / 1.151;
                                            break;
                                    }
                                    break;
                                case "Nudo":
                                    switch (Objects.requireNonNull(unidadDestinoSeleccionada)) {
                                        case "Metro por Segundo":
                                            resultado = valorIntroducido / 1.944;
                                            break;
                                        case "Kilómetro por Hora":
                                            resultado = valorIntroducido * 1.852;
                                            break;
                                        case "Milla por Hora":
                                            resultado = valorIntroducido * 1.151;
                                            break;
                                        case "Nudo":
                                            resultado = valorIntroducido;
                                            break;
                                    }
                                    break;
                            }
                            break;

                        case "Temperatura":
                            switch (Objects.requireNonNull(unidadOrigenSeleccionada)) {
                                case "Grado Celsius":
                                    switch (Objects.requireNonNull(unidadDestinoSeleccionada)) {
                                        case "Grado Celsius":
                                            resultado = valorIntroducido;
                                            break;
                                        case "Grado Fahrenheit":
                                            resultado = (valorIntroducido * ((double) 9 / 5)) + 32;
                                            break;
                                        case "Kelvin":
                                            resultado = valorIntroducido + 273.15;
                                            break;
                                    }
                                    break;
                                case "Grado Fahrenheit":
                                    switch (Objects.requireNonNull(unidadDestinoSeleccionada)) {
                                        case "Grado Celsius":
                                            resultado = (valorIntroducido - 32) * ((double) 5 / 9);
                                            break;
                                        case "Grado Fahrenheit":
                                            resultado = valorIntroducido;
                                            break;
                                        case "Kelvin":
                                            resultado = (valorIntroducido - 32) * ((double) 5 / 9) + 273.15;
                                            break;
                                    }
                                    break;
                                case "Kelvin":
                                    switch (Objects.requireNonNull(unidadDestinoSeleccionada)) {
                                        case "Grado Celsius":
                                            resultado = valorIntroducido - 273.15;
                                            break;
                                        case "Grado Fahrenheit":
                                            resultado = ((valorIntroducido - 273.15) * ((double) 9 / 5)) + 32;
                                            break;
                                        case "Kelvin":
                                            resultado = valorIntroducido;
                                            break;
                                    }
                                    break;
                            }

                        case "Presión":
                            switch (Objects.requireNonNull(unidadOrigenSeleccionada)) {
                                case "Atmósfera":
                                    switch (Objects.requireNonNull(unidadDestinoSeleccionada)) {
                                        case "Atmósfera":
                                            resultado = valorIntroducido;
                                            break;
                                        case "Bar":
                                            resultado = valorIntroducido * 1.013;
                                            break;
                                        case "Pascal":
                                            resultado = valorIntroducido * 101300;
                                            break;
                                    }
                                    break;
                                case "Bar":
                                    switch (Objects.requireNonNull(unidadDestinoSeleccionada)) {
                                        case "Atmósfera":
                                            resultado = valorIntroducido / 1.013;
                                            break;
                                        case "Bar":
                                            resultado = valorIntroducido;
                                            break;
                                        case "Pascal":
                                            resultado = valorIntroducido * 100000;
                                            break;
                                    }
                                    break;
                                case "Pascal":
                                    switch (Objects.requireNonNull(unidadDestinoSeleccionada)) {
                                        case "Atmósfera":
                                            resultado = valorIntroducido / 101300;
                                            break;
                                        case "Bar":
                                            resultado = valorIntroducido / 100000;
                                            break;
                                        case "Pascal":
                                            resultado = valorIntroducido;
                                            break;
                                    }
                                    break;
                            }

                        case "Tamaño de Datos":
                            switch (Objects.requireNonNull(unidadOrigenSeleccionada)) {
                                case "Bit":
                                    switch (Objects.requireNonNull(unidadDestinoSeleccionada)) {
                                        case "Bit":
                                            resultado = valorIntroducido;
                                            break;
                                        case "Byte":
                                            resultado = valorIntroducido / 8;
                                            break;
                                        case "KiloByte":
                                            resultado = valorIntroducido / 8000;
                                            break;
                                        case "MegaByte":
                                            resultado = valorIntroducido / 8e+6;
                                            break;
                                        case "GigaByte":
                                            resultado = valorIntroducido / 8e+9;
                                            break;
                                        case "TeraByte":
                                            resultado = valorIntroducido / 8e+12;
                                            break;
                                    }
                                    break;
                                case "Byte":
                                    switch (Objects.requireNonNull(unidadDestinoSeleccionada)) {
                                        case "Bit":
                                            resultado = valorIntroducido * 8;
                                            break;
                                        case "Byte":
                                            resultado = valorIntroducido;
                                            break;
                                        case "KiloByte":
                                            resultado = valorIntroducido / 1000;
                                            break;
                                        case "MegaByte":
                                            resultado = valorIntroducido / 1e+6;
                                            break;
                                        case "GigaByte":
                                            resultado = valorIntroducido / 1e+9;
                                            break;
                                        case "TeraByte":
                                            resultado = valorIntroducido / 1e+12;
                                            break;
                                    }
                                    break;
                                case "KiloByte":
                                    switch (Objects.requireNonNull(unidadDestinoSeleccionada)) {
                                        case "Bit":
                                            resultado = valorIntroducido * 8000;
                                            break;
                                        case "Byte":
                                            resultado = valorIntroducido * 1000;
                                            break;
                                        case "KiloByte":
                                            resultado = valorIntroducido;
                                            break;
                                        case "MegaByte":
                                            resultado = valorIntroducido / 1000;
                                            break;
                                        case "GigaByte":
                                            resultado = valorIntroducido / 1e+6;
                                            break;
                                        case "TeraByte":
                                            resultado = valorIntroducido / 1e+9;
                                            break;
                                    }
                                    break;
                                case "MegaByte":
                                    switch (Objects.requireNonNull(unidadDestinoSeleccionada)) {
                                        case "Bit":
                                            resultado = valorIntroducido * 8e+6;
                                            break;
                                        case "Byte":
                                            resultado = valorIntroducido * 1e+6;
                                            break;
                                        case "KiloByte":
                                            resultado = valorIntroducido * 1000;
                                            break;
                                        case "MegaByte":
                                            resultado = valorIntroducido;
                                            break;
                                        case "GigaByte":
                                            resultado = valorIntroducido / 1000;
                                            break;
                                        case "TeraByte":
                                            resultado = valorIntroducido / 1e+6;
                                            break;
                                    }
                                    break;
                                case "GigaByte":
                                    switch (Objects.requireNonNull(unidadDestinoSeleccionada)) {
                                        case "Bit":
                                            resultado = valorIntroducido * 8e+9;
                                            break;
                                        case "Byte":
                                            resultado = valorIntroducido * 1e+9;
                                            break;
                                        case "KiloByte":
                                            resultado = valorIntroducido * 1e+6;
                                            break;
                                        case "MegaByte":
                                            resultado = valorIntroducido * 1000;
                                            break;
                                        case "GigaByte":
                                            resultado = valorIntroducido;
                                            break;
                                        case "TeraByte":
                                            resultado = valorIntroducido / 1000;
                                            break;
                                    }
                                    break;
                                case "TeraByte":
                                    switch (Objects.requireNonNull(unidadDestinoSeleccionada)) {
                                        case "Bit":
                                            resultado = valorIntroducido * 8e+12;
                                            break;
                                        case "Byte":
                                            resultado = valorIntroducido * 1e+12;
                                            break;
                                        case "KiloByte":
                                            resultado = valorIntroducido * 1e+9;
                                            break;
                                        case "MegaByte":
                                            resultado = valorIntroducido * 1e+6;
                                            break;
                                        case "GigaByte":
                                            resultado = valorIntroducido * 1000;
                                            break;
                                        case "TeraByte":
                                            resultado = valorIntroducido;
                                            break;
                                    }
                                    break;
                            }
                    }

                    if (!tipoConversion.equals("Selecciona una opción")) {
                        DecimalFormat df = new DecimalFormat("#.####", DecimalFormatSymbols.getInstance(Locale.US));
                        String formattedResult = (resultado % 1 == 0) ?
                                String.valueOf((int) Math.round(resultado)) : df.format(resultado);
                        System.out.println(resultado);
                        System.out.println(formattedResult);
                        valorConvertido.setText(formattedResult);
                    }
                }
            }
        });
    }
}
