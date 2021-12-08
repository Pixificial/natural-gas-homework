package com.example.imudogalgazhomework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SubscriberMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subscriber_main)

        val extras : Bundle? = intent.extras

        val subNameText : TextView = findViewById(R.id.subname_text)
        val totalBillText : TextView = findViewById(R.id.total_bill_text)
        val continueButton : Button = findViewById(R.id.continue_button)

        subNameText.text = intent.getStringExtra("abone_adi")
        totalBillText.text = intent.getFloatExtra("abone_borcu", 0.5F).toString()

        continueButton.setOnClickListener {
            val next_intent = Intent(this@SubscriberMainActivity, SubscriberBillDetailsActivity::class.java)
            next_intent.putExtra("abone_adi", intent.getStringExtra("abone_adi"))
            next_intent.putExtra("abone_no", intent.getStringExtra("abone_no"))
            next_intent.putExtra("abone_borcu", intent.getFloatExtra("abone_borcu", 0.0F))
            next_intent.putExtra("ayin_m3_fiyati", intent.getFloatExtra("ayin_m3_fiyati", 0.0F))
            next_intent.putExtra("ayin_m3_kullanimi", intent.getFloatExtra("ayin_m3_kullanimi", 0.0F))

            next_intent.putExtra("ay_9_faturasi", intent.getFloatExtra("ay_9_faturasi", 0.0F))
            next_intent.putExtra("ay_10_faturasi", intent.getFloatExtra("ay_10_faturasi", 0.0F))
            next_intent.putExtra("ay_11_faturasi", intent.getFloatExtra("ay_11_faturasi", 0.0F))
            startActivity(next_intent)

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}