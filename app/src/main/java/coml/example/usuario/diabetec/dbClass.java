package coml.example.usuario.diabetec;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class dbClass extends SQLiteOpenHelper {
    public dbClass(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creamos la tabla de alumno
        /*tbAalumno     tabla
        -----------------------
        * PK|idCurp     |   texto
        *   |strNombre  |   Texto
        *   |strApat    |   Texto
        *   |strAmat    |   Texto
        * */
        db.execSQL("create table tbRegistro(" +
                "idGlucosa text primary key, " +
                "strCalendar text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        //Si existe la tabla la desechamos
        db.execSQL("drop table " +
                "if exists tbRegistro");

        //Volvemos a crear la tabla
        db.execSQL("create table tbRegistro(" +
                "idGlucosa text primary key, " +
                "strCalendar text)");
    }
}
