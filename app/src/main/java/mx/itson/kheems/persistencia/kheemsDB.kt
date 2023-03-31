package mx.itson.kheems.persistencia

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class kheemsDB(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int): SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase) {
        try {

            db.execSQL("CREATE TABLE ganadores(id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT,fecha TEXT, puntos INT, partidas INT)")


        }catch (ex:Exception){
            Log.e("error",ex.toString())


        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}