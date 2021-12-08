package com.example.imudogalgazhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SubscriberBillPaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subscriber_bill_payment)

        val extras : Bundle? = intent.extras

        val currentBillText : TextView = findViewById(R.id.current_bill_text)

        currentBillText.text = intent.getFloatExtra("ay_11_faturasi", 0.0F).toString()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}