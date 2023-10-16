package com.social.meetyourfriends.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.social.meetyourfriends.R
import com.social.meetyourfriends.databinding.ActivitySignUpBinding
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {
    lateinit var signUpBinding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signUpBinding=DataBindingUtil.setContentView(this ,R.layout.activity_sign_up)

        signUpBinding.showPassBtn.setOnTouchListener( object : OnTouchListener{
            override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
                when (p1?.action) {
                    MotionEvent.ACTION_DOWN -> Toast.makeText(this@SignUpActivity, "eye clicked",Toast.LENGTH_SHORT).show()
                }
                return p0?.onTouchEvent(p1) ?: true
            }

        })

    }

    fun isGmailAddress(email: String): Boolean {
        val gmailPattern = "[a-zA-Z0-9._%+-]+@gmail\\.com"
        val pattern = Pattern.compile(gmailPattern)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }






}