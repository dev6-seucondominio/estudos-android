package com.example.estudosapp.erp.usandoSqLite

import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.estudosapp.R
import com.example.estudosapp.erp.MainActivity

class UsandoSqLiteActivity : MainActivity() {

  private var baseDb = UsandoSqLiteDbHandler(this)

  private var botaoSalvar: Button? = null
  private var campoNome: EditText? = null
  private var campoIdade: EditText? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_usando_sq_lite_main)

    botaoSalvar = findViewById(R.id.botaoSalvar)
    campoNome = findViewById(R.id.campoNome)
    campoIdade = findViewById(R.id.campoIdade)

    setListContent()
  }

  fun cadastrar(view: View) {
    val item = UsandoSqlLite()

    val nome = campoNome?.text.toString()
    item.name = nome
    campoNome?.text = null

    val idade = campoIdade?.text.toString()
    if (idade != ""){ item.age = idade.toInt() }
    campoIdade?.text = null

    baseDb.insert(item)

    setListContent()
  }

  private fun setListContent() {
    val list = baseDb.all()

    val adapter = UsandoSqLiteAdapter(this, list)

    val listView = findViewById<ListView>(R.id.sq_lite_lista)
    listView.adapter = adapter
  }
}
