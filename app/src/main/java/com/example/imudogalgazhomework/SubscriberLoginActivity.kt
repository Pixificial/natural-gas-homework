package com.example.imudogalgazhomework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SubscriberLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subscriber_login)

        val subNameText : TextView = findViewById(R.id.subname_text)
        val backButton : Button = findViewById(R.id.back_button)

        val extras : Bundle? = intent.extras

        subNameText.text = intent.getStringExtra("abone_adi")

        backButton.setOnClickListener {
            val intent = Intent(this@SubscriberLoginActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}