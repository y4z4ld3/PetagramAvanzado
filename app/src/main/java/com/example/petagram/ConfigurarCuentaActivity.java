package com.example.petagram;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.petagram.restApi.ConstantesRestApi;

import java.util.Objects;

public class ConfigurarCuentaActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar_cuenta);

        androidx.appcompat.widget.Toolbar miActionBar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_huella);
    }

    public void btnGuadarCuenta(View view){
        EditText cuentaInstragram = (EditText)findViewById(R.id.edtxt_cuenta_usuario);
        if (cuentaInstragram.getText().toString().charAt(0) !='@'){
            Toast.makeText(ConfigurarCuentaActivity.this, getResources().getString(R.string.msgCuentaErrada), Toast.LENGTH_SHORT).show();
        }
        else{
            switch (cuentaInstragram.getText().toString()){
                case "@petagrmapp":
                    ConstantesRestApi.gUserId = ConstantesRestApi.USER_ID;
                    ConstantesRestApi.gToken = ConstantesRestApi.ACCEES_TOKEN_IG;
                    Toast.makeText(ConfigurarCuentaActivity.this, getResources().getString(R.string.msgCuentaGuardada), Toast.LENGTH_SHORT).show();
                break;
                default:
                    Toast.makeText(ConfigurarCuentaActivity.this, getResources().getString(R.string.msgCuentaNoAceptada), Toast.LENGTH_SHORT).show();
            }
        }
        cuentaInstragram.getText().clear();
    }
}