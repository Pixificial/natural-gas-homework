package com.example.imudogalgazhomework

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase.*
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.lang.NumberFormatException

class PersonnelMainActivity : MainActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personnel_main)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FF3377BA")))
        window.statusBarColor = Color.parseColor("#FF3377BA")

        val monthSpinner : Spinner = findViewById(R.id.month_spinner)
        val months = arrayOf("Seçin", "Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran", "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, months)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        monthSpinner.adapter = adapter
        val subNumText : EditText = findViewById(R.id.subnum_text)
        val usedM3Text : EditText = findViewById(R.id.usedm3_text)
        val m3PriceText : EditText = findViewById(R.id.m3price_text)
        val continueButton : Button = findViewById(R.id.continue_button)


        continueButton.setOnClickListener {
            var notInvalid = true

            if (monthSpinner.selectedItem.toString() == months[0])
            {
                Toast.makeText(this, "Lütfen ay seçin!", Toast.LENGTH_SHORT).show()
            }
            else {
                try {
                    subNumText.text.toString().toFloat()
                } catch(e: NumberFormatException) {
                    notInvalid = false
                    Toast.makeText(this, "Abone numarası istenilen formatta değil!", Toast.LENGTH_SHORT).show()
                }

                try {
                    usedM3Text.text.toString().toFloat()
                } catch(e: NumberFormatException) {
                    notInvalid = false
                    Toast.makeText(this, "Kullanılan gaz istenilen formatta değil!", Toast.LENGTH_SHORT).show()
                }

                try {
                    m3PriceText.text.toString().toFloat()
                } catch(e: NumberFormatException) {
                    notInvalid = false
                    Toast.makeText(this, "Gaz fiyatı istenilen formatta değil!", Toast.LENGTH_SHORT).show()
                }

                if (notInvalid) {
                    val af = ContentValues()
                    af.put("AylıkGazKullanımı", usedM3Text.text.toString().toFloat())
                    af.put("AyınM3Fiyatı", m3PriceText.text.toString().toFloat())
                    val db = openOrCreateDatabase("dg_odev_8.db", 0, null)
                    val cTableExists = db.rawQuery(
                        "SELECT DISTINCT tbl_name from sqlite_master WHERE tbl_name = 'aylıkFatura${subNumText.text.toString()}'",
                        null
                    )


                    if (cTableExists.count >= 1) {
                        val next_intent = Intent(this@PersonnelMainActivity, PersonnelPhotoUploadingActivity::class.java)
                        next_intent.putExtra("aylik_gaz_kullanimi", usedM3Text.text.toString().toFloat())
                        next_intent.putExtra("abone_no", subNumText.text.toString())
                        next_intent.putExtra("ay", monthSpinner.selectedItem.toString())
                        next_intent.putExtra("ayin_m3_kullanimi", m3PriceText.text.toString().toFloat())
                        startActivity(next_intent)
                    }
                    else {
                        Toast.makeText(this, "Belirtilen abone numarasıyla kayıtlı bir abone bulunamadı!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}