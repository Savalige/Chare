package com.puma.chare.ui.createUser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.puma.chare.R
import com.puma.chare.CreateUserActivity as CreateUser1


class CreateUser : Fragment() {

    companion object {
        fun newInstance() = CreateUser()
    }

    private lateinit var viewModel: CreateUserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val button: Button = R.id.userCreateButtonContinue1 as Button
        button.setOnClickListener {
            val act:CreateUser1 = activity as com.puma.chare.CreateUserActivity
            act.replaceFragments(CreateUser2());
        }
        return inflater.inflate(R.layout.fragment_create_user_1, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CreateUserViewModel::class.java)
        // TODO: Use the ViewModel
    }

}