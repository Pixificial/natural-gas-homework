package com.example.imudogalgazhomework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class PersonnelLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personnel_login)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //val backButton : Button = findViewById(R.id.back_button)
        //backButton.setOnClickListener {
        //    val intent = Intent(this@PersonnelLoginActivity, MainActivity::class.java)
        //    startActivity(intent)
        //}
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}