package com.example.estudosapp.erp.quizz

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class QuizzResultadoDb(context: Context?) : QuizzDbHandler(context, TABLE_NAME) {
  companion object {
    private var TABLE_NAME = "quizz_resultados"
    private val KEY_ID = "id"
    private val KEY_NAME = "nome"
    private val KEY_PONTUACAO = "pontuacao"
  }

  override fun onCreate(db: SQLiteDatabase?) {
    val sqlText ="CREATE TABLE $TABLE_NAME ($KEY_ID INTEGER PRIMARY KEY AUTOINCREMENT, $KEY_NAME VARCHAR, $KEY_PONTUACAO DECIMAL)"
    db?.execSQL(sqlText)
  }

  fun insert(obj: QuizzResultado) {
    // get the Data Repository in write mode
    val db = writableDatabase

    // Create a new map of values, where column names are the keys
    val cValues = ContentValues()

    cValues.put(KEY_NAME, obj.name)
    cValues.put(KEY_PONTUACAO, obj.pontuacao)

    // Insert the new row
    db.insert(TABLE_NAME, null, cValues)
    db.close()
  }

  fun all() : ArrayList<QuizzResultado> {
    // get the Data Repository in read mode
    var db = readableDatabase

    val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME ORDER BY $KEY_PONTUACAO DESC", null) as Cursor

    val indice = HashMap<String, Any>()

    indice[KEY_NAME] = cursor.getColumnIndex(KEY_NAME)
    indice[KEY_PONTUACAO] = cursor.getColumnIndex(KEY_PONTUACAO)

    val result = ArrayList<QuizzResultado>()
    while(cursor.moveToNext()){
      val item = QuizzResultado()

      item.id   = cursor.getString(cursor.getColumnIndex(KEY_ID)).toInt()
      item.name = cursor.getString(cursor.getColumnIndex(KEY_NAME))
      item.pontuacao = cursor.getString(cursor.getColumnIndex(KEY_PONTUACAO)).toInt()

      result.add(item)
    }

    return result
  }
}
