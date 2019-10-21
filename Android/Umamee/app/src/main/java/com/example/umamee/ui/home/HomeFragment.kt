package com.example.umamee.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.umamee.R
import com.example.umamee.SignInActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlin.math.sign

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(this, Observer {
            textView.text = it
        })

        //find the button in the fragment then set the onclick listener
        val signout: Button = root.findViewById(R.id.sign_out)
        signout.setOnClickListener{
            if (container?.context != null) {
                signOut(container.context)
            }
        }
        return root
    }

    private fun signOut(c: Context) {
        startActivity(SignInActivity.getLaunchIntent(c))
        FirebaseAuth.getInstance().signOut()
    }
}