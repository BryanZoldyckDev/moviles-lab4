package com.example.a00014820_labo4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tfName: TextView;
    private lateinit var tfEmail: TextView;
    private lateinit var tfPhone: TextView;
    private lateinit var bSave: Button;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        save()
    }

    fun bind () {
        bSave = findViewById(R.id.savebutton)
        tfName = findViewById(R.id.nametextfield2)
        tfEmail = findViewById(R.id.emailtextfield2)
        tfPhone = findViewById(R.id.phonetextfield2)
    }

    fun save() {
        bSave.setOnClickListener{
            val intent = Intent(this, ShowDataActivty::class.java)
            intent.putExtra(NAME, tfName.text.toString())
            intent.putExtra(EMAIL, tfEmail.text.toString())
            intent.putExtra(PHONE, tfPhone.text.toString())
            startActivity(intent)
        }
    }

    companion object{
        const val NAME = "NAME"
        const val EMAIL = "EMAIL"
        const val PHONE = "PHONE"
    }

}