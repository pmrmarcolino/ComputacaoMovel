package com.example.patriciamarcolino.imc;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    EditText peso;
    EditText altura;
    Button calcular ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //exibe a tela de acordo com o layout(xml) passado, nesse caso activity_main
        calcular = (Button) findViewById(R.id.b_Calcular);
        peso = (EditText) findViewById(R.id.t_Peso);
        altura = (EditText) findViewById(R.id.t_Altura);


        calcular.setOnClickListener(
                new View.OnClickListener(){
                    Bundle bundle = new Bundle();
                    public void onClick(View v){
                        double p = Double.parseDouble(peso.getText().toString());
                        double a = Double.parseDouble(altura.getText().toString());

                        double imc;
                        try{
                            imc = p/(Math.pow(a,2));
                            Intent secondActivity = new Intent(MainActivity.this, SecondActivity.class);
                            bundle.putDouble("imc", imc);
                            secondActivity.putExtras(bundle);
                            startActivity(secondActivity);

                        }catch (Exception e){
                            e.getMessage();
                        }}});

    }
}
