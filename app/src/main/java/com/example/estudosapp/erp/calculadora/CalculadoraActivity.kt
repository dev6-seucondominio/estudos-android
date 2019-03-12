package com.example.estudosapp.erp.calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.estudosapp.R
import com.example.estudosapp.erp.MainActivity

class CalculadoraActivity : MainActivity() {

  private var numeroA = 0f
  private var operacao = ""
  private var resultado = 0f

  private var textoResultado: TextView? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_calculadora)

    textoResultado = findViewById(R.id.textoResultado)
  }

  fun executarOperacao(view: View) {
    when (view.id) {
      R.id.botaoLimpar -> {
        textoResultado!!.text = "0"
        numeroA = 0f
        resultado = 0f
        operacao = ""
      }
      R.id.botaoSomar -> { setOperacao("+") }
      R.id.botaoMultiplicacao -> { setOperacao("X") }
      R.id.botaoSubtracao -> { setOperacao("-") }
      R.id.botaoDivisao -> { setOperacao("%") }
      R.id.botaoResultado -> { aplicarOperacao() }
      else -> {
        val numbStr = (view as Button).text.toString()
        var str = textoResultado!!.text.toString()

        str = if (str == "0") numbStr else str + numbStr
        textoResultado!!.text = str
      }
    }
  }

  fun setOperacao(tipoOperacao: String) {
    numeroA = textoResultado!!.text.toString().toFloat()
    operacao = tipoOperacao
    textoResultado!!.text = "0"
  }

  fun aplicarOperacao() {
    val numeroB = textoResultado!!.text.toString().toFloat()

    resultado = when (operacao) {
      "+" -> { numeroA + numeroB }
      "-" -> { numeroA - numeroB }
      "X" -> { numeroA * numeroB }
      "%" -> { numeroA / numeroB }
      else -> { resultado }
    }

    operacao = ""
    textoResultado!!.text = resultado.toString()
  }
}
