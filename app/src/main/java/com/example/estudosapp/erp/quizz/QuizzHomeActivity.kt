package com.example.estudosapp.erp.quizz

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.view.View
import android.widget.ListView
import com.example.estudosapp.R
import com.example.estudosapp.erp.MainActivity

class QuizzHomeActivity : MainActivity() {

  private var resultadoDb = QuizzResultadoDb(this)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_quizz_home)

    setResultados()
  }

  fun play(view: View) {
    startActivity(Intent(this, QuizzActivity::class.java))
  }

  fun exit(view: View) {
    finish()
  }

  // private

  private fun setResultados() {
    val list = resultadoDb.all()
    val listVew = findViewById<ListView>(R.id.quizzHomeResultadoList)

    if (list.isEmpty()) {
      val item = QuizzResultado()

      item.name = "Nenhuma pontuação cadastrada !"
      item.emptyItem = true

      list.add(item)
    }

    listVew.adapter = QuizzResultadoAdapter(this, list )
  }
}
