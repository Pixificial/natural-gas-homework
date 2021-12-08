package com.example.imudogalgazhomework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView

class SubscriberLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subscriber_login)

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
            if (subNumText.text.toString() == intent.getStringExtra("abone_no").toString()) {
                val next_intent = Intent(this@SubscriberLoginActivity, SubscriberMainActivity::class.java)
                next_intent.putExtra("abone_adi", intent.getStringExtra("abone_adi"))
                next_intent.putExtra("abone_no", intent.getStringExtra("abone_no"))
                next_intent.putExtra("abone_borcu", intent.getFloatExtra("abone_borcu", 0.0F))
                startActivity(next_intent)
            }
        }
        //val backButton : Button = findViewById(R.id.back_button)
        //backButton.setOnClickListener {
        //    val intent = Intent(this@SubscriberLoginActivity, MainActivity::class.java)
        //    startActivity(intent)
        //}
    }


}