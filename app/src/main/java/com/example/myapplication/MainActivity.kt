package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){//, MiView {
    private lateinit var binding: ActivityMainBinding
    //private val miViewModel: MiViewModel by viewModels()
    private var num=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.setText("hola")
        binding.button.setOnClickListener{apretar(it)}
    }
    //override
    fun apretar(view: View){
        num++
        binding.textView.setText(num.toString())
    }

    /*override fun onResume() {
        super.onResume()
        miViewModel.view = this
    }
    override fun onPause() {
        super.onPause()
        miViewModel.view = null
    }*/
}

interface MiView {
    fun apretar(view:View)
}

class MiViewModel: ViewModel() {
    var view: MiView? = null
        set(value) {
            field = value
            updateView()
        }
    private fun updateView() = view?.apply {
    }
}