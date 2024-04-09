package com.example.uzbekistan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.navigation.findNavController
import com.example.uzbekistan.databinding.ActivityEnterAnimationBinding
import com.example.uzbekistan.fragmnets.LoginFragment

private  var binding: ActivityEnterAnimationBinding?=null
private lateinit var handler: Handler

class enterAnimation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnterAnimationBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding!!.animname.animate().translationY(0F).setDuration(2700).startDelay = 0
        binding!!.lottie.animate().translationX(0F).setDuration(2000).startDelay = 0
        binding.apply {

            handler = Handler()
            handler.postDelayed({
                val intent = Intent(applicationContext, SignActivity::class.java)
                startActivity(intent)
            }, 3000)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}