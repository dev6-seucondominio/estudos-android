package com.example.estudosapp.erp.quizz

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

abstract class QuizzDbHandler(context: Context?, tableName: String) : SQLiteOpenHelper(context, tableName, null, 1) {
  companion object {
    private var TABLE_NAME = ""
  }

  override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    // Drop older table if exist
    db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
    // Create tables again
    onCreate(db)
  }
}
