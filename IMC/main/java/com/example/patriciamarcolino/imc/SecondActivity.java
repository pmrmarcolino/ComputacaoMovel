package com.example.patriciamarcolino.imc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.DecimalFormat;

/**
 * Created by patricia.marcolino on 08/05/2017.
 */

public class SecondActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        Bundle bundle = getIntent().getExtras();

        double imc = bundle.getDouble("imc");

        DecimalFormat formato = new DecimalFormat("#.##");

        TextView tvImc = (TextView) findViewById(R.id.tvImc);
        ImageView gif ;

        if(imc < 17){
            gif = (ImageView) findViewById(R.id.muitoabaixo);
            tvImc.setText("Muito abaixo do peso: "+String.valueOf(Double.valueOf(formato.format(imc))));
            Glide.with(this)
                    .load(R.drawable.muitoabaixo)
                    .asGif()
                    .into(gif);
        }
        if(imc >= 17 && imc < 19){
            gif = (ImageView) findViewById(R.id.abaixo);
            tvImc.setText("Abaixo do peso: "+String.valueOf(Double.valueOf(formato.format(imc))));
            Glide.with(this)
                    .load(R.drawable.abaixo)
                    .asGif()
                    .into(gif);

        }
        if(imc >= 19 && imc < 25){
            gif = (ImageView) findViewById(R.id.normal);
            tvImc.setText("Peso normal: "+String.valueOf(Double.valueOf(formato.format(imc))));
            Glide.with(this)
                    .load(R.drawable.normal)
                    .asGif()
                    .into(gif);
        }
        if(imc >= 25 && imc < 30){
            gif = (ImageView) findViewById(R.id.acima);
            tvImc.setText("Acima do peso: "+String.valueOf(Double.valueOf(formato.format(imc))));
            Glide.with(this)
                    .load(R.drawable.acima)
                    .asGif()
                    .into(gif);

        }
        if(imc >= 30 && imc < 35){
            gif = (ImageView) findViewById(R.id.obesidade1);
            tvImc.setText("Obesidade 1: "+String.valueOf(Double.valueOf(formato.format(imc))));
            Glide.with(this)
                    .load(R.drawable.obesidade1)
                    .asGif()
                    .into(gif);

        }
        if(imc >= 34 && imc < 40){
            gif = (ImageView) findViewById(R.id.obesidade2);
            tvImc.setText("Obesidade 2: "+String.valueOf(Double.valueOf(formato.format(imc))));
            Glide.with(this)
                    .load(R.drawable.obesidade2)
                    .asGif()
                    .into(gif);
        }
        if(imc >= 40){
            gif = (ImageView) findViewById(R.id.obesidade3);
            tvImc.setText("Obesidade 3: "+String.valueOf(Double.valueOf(formato.format(imc))));
            Glide.with(this)
                    .load(R.drawable.obesidade3)
                    .asGif()
                    .into(gif);
        }
        Button ok = (Button) findViewById(R.id.ok);

        ok.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){

                        Intent voltar = new Intent(SecondActivity.this, com.example.patriciamarcolino.imc.MainActivity.class);
                        startActivity(voltar);
                    }}
        );

    }
}
