package com.puma.chare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.puma.chare.ui.login.ui.login.login

class CreateUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)
        Log.d("PAIN", MyApplication.profileID.toString())
        if (MyApplication.profileID == -1) {
            MyApplication.profileID = -2
            Log.d("PAIN",MyApplication.profileID.toString())
            replaceFragments(login())
        }
    }

    public fun replaceFragments(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.userCreateFragmentContainerView, fragment)
            commit()
        }
    }
}