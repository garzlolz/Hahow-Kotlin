package com.garz.myapplication01

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.garz.myapplication01.databinding.ActivityMaterialBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.content_material.*

class MaterialActivity : AppCompatActivity() {
    private var secret = SecretNumber()

    //private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMaterialBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("secrectNumber","Number is ${secret.secretNumbernumber}")
        super.onCreate(savedInstanceState)
        binding = ActivityMaterialBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.fab.setOnClickListener { view ->
            AlertDialog.Builder(this)
                .setTitle("提示")
                .setMessage("你要重玩嗎?")
                .setPositiveButton("Yes") { dailog, which ->
                    secret.reset()
                    label_counter.text = secret.count.toString()
                }
                .setNeutralButton("Cancel", null)
                .show()
        }
        val counter: TextView = findViewById(R.id.label_counter)
        counter.text = secret.count.toString()
    }

    fun check(view: View) {
        val edNumber: TextView = findViewById(R.id.ed_number)
        val value: Int = edNumber.text.toString().toInt()
        var message: String
        Log.d("MainActivity", "number: $value")
        if (secret.validate(value) > 0) {
            message = "小一點"
        } else if (secret.validate(value) < 0) {
            message = "大一點"
        } else {
            message = "答對了!"
            if (secret.count < 3)
                message =
                    "Excellent! The number is ${secret.secretNumbernumber}}、超神的! 數字就是 ${secret.secretNumbernumber}"
            Log.d("MainActivity", "secretNumber: ${secret.secretNumbernumber}")
        }
        val counter: TextView = findViewById(R.id.label_counter)
        counter.text = secret.count.toString()
        edNumber.text = null
        AlertDialog.Builder(this)
            .setTitle("提示")
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show()
    }
}