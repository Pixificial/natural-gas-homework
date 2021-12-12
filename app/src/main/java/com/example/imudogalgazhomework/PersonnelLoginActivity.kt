package com.example.imudogalgazhomework

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.NumberFormatException

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
            var personnelNumTextNotInvalid = true

            try {
                personnelNumText.text.toString().toFloat()
            } catch(e: NumberFormatException) {
                personnelNumTextNotInvalid = false
            }

            if (personnelNumTextNotInvalid) {

                var personnelPassTextNotInvalid = true

                try {
                    personnelPassText.text.toString().toFloat()
                } catch(e: NumberFormatException) {
                    personnelPassTextNotInvalid = false
                }

                if (personnelPassTextNotInvalid) {
                    var noMatch = true
                    var i = 0
                    if (personnelNames != null) {
                        var nummLengthNotInvalid = true
                        var passLengthNotInvalid = true
                        while (i < personnelNames.size) {

                            if (personnelNumText.text.toString().length != personnelNumbers!![i].length) {
                                nummLengthNotInvalid = false
                                break
                            }
                            if (personnelPassText.text.toString().length != personnelPasswords!![i].length) {
                                passLengthNotInvalid = false
                                break
                            }
                            if (personnelNumText.text.toString() == personnelNumbers!![i] && personnelPassText.text.toString() == personnelPasswords!![i]) {
                                noMatch = false
                                val next_intent = Intent(this@PersonnelLoginActivity, PersonnelMainActivity::class.java)
                                startActivity(next_intent)
                                break
                            }
                            i++
                        }
                        if (!nummLengthNotInvalid) {
                            Toast.makeText(this, "Personel numarası doğru uzunlukta değil!", Toast.LENGTH_SHORT).show()

                        }
                        else if (!passLengthNotInvalid) {
                            Toast.makeText(this, "Personel şifresi doğru uzunlukta değil!", Toast.LENGTH_SHORT).show()

                        }
                        else if (noMatch) {
                            Toast.makeText(this, "Personel numarası ve personel şifresi uyuşmuyor!", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                else {
                    Toast.makeText(this, "Personel şifresi doğru formatta değil!", Toast.LENGTH_SHORT).show()
                }
            }
            else {
                Toast.makeText(this, "Personel numarası doğru formatta değil!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}