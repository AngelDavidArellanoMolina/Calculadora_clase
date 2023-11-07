package com.example.calculadora_clase;

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
        mas_menos = findViewById(R.id.mas_menos);
        eliminarUltDigito = findViewById(R.id.eliminarUltDigit);

        calcular = findViewById(R.id.igual);

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

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Botón pulsado: ", calcular.getText().toString());
                valorConvertido.setText(valorInicial.getText());
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

    }
}
