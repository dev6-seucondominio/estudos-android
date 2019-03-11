package com.example.estudosapp.erp.contadorPessoas

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.estudosapp.R
import com.example.estudosapp.erp.MainActivity

class ContadorPessoasActivity : MainActivity() {

    // init vars
    var numeroHomens = 0
    var numeroMulheres = 0
    var numeroPessoas = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contador_pessoas)

        // Atualizando total de homens e mulheres
        setTotalHomensMulheres()
    }

    private fun getTextView(id: Int) : TextView { return findViewById<TextView>(id) }

    fun setTotalHomensMulheres() {
        numeroPessoas = numeroHomens + numeroMulheres

        var newTextValue = getString(R.string.pessoas_label, numeroPessoas)
        getTextView(R.id.pessoas_label).setText( newTextValue )
    }

    fun reset(view: View) {
        numeroHomens = 0
        getTextView(R.id.pessoas_homens_count).setText(numeroHomens.toString())

        numeroMulheres = 0
        getTextView(R.id.pessoas_mulheres_count).setText(numeroMulheres.toString())

        setTotalHomensMulheres()
    }

    fun contarHomens(view: View) {
        numeroHomens++
        getTextView(R.id.pessoas_homens_count).setText(numeroHomens.toString())

        setTotalHomensMulheres()
    }

    fun contarMulheres(view: View) {
        numeroMulheres++
        getTextView(R.id.pessoas_mulheres_count).setText(numeroMulheres.toString())

        setTotalHomensMulheres()
    }
}
