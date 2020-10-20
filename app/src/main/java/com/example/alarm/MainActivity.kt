package com.example.alarm

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init
        val items = ArrayList<TimeModel>()
        val add = findViewById<Button>(R.id.addAlarm)
        var desc: String? = intent.getStringExtra("desc")
        var hour: String? = intent.getStringExtra("hour")
        var minute: String? = intent.getStringExtra("minute")
        val check: String? = intent.getStringExtra("check")
        var new: String = ""


        //check for null
        if (hour == null || hour == "") {
            hour = "00"
        }
        if (minute == null || minute == "") {
            minute = "00"
        }
        if (desc == null) {
            desc = ""
        }


//        check intent data
        new = check.toString()
        while (new == "true") {
            items.add(TimeModel("$hour:$minute", "$desc"))
            new = "false"
        }


        //set data
        items.add(TimeModel("08:00", "Good morning"))
        items.add(TimeModel("13:00", "Launch time"))
        items.add(TimeModel("22:00", "Sleeping time"))
        items.add(TimeModel("00:00", ""))

        //set to adapter
        val adapter = TimeAdapter(this, R.layout.time, items)
        ListView.adapter = adapter


        add.setOnClickListener{
            val intent = Intent(this, NewAlarm::class.java)
//            intent.putExtra("keyIdentifier", value)
            startActivity(intent)
        }

        ListView.setOnItemClickListener{ adapter, view, i, l ->
            val intent = Intent(this, left::class.java)
            intent.putExtra("popuptext", items[i].time.toString())
            startActivity(intent)
        }

        ListView.setOnItemLongClickListener setOnLongClickListener@{ adapter, view, i, l ->
            val intent1 = Intent(this, delete::class.java)
            intent1.putExtra("id", i)
            startActivity(intent1)

            return@setOnLongClickListener true
        }

        var cc:String =""
        val bundle = intent.extras
        var id = bundle?.getString("id") ?: ""
        var ch = bundle?.getString("ch", "false") ?: ""
        cc = ch
        Log.d("taaaaag", id)
        Log.d("taaaaag", ch)
        if(cc == "true"){
            items.removeAt(id.toInt())
        }
    }
}

