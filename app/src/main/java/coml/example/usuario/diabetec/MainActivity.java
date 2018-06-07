package coml.example.usuario.diabetec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rellay_config, rellay_registros, rellay_comidas, rellay_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rellay_info = findViewById(R.id.rellay_info);
        rellay_comidas = findViewById(R.id.rellay_comidas);
        rellay_registros = findViewById(R.id.rellay_registros);
        rellay_config = findViewById(R.id.rellay_config);

        rellay_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), RegistroActivity.class);
                it.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(it);
            }
        });

        rellay_comidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), RegistroActivity.class);
                it.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(it);
            }
        });
        rellay_registros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), RegistroActivity.class);
                it.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(it);
            }
        });
        rellay_config.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), RegistroActivity.class);
                it.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(it);
            }
        });


    }
}
