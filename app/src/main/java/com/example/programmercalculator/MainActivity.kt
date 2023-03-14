package com.example.programmercalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var equal: Button
    private lateinit var ce: Button
    private lateinit var hex: Button
    private lateinit var dec: Button
    private lateinit var oct: Button
    private lateinit var bin: Button
    private lateinit var number: TextView
    private lateinit var hexNumber: TextView
    private lateinit var decNumber: TextView
    private lateinit var octNumber: TextView
    private lateinit var binNumber: TextView
    private var stats = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        clear()
        hex()
        dec()
        oct()
        bin()
        equal()
    }

    private fun clear() {
        ce.setOnClickListener {
        number.text = ""
        hexNumber.text = ""
        decNumber.text = ""
        octNumber.text = ""
        binNumber.text = ""
        }
    }

    private fun initView() {
        equal = findViewById(R.id.equal)
        ce = findViewById(R.id.CE)
        hex = findViewById(R.id.hex)
        dec = findViewById(R.id.dec)
        oct = findViewById(R.id.oct)
        bin = findViewById(R.id.bin)
        number = findViewById(R.id.Number)
        hexNumber = findViewById(R.id.hex_number)
        decNumber = findViewById(R.id.dec_number)
        octNumber = findViewById(R.id.oct_number)
        binNumber = findViewById(R.id.bin_number)
    }

    private fun dec() {
        dec.setOnClickListener { stats = 0 }
    }
    private fun hex() {
        hex.setOnClickListener { stats = 1 }
    }
    private fun oct() {
        oct.setOnClickListener { stats = 2 }
    }
    private fun bin() {
        bin.setOnClickListener { stats = 3 }
    }

    fun onClickNumber(v: View){
        val newDigit = (v as Button).text.toString()
        val oldDigit = number.text.toString()
        val newNumber = oldDigit + newDigit
        number.text = newNumber
    }
     private fun getDec() {
         when {
             (stats == 0) -> number.text = number.text
             (stats == 1) -> number.text = Integer.parseInt(number.text.toString(), 16).toString()
             (stats == 2) -> number.text = Integer.parseInt(number.text.toString(), 8).toString()
             (stats == 3) -> number.text = Integer.parseInt(number.text.toString(), 2).toString()
         }
     }
     private fun hexConvert(){
         val hexConversion = number.text.toString().toUInt().toString(16)
        hexNumber.text = hexConversion
    }
     private fun binConvert(){
        val binConversion = number.text.toString().toUInt().toString(2)
        binNumber.text = binConversion
    }
        private fun octConvert(){
        val octConversion = number.text.toString().toUInt().toString(8)
        octNumber.text = octConversion
    }
    private fun decConvert(){
       decNumber.text = number.text
    }
    private fun conversation(){
        hexConvert()
        binConvert()
        octConvert()
        decConvert()
    }
    private fun numberText(){
        when {
            (stats == 0) -> number.text = decNumber.text
            (stats == 1) -> number.text = hexNumber.text
            (stats == 2) -> number.text = octNumber.text
            (stats == 3) -> number.text = binNumber.text
        }
    }

    private fun equal() {
        equal.setOnClickListener {
            getDec()
            conversation()
            numberText()
        }
    }

    }

