package com.example.imudogalgazhomework

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.NumberFormatException

class SubscriberLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subscriber_login)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FFBA4444")))
        window.statusBarColor = Color.parseColor("#FFBA4444")


        val subNameText : TextView = findViewById(R.id.subname_text)
        val subNumText : TextView = findViewById(R.id.subnum_text)
        val continueButton : Button = findViewById(R.id.continue_button)

        val extras : Bundle? = intent.extras

        val actionBar = supportActionBar

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
        subNameText.text = intent.getStringExtra("abone_adi")

        continueButton.setOnClickListener {
            var notInvalid = true

            try {
                subNumText.text.toString().toFloat()
            } catch(e: NumberFormatException) {
                notInvalid = false
            }

            if (notInvalid) {
                if (subNumText.text.toString().length == intent.getStringExtra("abone_no").toString().length) {
                    if (subNumText.text.toString() == intent.getStringExtra("abone_no").toString()) {
                        val next_intent = Intent(this@SubscriberLoginActivity, SubscriberMainActivity::class.java)
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
                    else {
                        Toast.makeText(this, "İsim ve abone numarası uyuşmuyor!", Toast.LENGTH_SHORT).show()
                    }
                }
                else {
                    Toast.makeText(this, "Abone numarası doğru uzunlukta değil!", Toast.LENGTH_SHORT).show()
                }
            }
            else {
                Toast.makeText(this, "Abone numarası doğru formatta değil!", Toast.LENGTH_SHORT).show()
            }
        }
        //val backButton : Button = findViewById(R.id.back_button)
        //backButton.setOnClickListener {
        //    val intent = Intent(this@SubscriberLoginActivity, MainActivity::class.java)
        //    startActivity(intent)
        //}
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}