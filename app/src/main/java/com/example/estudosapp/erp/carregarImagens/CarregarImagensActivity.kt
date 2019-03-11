package com.example.estudosapp.erp.carregarImagens

import android.app.AlertDialog
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.estudosapp.R
import com.example.estudosapp.erp.MainActivity
import java.io.InputStream
import java.net.URL

class CarregarImagensActivity : MainActivity() {

  private val URL_IMAGE = "https://upload.wikimedia.org/wikipedia/pt/thumb/6/6f/Donald.png/220px-Donald.png"

  var viewImage: ImageView? = null

  var mainContext = this

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_carregar_imagens)

    viewImage = findViewById(R.id.carregar_imagens_image_view)
  }

  fun carregarImagem(view: View) {
    val imagemDownloader = ImagemDownloader()
    imagemDownloader.execute(URL_IMAGE)
  }

  inner class ImagemDownloader : AsyncTask<String, String, Bitmap>() {
    var alerta = AlertDialog.Builder(mainContext).setMessage("Carregando Imagem...").show()

    override fun doInBackground(vararg args: String?): Bitmap {
      return BitmapFactory.decodeStream( URL(args[0]).content as InputStream )
    }

    override fun onPostExecute(result: Bitmap?) {
      if (result == null) { return }
      viewImage?.setImageBitmap(result)
      alerta.hide()
    }
  }
}
