package com.mcas2.firstdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView olvideContrasena = findViewById(R.id.olvideContrasena);
        SpannableString ForgotPassword = new SpannableString("Olvidé mi contraseña");
        ForgotPassword.setSpan(new UnderlineSpan(), 0, ForgotPassword.length(), 0);
        olvideContrasena.setText(ForgotPassword);

        ImageView img = findViewById(R.id.background);
        img.setAlpha(0.1f);
        Glide.with(this)
                .load("https://images.unsplash.com/photo-1533240332313-0db49b459ad6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1974&q=80")
                .centerCrop()
                .into(img);
    }
}