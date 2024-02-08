package com.parham.msu.geoquizagain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.parham.msu.geoquizagain.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    //private lateinit var trueButton : Button
    //private lateinit var falseButton : Button

    private val questionBank = listOf(
        Question(R.string.question_australia, answer = true),
        Question(R.string.question_ocean, answer = true),
        Question(R.string.question_mideast, answer = false),
        Question(R.string.question_Africa, answer = false),
        Question(R.string.question_americas, answer = true),
        Question(R.string.question_asia, answer = true)
    )
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //trueButton = findViewById(R.id.true_button)
        //falseButton = findViewById(R.id.False_button)


        binding.trueButton.setOnClickListener{
            checkAnswer(true)
        }
        binding.FalseButton.setOnClickListener{
            checkAnswer(false)
        }

        binding.nextButton.setOnClickListener{
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
        }
        binding.questionTextview.setOnClickListener{
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
        }
        binding.previousButton.setOnClickListener{
            currentIndex = if (currentIndex > 0) {
                (currentIndex - 1) % questionBank.size
            } else {
                questionBank.size - 1 // Set currentIndex to the last index if it's already 0
            }
            updateQuestion()
        }

        updateQuestion()
    }
    private fun updateQuestion() {
        val questiontextResId = questionBank[currentIndex].textResId
        binding.questionTextview.setText(questiontextResId)
    }
    private fun checkAnswer(userAnswer:Boolean) {
        val correctAnswer = questionBank[currentIndex].answer

        val messageResId = if (userAnswer == correctAnswer){
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
            .show()
    }
}
