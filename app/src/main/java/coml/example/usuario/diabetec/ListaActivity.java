package coml.example.usuario.diabetec;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<String> lista;
    ArrayAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        lv = (ListView) findViewById(R.id.lv);
        dbClass db = new dbClass(getApplicationContext(),null,null,1);
        lista = llenar_lv();
        adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,lista);
        lv.setAdapter(adaptador);

    }
    public ArrayList llenar_lv(){
        ArrayList<String> lista = new ArrayList<>();
        dbClass dbRegistro = new dbClass(getApplicationContext(), "glucosa", null, 1);
        SQLiteDatabase sqlDB = dbRegistro.getReadableDatabase();
        String q = "SELECT * FROM tbRegistro";
        Cursor registro = sqlDB.rawQuery(q,null);
        if(registro.moveToFirst()){
            do{
                lista.add(("     ")+registro.getString(1)+("                -            ")+registro.getString(0));

            }while(registro.moveToNext());
        }
        return lista;

    }
}
