package com.example.livechallenge

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    lateinit var dartBlue: ImageView
    lateinit var lightBlue: ImageView
    lateinit var purple: ImageView
    lateinit var red: ImageView
    lateinit var orange: ImageView
    lateinit var normalBlue: ImageView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        dartBlue = findViewById(R.id.dartBlue)
        lightBlue = findViewById(R.id.lightBlue)
        normalBlue = findViewById(R.id.normalBlue)
        purple = findViewById(R.id.purple)
        red = findViewById(R.id.red)
        orange = findViewById(R.id.orange)

        button.setOnClickListener(View.OnClickListener {
            fader(dartBlue, 0, 1800)
            fader(lightBlue, 300, 2100)
            fader(red, 600, 2400)
            fader(orange, 900, 2700)
            fader(purple, 1200, 3000)
            fader(normalBlue, 1500, 3300)
        })
    }

    private fun fader(view: View, time: Long, time1: Long) {
        val fader = ObjectAnimator.ofFloat(view, View.ALPHA, 1f,0f)
        fader.repeatCount = 1
        fader.repeatMode = ObjectAnimator.REVERSE
        fader.startDelay = time

        val fader1 = ObjectAnimator.ofFloat(view, View.ALPHA, 0f,1f)
        fader1.repeatCount = 1
        fader1.repeatMode = ObjectAnimator.REVERSE
        fader1.startDelay = time1
//        var color = ObjectAnimator.ofArgb(view,
//            "backgroundColor", Color.BLUE, Color.GREEN)
//        color.repeatMode = ObjectAnimator.REVERSE
//        color.repeatCount = 1
////
        val set = AnimatorSet()
        set.playTogether(fader, fader1)
        set.duration = 50
        set.start()
    }

//    private fun ObjectAnimator.disableView(view: View){
//        addListener(object: AnimatorListenerAdapter(){
//            override fun onAnimationEnd(animation: Animator?) {
//                super.onAnimationEnd(animation)
//                view.isEnabled = true
//            }
//
//            override fun onAnimationStart(animation: Animator?) {
//                super.onAnimationStart(animation)
//                view.isEnabled = false
//            }
//
//        })
//    }
}
