package com.example.alarm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView

class TimeAdapter (val mCtx: Context, val resources: Int, val items: ArrayList<TimeModel>):
    ArrayAdapter<TimeModel>(mCtx, resources, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(resources, null)

        //set data
        val time: TextView = view.findViewById(R.id.time)
        val message: TextView = view.findViewById(R.id.message)
//        val active: Switch = view.findViewById(R.id.active)

        //init mItem
        var mItem: TimeModel = items[position]

        //set data
        time.text = mItem.time
        message.text = mItem.message


        return view
    }
}