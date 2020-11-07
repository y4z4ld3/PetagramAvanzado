package com.example.petagram;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.petagram.pojo.SendMail;

import java.util.Objects;


public class ContactoActivity extends AppCompatActivity {

    EditText edtxt_nombre;
    EditText edtxt_email;
    EditText edtxt_mensaje;
    Button btn_enviar;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        androidx.appcompat.widget.Toolbar miActionBar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_huella);

        edtxt_nombre = (EditText)findViewById(R.id.edtxt_nombre);
        edtxt_email = (EditText)findViewById(R.id.edtxt_email);
        edtxt_mensaje = (EditText)findViewById(R.id.edtxt_mensaje);
        btn_enviar  = (Button)findViewById(R.id.btn_enviar);


        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (
                        String.valueOf(edtxt_nombre.getText()).isEmpty() ||
                                String.valueOf(edtxt_nombre.getText()).equals("") ||
                                String.valueOf(edtxt_email.getText()).isEmpty() ||
                                String.valueOf(edtxt_email.getText()).equals("") ||
                                String.valueOf(edtxt_mensaje.getText()).isEmpty() ||
                                String.valueOf(edtxt_mensaje.getText()).equals("")
                )
                    Toast.makeText(ContactoActivity.this, getResources().getString(R.string.msgDatosFaltantes), Toast.LENGTH_SHORT).show();
                else {
                    sendEmail();
                }
            }
        });
    }

    private void sendEmail() {
        //Agregando contenido del  email
        String email = edtxt_email.getText().toString().trim();
        String subject = getResources().getString(R.string.mensaje_subject) + edtxt_nombre.getText().toString().trim();
        String message = edtxt_mensaje.getText().toString().trim();

        //Creando objeto SendMail
        SendMail sm = new SendMail(this, email, subject, message);

        //Ejecutando sendmail enviando email
        sm.execute();

        limpiarView();
    }

    /**/

    public void limpiarView()
    {
        edtxt_nombre.getText().clear();
        edtxt_email.getText().clear();
        edtxt_mensaje.getText().clear();
    }
}