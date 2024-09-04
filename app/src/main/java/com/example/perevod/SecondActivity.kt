package com.example.perevod

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity() {
    private  lateinit var number:EditText
    private var fromBaseSpinner: Spinner? = null
    private var toBaseSpinner:Spinner? = null
    private val inputNumber: EditText? = null
    private var resultTextView: TextView? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        fromBaseSpinner = findViewById(R.id.spinner1);
        toBaseSpinner = findViewById(R.id.spinner2);
        number = findViewById(R.id.nu);
        resultTextView = findViewById(R.id.answ);





    }

        fun click(view: View) {
            convertNumber()
    }



    private fun convertNumber() {

        val selectedConversion: String = fromBaseSpinner!!.selectedItem.toString()
        val selectedConversion2: String = toBaseSpinner!!.getSelectedItem().toString()
        val input: String = number.getText().toString()

        if (!input.isEmpty()) {
            try {
                val value = input.toDouble()
                val result: Double
                if (selectedConversion == "Байты" && selectedConversion2=="Килобайты") {
                    result = value / 1024
                    resultTextView!!.text = "Результат: $result КБ"
                } else if (selectedConversion == "Килобайты" && selectedConversion2=="Байты"){
                    result = value * 1024
                    resultTextView!!.text = "Результат: $result Б"
                }
                else {
                    resultTextView!!.text =value.toString()
                }
            } catch (e: java.lang.NumberFormatException) {
                resultTextView!!.text = "Ошибка: неверный ввод"
            }
        } else {
            resultTextView!!.text = "Ошибка: введите значение"
        }
        val intent = Intent(this, ThirdActivity::class.java)
        intent.putExtra("number", input!!.toString())
        intent.putExtra("answ", resultTextView!!.text.toString())
        startActivity(intent);

    }


}