package com.mcas2.firstdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText user = findViewById(R.id.user);
        EditText password = findViewById(R.id.password);
        CheckBox remember = findViewById(R.id.recuerdame);

        TextView olvideContrasena = findViewById(R.id.olvideContrasena);
        SpannableString ForgotPassword = new SpannableString("Olvidé mi contraseña");
        ForgotPassword.setSpan(new UnderlineSpan(), 0, ForgotPassword.length(), 0);
        olvideContrasena.setText(ForgotPassword);
        olvideContrasena.setOnClickListener(view -> {
            View alertDialog = LayoutInflater.from(this).inflate(R.layout.dialog_forgot_password, null, false);

            new AlertDialog.Builder(this)
                        .setTitle("¿Olvidaste tu contarseña?")
                        .setMessage("Aqui puedes recuperarla")
                        .setView(alertDialog)
                        .setPositiveButton("Aceptar", null)
                        .setNegativeButton("Cancelar",null)
                        .setIcon(R.drawable.huella)
                        .create()
                        .show();

            });


        ImageView img = findViewById(R.id.background);
        img.setAlpha(0.1f);
        Glide.with(this)
                .load("https://images.unsplash.com/photo-1544653221-81df644ed75f?q=80&w=1854&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
                .centerCrop()
                .into(img);

        Button logIn = findViewById(R.id.login);
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
                    ImageView huella = findViewById(R.id.logoLogin);
                    Animation DenyAnim = AnimationUtils.loadAnimation(Login.this, R.anim.deny);
                    huella.startAnimation(DenyAnim);
                }else{
                    if(!remember.isChecked()){
                        AlertDialog.Builder builderDatos = new AlertDialog.Builder(Login.this);
                        builderDatos.setMessage("¿Quieres guardar la contraseña?")
                                .setCancelable(false)
                                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Toast.makeText(Login.this, "Contarseña guardada", Toast.LENGTH_LONG).show();
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Toast.makeText(Login.this, "No has guardado tu contraseña", Toast.LENGTH_SHORT).show();
                                    }
                                });
                        builderDatos.create();
                        builderDatos.show();
                    }else{
                        Toast.makeText(Login.this, "Contraseña guardada", Toast.LENGTH_SHORT).show();
                    }
                }
                user.setText("");
                password.setText("");
            }


        });
        TextView copy = findViewById(R.id.copyRight);
        copy.setText("Hikers by Rodrigo Hernández\n");
    }
}