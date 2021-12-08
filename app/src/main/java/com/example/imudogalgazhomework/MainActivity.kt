package com.example.imudogalgazhomework

import android.content.ContentValues
import android.content.Intent
import android.database.DatabaseUtils
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.openOrCreateDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Button


class MainActivity : AppCompatActivity() {

    fun calculateToplamBorc(db : SQLiteDatabase, tableName : String): Float {
        var toplamBorc : Float = 0.0F
        val cMonthlyGasUsages = db.rawQuery("SELECT AylıkGazKullanımı FROM $tableName", null)
        val cM3Prices = db.rawQuery("SELECT AyınM3Fiyatı FROM $tableName", null)
        cMonthlyGasUsages.moveToFirst()
        cM3Prices.moveToFirst()
        toplamBorc += cMonthlyGasUsages.getFloat(cMonthlyGasUsages.getColumnIndexOrThrow("AylıkGazKullanımı")) * cM3Prices.getFloat(cM3Prices.getColumnIndexOrThrow("AyınM3Fiyatı"))
        while (cMonthlyGasUsages.moveToNext() && cM3Prices.moveToNext()) {
            toplamBorc += cMonthlyGasUsages.getFloat(cMonthlyGasUsages.getColumnIndexOrThrow("AylıkGazKullanımı")) * cM3Prices.getFloat(cM3Prices.getColumnIndexOrThrow("AyınM3Fiyatı"))
        }
        return toplamBorc
    }

    fun getAyM3Fiyati(db: SQLiteDatabase, tableName: String, monthIndex: Int): Float {
        val cM3Prices = db.rawQuery("SELECT AyınM3Fiyatı FROM $tableName", null)
        cM3Prices.moveToFirst()
        var i : Int = 0
        while (i < monthIndex) {
            cM3Prices.moveToNext()
            i += 1
        }
        return cM3Prices.getFloat(cM3Prices.getColumnIndexOrThrow("AyınM3Fiyatı"))
    }

    fun getAyM3Kullanimi(db: SQLiteDatabase, tableName: String, monthIndex: Int): Float {
        val cMonthlyGasUsages = db.rawQuery("SELECT AylıkGazKullanımı FROM $tableName", null)
        cMonthlyGasUsages.moveToFirst()
        var i : Int = 0
        while (i < monthIndex) {
            cMonthlyGasUsages.moveToNext()
            i += 1
        }
        return cMonthlyGasUsages.getFloat(cMonthlyGasUsages.getColumnIndexOrThrow("AylıkGazKullanımı"))
    }

    fun getAyFaturasi(db: SQLiteDatabase, tableName: String, monthIndex: Int): Float {
        val cMonthlyGasUsages = db.rawQuery("SELECT AylıkGazKullanımı FROM $tableName", null)
        val cM3Prices = db.rawQuery("SELECT AyınM3Fiyatı FROM $tableName", null)
        cMonthlyGasUsages.moveToFirst()
        cM3Prices.moveToFirst()
        var i : Int = 0
        while (i < monthIndex) {
            cMonthlyGasUsages.moveToNext()
            cM3Prices.moveToNext()
            i += 1
        }
        return cMonthlyGasUsages.getFloat(cMonthlyGasUsages.getColumnIndexOrThrow("AylıkGazKullanımı")) * cM3Prices.getFloat(cM3Prices.getColumnIndexOrThrow("AyınM3Fiyatı"))
    }

