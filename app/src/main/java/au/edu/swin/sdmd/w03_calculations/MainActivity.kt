package au.edu.swin.sdmd.w03_calculations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var operation = "plus"
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number1 = findViewById<EditText>(R.id.number1)
        val number2 = findViewById<EditText>(R.id.number2)
        val answer = findViewById<TextView>(R.id.answer)

        val equals = findViewById<Button>(R.id.equals)
        equals.setOnClickListener {
            var result : Int = when (operation) {
                "plus" -> add(number1.text.toString(), number2.text.toString())
                "mult" -> multiply(number1.text.toString(), number2.text.toString())
                else -> add(number1.toString(), number2.toString())
            }
            // TODO: show result on the screen
            answer.text = result.toString()
        }
    }
    fun onRadioButtonClicked(view : View) {
        if (view is RadioButton) {
            val checked = view.isChecked

            when (view.id) {
                R.id.plusButton -> {
                    if (checked) {
                        operation = "plus"
                    }
                }
                R.id.multButton -> {
                    if (checked) operation = "mult"
                }
            }
        }
    }
    // adds two numbers together
    private fun add(number1: String, number2: String) : Int = number1.toInt() + number2.toInt()
    private fun multiply(number1 : String, number2: String) : Int = number1.toInt() * number2.toInt()
}