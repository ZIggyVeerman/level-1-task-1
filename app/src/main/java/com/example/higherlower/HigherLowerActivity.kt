package com.example.higherlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_higher_lower.*

class HigherLowerActivity : AppCompatActivity() {

  private var currentThrow: Int = 6
  private var lastThrow: Int = 6

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_higher_lower)
    initViews()
  }

  /**
   * Set the initial (UI) state of the game.
   */
  private fun initViews() {
    btnhigher.setOnClickListener {
      onHigherClick()
    }
    btnequal.setOnClickListener{
      onEqualClick()
    }
    btnlower.setOnClickListener{
      onLowerClick()
    }

    updateUI()

  }

  /**
   * Update the last throw text and the dice image resource drawable with the current throw.
   */
  private fun updateUI() {
    tvLastThrow.text = getString(R.string.last_Throw, lastThrow)

    val image = resources.getIdentifier("dice${lastThrow}", "drawable", packageName)

    imageView.setImageResource(image)
  }
  /**
   * Replaces the previous dice value with the current one and replaces the current dice with a new dice
   * with a random number between 1 and 6 (inclusive).
   */
  private fun rollDice() {
    lastThrow = currentThrow
    currentThrow = (1..6).random()
    updateUI()
  }

  /**
   * Calls [rollDice] and checks if the answer is correct.
   */
  private fun onHigherClick() {
    if(currentThrow > lastThrow){
      onAnswerCorrect()
    }else{
      onAnswerIncorrect()
    }

    rollDice()
  }

  /**
   * Calls [rollDice] and checks if the answer is correct.
   */
  private fun onLowerClick() {
    if(currentThrow < lastThrow){
      onAnswerCorrect()
    }else{
      onAnswerIncorrect()
    }

    rollDice()
  }

  /**
   * Calls [rollDice] and checks if the answer is correct.
   */
  private fun onEqualClick() {
    if(currentThrow == lastThrow){
      onAnswerCorrect()
    }else{
      onAnswerIncorrect()
    }

    rollDice()
  }

  /**
   * Displays a successful Toast message.
   */
  private fun onAnswerCorrect() {
    Toast.makeText(this, R.string.correct, Toast.LENGTH_LONG).show()


  }

  /**
   * Displays a incorrect Toast message.
   */
  private fun onAnswerIncorrect() {
    Toast.makeText(this, R.string.incorrect, Toast.LENGTH_LONG).show()


  }


}
