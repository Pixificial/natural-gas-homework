package com.example.imudogalgazhomework

import android.content.ContentValues
import android.content.Intent
import android.database.DatabaseUtils
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.openOrCreateDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Button


class MainActivity : AppCompatActivity() {

    fun initiateDatabase(): SQLiteDatabase {
        val db = openOrCreateDatabase("dogalgaz_odev.db", 0,null)

        val af_1 = ContentValues()
        val af_2 = ContentValues()
        val af_3 = ContentValues()
        val af_4 = ContentValues()
        val af_5 = ContentValues()
        val af_6 = ContentValues()
        val af_7 = ContentValues()
        val af_8 = ContentValues()
        val af_9 = ContentValues()
        val af_10 = ContentValues()
        val af_11 = ContentValues()
        val af_12 = ContentValues()

        af_1.put("Aylar", "Ocak")
        af_2.put("Aylar", "Şubat")
        af_3.put("Aylar", "Mart")
        af_4.put("Aylar", "Nisan")
        af_5.put("Aylar", "Mayıs")
        af_6.put("Aylar", "Haziran")
        af_7.put("Aylar", "Temmuz")
        af_8.put("Aylar", "Ağustos")
        af_9.put("Aylar", "Eylül")
        af_10.put("Aylar", "Ekim")
        af_11.put("Aylar", "Kasım")
        af_12.put("Aylar", "Aralık")

        af_1.put("AylıkGazKullanımı", 123.2)
        af_2.put("AylıkGazKullanımı", 110)
        af_3.put("AylıkGazKullanımı", 90.14)

        af_1.put("AyınM3Fiyatı", 3.1)
        af_2.put("AyınM3Fiyatı", 2.7)
        af_3.put("AyınM3Fiyatı", 2.2)

        db.execSQL("CREATE TABLE IF NOT EXISTS aylıkFatura (Aylar char(8), AylıkGazKullanımı float4, AyınM3Fiyatı float4)")

        val cRowCount = db.rawQuery("SELECT count(1) FROM aylıkFatura", null)
        cRowCount.moveToFirst()
        val rowCount = cRowCount.getInt(0)
        cRowCount.close()

        if (rowCount <= 0)
        {
            db.insert("aylıkFatura", null, af_1)
            db.insert("aylıkFatura", null, af_2)
            db.insert("aylıkFatura", null, af_3)
            db.insert("aylıkFatura", null, af_4)
            db.insert("aylıkFatura", null, af_5)
            db.insert("aylıkFatura", null, af_6)
            db.insert("aylıkFatura", null, af_7)
            db.insert("aylıkFatura", null, af_8)
            db.insert("aylıkFatura", null, af_9)
            db.insert("aylıkFatura", null, af_10)
            db.insert("aylıkFatura", null, af_11)
            db.insert("aylıkFatura", null, af_12)

            val kp_1 = ContentValues()
            val kp_2 = ContentValues()
            val kp_3 = ContentValues()

            kp_1.put("AboneNo", "12345678")
            kp_1.put("AboneAdSoyad", "Ozan Arda Kazan")
            kp_1.put("ToplamBorc", 1004.32)
            //vals_2.put("AylıkFatura", db.rawQuery("SELECT * FROM aylıkFatura", null))
            kp_1.put("AylıkFatura", 0)

            kp_2.put("AboneNo", "12345679")
            kp_2.put("AboneAdSoyad", "İlke Ata Kazan")
            kp_2.put("ToplamBorc", 1031.31)
            //vals_2.put("AylıkFatura", db.rawQuery("SELECT * FROM aylıkFatura", null))
            kp_2.put("AylıkFatura", 0)

            kp_3.put("AboneNo", "12345670")
            kp_3.put("AboneAdSoyad", "Ersen Kazan")
            kp_3.put("ToplamBorc", 20.11)
            kp_3.put("AylıkFatura", 0)

            db.execSQL("CREATE TABLE IF NOT EXISTS kullanıcıProfili (AboneNo integer, AboneAdSoyad varchar(40), ToplamBorc float4, AylıkFatura integer)")
            db.insert("kullanıcıProfili", null, kp_1)
            db.insert("kullanıcıProfili", null, kp_2)
            db.insert("kullanıcıProfili", null, kp_3)
        }
        return db;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = initiateDatabase()

        val continueButton : Button = findViewById(R.id.continue_button)
        val personnelButton : Button = findViewById(R.id.personnel_button)
        val mainSpinner : Spinner = findViewById(R.id.main_spinner)
        val cRowCount = db.rawQuery("SELECT count(1) FROM kullanıcıProfili", null)
        cRowCount.moveToFirst()
        val rowCount = cRowCount.getInt(0)
        cRowCount.close()
        val lolStringA =  arrayOf(rowCount, "Haha", "Funny", "Lol")
        val names = db.rawQuery("SELECT AboneAdSoyad FROM kullanıcıProfili", null)
        var namessa = arrayOfNulls<String>(rowCount)

        var i = 0
        names.moveToFirst()
        namessa[i] = names.getString(names.getColumnIndexOrThrow("AboneAdSoyad"))
        while (names.moveToNext())
        {
            i += 1;
            namessa[i] = names.getString(names.getColumnIndexOrThrow("AboneAdSoyad"))
           // namessa[i] = i.toString()
        }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, namessa)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        mainSpinner.adapter = adapter

        continueButton.setOnClickListener {
            val intent = Intent(this@MainActivity, SubscriberLoginActivity::class.java)
            intent.putExtra("abone_adi", mainSpinner.selectedItem.toString())
            startActivity(intent)
        }
        personnelButton.setOnClickListener {
            val intent = Intent(this@MainActivity, PersonnelLoginActivity::class.java)
            startActivity(intent)
        }
    }
}
