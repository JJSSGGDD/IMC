package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText peso, altura;
    private Button calcular, eliminar;
    private TextView imc, descripcion, pesoalturarecomendado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //cuando ingresa los datos de usuario
        peso = findViewById(R.id.txtpeso);
        altura = findViewById(R.id.txtaltura);
        calcular = findViewById(R.id.btncalcular);
        eliminar = findViewById(R.id.btneliminar);
        imc = findViewById(R.id.txtimc);
        descripcion = findViewById(R.id.txtdescripcion);
        pesoalturarecomendado = findViewById(R.id.txtideal);
    }
//haciendo las operaciones
        public void operar(View view) {
            double npeso = Double.parseDouble(peso.getText().toString());
            double naltura = Double.parseDouble(altura.getText().toString());
            double resultadoimc = npeso / (naltura * naltura);
//mostrar el resultado
            imc.setText("IMC: " + String.format("%.2f", resultadoimc)); //"%2.f" = para solo dos decimales
            //mostrar resultado en la descripcion
            if (resultadoimc < 18.5)
                descripcion.setText("Peso bajo");
             else if (resultadoimc >= 18.5 && resultadoimc <= 24.9)  //&& = funcion logica "y"
                descripcion.setText("Peso normal");
             else if (resultadoimc >= 25 && resultadoimc <= 29.9)  //&& = funcion logica "y"
                descripcion.setText("Sobrepeso");
            else if (resultadoimc >= 30 && resultadoimc <= 34.9) //&& = funcion logica "y"
                descripcion.setText("Obesidad I");
            else if (resultadoimc >= 35 && resultadoimc <= 39.9) //&& = funcion logica "y"
                descripcion.setText("Obesidad II");
            else if (resultadoimc >= 40 && resultadoimc <= 49.9) //&& = funcion logica "y"
                descripcion.setText("Obesidad III");
            else if (resultadoimc > 50) //&& = funcion logica "y"
                descripcion.setText("Obesidad IV");

        }

        public void borrar(View view){
        peso.setText("");
        altura.setText("");
        imc.setText("");
        descripcion.setText("");
        pesoalturarecomendado.setText("");
        }


}