package com.example.simplechronometer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import com.example.simplechronometer.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var running = false
    var inPause: Long = 0
    var time_value: Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.start.setOnClickListener{
            StartChronometer()
        }

        binding.pause.setOnClickListener{
            PauseChronometer()
        }

        binding.reset.setOnClickListener{
            ResetChronometer()
        }

    }
    private fun StartChronometer(){
        if(!running){
            binding.chronometer.base = SystemClock.elapsedRealtime() - inPause
            binding.chronometer.start()
            running = true
        }
    }
    private fun PauseChronometer(){
        if(running){
            inPause = SystemClock.elapsedRealtime() - binding.chronometer.base
            binding.chronometer.stop()
            running = false
        }
    }
    private fun ResetChronometer(){
        binding.chronometer.base = SystemClock.elapsedRealtime()
        inPause = 0
    }

}