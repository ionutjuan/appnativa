package net.iescm.abogadosapp.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import net.iescm.abogadosapp.data.AbogadosContract.AbogadoEntry;

/**
 * Manejador de la base de datos
 * Created by JoseMaria on 01/09/2016.
 */
public class AbogadosDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Abogados.db";

    public AbogadosDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + AbogadoEntry.TABLE_NAME + " ("
                + AbogadoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + AbogadoEntry.ID + " TEXT NOT NULL,"
                + AbogadoEntry.NAME + " TEXT NOT NULL,"
                + AbogadoEntry.SPECIALTY + " TEXT NOT NULL,"
                + AbogadoEntry.PHONE_NUMBER + " TEXT NOT NULL,"
                + AbogadoEntry.BIO + " TEXT NOT NULL,"
                + AbogadoEntry.AVATAR_URI + " TEXT,"
                + "UNIQUE (" + AbogadoEntry.ID + "))");

        // Insertar datos ficticios para prueba inicial
        datosFicticios(db);

    }

    private void datosFicticios(SQLiteDatabase sqLiteDatabase) {
        abogadoFicticio(sqLiteDatabase, new Abogado("Carlos Pérez", "Abogado penalista",
                "300 200 1111", "Gran profesional con experiencia de 5 años en casos penales.",
                "carlos_perez.jpg"));
        abogadoFicticio(sqLiteDatabase, new Abogado("Daniel Samper", "Abogado accidentes de tráfico",
                "300 200 2222", "Gran profesional con experiencia de 5 años en accidentes de tráfico.",
                "daniel_samper.jpg"));
        abogadoFicticio(sqLiteDatabase, new Abogado("Lucía Aristizabal", "Abogado de derechos " +
                "laborales",
                "300 200 3333", "Gran profesional con más de 3 años de experiencia en defensa de los trabajadores.",
                "lucia_aristizabal.jpg"));
        abogadoFicticio(sqLiteDatabase, new Abogado("Marina Acosta", "Abogado de familia",
                "300 200 4444", "Gran profesional con experiencia de 5 años en casos de familia.",
                "marina_acosta.jpg"));
        abogadoFicticio(sqLiteDatabase, new Abogado("Olga Ortiz", "Abogado de administración pública",
                "300 200 5555", "Gran profesional con experiencia de 5 años en casos en expedientes de urbanismo.",
                "olga_ortiz.jpg"));
        abogadoFicticio(sqLiteDatabase, new Abogado("Pamela Briger", "Abogado fiscalista",
                "300 200 6666", "Gran profesional con experiencia de 5 años en casos de derecho financiero",
                "pamela_briger.jpg"));
        abogadoFicticio(sqLiteDatabase, new Abogado("Rodrigo Benavides", "Abogado Mercantilista",
                "300 200 1111", "Gran profesional con experiencia de 5 años en redacción de contratos mercantiles",
                "rodrigo_benavidez.jpg"));
        abogadoFicticio(sqLiteDatabase, new Abogado("Tom Bonz", "Abogado penalista",
                "300 200 1111", "Gran profesional con experiencia de 5 años en casos penales.",
                "tom_bonz.jpg"));
    }

    public long abogadoFicticio(SQLiteDatabase db, Abogado abogado) {
        return db.insert(
                AbogadoEntry.TABLE_NAME,
                null,
                abogado.toContentValues());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // No hay operaciones
    }

    public long saveAbogado(Abogado abogado) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                AbogadoEntry.TABLE_NAME,
                null,
                abogado.toContentValues());

    }

    public Cursor getAllAbogados() {
        return getReadableDatabase()
                .query(
                        AbogadoEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

    public Cursor getAbogadoById(String abogadoId) {
        Cursor c = getReadableDatabase().query(
                AbogadoEntry.TABLE_NAME,
                null,
                AbogadoEntry.ID + " LIKE ?",
                new String[]{abogadoId},
                null,
                null,
                null);
        return c;
    }

    public int deleteAbogado(String abogadoId) {
        return getWritableDatabase().delete(
                AbogadoEntry.TABLE_NAME,
                AbogadoEntry.ID + " LIKE ?",
                new String[]{abogadoId});
    }

    public int updateAbogado(Abogado abogado, String abogadoId) {
        return getWritableDatabase().update(
                AbogadoEntry.TABLE_NAME,
                abogado.toContentValues(),
                AbogadoEntry.ID + " LIKE ?",
                new String[]{abogadoId}
        );
    }
}
