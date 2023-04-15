package com.example.a00014820_labo4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ShowDataActivty : AppCompatActivity() {

    private lateinit var tName: TextView;
    private lateinit var tEmail: TextView;
    private lateinit var tPhone: TextView;
    private lateinit var bShare: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_data_activty)

        bind();
        showData();
        shareData()
    }
    private fun showData(){
        tName.text = tName.text.toString()+ " " + intent.getStringExtra(NAME.toString())
        tEmail.text = tEmail.text.toString()+ " " + intent.getStringExtra(EMAIL.toString())
        tPhone.text = tPhone.text.toString()+ " " + intent.getStringExtra(PHONE.toString())
    }

    private fun shareData(){
        val content = tName.text.toString() + "\n" + tEmail.text.toString() + "\n" + tPhone.text.toString()
        bShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT,  content)
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "The title")
            startActivity(Intent.createChooser(shareIntent, "Share..."))
        }
    }

    fun bind () {
        bShare = findViewById(R.id.sharebutton)
        tName = findViewById(R.id.nametextview)
        tEmail = findViewById(R.id.emailtextview)
        tPhone = findViewById(R.id.phonetextview)
    }

    companion object{
        const val NAME = "NAME"
        const val EMAIL = "EMAIL"
        const val PHONE = "PHONE"
    }
}