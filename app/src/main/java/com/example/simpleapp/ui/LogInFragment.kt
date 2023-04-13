package com.example.simpleapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.simpleapp.databinding.FragmentLogInBinding

class LogInFragment : Fragment() {

    //global var

    val userName:String="Ahmed"
    val password:String="Ahmed123"

    lateinit var binding: FragmentLogInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentLogInBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //set onclick listener direct to the button

        binding.btnLogin.setOnClickListener {
            if (!binding.edtUserName.text.toString().isNullOrEmpty()
                && !binding.edtPassword.text.toString().isNullOrEmpty()) {
                if (binding.edtUserName.text.toString().equals(userName)
                    && binding.edtPassword.text.toString().equals(password)) {
                    Toast.makeText(
                        context, "log in successfully", Toast.LENGTH_LONG
                    ).show()

                    //intent

//                    val intent= Intent(this, SecondActivity::class.java)
//
//                    intent.putExtra("UserName", binding.edtPassword.text.toString())
//                    startActivity(intent)

                    //set action to the fragment

                    var action = LogInFragmentDirections.
                    actionLogInFragmentToListFragment(userName)

                    findNavController().navigate(action)
    }
    }
        }
    }
}