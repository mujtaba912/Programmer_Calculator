package com.example.programmercalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var equal: Button
    private lateinit var ce: Button
    private lateinit var hex: Button
    private lateinit var dec: Button
    private lateinit var oct: Button
    private lateinit var bin: Button
    private lateinit var a: Button
    private lateinit var b: Button
    private lateinit var c: Button
    private lateinit var d: Button
    private lateinit var e: Button
    private lateinit var f: Button
    private lateinit var zero: Button
    private lateinit var one: Button
    private lateinit var two: Button
    private lateinit var three: Button
    private lateinit var four: Button
    private lateinit var five: Button
    private lateinit var six: Button
    private lateinit var seven: Button
    private lateinit var eight: Button
    private lateinit var nine: Button
    private lateinit var number: TextView
    private lateinit var hexNumber: TextView
    private lateinit var decNumber: TextView
    private lateinit var octNumber: TextView
    private lateinit var binNumber: TextView
    private var stats = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        enabledButtons()
        clear()
        hex()
        dec()
        oct()
        bin()
        equal()
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
        a = findViewById(R.id.a)
        b = findViewById(R.id.b)
        c = findViewById(R.id.c)
        d = findViewById(R.id.d)
        e = findViewById(R.id.e)
        f = findViewById(R.id.f)
        zero = findViewById(R.id.zero)
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
    }

    private fun enabledButtons() {
        when {
            (stats == 0) -> {
                a.isEnabled = false
                b.isEnabled = false
                c.isEnabled = false
                d.isEnabled = false
                e.isEnabled = false
                f.isEnabled = false
                nine.isEnabled = true
                eight.isEnabled = true
                seven.isEnabled = true
                six.isEnabled = true
                five.isEnabled = true
                four.isEnabled = true
                three.isEnabled = true
                two.isEnabled = true
                one.isEnabled = true
                zero.isEnabled = true
            }
            (stats == 1) -> {
                a.isEnabled = true
                b.isEnabled = true
                c.isEnabled = true
                d.isEnabled = true
                e.isEnabled = true
                f.isEnabled = true
                nine.isEnabled = true
                eight.isEnabled = true
                seven.isEnabled = true
                six.isEnabled = true
                five.isEnabled = true
                four.isEnabled = true
                three.isEnabled = true
                two.isEnabled = true
                one.isEnabled = true
                zero.isEnabled = true
            }
            (stats == 2) -> {
                a.isEnabled = false
                b.isEnabled = false
                c.isEnabled = false
                d.isEnabled = false
                e.isEnabled = false
                f.isEnabled = false
                nine.isEnabled = false
                eight.isEnabled = false
                seven.isEnabled = true
                six.isEnabled = true
                five.isEnabled = true
                four.isEnabled = true
                three.isEnabled = true
                two.isEnabled = true
                one.isEnabled = true
                zero.isEnabled = true
            }
            (stats == 3) -> {
                a.isEnabled = false
                b.isEnabled = false
                c.isEnabled = false
                d.isEnabled = false
                e.isEnabled = false
                f.isEnabled = false
                nine.isEnabled = false
                eight.isEnabled = false
                seven.isEnabled = false
                six.isEnabled = false
                five.isEnabled = false
                four.isEnabled = false
                three.isEnabled = false
                two.isEnabled = false
                one.isEnabled = true
                zero.isEnabled = true
            }
            (stats == 4) -> {
                a.isEnabled = false
                b.isEnabled = false
                c.isEnabled = false
                d.isEnabled = false
                e.isEnabled = false
                f.isEnabled = false
                nine.isEnabled = false
                eight.isEnabled = false
                seven.isEnabled = false
                six.isEnabled = false
                five.isEnabled = false
                four.isEnabled = false
                three.isEnabled = false
                two.isEnabled = false
                one.isEnabled = false
                zero.isEnabled = false
            }
        }
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

    private fun dec() {
        dec.setOnClickListener {
            stats = 0
            enabledButtons()
            number.text = ""
            hexNumber.text = ""
            decNumber.text = ""
            octNumber.text = ""
            binNumber.text = ""
        }
    }

    private fun hex() {
        hex.setOnClickListener {
            stats = 1
            enabledButtons()
            number.text = ""
            hexNumber.text = ""
            decNumber.text = ""
            octNumber.text = ""
            binNumber.text = ""
        }
    }

    private fun oct() {
        oct.setOnClickListener {
            stats = 2
            enabledButtons()
            number.text = ""
            hexNumber.text = ""
            decNumber.text = ""
            octNumber.text = ""
            binNumber.text = ""
        }
    }

    private fun bin() {
        bin.setOnClickListener {
            stats = 3
            enabledButtons()
            number.text = ""
            hexNumber.text = ""
            decNumber.text = ""
            octNumber.text = ""
            binNumber.text = ""
        }
    }

    fun onClickNumber(v: View) {
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

    private fun hexConvert() {
        val hexConversion = number.text.toString().toUInt().toString(16)
        hexNumber.text = hexConversion
    }

    private fun binConvert() {
        val binConversion = number.text.toString().toUInt().toString(2)
        binNumber.text = binConversion
    }

    private fun octConvert() {
        val octConversion = number.text.toString().toUInt().toString(8)
        octNumber.text = octConversion
    }

    private fun decConvert() {
        decNumber.text = number.text
    }

    private fun conversation() {
        hexConvert()
        binConvert()
        octConvert()
        decConvert()
    }

    private fun numberText() {
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

