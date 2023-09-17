package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var mode : String = "";
    private var accumulatedValues: String = ""
    private var accumulatedValues2: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonPlus = findViewById<Button>(R.id.buttonPlus)
        buttonPlus.setOnClickListener {
            mode = "plus"
        }
        val ButtonA = findViewById<Button>(R.id.buttonA)
        val ButtonB = findViewById<Button>(R.id.buttonB)
        val ButtonC = findViewById<Button>(R.id.buttonC)

        ButtonA.setOnClickListener {
            // Append value for button A to the accumulatedValues variable
            accumulatedValues += "A "
            updateTextView()
        }

        ButtonB.setOnClickListener {
            // Append value for button B to the accumulatedValues variable
            accumulatedValues += "B "
            updateTextView()
        }

        ButtonC.setOnClickListener {
            // Append value for button C to the accumulatedValues variable
            accumulatedValues += "C "
            updateTextView()
        }
//        OPERATORS
    }
    fun One(view: View?) {
        accumulatedValues2 += 1
        Toast.makeText(this, accumulatedValues2.toString(), Toast.LENGTH_SHORT).show()
    }

    fun Two(view: View?) {
        accumulatedValues2 += 2
        Toast.makeText(this, accumulatedValues2.toString(), Toast.LENGTH_SHORT).show()
    }

    fun Three(view: View?) {
        accumulatedValues2 += 3
        Toast.makeText(this, accumulatedValues2.toString(), Toast.LENGTH_SHORT).show()
    }
    var selectedNumber = 0;
    var selectedLetter = "";

    fun selectNumber(number: Int) {
        selectedNumber = number
    }
    fun selectedLetter(letter: String) {
        selectedLetter = letter
    }
    fun Operation1(view:View)
    {

        val ButtonA = findViewById<Button>(R.id.buttonA)
        val ButtonB = findViewById<Button>(R.id.buttonB)
        val ButtonC = findViewById<Button>(R.id.buttonC)
        val Button1 = findViewById<Button>(R.id.buttonOne)
        val Button2 = findViewById<Button>(R.id.buttonTwo)
        val Button3 = findViewById<Button>(R.id.buttonThree)


        Button1.setOnClickListener{selectNumber(1)}
        Button2.setOnClickListener{selectNumber(2)}
        Button3.setOnClickListener{selectNumber(3)}
        ButtonA.setOnClickListener{selectedLetter("A")}
        ButtonB.setOnClickListener{selectedLetter("B")}
        ButtonC.setOnClickListener{selectedLetter("C")}

        val buttonMinus = findViewById<Button>(R.id.buttonMinus)
        buttonMinus.setOnClickListener{subtractSelectedNumber()}

        val buttonPlus = findViewById<Button>(R.id.buttonPlus)
        buttonPlus.setOnClickListener{addSelectedNumber()}
    }
    fun subtractSelectedNumber() {
        var userInput: Int? = selectedNumber
        var userInputLetters = selectedLetter
        var subState=userInput.toString() + " minus " + accumulatedValues2.toString()

        // subtraction
        if (accumulatedValues.isEmpty()&&accumulatedValues2<=0) {
            Toast.makeText(this, "impossible", Toast.LENGTH_SHORT).show()
        }else if (userInput==1 || userInput==2 || userInput==3 && accumulatedValues2>0) {
            Toast.makeText(this,subState, Toast.LENGTH_SHORT).show()
            accumulatedValues2 = accumulatedValues2 - userInput
            var Result= "equals : "+accumulatedValues2.toString()
            Toast.makeText(this, accumulatedValues2.toString(), Toast.LENGTH_SHORT).show()
            if (accumulatedValues2<=0) {
                Toast.makeText(this, "impossible", Toast.LENGTH_SHORT).show()
            }
            userInput= 0;
            return
        }else{
            val ButtonA = findViewById<Button>(R.id.buttonA)
            val ButtonB = findViewById<Button>(R.id.buttonB)
            val ButtonC = findViewById<Button>(R.id.buttonC)

            ButtonA.setOnClickListener{selectedLetter("A")}
            ButtonB.setOnClickListener{selectedLetter("B")}
            ButtonC.setOnClickListener{selectedLetter("C")}
            val lastIndex = accumulatedValues.lastIndexOf(userInputLetters)
            if (lastIndex >= 0) {
                accumulatedValues =
                        accumulatedValues.substring(0, lastIndex) + accumulatedValues.substring(
                                lastIndex + 1
                        )
                updateTextView()
            }
        }




    }

    fun addSelectedNumber() {
        var userInput: Int? = selectedNumber
        var userInputLetters = selectedLetter
        var addState=userInput.toString() + " plus " + accumulatedValues2.toString()

        // subtraction
        if (accumulatedValues.isEmpty()&&accumulatedValues2<=0) {
            Toast.makeText(this, "impossible", Toast.LENGTH_SHORT).show()
        }else if (userInput==1 || userInput==2 || userInput==3 && accumulatedValues2>0) {

            Toast.makeText(this, addState, Toast.LENGTH_SHORT).show()
            accumulatedValues2 = accumulatedValues2 + userInput

            var addResult= "equals : "+accumulatedValues2.toString()
            userInput= 0;
            Toast.makeText(this, addResult, Toast.LENGTH_SHORT).show()
        }else if(userInputLetters=="A" || userInputLetters=="B" || userInputLetters=="C"){
            accumulatedValues += userInputLetters;
            updateTextView()
        }
//       ------ try
        val ButtonA = findViewById<Button>(R.id.buttonA)
        val ButtonB = findViewById<Button>(R.id.buttonB)
        val ButtonC = findViewById<Button>(R.id.buttonC)
        ButtonA.setOnClickListener {
            // Append value for button A to the accumulatedValues variable
            accumulatedValues += "A "
            updateTextView()
        }

        ButtonB.setOnClickListener {
            // Append value for button B to the accumulatedValues variable
            accumulatedValues += "B "
            updateTextView()
        }

        ButtonC.setOnClickListener {
            // Append value for button C to the accumulatedValues variable
            accumulatedValues += "C "
            updateTextView()
        }
    }

    fun updateTextView() {
        Toast.makeText(this, accumulatedValues, Toast.LENGTH_SHORT).show()
    }
}