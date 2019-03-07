package com.example.estudosapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.estudosapp.contador_pessoas.ContadorPessoas
import com.example.estudosapp.lista.ListaMainActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openVariaveisLista( findViewById(R.id.app_variavies_lista_btn) )
    }

    fun openContadorPessoas(view: View) {
        val intent = Intent(this, ContadorPessoas::class.java)

        // Start the new activity.contarHomens
        startActivity(intent)
    }

    fun openVariaveisLista(view: View) {
        val intent = Intent(this,  ListaMainActivity::class.java)

        // Start the new activity.
        startActivity(intent)
    }
}
