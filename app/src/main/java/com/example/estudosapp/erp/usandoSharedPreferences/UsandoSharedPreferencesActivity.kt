package com.example.estudosapp.erp.usandoSharedPreferences

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.estudosapp.R
import com.example.estudosapp.erp.MainActivity

class UsandoSharedPreferencesActivity : MainActivity() {

    private var botaoSalvar: Button? = null
    private var textoNome: TextView? = null
    private var campoNome: EditText? = null
    private var campoIdade: EditText? = null

    private val MINHAS_PREFERENCIAS = "Minhas Preferencias"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usando_shared_preferences_main)

        botaoSalvar = findViewById(R.id.botaoSalvar)
        textoNome = findViewById(R.id.usandoSqLiteNome)
        campoNome = findViewById(R.id.campoNome)
        campoIdade = findViewById(R.id.campoIdade)

        setPreferencesData()
    }

    fun salvar(view: View) {
        var sharedPreferences = getSharedPreferences(MINHAS_PREFERENCIAS, 0)
        var editor = sharedPreferences.edit()

        editor.putString("nome", campoNome?.text.toString())
        editor.putInt("idade", Integer.parseInt(campoIdade?.text.toString()))

        editor.apply()

        setPreferencesData()
    }

    fun setPreferencesData() {
        var sharedPreferences = getSharedPreferences(MINHAS_PREFERENCIAS, 0)

        if (!sharedPreferences.contains("nome")) { return }

        var nome = sharedPreferences.getString("nome", "")
        campoNome?.setText(nome)

        var idade = sharedPreferences.getInt("idade", 0).toString()
        campoIdade?.setText(idade)

        var newText = "Nome: ${nome}\nIdade: ${idade}"
        textoNome?.text = newText

    }
}
