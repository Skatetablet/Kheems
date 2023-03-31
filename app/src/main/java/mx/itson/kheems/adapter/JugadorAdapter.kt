package mx.itson.kheems.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import mx.itson.kheems.R
import mx.itson.kheems.entidades.Jugador

class JugadorAdapter(private val ganadores: ArrayList<Jugador>) : BaseAdapter() {
    override fun getCount(): Int {
        return ganadores.size
    }

    override fun getItem(position: Int): Any {
        return ganadores[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(parent?.context).inflate(R.layout.item_jugador, parent, false)
        }
        val nombreTextView = view?.findViewById<TextView>(R.id.txt_nombre)
        nombreTextView?.text = ganadores[position].nombre

        val puntosTextView = view?.findViewById<TextView>(R.id.txt_puntos)
        puntosTextView?.text = ganadores[position].puntos.toString()

        val partidasTextView = view?.findViewById<TextView>(R.id.txt_partidas)
        partidasTextView?.text = ganadores[position].partidas.toString()
        val fechaTextView = view?.findViewById<TextView>(R.id.txt_fecha)
        fechaTextView?.text = ganadores[position].fecha

        return view!!
    }
}