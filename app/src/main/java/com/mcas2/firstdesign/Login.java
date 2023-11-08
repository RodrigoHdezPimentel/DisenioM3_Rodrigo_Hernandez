package com.mcas2.firstdesign;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView olvideContrasena = findViewById(R.id.olvideContrasena);
        SpannableString mitextoU = new SpannableString("Olvidé mi contraseña");
        mitextoU.setSpan(new UnderlineSpan(), 0, mitextoU.length(), 0);
        olvideContrasena.setText(mitextoU);
    }
}