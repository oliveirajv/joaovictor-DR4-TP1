package com.example.crispy_octo_lamp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonRegister = this.findViewById<Button>(R.id.buttonRegister)
        buttonRegister.setOnClickListener {
            val file = File(this.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), "text")
            val fileOutputStream = FileOutputStream(file)
            val editTextUserInputText = this.findViewById<EditText>(R.id.editTextUserInput)
            fileOutputStream.write(editTextUserInputText.text.toString().toByteArray())
            fileOutputStream.close()
            editTextUserInputText.text = null

        val buttonShow = this.findViewById<Button>(R.id.buttonShow)
        buttonShow.setOnClickListener {
            val file = File(this.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), "text")
            val fileInputStream = FileInputStream(file)
            val bytes = fileInputStream.readBytes()
            fileInputStream.close()
            val textViewFiles = this.findViewById<TextView>(R.id.textViewFiles)
            textViewFiles.text = String(bytes)
        }
        }
    }
}