package com.example.imudogalgazhomework

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SubscriberBillPaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subscriber_bill_payment)

        val extras : Bundle? = intent.extras

        val continueButton : Button = findViewById(R.id.continue_button)
        val currentBillText : TextView = findViewById(R.id.current_bill_text)

        currentBillText.text = "%.2f".format(intent.getFloatExtra("ay_11_faturasi", 0.0F))

        continueButton.setOnClickListener {
            val url_intent = Intent(Intent.ACTION_VIEW)
            url_intent.data = Uri.parse("https://example.com")
            startActivity(url_intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}