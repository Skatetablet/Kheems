package mx.itson.kheems

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import mx.itson.kheems.entidades.Jugador

class JugadorFormActivity : AppCompatActivity(), View.OnClickListener{
    lateinit var nombre : EditText
    var partidas : Int = 0
    var puntos : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jugador_form)
        val btnAgregar = findViewById<Button>(R.id.btnGuardar)
        btnAgregar.setOnClickListener(this)
        nombre = findViewById(R.id.txt_nombre)
        partidas = intent.getIntExtra("partida",0)
        puntos = intent.getIntExtra("puntos",0)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            (R.id.btnGuardar)->{
                try{
                    Jugador().guardar(applicationContext,nombre.text.toString(),puntos,partidas)
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }catch(ex : Exception){
                    Log.e("Error al agregar Jugador",ex.toString())
                }


            }
        }
    }
}