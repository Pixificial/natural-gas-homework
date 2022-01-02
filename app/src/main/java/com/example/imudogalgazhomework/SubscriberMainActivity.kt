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
        val payButton : Button = findViewById(R.id.pay_button)

        subNameText.text = intent.getStringExtra("abone_adi")
        totalBillText.text = "%.2f TL".format(intent.getFloatExtra("abone_borcu", 0.5F))

        continueButton.setOnClickListener {
            val next_intent = Intent(this@SubscriberMainActivity, SubscriberBillDetailsActivity::class.java)
            next_intent.putExtra("abone_adi", intent.getStringExtra("abone_adi"))
            next_intent.putExtra("abone_no", intent.getStringExtra("abone_no"))
            next_intent.putExtra("abone_borcu", intent.getFloatExtra("abone_borcu", 0.0F))
            next_intent.putExtra("ayin_m3_fiyati", intent.getFloatExtra("ayin_m3_fiyati", 0.0F))
            next_intent.putExtra("ayin_m3_kullanimi", intent.getFloatExtra("ayin_m3_kullanimi", 0.0F))

            next_intent.putExtra("ay_0_faturasi", intent.getFloatExtra("ay_0_faturasi", 0.0F))
            next_intent.putExtra("ay_1_faturasi", intent.getFloatExtra("ay_1_faturasi", 0.0F))
            next_intent.putExtra("ay_2_faturasi", intent.getFloatExtra("ay_2_faturasi", 0.0F))
            next_intent.putExtra("ay_3_faturasi", intent.getFloatExtra("ay_3_faturasi", 0.0F))
            next_intent.putExtra("ay_4_faturasi", intent.getFloatExtra("ay_4_faturasi", 0.0F))
            next_intent.putExtra("ay_5_faturasi", intent.getFloatExtra("ay_5_faturasi", 0.0F))
            next_intent.putExtra("ay_6_faturasi", intent.getFloatExtra("ay_6_faturasi", 0.0F))
            next_intent.putExtra("ay_7_faturasi", intent.getFloatExtra("ay_7_faturasi", 0.0F))
            next_intent.putExtra("ay_8_faturasi", intent.getFloatExtra("ay_8_faturasi", 0.0F))
            next_intent.putExtra("ay_9_faturasi", intent.getFloatExtra("ay_9_faturasi", 0.0F))
            next_intent.putExtra("ay_10_faturasi", intent.getFloatExtra("ay_10_faturasi", 0.0F))
            next_intent.putExtra("ay_11_faturasi", intent.getFloatExtra("ay_11_faturasi", 0.0F))
            startActivity(next_intent)

        }

        payButton.setOnClickListener {
            val next_intent = Intent(this@SubscriberMainActivity, SubscriberBillPaymentActivity::class.java)
            next_intent.putExtra("abone_adi", intent.getStringExtra("abone_adi"))
            next_intent.putExtra("abone_no", intent.getStringExtra("abone_no"))
            next_intent.putExtra("abone_borcu", intent.getFloatExtra("abone_borcu", 0.0F))
            next_intent.putExtra("ayin_m3_fiyati", intent.getFloatExtra("ayin_m3_fiyati", 0.0F))
            next_intent.putExtra("ayin_m3_kullanimi", intent.getFloatExtra("ayin_m3_kullanimi", 0.0F))

            next_intent.putExtra("ay_0_faturasi", intent.getFloatExtra("ay_0_faturasi", 0.0F))
            next_intent.putExtra("ay_1_faturasi", intent.getFloatExtra("ay_1_faturasi", 0.0F))
            next_intent.putExtra("ay_2_faturasi", intent.getFloatExtra("ay_2_faturasi", 0.0F))
            next_intent.putExtra("ay_3_faturasi", intent.getFloatExtra("ay_3_faturasi", 0.0F))
            next_intent.putExtra("ay_4_faturasi", intent.getFloatExtra("ay_4_faturasi", 0.0F))
            next_intent.putExtra("ay_5_faturasi", intent.getFloatExtra("ay_5_faturasi", 0.0F))
            next_intent.putExtra("ay_6_faturasi", intent.getFloatExtra("ay_6_faturasi", 0.0F))
            next_intent.putExtra("ay_7_faturasi", intent.getFloatExtra("ay_7_faturasi", 0.0F))
            next_intent.putExtra("ay_8_faturasi", intent.getFloatExtra("ay_8_faturasi", 0.0F))
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