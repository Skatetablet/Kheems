package mx.itson.kheems

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var ubicacion = 0
    var contador = 0
    var puntos = 0
    var partidas = 1

    var destapadas = IntArray(12)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnReiniciar = findViewById<Button>(R.id.btnReiniciar)
        btnReiniciar.setOnClickListener(this)
        val btnPartidas = findViewById<Button>(R.id.btnLista)
        btnPartidas.setOnClickListener(this)
        for (i in 1..12) {
            var btnSeleccion = findViewById<ImageButton>(
                resources.getIdentifier("opcion$i", "id", this.packageName)
            )
            btnSeleccion.setOnClickListener(this)
        }
        iniciar()
    }

    fun iniciar() {
        findViewById<View>(R.id.opcion1).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion2).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion3).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion4).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion5).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion6).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion7).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion8).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion9).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion10).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion11).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion12).setBackgroundResource(R.drawable.icon_pregunta)
        val random = Random()
        ubicacion = random.nextInt(11)+1
        contador = 0
        destapadas = IntArray(12)
    }
    fun destapar(opcion: Int) {
        if (opcion == ubicacion) {
            partidas++
            Toast.makeText(this, "!PERMDISTE¡", Toast.LENGTH_SHORT).show()
            for (i in 1..12) {
                var btnSeleccion = findViewById<ImageButton>(
                    resources.getIdentifier(
                        "opcion$i", "id", this.packageName
                    )
                )
                if (i == opcion) {
                    btnSeleccion.setBackgroundResource(R.drawable.icon_cheems_llora)

                } else {
                    btnSeleccion.setBackgroundResource(R.drawable.icon_cheems)
                }
            }
        } else {

            var btnSeleccion = findViewById<View>(
                resources.getIdentifier("opcion$opcion", "id", this.packageName)
            ) as ImageButton
            btnSeleccion.setBackgroundResource(R.drawable.icon_cheems)
            contador++
            puntos++
            if (contador == 5) {

                var btngGanador = findViewById<ImageButton>(
                    resources.getIdentifier("opcion$ubicacion", "id", this.packageName)
                )
                btngGanador.setBackgroundResource(R.drawable.cheems_win)
                Toast.makeText(this, "!GAMNASTE¡", Toast.LENGTH_SHORT).show()
                val intentJugadorFormActivity = Intent(this, JugadorFormActivity::class.java).apply {
                    putExtra("partidas",partidas)
                    putExtra("puntos",puntos)

                }
                startActivity(intentJugadorFormActivity)

            }
        }
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btnLista) {
            val intentListActivity = Intent(this, JugadorListActivity::class.java)
            startActivity(intentListActivity)
        }
        if (v?.id == R.id.opcion1) {
            if (destapadas.get(0) != 1) {
                destapar(1)
                destapadas.set(0,1)
            }
        } else if (v?.id == R.id.opcion2) {
            if (destapadas.get(1) != 1) {
                destapar(2)
                destapadas.set(1,1)
            }
        } else if (v?.id == R.id.opcion3) {
            if (destapadas.get(2) != 1) {
                destapar(3)
                destapadas.set(2,1)
            }
        } else if (v?.id == R.id.opcion4) {
            if (destapadas.get(3) != 1) {
                destapar(4)
                destapadas.set(3,1)
            }
        } else if (v?.id == R.id.opcion5) {
            if (destapadas.get(4) != 1) {
                destapar(5)
                destapadas.set(4,1)
            }
        } else if (v?.id == R.id.opcion6) {
            if (destapadas.get(5) != 1) {
                destapar(6)
                destapadas.set(5,1)
            }
        }
        if (v?.id == R.id.opcion7) {
            if (destapadas.get(6) != 1) {
                destapar(7)
                destapadas.set(6,1)
            }
        } else if (v?.id == R.id.opcion8) {
            if (destapadas.get(7) != 1) {
                destapar(8)
                destapadas.set(7,1)
            }
        } else if (v?.id == R.id.opcion9) {
            if (destapadas.get(8) != 1) {
                destapar(9)
                destapadas.set(8,1)
            }
        } else if (v?.id == R.id.opcion10) {
            if (destapadas.get(9) != 1) {
                destapar(10)
                destapadas.set(9,1)
            }
        } else if (v?.id == R.id.opcion11) {
            if (destapadas.get(10) != 1) {
                destapar(11)
                destapadas.set(10,1)
            }
        } else if (v?.id == R.id.opcion12) {
            if (destapadas.get(11) != 1) {
                destapar(12)
                destapadas.set(11,1)
            }
        } else if (v?.id == R.id.btnReiniciar) {
            iniciar()
        }

    }
}