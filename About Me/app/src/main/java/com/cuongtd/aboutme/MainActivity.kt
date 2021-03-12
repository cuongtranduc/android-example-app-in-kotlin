package com.cuongtd.aboutme

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.cuongtd.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;
    private val myName = MyName("Cuong Tran Duc");

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.myName = myName;

//        findViewById<Button>(R.id.button_submit_name).setOnClickListener {
//            submitName(it);
//        }

        binding.buttonSubmitName.setOnClickListener {
            submitName(it);
        }
    }

    fun submitName(view: View) {
        binding.apply {
            invalidateAll();
            myName?.nickName = editTextNickName.text.toString();
            textViewNickName.visibility = View.VISIBLE;
            editTextNickName.visibility = View.GONE;
            buttonSubmitName.visibility = View.GONE;
        }

//        val editTextNickName = findViewById<EditText>(R.id.editText_nickName);
//        val textViewNickName = findViewById<TextView>(R.id.textView_nickName);
//
//        textViewNickName.text = editTextNickName.text;
//        textViewNickName.visibility = View.VISIBLE;
//        editTextNickName.visibility = View.GONE;
    }
}