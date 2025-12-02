package com.example.account.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.account.R
import com.example.account.ui.login.LoginFragment
import com.example.account.ui.register.RegisterFragment

class MainActivity : AppCompatActivity() {

    companion object {
        const val SAVE_PREF = "save_pref"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            gotoLoginScreen()
        }
    }

    fun gotoRegisterScreen() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, RegisterFragment())
            .addToBackStack(null)
            .commit()
    }

    fun gotoLoginScreen() {
        supportFragmentManager.popBackStack()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, LoginFragment())
            .commit()
    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun saveLastLogin(email: String) {
        val pref = getSharedPreferences(SAVE_PREF, Context.MODE_PRIVATE)
        pref.edit().putString("last_email", email).apply()
    }
}

