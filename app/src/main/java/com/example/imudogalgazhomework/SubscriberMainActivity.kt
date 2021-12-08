package com.example.imudogalgazhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SubscriberMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subscriber_main)

        val extras : Bundle? = intent.extras

        val subNameText : TextView = findViewById(R.id.subname_text)
        val totalBillText : TextView = findViewById(R.id.total_bill_text)
        subNameText.text = intent.getStringExtra("abone_adi")
        totalBillText.text = intent.getFloatExtra("abone_borcu", 0.5F).toString()

    }
}