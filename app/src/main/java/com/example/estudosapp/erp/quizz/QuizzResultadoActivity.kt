package com.example.estudosapp.erp.quizz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.estudosapp.R
import com.example.estudosapp.erp.MainActivity
import org.w3c.dom.Text
import java.util.concurrent.TimeUnit

class QuizzResultadoActivity : MainActivity() {

  private var baseDb = QuizzResultadoDb(this)
  private var totalAcerto = 0

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_quizz_resultado)

    setResultado()
  }

  fun salvarResultado(view: View) {
    val item = QuizzResultado()

    item.name = findViewById<EditText>(R.id.quizzResultadoNome).text.toString()
    item.pontuacao = getPontuacao()

    baseDb.insert(item)

    cancelar(view)
  }

  fun cancelar(view: View) {
    startActivity(Intent(this, QuizzHomeActivity::class.java))
    finish()
  }

  private fun setResultado() {
    val list = Quizz.perguntas

    list.forEach {
      val opcoes = it["opcoes"] as List<MutableMap<String, Any>>

      opcoes.forEach {
        if (it["checked"] == true && it["correta"] == true) { totalAcerto++ }
      }
    }

    val resultText = "Você acertou $totalAcerto perguntas de ${list.size}"

    findViewById<TextView>(R.id.quizzResultadoText).text = resultText
    findViewById<TextView>(R.id.quizzResultadoPontuacao).text = getString(R.string.quizzResultadoPontuacao, getPontuacao())
  }

  private fun getPontuacao() : Int {
    val duration = TimeUnit.MILLISECONDS.toSeconds(Quizz.startTime!!.time - Quizz.finishTime!!.time)
    return ((totalAcerto * 10) + (duration / 1000f)).toInt()
  }
}
