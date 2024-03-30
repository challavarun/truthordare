package com.example.truthordare



import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var ivBottle: ImageView
    private lateinit var btnSpin: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivBottle = findViewById(R.id.iv_bottle)
        btnSpin = findViewById(R.id.btn_spin)
        tvResult = findViewById(R.id.tv_result)

        btnSpin.setOnClickListener {
            spinBottle()
        }
    }

    private fun spinBottle() {
        val random = Random()
        val degrees = random.nextInt(3600) + 360 // Random angle between 360 and 3960 degrees for more than one full rotation

        val rotateAnimation = RotateAnimation(
            0f, degrees.toFloat(),
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )

        rotateAnimation.duration = 2000 // Duration for rotation (2 seconds)
        rotateAnimation.fillAfter = true // Keeps the final state of the animation after it finishes

        ivBottle.startAnimation(rotateAnimation)

        // Delay the result display to match the duration of the spin animation
        ivBottle.postDelayed({
            displayResult()
        }, 2000)
    }

    private fun displayResult() {
        val random = Random()
        val isTruth = random.nextBoolean() // Randomly select whether it's truth or dare

        if (isTruth) {
            tvResult.text = "Truth"
        } else {
            tvResult.text = "Dare"
        }
    }
}
