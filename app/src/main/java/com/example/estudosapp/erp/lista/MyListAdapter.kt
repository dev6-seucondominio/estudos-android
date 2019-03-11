package com.example.estudosapp.erp.lista

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.estudosapp.R

class MyListAdapter(private var activity: Activity, private var items: ArrayList<ItemList>) : BaseAdapter() {

    private class ViewHolder(row: View?) {
        var imagemIcone : ImageView? = null
        var nomePersonagem : TextView? = null
        var descricaoPersonagem : TextView? = null

        init {
            this.imagemIcone         = row?.findViewById(R.id.imagemIcone)    as ImageView
            this.nomePersonagem      = row.findViewById(R.id.usandoSqLiteNome)      as TextView
            this.descricaoPersonagem = row.findViewById(R.id.textoDescricao) as TextView
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup) : View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            val inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.activity_lista_minha_celula, null)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var emp = getItem(position)
        viewHolder.imagemIcone?.setImageResource(emp.icone)
        viewHolder.nomePersonagem?.text = emp.nome
        viewHolder.descricaoPersonagem?.text = emp.descricao

        return view
    }

    override fun getItem(i: Int): ItemList {
        return items[i]
    }
    override fun getItemId(i: Int): Long {
        return i.toLong()
    }
    override fun getCount(): Int {
        return items.size
    }
}
