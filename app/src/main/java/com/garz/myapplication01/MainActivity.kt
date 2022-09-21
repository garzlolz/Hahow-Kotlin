package com.garz.myapplication01
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var secret = SecretNumber()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity", "secretNumber: ${secret.secretNumbernumber}")
    }

    fun check(view: View) {
        var ed_number:TextView = findViewById(R.id.ed_number)
        val value: Int = ed_number.text.toString().toInt()
        val message: String
        Log.d("MainActivity", "number: $value")
        if (secret.validate(value) > 0) {
            message = "小一點"
        } else if (secret.validate(value) < 0) {
            message = "大一點"
        } else {
            message = "答對了!"
            secret = SecretNumber()
            Log.d("MainActivity", "secretNumber: ${secret.secretNumbernumber}")
        }
        ed_number.setText(null);
        AlertDialog.Builder(this)
            .setTitle("提示")
            .setMessage(message)
            .setPositiveButton("OK",null)
            .show()
    }
}