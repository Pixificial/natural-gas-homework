package com.example.imudogalgazhomework

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.lang.NumberFormatException

class SubscriberBillPaymentActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    var monthBillText : TextView? = null
    var db : SQLiteDatabase? = null
    var monthSpinner : Spinner? = null
    val months = arrayOf("Ay Seçin", "Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran", "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık")
    var monthBillInfoText : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subscriber_bill_payment)

        val extras : Bundle? = intent.extras


        monthBillText = findViewById(R.id.month_bill_text)
        monthBillInfoText = findViewById(R.id.info_text_5)
        var paymentAmountText : EditText = findViewById(R.id.payment_amount_text)

        val continueButton : Button = findViewById(R.id.continue_button)
        val totalBillText : TextView = findViewById(R.id.total_bill_text)

        db = openOrCreateDatabase("dg_odev_9.db", 0, null)


        totalBillText.text = "%.2f".format(intent.getFloatExtra("abone_borcu", 0.0F))

        monthSpinner = findViewById(R.id.month_spinner)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, months)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        monthSpinner?.adapter = adapter

        monthSpinner?.onItemSelectedListener = this

        continueButton.setOnClickListener {
            if (monthSpinner!!.selectedItem.toString() != months[0]) {
                var notInvalid = true
                try {
                    paymentAmountText.text.toString().toFloat()
                } catch (e: NumberFormatException) {
                    notInvalid = false
                    Toast.makeText(this, "Ödeme miktarı istenilen formatta değil!", Toast.LENGTH_SHORT).show()
                }
                if (notInvalid)
                {
                    val cMonthlyGasUsages = db!!.rawQuery("SELECT AylıkGazKullanımı FROM aylıkFatura${intent.getStringExtra("abone_no")} WHERE Aylar = '${monthSpinner!!.selectedItem.toString()}'", null)
                    val cM3Prices = db!!.rawQuery("SELECT AyınM3Fiyatı FROM aylıkFatura${intent.getStringExtra("abone_no")} WHERE Aylar = '${monthSpinner!!.selectedItem.toString()}'", null)
                    cMonthlyGasUsages.moveToFirst()
                    cM3Prices.moveToFirst()

                    if(paymentAmountText.text.toString().toFloat() < 0.0f)
                    {
                        Toast.makeText(this, "Ödeme miktarı negatif olamaz!", Toast.LENGTH_SHORT).show()
                    }
                    else if (paymentAmountText.text.toString().toFloat() > cMonthlyGasUsages.getFloat(cMonthlyGasUsages.getColumnIndexOrThrow("AylıkGazKullanımı")) * cM3Prices.getFloat(cM3Prices.getColumnIndexOrThrow("AyınM3Fiyatı")))
                    {
                        Toast.makeText(this, "Ödeme miktarı faturadan daha büyük!", Toast.LENGTH_SHORT).show()
                    }
                    else
                    {
                        val cMonthlyGasUsages = db!!.rawQuery("SELECT AylıkGazKullanımı FROM aylıkFatura${intent.getStringExtra("abone_no")} WHERE Aylar = '${monthSpinner!!.selectedItem.toString()}'", null)
                        val cM3Prices = db!!.rawQuery("SELECT AyınM3Fiyatı FROM aylıkFatura${intent.getStringExtra("abone_no")} WHERE Aylar = '${monthSpinner!!.selectedItem.toString()}'", null)
                        cMonthlyGasUsages.moveToFirst()
                        cM3Prices.moveToFirst()
                        val af = ContentValues()
                        af.put("AylıkGazKullanımı", cMonthlyGasUsages.getFloat(cMonthlyGasUsages.getColumnIndexOrThrow("AylıkGazKullanımı")) - paymentAmountText.text.toString().toFloat() / cM3Prices.getFloat(cM3Prices.getColumnIndexOrThrow("AyınM3Fiyatı")))
                        af.put("AyınM3Fiyatı", cM3Prices.getFloat(cM3Prices.getColumnIndexOrThrow("AyınM3Fiyatı")))
                        db!!.update(
                            "aylıkFatura${intent.getStringExtra("abone_no")}",
                            af,
                            "Aylar = '${monthSpinner!!.selectedItem}'",
                            null
                        )

                        val kp = ContentValues()
                        kp.put("ToplamBorc",
                            MainActivity.calculateToplamBorc(
                                db!!,
                                "aylıkFatura${intent.getStringExtra("abone_no")}"
                            )
                        )
                        db!!.update(
                            "kullanıcıProfili",
                            kp,
                            "AboneNo = '${intent.getStringExtra("abone_no")}'",
                            null
                        )
                        Toast.makeText(this, "Ödeme yapıldı. Bilgileriniz ana menüye döndüğünüzde güncellenecektir.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            else
            {
                Toast.makeText(this, "Ödeme yapılacak ay seçilmedi!", Toast.LENGTH_SHORT).show()
            }
        }


    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (monthSpinner!!.selectedItem.toString() != months[0])
        {
            val cMonthlyGasUsages = db!!.rawQuery("SELECT AylıkGazKullanımı FROM aylıkFatura${intent.getStringExtra("abone_no")} WHERE Aylar = '${monthSpinner!!.selectedItem.toString()}'", null) //WHERE Aylar = ${monthSpinner!!.selectedItem.toString()}
            val cM3Prices = db!!.rawQuery("SELECT AyınM3Fiyatı FROM aylıkFatura${intent.getStringExtra("abone_no")} WHERE Aylar = '${monthSpinner!!.selectedItem.toString()}'", null)
            cMonthlyGasUsages.moveToFirst()
            cM3Prices.moveToFirst()
            monthBillText!!.text = "%.2f".format(cMonthlyGasUsages.getFloat(cMonthlyGasUsages.getColumnIndexOrThrow("AylıkGazKullanımı")) * cM3Prices.getFloat(cM3Prices.getColumnIndexOrThrow("AyınM3Fiyatı")) - 0.01F)
            monthBillInfoText!!.text = monthSpinner!!.selectedItem.toString() + " Ayı Fatura:"
        }
        else {
            monthBillText!!.text = "0.00"
            monthBillInfoText!!.text = "Fatura: "
        }

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}