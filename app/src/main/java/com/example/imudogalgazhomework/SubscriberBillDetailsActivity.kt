package com.example.imudogalgazhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SubscriberBillDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subscriber_bill_details)

        val m3PriceText : TextView = findViewById(R.id.m3price_text)
        val usedM3Text : TextView = findViewById(R.id.usedm3_text)
        val currentBillText : TextView = findViewById(R.id.current_bill_text)
        val totalBillText : TextView = findViewById(R.id.total_bill_text)
        val month9BillText : TextView = findViewById(R.id.month_9_bill_text)
        val month10BillText : TextView = findViewById(R.id.month_10_bill_text)
        val month11BillText : TextView = findViewById(R.id.month_11_bill_text)


        val extras : Bundle? = intent.extras


        m3PriceText.text = "%.2f".format(intent.getFloatExtra("ayin_m3_fiyati", 0.0F))
        usedM3Text.text = "%.2f".format(intent.getFloatExtra("ayin_m3_kullanimi", 0.0F))
        currentBillText.text = "%.2f".format(intent.getFloatExtra("ay_11_faturasi", 0.0F))
        totalBillText.text = "%.2f".format(intent.getFloatExtra("abone_borcu", 0.0F))
        month9BillText.text = "%.2f".format(intent.getFloatExtra("ay_10_faturasi", 0.0F))
        month10BillText.text = "%.2f".format(intent.getFloatExtra("ay_11_faturasi", 0.0F))
        month11BillText.text = "%.2f".format(intent.getFloatExtra("ay_0_faturasi", 0.0F))
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}