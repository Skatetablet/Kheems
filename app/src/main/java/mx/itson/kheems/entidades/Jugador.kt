package mx.itson.kheems.entidades

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import mx.itson.kheems.persistencia.kheemsDB
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Jugador {
    var id = 0
    var nombre : String? = null
    var fecha : String? = null
    var puntos : Int = 0
    var partidas : Int = 0
    constructor()

    constructor(nombre: String,fecha:String,puntos: Int,partidas: Int){
        this.nombre = nombre
        this.fecha = fecha
        this.puntos = puntos
        this.partidas = partidas
    }
    fun guardar(context: Context, nombre: String, puntos: Int, partidas: Int) {
        try {
            val dateTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm:ss a"))
            val kheemsdb = kheemsDB(context,"Kheems",null,1)
            var baseDatos : SQLiteDatabase = kheemsdb.writableDatabase
            val valores = ContentValues()
            valores.put("nombre",nombre)
            valores.put("fecha",dateTime.toString())
            valores.put("puntos",puntos)
            valores.put("partidas",partidas)

            baseDatos.insert("ganadores", null,valores)
        } catch (ex: Exception){
            Log.e("Ocurrio un error al guardar", ex.toString())
        }
    }
    fun obtenerTodos(context: Context): ArrayList<Jugador>{
        val ganadores : MutableList<Jugador> = ArrayList()

        try {
            val kheemsdb = kheemsDB(context,"Kheems",null,1)
            val baseDatos : SQLiteDatabase = kheemsdb.readableDatabase
            val cursor = baseDatos.rawQuery("SELECT id,nombre,fecha,puntos,partidas FROM  ganadores  ORDER BY puntos,partidas,fecha ASC LIMIT 10",null)

            while (cursor.moveToNext()){
                val u = Jugador(cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getInt(4))

                ganadores.add(u)

            }


        } catch (ex: Exception){
            Log.e("Ocurrio un error al obtener usuarios", ex.toString())
        }

        return ganadores as ArrayList<Jugador>
    }
}