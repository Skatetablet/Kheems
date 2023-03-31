package mx.itson.kheems

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import mx.itson.kheems.adapter.JugadorAdapter
import mx.itson.kheems.entidades.Jugador

class JugadorListActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var ganadorAdaptador: JugadorAdapter
    private lateinit var listaPartidas: ArrayList<Jugador>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabla_jugadores)
        listView = findViewById(R.id.listView)

        listaPartidas = Jugador().obtenerTodos(applicationContext)

        ganadorAdaptador = JugadorAdapter(listaPartidas)
        listView.adapter = ganadorAdaptador
    }
}