package com.example.perevod


import android.os.Bundle

import android.content.Intent
import android.content.SharedPreferences

import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class FirstActivity : AppCompatActivity() {

    private lateinit var login1: EditText
    private  lateinit var pass:EditText
    private lateinit var pref:SharedPreferences
    private lateinit var  builder:AlertDialog



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        login1=findViewById(R.id.login)
        pass=findViewById(R.id.pass)
    }


    fun enter(view: View) {
        if(login1.text.toString().isNotEmpty()&&pass.text.toString().isNotEmpty()){
            val intent= Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
        else{
            val toast = Toast.makeText(this, "no", Toast.LENGTH_SHORT )
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
            toast.show()
        }
    }

    fun hendler(view: View) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Важный выбор")
            .setMessage("Выбери что делаем")
            .setCancelable(true)
            .setPositiveButton("Сохранить") { _, _ ->

                Toast.makeText(
                    this,
                    "Сохранено",
                    Toast.LENGTH_LONG
                ).show()
                pref=getPreferences(MODE_PRIVATE)
                val ed = pref.edit()
                if(login1.toString()=="ects"&&pass.toString()=="ects2023"){
                    ed.putString("login", login1.text.toString())
                    ed.putString("password", pass.text.toString())
                    ed.apply()
                }
                else{
                    Toast.makeText(this, "no", Toast.LENGTH_SHORT )
                }

            }
            .setNegativeButton(
                "Загрузить"
            ) { _, _ ->

                Toast.makeText(
                    this, "загружено",
                    Toast.LENGTH_LONG
                ).show()
                pref=getPreferences(MODE_PRIVATE)
                login1.setText(pref.getString("login", "ects"));
                pass.setText(pref.getString("password", "ects2023"));
            }
        builder.create()
        builder.show()
    }
}