package com.social.meetyourfriends.view

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth

import com.social.meetyourfriends.R
import com.social.meetyourfriends.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    lateinit var splashBinding: ActivitySplashBinding
    lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding=DataBindingUtil.setContentView(this,R.layout.activity_splash)
        splashBinding.splashPbar.visibility= View.VISIBLE




        if( isNetworkAvailable(this)){
            auth=FirebaseAuth.getInstance()

            Handler().postDelayed(Runnable {
                splashBinding.splashPbar.visibility=View.GONE
                if(auth.currentUser !=null){
                    startActivity(Intent(this, MainActivity::class.java));
                     this.finish()
                }
                else{
                    startActivity(Intent(this, LoginActivity::class.java))
                    this.finish()
                }
            }, 2000)
        }
        else{
            Toast.makeText(this,"Sorry, No InterNet Connection!", Toast.LENGTH_LONG).show()
        }






    }

    fun isNetworkAvailable(context: Context?): Boolean {
        if (context == null) return false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false
    }


}