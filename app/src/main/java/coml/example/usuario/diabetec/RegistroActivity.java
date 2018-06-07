package coml.example.usuario.diabetec;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class RegistroActivity extends AppCompatActivity {

    EditText edtGlucosa;
    Button btnRegistrar, btnLista;
    Calendar calendar;
    String Date;
    SimpleDateFormat simpleDateFormat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        edtGlucosa = (EditText)findViewById(R.id.edtGlucosa);
        btnRegistrar = (Button)findViewById(R.id.btnRegistrar);
        btnLista = (Button)findViewById(R.id.btnLista);


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbAlta();
            }
        });

        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), ListaActivity.class);
                startActivity(it);
            }
        });
    }

    private void dbAlta(){
        //Variables para agregar a la DB
        String strCalendar, strGlucosa;
        simpleDateFormat = new SimpleDateFormat("dd-MM-yy HH:mm");
        calendar=Calendar.getInstance();
        Date = simpleDateFormat.format(calendar.getTime());
        strGlucosa = edtGlucosa.getText().toString();
        strCalendar = Date;

        dbClass dbGlucosa = new dbClass(getApplicationContext(),"glucosa", null, 1);
        SQLiteDatabase sqlDB = dbGlucosa.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("idGlucosa", strGlucosa);
        registro.put("strCalendar", strCalendar);
        // los inserto en la base de datos
        sqlDB.insert("tbRegistro", null, registro);
        sqlDB.close();
        // ponemos los campos a vacío para insertar el siguiente usuario
        edtGlucosa.setText("");

        Toast.makeText(getApplicationContext(),"Datos Registrados", Toast.LENGTH_SHORT).show();
    }


}
