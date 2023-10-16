package com.social.meetyourfriends.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.social.meetyourfriends.R
import com.social.meetyourfriends.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var loginBinding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       loginBinding=DataBindingUtil.setContentView(this,R.layout.activity_login)

        loginBinding.textViewSignUp.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
            this.finish()
        }
    }
}