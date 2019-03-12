package com.example.estudosapp.erp.quizz

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.example.estudosapp.R
import com.example.estudosapp.erp.MainActivity
import java.util.*

class QuizzActivity : MainActivity() {

  private var list = Quizz.perguntas
  private var perguntaAtual = 0

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_quizz)

    clearPerguntas()
    setPerguntaAtual()

    Quizz.startTime = Date()
  }

  fun confirmarResposta(view: View) {
    val opcaoChecked = getOpcaoChecked()

    opcaoChecked["checked"] = true

    if (list.size - 1 == perguntaAtual) {
      Quizz.finishTime = Date()

      startActivity( Intent( this, QuizzResultadoActivity::class.java ) )

      finish()
    } else {
      perguntaAtual++
      setPerguntaAtual()
    }
  }

  //  private func

  private fun setPerguntaAtual() {
    val pergunta = getPerguntaAtual()

    getCampoPergunta().text = pergunta["pergunta"].toString()

    val opcoes = getOpcoes(pergunta)

    var hasChecked = false
    opcoes.forEach {
      val campoOpcao = getCampoOpcao(opcoes.indexOf(it))

      hasChecked = hasChecked || campoOpcao.isChecked
      campoOpcao.isChecked = false
      campoOpcao.text = it["label"].toString()
    }

    if (!hasChecked) { return }
    findViewById<RadioGroup>(R.id.quizzOpcaoGroup).clearCheck()
  }

  private fun getOpcoes(pergunta: MutableMap<String, Any> = getPerguntaAtual()) : List<MutableMap<String, Any>> {
    return pergunta["opcoes"] as List<MutableMap<String, Any>>
  }

  private fun getPerguntaAtual() :  MutableMap<String, Any> {
    return getPergunta(perguntaAtual)
  }

  private fun getPergunta(idx: Int) : MutableMap<String, Any> {
    return list[idx]
  }

  private fun getCampoOpcao(posicaoOpcao: Int) : RadioButton {
    val identifierId = "quizzOpcao${ (posicaoOpcao + 65).toChar() }"
    return findViewById<RadioButton>( resources.getIdentifier(identifierId, "id", packageName ) ) as RadioButton
  }

  private fun getCampoPergunta() : TextView {
    return findViewById<TextView>(R.id.quizzPergunta) as TextView
  }

  private fun getOpcaoChecked() : MutableMap<String, Any> {
    val chekedId = findViewById<RadioGroup>(R.id.quizzOpcaoGroup).checkedRadioButtonId
    val radeioChecked = findViewById<RadioButton>(chekedId)

    val idText = resources.getResourceName(radeioChecked.id).toString()

    val opcaoText = idText.split(Regex("/quizzOpcao")).last().toString()

    return getOpcoes()[ opcaoText.toCharArray().first().toInt() - 65 ]
  }

  private fun clearPerguntas() {
    perguntaAtual = 0

    list.forEach {
      val opcoes = getOpcoes(it)

      opcoes.forEach {
        it.remove("checked")
      }
    }
  }
}
