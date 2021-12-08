package com.example.imudogalgazhomework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class PersonnelLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personnel_login)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val personnelNumText : EditText = findViewById(R.id.personnelnum_text)
        val personnelPassText : EditText = findViewById(R.id.personnelpass_text)
        val continueButton : Button = findViewById(R.id.continue_button)

        val personnelNumbers = intent.getStringArrayExtra("personel_nolari")
        val personnelPasswords = intent.getStringArrayExtra("personel_sifreleri")
        val personnelNames = intent.getStringArrayExtra("personel_adlari")

        continueButton.setOnClickListener {
            var i = 0
            if (personnelNames != null) {
                while (i < personnelNames.size) {
                    if (personnelNumText.text.toString() == personnelNumbers!![i] && personnelPassText.text.toString() == personnelPasswords!![i]) {
                        // goto next screen (which is nonexistent as of now)
                        //findViewById<TextView>(R.id.system_text).text = personnelNames[i]
                    }
                    i++
                }
            }
        }

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