package com.example.imudogalgazhomework

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.lang.NumberFormatException

class PersonnelMainActivity : MainActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personnel_main)

        val monthSpinner : Spinner = findViewById(R.id.month_spinner)
        val months = arrayOf("Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran", "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, months)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        monthSpinner.adapter = adapter
        val subNumText : EditText = findViewById(R.id.subnum_text)
        val usedM3Text : EditText = findViewById(R.id.usedm3_text)
        val m3PriceText : EditText = findViewById(R.id.m3price_text)
        val continueButton : Button = findViewById(R.id.continue_button)


        continueButton.setOnClickListener {
            var notInvalid = true

            try {
                usedM3Text.text.toString().toFloat()
            } catch(e: NumberFormatException) {
                notInvalid = false
            }

            try {
                m3PriceText.text.toString().toFloat()
            } catch(e: NumberFormatException) {
                notInvalid = false
            }

            if (notInvalid) {
                val af = ContentValues()
                af.put("AylıkGazKullanımı", usedM3Text.text.toString().toFloat())
                af.put("AyınM3Fiyatı", m3PriceText.text.toString().toFloat())
                val db = openOrCreateDatabase("ssdfgjsgffgjrtye.db", 0, null)
                val cTableExists = db.rawQuery(
                    "SELECT DISTINCT tbl_name from sqlite_master WHERE tbl_name = 'aylıkFatura${subNumText.text.toString()}'",
                    null
                )


                if (cTableExists.count >= 1) {
                    db.update(
                        "aylıkFatura${subNumText.text.toString()}",
                        af,
                        "Aylar = '${monthSpinner.selectedItem}'",
                        null
                    )

                    val kp = ContentValues()
                    kp.put("ToplamBorc", calculateToplamBorc(db, "aylıkFatura${subNumText.text.toString()}"))
                    db.update(
                        "kullanıcıProfili",
                        kp,
                        "AboneNo = '${subNumText.text.toString()}'",
                        null
                    )
                }
            }
            //db.execSQL("UPDATE aylıkFatura${subNumText.text.toString()} SET AylıkGazKullanımı = ${usedM3Text.text.toString().toFloat()} WHERE Aylar = '${monthSpinner.selectedItem}'")
            //db.execSQL("UPDATE aylıkFatura${subNumText.text.toString()} SET AyınM3Fiyatı = ${m3PriceText.text.toString().toFloat()} WHERE Aylar = '${monthSpinner.selectedItem}'")

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}