package com.example.imudogalgazhomework

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
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
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FF3377BA")))
        window.statusBarColor = Color.parseColor("#FF3377BA")


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
                        val next_intent = Intent(this@PersonnelLoginActivity, PersonnelMainActivity::class.java)
                        startActivity(next_intent)
                        break
                    }
                    i++
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}