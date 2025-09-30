package cl.unab.rviewkotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val recyclerView = findViewById<RecyclerView>(R.id.rview)

        // Lista de ejemplo
        val personas = listOf(
            Persona("Ana", 25, "Ingeniera", true),
            Persona("Luis", 30, "Abogado", false ),
            Persona("María", 22, "Diseñadora", true),
            Persona("Pedro", 28, "Médico", false),
            Persona("Sofía", 35, "Arquitecta",true)
        )

        // Configurar RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PersonaAdapter(personas)
    }
}