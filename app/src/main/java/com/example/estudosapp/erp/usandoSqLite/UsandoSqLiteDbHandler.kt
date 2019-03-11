package com.example.estudosapp.erp.usandoSqLite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class UsandoSqLiteDbHandler(context: Context?) : SQLiteOpenHelper(context, TABLE_NAME, null, 1) {
  companion object {
    private val TABLE_NAME = "usando_sq_lites"
    private val KEY_ID = "id"
    private val KEY_NAME = "name"
    private val KEY_AGE = "age"
  }

  override fun onCreate(db: SQLiteDatabase?) {
    val sqlText ="CREATE TABLE $TABLE_NAME ($KEY_ID INTEGER PRIMARY KEY AUTOINCREMENT, $KEY_NAME VARCHAR, $KEY_AGE INT (3))"
    db?.execSQL(sqlText)
  }

  override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    // Drop older table if exist
    db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
    // Create tables again
    onCreate(db)
  }

  fun insert(obj: UsandoSqlLite) {
    // get the Data Repository in write mode
    val db = writableDatabase

    // Create a new map of values, where column names are the keys
    val cValues = ContentValues()

    cValues.put(KEY_AGE,  obj.age )
    cValues.put(KEY_NAME, obj.name)

    // Insert the new row
    db.insert(TABLE_NAME, null, cValues)
    db.close()
  }

  fun all() : ArrayList<UsandoSqlLite> {
    // get the Data Repository in read mode
    var db = writableDatabase

    val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null) as Cursor

    val indice = HashMap<String, Any>()

    indice[KEY_NAME] = cursor.getColumnIndex(KEY_NAME)
    indice[KEY_AGE] = cursor.getColumnIndex(KEY_AGE)

    val result = ArrayList<UsandoSqlLite>()
    while(cursor.moveToNext()){
      val item = UsandoSqlLite()

      item.id   = cursor.getString(cursor.getColumnIndex(KEY_ID)).toInt()
      item.age  = cursor.getString(cursor.getColumnIndex(KEY_AGE)).toInt()
      item.name = cursor.getString(cursor.getColumnIndex(KEY_NAME))

      result.add(item)
    }

    return result
  }
}
