package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.style.LineHeightSpan
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        button_calculate.setOnClickListener(){
            val builder = AlertDialog.Builder(this@MainActivity)

            if (editText_kg.text.isEmpty()){

                builder.setMessage("No Leave It Blank!")
                val alert = builder.create()
                // set title for alert dialog box
                alert.setTitle("Weight(KG)")
                // show alert dialog
                alert.show()
            }else if (editText2.text.isEmpty()){
                builder.setMessage("No Leave It Blank!")
                val alert = builder.create()
                // set title for alert dialog box
                alert.setTitle("Height(M)")
                // show alert dialog
                alert.show()
            } else {



                val weight:Double = editText_kg.text.toString().toDouble()

                val height:Double = editText2.text.toString().toDouble()

                val bmi = calculateBMI(height,weight)
                if (bmi <= 18.5){
                    imageView.setImageResource(R.drawable.under)
                    textView.text = "BMI:" + " %.2f ".format(bmi) + " (Underweight)"
                }else if(bmi <= 24.9){
                    imageView.setImageResource(R.drawable.normal)
                    textView.text =  "BMI:" + " %.2f ".format(bmi) + " (Normal)"
                }else if(bmi > 25){
                    imageView.setImageResource(R.drawable.over)
                    textView.text =  "BMI:" + " %.2f ".format(bmi) + " (Overweight)"
                }

            }
        }

        button_reset.setOnClickListener(){
            editText2.text.clear()
            editText_kg.text.clear()
            imageView.setImageResource(R.drawable.empty)
            textView.text = ""
            
            editText_kg.requestFocus()
        }
    }

    public fun calculateBMI (height:Double,weight:Double):Double{

        return weight / (height * height)
    }
}
