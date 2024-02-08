package com.parham.msu.trafficlight

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isInvisible
import com.parham.msu.trafficlight.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private var traffic: Int = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.redButton.setOnClickListener{
            if (traffic == 1) {
                binding.redButton.setBackgroundColor(Color.RED)
                binding.redButton.setTextColor(Color.BLACK)
                binding.redButton.text ="STOP"
                binding.redImageView.visibility = View.VISIBLE
                binding.greenImageView.visibility = View.INVISIBLE
                binding.yellowImageView.visibility = View.INVISIBLE
                traffic = (traffic + 1)

            } else if (traffic == 2) {
                binding.redButton.setBackgroundColor(Color.GREEN)
                binding.redButton.setTextColor(Color.BLACK)
                binding.redButton.text ="GO"
                binding.redImageView.visibility = View.INVISIBLE
                binding.greenImageView.visibility = View.VISIBLE
                binding.yellowImageView.visibility = View.INVISIBLE
                traffic = (traffic + 1)
            }
            else if (traffic == 3) {
                binding.redButton.setBackgroundColor(Color.YELLOW)
                binding.redButton.setTextColor(Color.BLACK)
                binding.redButton.text ="WAIT"
                binding.redImageView.visibility = View.INVISIBLE
                binding.greenImageView.visibility = View.INVISIBLE
                binding.yellowImageView.visibility = View.VISIBLE
                traffic = (traffic - 2)
            }
        }




    }
}