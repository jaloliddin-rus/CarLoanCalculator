package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.lang.Math
import java.lang.Number

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener{
            calculate(it)
        }

        buttonReset.setOnClickListener{
            reset(it)
        }

    }

    private fun calculate(view : View){

        try {
            val carPrice:Double = editTextCarPrice.text.toString().toDouble()
            val downPayment:Double = editTextDownPayment.text.toString().toDouble()
            val loanPeriod:Double = editTextLoanPeriod.text.toString().toDouble()
            val rate:Double = editTextInterestRate.text.toString().toDouble()

            val loan:Double = carPrice - downPayment
            val interest:Double = loan * (rate/100) * loanPeriod
            val monthlyRepayment:Double = ((loan + interest)/loanPeriod)/ 12

            textLoan.text = loan.toString()
            textInterest.text = interest.toString()
            textMonthlyRepay.text = monthlyRepayment.toString()
        }catch (ex:Exception) {

        }
    }

    private fun reset(view:View){
        editTextCarPrice.text.clear()
        editTextDownPayment.text.clear()
        editTextLoanPeriod.text.clear()
        editTextInterestRate.text.clear()

        textLoan.text = ""
        textInterest.text = ""
        textMonthlyRepay.text = ""
    }
}
