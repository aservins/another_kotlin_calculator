package com.exodoestudios.micalculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity(), View.OnClickListener  {

    // guardar el resultado parcial o final
    private var resultado by Delegates.notNull<Double>()

    private var operacion by Delegates.notNull<Int>()
    /*
    si es una suma, operacion va ser igual a 0
    si es una resta, operacion va ser igual a 1
    si es una multiplicacion, operacion va ser igual a 2
    si es una division, operación va ser igual a 3
    si es porcentaje, operación va ser igual a 4
    si es igual, operación va ser igual a -1
     */

    // igual se utilizará cuando se presiona el boton de resultado (=)
    private var igual by Delegates.notNull<Boolean>()

    // despliga el resultado en pantalla (display)
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        operacion = -1
        resultado = 0.0
        igual = false

        textViewResult = findViewById<TextView>(R.id.textViewResult)

        val button0 = findViewById<Button>(R.id.button0)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)

        val buttonSign = findViewById<Button>(R.id.buttonSign)
        val buttonDelete = findViewById<Button>(R.id.buttonDelete)
        val buttonPoint = findViewById<Button>(R.id.buttonPoint)
        val buttonClear = findViewById<Button>(R.id.buttonClear)
        val buttonPercentage = findViewById<Button>(R.id.buttonPercentage)

        val buttonRest = findViewById<Button>(R.id.buttonRest)
        val buttonSum = findViewById<Button>(R.id.buttonSum)
        val buttonDivision = findViewById<Button>(R.id.buttonDivision)
        val buttonMult = findViewById<Button>(R.id.buttonMult)
        val buttonEqual = findViewById<Button>(R.id.buttonEqual)

        button0.setOnClickListener(this)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)

        buttonSign.setOnClickListener(this)
        buttonDelete.setOnClickListener(this)
        buttonPoint.setOnClickListener(this)
        buttonClear.setOnClickListener(this)
        buttonPercentage.setOnClickListener(this)

        buttonRest.setOnClickListener(this)
        buttonSum.setOnClickListener(this)
        buttonDivision.setOnClickListener(this)
        buttonMult.setOnClickListener(this)
        buttonEqual.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
            when(p0.id)
            {
                R.id.button0 ->
                {
                    textViewResult.text = Concatena("0", textViewResult.text.toString())
                }
                R.id.button1 ->
                {
                    textViewResult.text = Concatena("1", textViewResult.text.toString())
                }
                R.id.button2 ->
                {
                    textViewResult.text = Concatena("2", textViewResult.text.toString())
                }
                R.id.button3 ->
                {
                    textViewResult.text = Concatena("3", textViewResult.text.toString())
                }
                R.id.button4 ->
                {
                    textViewResult.text = Concatena("4", textViewResult.text.toString())
                }
                R.id.button5 ->
                {
                    textViewResult.text = Concatena("5", textViewResult.text.toString())
                }
                R.id.button6 ->
                {
                    textViewResult.text = Concatena("6", textViewResult.text.toString())
                }
                R.id.button7 ->
                {
                    textViewResult.text = Concatena("7", textViewResult.text.toString())
                }
                R.id.button8 ->
                {
                    textViewResult.text = Concatena("8", textViewResult.text.toString())
                }
                R.id.button9 ->
                {
                    textViewResult.text = Concatena("9", textViewResult.text.toString())
                }
                R.id.buttonSign ->
                {
                    var x = textViewResult.text.toString().toDouble()
                    x = x * -1.0
                    textViewResult.text = x.toString()
                }
                R.id.buttonDelete ->
                {
                    var delete = textViewResult.text.toString()
                    if (delete.compareTo("0") != 0)
                    {
                        // 8475738 => de la posición 0 a las n - 1 = 847573
                        delete = delete.substring(0, delete.length - 1)
                    }
                    if (delete.isEmpty())
                    {
                        delete = "0"
                    }
                    textViewResult.text = delete
                }
                R.id.buttonPoint ->
                {
                    if (!textViewResult.text.toString().contains("."))
                    {
                        textViewResult.text = Concatena(".", textViewResult.text.toString())
                    }
                }
                R.id.buttonClear ->
                {
                    textViewResult.text = "0"
                    operacion = -1
                    resultado = 0.0
                    igual = false
                }
                R.id.buttonPercentage ->
                {
                    RealizaOperacion(operacion, textViewResult.text.toString())
                    operacion = 4
                }
                R.id.buttonRest ->
                {
                    RealizaOperacion(operacion, textViewResult.text.toString())
                    operacion = 1
                }
                R.id.buttonSum ->
                {
                    RealizaOperacion(operacion, textViewResult.text.toString())
                    operacion = 0
                }
                R.id.buttonDivision ->
                {
                    RealizaOperacion(operacion, textViewResult.text.toString())
                    operacion = 3
                }
                R.id.buttonMult ->
                {
                    RealizaOperacion(operacion, textViewResult.text.toString())
                    operacion = 2
                }
                R.id.buttonEqual ->
                {
                    RealizaOperacion(operacion, textViewResult.text.toString())
                    igual = true
                    operacion = -1
                    if (resultado != 0.0)
                    {
                        textViewResult.text = resultado.toString()
                    }
                    else
                    {
                        textViewResult.text = "0"
                        igual = false
                    }
                }
            }
        }
    }

    private fun Concatena (numero: String, display: String) : String
    {
        var r = ""
        if (display.length < 10)
        {
            if (display.compareTo("0") != 0 || display.contains("0."))
            {
                if (igual)
                {
                    r = numero
                }
                else
                {
                    r = display + numero //CONCTATENANDO ES DECIR SI EN DISPLAY HAY UN 5 Y EN NUMERO 4
                }
            }
            else
            {
                if (numero.compareTo(".") == 0)
                {
                    r = display + numero
                }
                else
                {
                    r = numero
                }
            }
        }
        else
        {
            Toast.makeText(this, "Excede del rango de valores que podemos soportar", Toast.LENGTH_LONG).show()
            r = display
        }
        return r
    }

    private fun RealizaOperacion(op: Int, display: String)
    {
        when(op)
        {
            0 -> resultado = resultado + display.toDouble() // resultado += display.toDouble()
            1 -> resultado = resultado - display.toDouble() // resultado -= display.toDouble()
            2 -> resultado = resultado * display.toDouble() // resultado *= display.toDouble()
            3 ->
            {
                if (resultado != 0.0)
                {
                    if (display.toDouble() != 0.0)
                    {
                        resultado = resultado / display.toDouble() // resultado /= display.toDouble()
                    }
                    else
                    {
                        Toast.makeText(this, "ERROR: DIVISION ENTRE CERO", Toast.LENGTH_LONG).show()
                        resultado = 0.0
                    }
                }
                else
                {
                    resultado = display.toDouble()
                }
            }
            4 -> resultado = (resultado * display.toDouble()) / 100
            -1 -> resultado = display.toDouble()
        }
        textViewResult.text = "0"
    }

}
