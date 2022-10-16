package com.example.convertirdivisas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.convertirdivisas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var spinner: Spinner
    lateinit var spinner2: Spinner
    var opcion: Int = 0
    var secondopcion: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        val total=binding.textResult
        val cant=binding.cant.text
        var final: Double = 0.0
        val btn=binding.btnConv
        spinner = binding.spinner
        spinner2 = binding.spinner2

        ArrayAdapter.createFromResource(
            this,
            R.array.divisas,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
            spinner2.adapter = adapter
        }
        spinner.onItemSelectedListener = this
        spinner2.onItemSelectedListener = this
        btn.setOnClickListener {
            if (cant.toString().isNotEmpty()) {
                val cantsec: Double = cant.toString().toDouble()
                when (opcion) {
                    0 -> {
                        when (secondopcion) {
                            0 -> {
                                final = cantsec
                            }
                            1 -> {
                                final = cantsec * 0.050
                            }
                            2 -> {
                                final = cantsec * 0.057
                            }
                        }
                    }
                    1 -> {
                        when (secondopcion) {
                            0 -> {
                                final = cantsec * 20
                            }
                            1 -> {
                                final = cantsec
                            }
                            2 -> {
                                final = cantsec * 1.02
                            }
                        }
                    }
                    2 -> {
                        when (secondopcion) {
                            0 -> {
                                final = cantsec * 19.54
                            }
                            1 -> {
                                final = cantsec * 0.98
                            }
                            2 -> {
                                final = cantsec
                            }
                        }
                    }
                }
                total.text = String.format("La conversión es: %.2f", final)
            }
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        if(p0 != null){
            if(p0.id==spinner.id){
                opcion=p2
            }else if(p0.id==spinner2.id){
                secondopcion=p2
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}