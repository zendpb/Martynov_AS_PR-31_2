package com.example.perevod

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ThirdActivity : AppCompatActivity() {
    private var number: TextView? = null
    private var answ: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        number=findViewById(R.id.tt)
        answ=findViewById(R.id.tt1)
        val txtName = intent.getStringExtra("number")
        val txtLastname = intent.getStringExtra("answ")
        number!!.setText(txtName)
        answ!!.setText(txtLastname)
    }

    fun yy(view: View) {
        val intent= Intent(this,SecondActivity::class.java)
        startActivity(intent)
    }
}