package com.example.alarm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.NumberPicker
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.new_alarm.*

class NewAlarm: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_alarm)

        //init
        val np = findViewById<NumberPicker>(R.id.hour)
        val np2 = findViewById<NumberPicker>(R.id.minute)
        val desc = findViewById<EditText>(R.id.desc)
        val add = findViewById<Button>(R.id.add)
        var hour: String = ""
        var minute: String = ""

        //set max min of number picker
        np.maxValue = 23;
        np.minValue = 0;
        np2.maxValue = 59;
        np2.minValue = 0;

        //change textview clock value
        np.setOnValueChangedListener { picker, oldVal, newVal ->
            textHour.text = "$newVal"
            hour = "$newVal"
        }
        np2.setOnValueChangedListener { picker, oldVal, newVal ->
            textMinute.text = "$newVal"
            minute = "$newVal"
        }


        add.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("desc", desc.text.toString())
            intent.putExtra("hour", hour)
            intent.putExtra("minute", minute)
            intent.putExtra("check", "true")
            startActivity(intent)
        }


    }
}