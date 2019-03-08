package com.example.estudosapp.erp.home

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.estudosapp.R

class HomeListAdapter(private var activity: Activity, private var items: ArrayList<HomeListItem>) : BaseAdapter() {

    private class ViewHolder(row: View?) {
        var label: TextView? = null

        init {
            this.label = row?.findViewById(R.id.menu_item_label)
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup) : View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            val inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.activity_home_list_item, null)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var emp = getItem(position)
        viewHolder.label?.text = emp.label

        return view
    }

    override fun getItem(i: Int): HomeListItem {
        return items[i]
    }
    override fun getItemId(i: Int): Long {
        return i.toLong()
    }
    override fun getCount(): Int {
        return items.size
    }

}