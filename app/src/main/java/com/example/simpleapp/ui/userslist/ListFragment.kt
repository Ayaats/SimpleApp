package com.example.simpleapp.ui.userslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.simpleapp.R
import com.example.simpleapp.databinding.FragmentListBinding
import com.example.simpleapp.model.entity.User
import com.example.simpleapp.model.local.LocalRepositoryImp
import com.example.simpleapp.model.local.UserDatabase
import com.example.simpleapp.ui.adapter.OnListItemClicked
import com.example.simpleapp.ui.adapter.UserRecyclerView
import kotlinx.coroutines.*


class ListFragment : Fragment() , OnListItemClicked {

    lateinit var binding: FragmentListBinding

    var userList : List <User> = emptyList()

    var userName: String? = null

    val userRecyclerView: UserRecyclerView by lazy {
        UserRecyclerView()
    }

   lateinit var viewModel: UsersViewModel

//   lateinit var localRepositoryImp:LocalRepositoryImp


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        if (intent!=null){
//
//            userName = intent.extras!!.get("UserName").toString()
//
//            Toast.makeText(this,
//                "user name is $userName", Toast.LENGTH_LONG)
//                .show()
//        }

//        var db=UserDatabase.getInstance(requireContext())
//        //add local repo
//
//        localRepositoryImp= LocalRepositoryImp(db)

        binding.rvShowData.adapter=userRecyclerView

        getAllUsers()



        //add action to button

        userName=arguments?.getString(userName)

        //view model

        viewModel =ViewModelProvider(requireActivity()).get(UsersViewModel::class.java)

        binding.btnAdd.setOnClickListener{

            //apply update and insert

//            db.userDao().insertOrUpdateUser(
//                User(
//                    0,
//                    userName.toString(),
//                    binding.edtMessage.text.toString(),
//                    R.drawable.app
//                )
//
//            )
            //you shouldn't use any thing UI in scope
            var msg=binding.edtMessage.text.toString()

            // view model way

            viewModel.addAPIUser(
                User(
                    10,
                    userName.toString(),
                    msg,
                    R.drawable.app
                )
            )

            //coroutine fun should be implement in scope

//            GlobalScope.launch(Dispatchers.IO) {
//                localRepositoryImp.insertOrUpdateUser(
//                    User(
//                        0,
//                        userName.toString(),
//                        msg,
//                        R.drawable.app
//                    )
//                )
//
//            }
//            userList.add(
//                User(
//               0,
//                userName.toString(),
//                binding.edtMessage.text.toString(),
//                R.drawable.app
//                )
//            )
            binding.edtMessage.setText("") }

        getAllUsers()

        userRecyclerView.onListItemClicked=this

        viewModel.userAPILiveData.observe(viewLifecycleOwner, Observer {
            if (it != null){
                userRecyclerView.setList(it)
                binding.progressBar.visibility=View.GONE

            }
        })
    }


// fun for get all users
    fun getAllUsers(){
      viewModel.getAPIUsers()
//    viewModel.getUsers()
      binding.progressBar.visibility=View.VISIBLE
//        GlobalScope.launch(Dispatchers.IO) {
//            var returnedUsers = async {
//                localRepositoryImp.getUsers()
//            }
//            withContext(Dispatchers.IO){
//                userList=returnedUsers.await()
//                binding.progressBar.visibility=View.GONE
//                userRecyclerView.setList(userList)
//            }

    }

    override fun onItemClicked(user: User) {

//        GlobalScope.launch(Dispatchers.IO){
//            localRepositoryImp.deleteUser(user)
//        }

        viewModel.deleteUser(user)

        getAllUsers()

        Toast.makeText(context
            ,"the user is deleted}"
            ,Toast.LENGTH_SHORT).show()
    }
}

