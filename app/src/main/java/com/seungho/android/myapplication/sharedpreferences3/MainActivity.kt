package com.seungho.android.myapplication.sharedpreferences3

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.seungho.android.myapplication.sharedpreferences3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val preference = getPreferences(Context.MODE_PRIVATE)
        val editor = preference.edit()

        var prefText = preference.getString("PrefText", "")

        binding.loadTextView.setText(prefText)

        binding.saveBtn.setOnClickListener {
            prefText = binding.editText.text.toString()
            editor.putString("PrefText", prefText)
            editor.apply()
            Toast.makeText(this, "텍스트를 저장했습니다. LOAD 버튼을 누르거나 어플을 다시 실행하여 갱신하세요", Toast.LENGTH_SHORT).show()
        }

        binding.loadBtn.setOnClickListener {
            binding.loadTextView.setText(prefText)
            Toast.makeText(this, "텍스트를 불러왔습니다", Toast.LENGTH_SHORT).show()
        }
    }
}