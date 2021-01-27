package no.uia.ikt205.pomodoro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import no.uia.ikt205.pomodoro.util.millisecondsToDescriptiveTime
import no.uia.ikt205.pomodoro.util.minutesToMilliSeconds

class MainActivity : AppCompatActivity() {

    lateinit var timer:CountDownTimer
    lateinit var startButton:Button
    lateinit var coutdownDisplay:TextView

    var timeToCountDownInMs = 5000L
    val timeTicks = 1000L
    val buttonMinuteTimeIncrement = 30L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       startButton = findViewById<Button>(R.id.startCountdownButton)
       startButton.setOnClickListener(){
           startCountDown(it)
       }
       coutdownDisplay = findViewById<TextView>(R.id.countDownView)

       val setTimeDurationButtons = listOf<Button>(findViewById<Button>(R.id.setTimeDurationTo30MinutesBt),findViewById<Button>(R.id.setTimeDurationTo60MinutesBt),findViewById<Button>(R.id.setTimeDurationTo90MinutesBt),findViewById<Button>(R.id.setTimeDurationTo120MinutesBt))

        setTimeDurationButtons.forEachIndexed { index, button ->
            button.setOnClickListener(){
                if(startButton.isEnabled){
                    val newCountdownTime = minutesToMilliSeconds((index+1) * buttonMinuteTimeIncrement)
                    setCountDownTime(newCountdownTime)
                }
            }
        }

    }

    fun setCountDownTime(newCountDownTimeInMs:Long){
        timeToCountDownInMs = newCountDownTimeInMs
        updateCountDownDisplay(timeToCountDownInMs)
    }

    fun startCountDown(v: View){

        timer = object : CountDownTimer(timeToCountDownInMs,timeTicks) {
            override fun onFinish() {
                v.isEnabled = true
                Toast.makeText(this@MainActivity,"Arbeidsøkt er ferdig", Toast.LENGTH_SHORT).show()
            }

            override fun onTick(millisUntilFinished: Long) {
               updateCountDownDisplay(millisUntilFinished)
            }
        }
        v.isEnabled = false
        timer.start()
    }

    fun updateCountDownDisplay(timeInMs:Long){
        coutdownDisplay.text = millisecondsToDescriptiveTime(timeInMs)
    }

}