    fun initiateDatabase(): SQLiteDatabase {
        val db = openOrCreateDatabase("dogalgaz_odev_2.db", 0,null)

        val af_12345678_1 = ContentValues()
        val af_12345678_2 = ContentValues()
        val af_12345678_3 = ContentValues()
        val af_12345678_4 = ContentValues()
        val af_12345678_5 = ContentValues()
        val af_12345678_6 = ContentValues()
        val af_12345678_7 = ContentValues()
        val af_12345678_8 = ContentValues()
        val af_12345678_9 = ContentValues()
        val af_12345678_10 = ContentValues()
        val af_12345678_11 = ContentValues()
        val af_12345678_12 = ContentValues()

        val af_12345679_1 = ContentValues()
        val af_12345679_2 = ContentValues()
        val af_12345679_3 = ContentValues()
        val af_12345679_4 = ContentValues()
        val af_12345679_5 = ContentValues()
        val af_12345679_6 = ContentValues()
        val af_12345679_7 = ContentValues()
        val af_12345679_8 = ContentValues()
        val af_12345679_9 = ContentValues()
        val af_12345679_10 = ContentValues()
        val af_12345679_11 = ContentValues()
        val af_12345679_12 = ContentValues()

        val af_12345670_1 = ContentValues()
        val af_12345670_2 = ContentValues()
        val af_12345670_3 = ContentValues()
        val af_12345670_4 = ContentValues()
        val af_12345670_5 = ContentValues()
        val af_12345670_6 = ContentValues()
        val af_12345670_7 = ContentValues()
        val af_12345670_8 = ContentValues()
        val af_12345670_9 = ContentValues()
        val af_12345670_10 = ContentValues()
        val af_12345670_11 = ContentValues()
        val af_12345670_12 = ContentValues()

        af_12345678_1.put("Aylar", "Ocak")
        af_12345678_2.put("Aylar", "Şubat")
        af_12345678_3.put("Aylar", "Mart")
        af_12345678_4.put("Aylar", "Nisan")
        af_12345678_5.put("Aylar", "Mayıs")
        af_12345678_6.put("Aylar", "Haziran")
        af_12345678_7.put("Aylar", "Temmuz")
        af_12345678_8.put("Aylar", "Ağustos")
        af_12345678_9.put("Aylar", "Eylül")
        af_12345678_10.put("Aylar", "Ekim")
        af_12345678_11.put("Aylar", "Kasım")
        af_12345678_12.put("Aylar", "Aralık")

        af_12345678_1.put("AylıkGazKullanımı", 123.2)
        af_12345678_2.put("AylıkGazKullanımı", 110)
        af_12345678_3.put("AylıkGazKullanımı", 90.14)
        af_12345678_4.put("AylıkGazKullanımı", 113.12)
        af_12345678_5.put("AylıkGazKullanımı", 93.41)
        af_12345678_6.put("AylıkGazKullanımı", 97.68)
        af_12345678_7.put("AylıkGazKullanımı", 86.84)
        af_12345678_8.put("AylıkGazKullanımı", 104.35)
        af_12345678_9.put("AylıkGazKullanımı", 111.28)
        af_12345678_10.put("AylıkGazKullanımı", 98.36)
        af_12345678_11.put("AylıkGazKullanımı", 102.63)
        af_12345678_12.put("AylıkGazKullanımı", 94.74)

        af_12345678_1.put("AyınM3Fiyatı", 3.1)
        af_12345678_2.put("AyınM3Fiyatı", 2.7)
        af_12345678_3.put("AyınM3Fiyatı", 2.8)
        af_12345678_4.put("AyınM3Fiyatı", 3.0)
        af_12345678_5.put("AyınM3Fiyatı", 2.9)
        af_12345678_6.put("AyınM3Fiyatı", 3.0)
        af_12345678_7.put("AyınM3Fiyatı", 2.6)
        af_12345678_8.put("AyınM3Fiyatı", 3.1)
        af_12345678_9.put("AyınM3Fiyatı", 3.2)
        af_12345678_10.put("AyınM3Fiyatı", 2.9)
        af_12345678_11.put("AyınM3Fiyatı", 2.7)
        af_12345678_12.put("AyınM3Fiyatı", 2.8)

        af_12345679_1.put("Aylar", "Ocak")
        af_12345679_2.put("Aylar", "Şubat")
        af_12345679_3.put("Aylar", "Mart")
        af_12345679_4.put("Aylar", "Nisan")
        af_12345679_5.put("Aylar", "Mayıs")
        af_12345679_6.put("Aylar", "Haziran")
        af_12345679_7.put("Aylar", "Temmuz")
        af_12345679_8.put("Aylar", "Ağustos")
        af_12345679_9.put("Aylar", "Eylül")
        af_12345679_10.put("Aylar", "Ekim")
        af_12345679_11.put("Aylar", "Kasım")
        af_12345679_12.put("Aylar", "Aralık")

        af_12345679_1.put("AylıkGazKullanımı", 126.63)
        af_12345679_2.put("AylıkGazKullanımı", 85.48)
        af_12345679_3.put("AylıkGazKullanımı", 95.45)
        af_12345679_4.put("AylıkGazKullanımı", 118.97)
        af_12345679_5.put("AylıkGazKullanımı", 93.85)
        af_12345679_6.put("AylıkGazKullanımı", 147.23)
        af_12345679_7.put("AylıkGazKullanımı", 86.75)
        af_12345679_8.put("AylıkGazKullanımı", 104.84)
        af_12345679_9.put("AylıkGazKullanımı", 111.28)
        af_12345679_10.put("AylıkGazKullanımı", 90.57)
        af_12345679_11.put("AylıkGazKullanımı", 121.25)
        af_12345679_12.put("AylıkGazKullanımı", 99.45)

        af_12345679_1.put("AyınM3Fiyatı", 2.7)
        af_12345679_2.put("AyınM3Fiyatı", 3.3)
        af_12345679_3.put("AyınM3Fiyatı", 2.3)
        af_12345679_4.put("AyınM3Fiyatı", 2.6)
        af_12345679_5.put("AyınM3Fiyatı", 3.1)
        af_12345679_6.put("AyınM3Fiyatı", 3.2)
        af_12345679_7.put("AyınM3Fiyatı", 2.8)
        af_12345679_8.put("AyınM3Fiyatı", 2.9)
        af_12345679_9.put("AyınM3Fiyatı", 3.0)
        af_12345679_10.put("AyınM3Fiyatı", 2.6)
        af_12345679_11.put("AyınM3Fiyatı", 3.1)
        af_12345679_12.put("AyınM3Fiyatı", 2.8)

        af_12345670_1.put("Aylar", "Ocak")
        af_12345670_2.put("Aylar", "Şubat")
        af_12345670_3.put("Aylar", "Mart")
        af_12345670_4.put("Aylar", "Nisan")
        af_12345670_5.put("Aylar", "Mayıs")
        af_12345670_6.put("Aylar", "Haziran")
        af_12345670_7.put("Aylar", "Temmuz")
        af_12345670_8.put("Aylar", "Ağustos")
        af_12345670_9.put("Aylar", "Eylül")
        af_12345670_10.put("Aylar", "Ekim")
        af_12345670_11.put("Aylar", "Kasım")
        af_12345670_12.put("Aylar", "Aralık")

        af_12345670_1.put("AylıkGazKullanımı", 83.16)
        af_12345670_2.put("AylıkGazKullanımı", 81.47)
        af_12345670_3.put("AylıkGazKullanımı", 72.83)
        af_12345670_4.put("AylıkGazKullanımı", 79.47)
        af_12345670_5.put("AylıkGazKullanımı", 73.29)
        af_12345670_6.put("AylıkGazKullanımı", 61.67)
        af_12345670_7.put("AylıkGazKullanımı", 97.62)
        af_12345670_8.put("AylıkGazKullanımı", 85.41)
        af_12345670_9.put("AylıkGazKullanımı", 91.98)
        af_12345670_10.put("AylıkGazKullanımı", 94.12)
        af_12345670_11.put("AylıkGazKullanımı", 69.69)
        af_12345670_12.put("AylıkGazKullanımı", 72.17)

        af_12345670_1.put("AyınM3Fiyatı", 3.0)
        af_12345670_2.put("AyınM3Fiyatı", 3.5)
        af_12345670_3.put("AyınM3Fiyatı", 2.9)
        af_12345670_4.put("AyınM3Fiyatı", 3.2)
        af_12345670_5.put("AyınM3Fiyatı", 3.3)
        af_12345670_6.put("AyınM3Fiyatı", 3.4)
        af_12345670_7.put("AyınM3Fiyatı", 3.0)
        af_12345670_8.put("AyınM3Fiyatı", 3.1)
        af_12345670_9.put("AyınM3Fiyatı", 3.2)
        af_12345670_10.put("AyınM3Fiyatı", 3.1)
        af_12345670_11.put("AyınM3Fiyatı", 3.3)
        af_12345670_12.put("AyınM3Fiyatı", 3.4)

        db.execSQL("CREATE TABLE IF NOT EXISTS aylıkFatura12345678 (Aylar char(8), AylıkGazKullanımı float4, AyınM3Fiyatı float4)")
        db.execSQL("CREATE TABLE IF NOT EXISTS aylıkFatura12345679 (Aylar char(8), AylıkGazKullanımı float4, AyınM3Fiyatı float4)")
        db.execSQL("CREATE TABLE IF NOT EXISTS aylıkFatura12345670 (Aylar char(8), AylıkGazKullanımı float4, AyınM3Fiyatı float4)")

        val cRowCount = db.rawQuery("SELECT count(1) FROM aylıkFatura12345678", null)
        cRowCount.moveToFirst()
        val rowCount = cRowCount.getInt(0)
        cRowCount.close()


        if (rowCount <= 0)
        {
            db.insert("aylıkFatura12345678", null, af_12345678_1)
            db.insert("aylıkFatura12345678", null, af_12345678_2)
            db.insert("aylıkFatura12345678", null, af_12345678_3)
            db.insert("aylıkFatura12345678", null, af_12345678_4)
            db.insert("aylıkFatura12345678", null, af_12345678_5)
            db.insert("aylıkFatura12345678", null, af_12345678_6)
            db.insert("aylıkFatura12345678", null, af_12345678_7)
            db.insert("aylıkFatura12345678", null, af_12345678_8)
            db.insert("aylıkFatura12345678", null, af_12345678_9)
            db.insert("aylıkFatura12345678", null, af_12345678_10)
            db.insert("aylıkFatura12345678", null, af_12345678_11)
            db.insert("aylıkFatura12345678", null, af_12345678_12)

            db.insert("aylıkFatura12345679", null, af_12345679_1)
            db.insert("aylıkFatura12345679", null, af_12345679_2)
            db.insert("aylıkFatura12345679", null, af_12345679_3)
            db.insert("aylıkFatura12345679", null, af_12345679_4)
            db.insert("aylıkFatura12345679", null, af_12345679_5)
            db.insert("aylıkFatura12345679", null, af_12345679_6)
            db.insert("aylıkFatura12345679", null, af_12345679_7)
            db.insert("aylıkFatura12345679", null, af_12345679_8)
            db.insert("aylıkFatura12345679", null, af_12345679_9)
            db.insert("aylıkFatura12345679", null, af_12345679_10)
            db.insert("aylıkFatura12345679", null, af_12345679_11)
            db.insert("aylıkFatura12345679", null, af_12345679_12)

            db.insert("aylıkFatura12345670", null, af_12345670_1)
            db.insert("aylıkFatura12345670", null, af_12345670_2)
            db.insert("aylıkFatura12345670", null, af_12345670_3)
            db.insert("aylıkFatura12345670", null, af_12345670_4)
            db.insert("aylıkFatura12345670", null, af_12345670_5)
            db.insert("aylıkFatura12345670", null, af_12345670_6)
            db.insert("aylıkFatura12345670", null, af_12345670_7)
            db.insert("aylıkFatura12345670", null, af_12345670_8)
            db.insert("aylıkFatura12345670", null, af_12345670_9)
            db.insert("aylıkFatura12345670", null, af_12345670_10)
            db.insert("aylıkFatura12345670", null, af_12345670_11)
            db.insert("aylıkFatura12345670", null, af_12345670_12)

            val kp_1 = ContentValues()
            val kp_2 = ContentValues()
            val kp_3 = ContentValues()

            kp_1.put("AboneNo", "12345678")
            kp_1.put("AboneAdSoyad", "Ozan Arda Kazan")
            kp_1.put("ToplamBorc", calculateToplamBorc(db, "aylıkFatura12345678"))
            //vals_2.put("AylıkFatura", db.rawQuery("SELECT * FROM aylıkFatura", null))

            kp_2.put("AboneNo", "12345679")
            kp_2.put("AboneAdSoyad", "İlke Ata Kazan")
            kp_2.put("ToplamBorc", calculateToplamBorc(db, "aylıkFatura12345679"))
            //vals_2.put("AylıkFatura", db.rawQuery("SELECT * FROM aylıkFatura", null))

            kp_3.put("AboneNo", "12345670")
            kp_3.put("AboneAdSoyad", "Ersen Kazan")
            kp_3.put("ToplamBorc", calculateToplamBorc(db, "aylıkFatura12345670"))

            db.execSQL("CREATE TABLE IF NOT EXISTS kullanıcıProfili (AboneNo integer, AboneAdSoyad varchar(40), ToplamBorc float4)")
            db.insert("kullanıcıProfili", null, kp_1)
            db.insert("kullanıcıProfili", null, kp_2)
            db.insert("kullanıcıProfili", null, kp_3)

            val pp_1 = ContentValues()
            val pp_2 = ContentValues()

            pp_1.put("PersonelNo", "45678912")
            pp_1.put("PersonelSifre", "12345678")
            pp_1.put("PersonelAdSoyad", "Serkan Sayacokuyan")

            pp_2.put("PersonelNo", "45678913")
            pp_2.put("PersonelSifre", "12345679")
            pp_2.put("PersonelAdSoyad", "Semih Sayacokuyamayan")

            db.execSQL("CREATE TABLE IF NOT EXISTS personelProfili (PersonelNo integer, PersonelSifre varchar(40), PersonelAdSoyad varchar(40))")
            db.insert("personelProfili", null, pp_1)
            db.insert("personelProfili", null, pp_2)
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
        val names = db.rawQuery("SELECT AboneAdSoyad FROM kullanıcıProfili", null)
        val subNumbers = db.rawQuery("SELECT AboneNo FROM kullanıcıProfili", null)
        val totalPayments = db.rawQuery("SELECT ToplamBorc FROM kullanıcıProfili", null)
        var namessa = arrayOfNulls<String>(rowCount)
        var subNumberssa = arrayOfNulls<String>(rowCount)
        var totalPaymentsfa = arrayOfNulls<Float>(rowCount)

        var i = 0

        names.moveToFirst()
        namessa[i] = names.getString(names.getColumnIndexOrThrow("AboneAdSoyad"))
        subNumbers.moveToFirst()
        subNumberssa[i] = subNumbers.getString(subNumbers.getColumnIndexOrThrow("AboneNo"))
        totalPayments.moveToFirst()
        totalPaymentsfa[i] = totalPayments.getFloat(totalPayments.getColumnIndexOrThrow("ToplamBorc"))
        while (names.moveToNext() && subNumbers.moveToNext() && totalPayments.moveToNext())
        {
            i += 1
            namessa[i] = names.getString(names.getColumnIndexOrThrow("AboneAdSoyad"))
            subNumberssa[i] = subNumbers.getString(subNumbers.getColumnIndexOrThrow("AboneNo"))
            totalPaymentsfa[i] = totalPayments.getFloat(totalPayments.getColumnIndexOrThrow("ToplamBorc"))
        }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, namessa)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        mainSpinner.adapter = adapter

        i = 0

        val cPersonnelRowCount = db.rawQuery("SELECT count(1) FROM personelProfili", null)
        cPersonnelRowCount.moveToFirst()
        val personnelRowCount = cPersonnelRowCount.getInt(0)
        cPersonnelRowCount.close()

        val cPersonnelNumbers = db.rawQuery("SELECT PersonelNo FROM personelProfili", null)
        val cPersonnelPasswords = db.rawQuery("SELECT PersonelSifre FROM personelProfili", null)
        val cPersonnelNames = db.rawQuery("SELECT PersonelAdSoyad FROM personelProfili", null)

        var personnelNumberssa = arrayOfNulls<String>(personnelRowCount)
        var personnelPasswordssa = arrayOfNulls<String>(personnelRowCount)
        var personnelNamessa = arrayOfNulls<String>(personnelRowCount)

        cPersonnelNumbers.moveToFirst()
        cPersonnelPasswords.moveToFirst()
        cPersonnelNames.moveToFirst()

        personnelNumberssa[i] = cPersonnelNumbers.getString(cPersonnelNumbers.getColumnIndexOrThrow("PersonelNo"))
        personnelPasswordssa[i] = cPersonnelPasswords.getString(cPersonnelPasswords.getColumnIndexOrThrow("PersonelSifre"))
        personnelNamessa[i] = cPersonnelNames.getString(cPersonnelNames.getColumnIndexOrThrow("PersonelAdSoyad"))

        while (cPersonnelNumbers.moveToNext() && cPersonnelPasswords.moveToNext() && cPersonnelNames.moveToNext())
        {
            i += 1
            personnelNumberssa[i] = cPersonnelNumbers.getString(cPersonnelNumbers.getColumnIndexOrThrow("PersonelNo"))
            personnelPasswordssa[i] = cPersonnelPasswords.getString(cPersonnelPasswords.getColumnIndexOrThrow("PersonelSifre"))
            personnelNamessa[i] = cPersonnelNames.getString(cPersonnelNames.getColumnIndexOrThrow("PersonelAdSoyad"))
        }

        continueButton.setOnClickListener {
            var i = 0
            while(i < rowCount) {
                if(namessa[i] == mainSpinner.selectedItem.toString())
                {
                    break
                }
                i += 1
            }
            val next_intent_1 = Intent(this@MainActivity, SubscriberLoginActivity::class.java)
            next_intent_1.putExtra("abone_adi", mainSpinner.selectedItem.toString())
            next_intent_1.putExtra("abone_no", subNumberssa[i])
            next_intent_1.putExtra("abone_borcu", totalPaymentsfa[i])
            next_intent_1.putExtra("ayin_m3_fiyati", getAyM3Fiyati(db, "aylıkFatura" + subNumberssa[i], 11))
            next_intent_1.putExtra("ayin_m3_kullanimi", getAyM3Kullanimi(db, "aylıkFatura" + subNumberssa[i], 11))
            next_intent_1.putExtra("ay_9_faturasi", getAyFaturasi(db, "aylıkFatura" + subNumberssa[i], 9))
            next_intent_1.putExtra("ay_10_faturasi", getAyFaturasi(db, "aylıkFatura" + subNumberssa[i], 10))
            next_intent_1.putExtra("ay_11_faturasi", getAyFaturasi(db, "aylıkFatura" + subNumberssa[i], 11))
            startActivity(next_intent_1)
        }

        personnelButton.setOnClickListener {
            val next_intent_2 = Intent(this@MainActivity, PersonnelLoginActivity::class.java)
            next_intent_2.putExtra("personel_nolari", personnelNumberssa)
            next_intent_2.putExtra("personel_sifreleri", personnelPasswordssa)
            next_intent_2.putExtra("personel_adlari", personnelNamessa)
            startActivity(next_intent_2)
        }
    }
    //override fun onContextItemSelected(item: MenuItem): Boolean {
    //    when (item.itemId) {
    //        android.R.id.home -> {
    //            onBackPressed()
    //           finish()
    //            return true
    //        }
    //    }
    //    return super.onContextItemSelected(item)
    //}


}
