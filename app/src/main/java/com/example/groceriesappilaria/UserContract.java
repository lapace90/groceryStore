package com.example.groceriesappilaria;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class UserContract extends SQLiteOpenHelper {
    public static final String BASE_NOM = "Users.db";
    public static final int BASE_VERSION = 4;
    public static final String NOM_TABLE = "T_Users";
    public static final String COL0 = "IdClient";
    public static final String COL1 = "Email";
    public static final String COL2 = "Password";

    public static final String COL3 = "UserName";


    public UserContract(Context context) {
        super(context, BASE_NOM, null, BASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String strSql = "CREATE TABLE " + NOM_TABLE +
                " ("
                + COL0 + " integer primary key autoincrement,"
                + COL1 + " text not null,"
                + COL2 + " text not null,"
                + COL3 + " text not null);";

        Log.d("DataBase", "strSql" + strSql);
        db.execSQL(strSql);
        Log.d("DataBase", "La tua Banca Dati é stata creata correttamente." + NOM_TABLE);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("DataBase", "oldVersion: " + oldVersion);
        Log.d("DataBase", "newVersion: " + newVersion);
        String strSql = "DROP TABLE IF EXISTS " + NOM_TABLE + ";";
        Log.d("DataBase", "Richiesta di Aggiornamento sql : " + strSql);
        db.execSQL(strSql);
        onCreate(db);
        Log.d("DataBase", "Method Upgrade Call: " + NOM_TABLE);
    }

    public void insertionCLIENTS(String Email, String Password, String UserName) {
        Email = Email.replace("'", " ");
        Password = Password.replace("'", " ");
        String strSql = "INSERT INTO " + NOM_TABLE + "(" +COL1 + "," +COL2 + ", " +COL3 + ")" + "values ('" + Email + "','" + Password + "','" + UserName +"');";
        Log.d("DataBase", "StrSql insert: " +strSql);
        getWritableDatabase().execSQL(strSql);
        Log.d("DataBase", "Clienti inseriti con successo!");
    }

    public Cursor readTable() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor myCursor = db.rawQuery("select * from " + NOM_TABLE, null);
        return myCursor;


    }


}

