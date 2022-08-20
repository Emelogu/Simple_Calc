@file:Suppress("DEPRECATION")

package com.technicalx.simplecalc

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private var lastDot = false
    private var lastDigit = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val inputLine = findViewById<TextView>(R.id.input)
        val outputLine = findViewById<TextView>(R.id.output)
        
        val seven =findViewById<TextView>(R.id.sevenKey)
        seven.setOnClickListener {
            inputLine.append("7")
            lastDigit=true
        }

        val four= findViewById<TextView>(R.id.fourKey)
        four.setOnClickListener {
            inputLine.append("4")
            lastDigit=true
        }


        val one = findViewById<TextView>(R.id.oneKey)
        one.setOnClickListener {
            inputLine.append("1")
            lastDigit=true
        }

        val eight = findViewById<TextView>(R.id.eightKey)
        eight.setOnClickListener {
            inputLine.append("8")
            lastDigit=true
        }

        val five = findViewById<TextView>(R.id.fiveKey)
        five.setOnClickListener {
            inputLine.append("5")
            lastDigit=true
        }

        val two= findViewById<TextView>(R.id.twoKey)
        two.setOnClickListener {
            inputLine.append("2")
            lastDigit=true
        }

        val zero= findViewById<TextView>(R.id.zeroKey)
        zero.setOnClickListener {
            inputLine.append("0")
            lastDigit=true
        }

        val nine = findViewById<TextView>(R.id.nineKey)
        nine.setOnClickListener {
            inputLine.append("9")
            lastDigit=true
        }

        val six = findViewById<TextView>(R.id.sixKey)
        six.setOnClickListener {
            inputLine.append("6")
            lastDigit=true
        }

        val three = findViewById<TextView>(R.id.threeKey)
        three.setOnClickListener {
            inputLine.append("3")
            lastDigit=true
        }

        val dot = findViewById<TextView>(R.id.dotKey)
        dot.setOnClickListener {
            if(lastDigit && !lastDot){
                inputLine.append(".")
                lastDigit= false
                lastDot= true
            }
        }

        val clear = findViewById<TextView>(R.id.clrKey)
        clear.setOnClickListener {
            inputLine.text= ""
            outputLine.text= "0"
            lastDigit = false
            lastDot = false
        }

        val backspace = findViewById<TextView>(R.id.delKey)
        backspace.setOnClickListener {
            if(inputLine.text.isNotEmpty()){
                inputLine.text = (inputLine.text.substring(0,inputLine.text.length -1))
            }
        }

        val add = findViewById<TextView>(R.id.plusKey)
        add.setOnClickListener {
            if (lastDigit){
                inputLine.append("+")
                lastDigit= false
                lastDot = false
            }
        }

        val divide = findViewById<TextView>(R.id.divisionKey)
        divide.setOnClickListener {
            if (lastDigit){
                inputLine.append("/")
                lastDigit= false
                lastDot = false
            }

        }

        val minus = findViewById<TextView>(R.id.minusKey)
        minus.setOnClickListener {
            if (!lastDigit || lastDigit){
                inputLine.append("-")
                lastDigit= false
                lastDot = false
            }
        }

        val times = findViewById<TextView>(R.id.multiplyKey)
        times.setOnClickListener {
            if (lastDigit){
                inputLine.append("*")
                lastDigit= false
                lastDot = false
            }
        }

        val equal = findViewById<TextView>(R.id.equalKey)
        equal.setOnClickListener {
            try {
                val expression = ExpressionBuilder(inputLine.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()){
                    outputLine.text = longResult.toString()
                }
                else
                    outputLine.text = result.toString()

            } catch (e:Exception){
                Log.d("EXCEPTION", "Message: ${e.message}")
            }
        }

    }

}











