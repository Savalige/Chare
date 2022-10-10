package com.puma.chare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class CreateUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)

    }

    public fun replaceFragments(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView2, fragment)
            commit()
        }
    }
}