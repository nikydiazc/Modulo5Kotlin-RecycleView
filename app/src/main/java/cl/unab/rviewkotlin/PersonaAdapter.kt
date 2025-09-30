package cl.unab.rviewkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//conector entre tus datos y el RecyclerView.
class PersonaAdapter(private val lista: List<Persona>) : RecyclerView.Adapter<PersonaAdapter.PersonaViewHolder>() {


    //caja que guarda las vistas de cada fila.
    class PersonaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPersona: ImageView = itemView.findViewById(R.id.imageView)
        val txtNombre: TextView = itemView.findViewById(R.id.txtNombre)
        val txtEdad: TextView = itemView.findViewById(R.id.txtEdad)
        val txt3: TextView = itemView.findViewById(R.id.txt3)

    }

    //crea la vista de un ítem.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_persona, parent, false)
        return PersonaViewHolder(view)
    }

    //llena la vista con datos. es mi [for]
    override fun onBindViewHolder(holder: PersonaViewHolder, position: Int) {
        val persona = lista[position]
        holder.imgPersona.setImageResource(R.drawable.man)
        holder.txtNombre.text = persona.nombre
        holder.txtEdad.text = "Edad: ${persona.edad}"
        holder.txt3.text = persona.ocupacion
    }

    //obligatorio debido a la abstraccion y nos permite ver el tamaño de la lista.
    override fun getItemCount(): Int = lista.size


}