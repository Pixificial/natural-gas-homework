package com.example.imudogalgazhomework

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

class PersonnelPhotoUploadingActivity : AppCompatActivity() {
    val PICK_IMAGE = 200
    var photoImage : ImageView? = null
    var photoAdded = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personnel_photo_uploading)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FF3377BA")))
        window.statusBarColor = Color.parseColor("#FF3377BA")

        val db = openOrCreateDatabase("dg_odev_9.db", 0, null)

        photoImage = findViewById(R.id.uploaded_picture)
        val uploadButton : Button = findViewById(R.id.upload_button)
        val continueButton : Button = findViewById(R.id.continue_button)

        val extras : Bundle? = intent.extras

        uploadButton.setOnClickListener {
            val upload_intent : Intent = Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            upload_intent.setType("image/*")
            upload_intent.setAction(Intent.ACTION_GET_CONTENT)

            startActivityForResult(Intent.createChooser(upload_intent, "Select Photo"), PICK_IMAGE)
        }
        val af = ContentValues()
        af.put("AylıkGazKullanımı", intent.getFloatExtra("aylik_gaz_kullanimi", 0.0F))
        af.put("AyınM3Fiyatı", intent.getFloatExtra("ayin_m3_kullanimi", 0.0F))

        val kp = ContentValues()
        kp.put("ToplamBorc",
            MainActivity.calculateToplamBorc(db, "aylıkFatura${intent.getStringExtra("abone_no")}")
        )
        continueButton.setOnClickListener {
            if (photoImage!!.drawable != null && photoImage!!.drawable != ResourcesCompat.getDrawable(this.resources, R.drawable.placeholder_photo_icon, null) && photoAdded) {
                db.update(
                    "aylıkFatura${intent.getStringExtra("abone_no")}",
                    af,
                    "Aylar = '${intent.getStringExtra("ay")}'",
                    null
                )
                db.update(
                    "kullanıcıProfili",
                    kp,
                    "AboneNo = '${intent.getStringExtra("abone_no")}'",
                    null
                )
                Toast.makeText(this, "Fatura bilgisi başarıyla güncellendi!", Toast.LENGTH_SHORT).show()

            }
            else
            {
                Toast.makeText(this, "Resim yüklenmedi!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK)
        {
            if (data != null)
            {
                photoImage!!.setImageURI(null)
                photoImage!!.setImageURI(data.data)
                photoAdded = true
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}