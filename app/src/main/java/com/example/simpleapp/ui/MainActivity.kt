package com.example.simpleapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.simpleapp.R
import com.example.simpleapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    //global references

   lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)







//                    startActivity(Intent(this, SecondActivity::class.java).apply {
//                        // you can add values(if any) to pass to the next class or avoid using `.apply`
//                        putExtra("UserName", edt_password.text.toString())
//                    })
                }
            }

        //set action to the btn
//        btn_login.setOnClickListener(this)



//    override fun onClick(v: View?) {
//        when(v!!.id){
//            R.id.btn_login->{
//                Toast.makeText(
//                    this,"log in button clicked", Toast.LENGTH_LONG
//                ).show()
//            }
//        }
//
//    }

//    fun onClickLogin(view:View){
//        Toast.makeText(
//            this,"log in button clicked", Toast.LENGTH_LONG
//        ).show()
//    }
