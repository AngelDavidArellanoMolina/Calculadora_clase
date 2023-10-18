package com.example.calculadora_clase;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

        elegirConversion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tipoSeleccionado = (String) parent.getItemAtPosition(position);

                switch (Objects.requireNonNull(tipoSeleccionado)) {
                    case "Volumen":
                        unidadValorInicial.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, unidadesVolumen));
                        unidadValorConvertido.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, unidadesVolumen));
                        break;

                    case "Longitud":
                        unidadValorInicial.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, unidadesLongitud));
                        unidadValorConvertido.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, unidadesLongitud));
                        break;

                    case "Masa":
                        unidadValorInicial.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, unidadesMasa));
                        unidadValorConvertido.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, unidadesMasa));
                        break;

                    case "Velocidad":
                        unidadValorInicial.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, unidadesVelocidad));
                        unidadValorConvertido.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, unidadesVelocidad));
                        break;

                    case "Temperatura":
                        unidadValorInicial.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, unidadesTemperatura));
                        unidadValorConvertido.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, unidadesTemperatura));
                        break;

                    case "Presión":
                        unidadValorInicial.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, unidadesPresion));
                        unidadValorConvertido.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, unidadesPresion));
                        break;

                    case "Tamaño de Datos":
                        unidadValorInicial.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, unidadesTamañoDatos));
                        unidadValorConvertido.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, unidadesTamañoDatos));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Código para cuando no se selecciona nada
            }
        });

    }
}
