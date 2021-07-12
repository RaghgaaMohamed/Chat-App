package com.route.chatappc34.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.route.chatappc34.R
import com.route.chatappc34.databinding.ActivityLoginBinding
import com.route.chatappc34.ui.home.HomeActivity
import com.route.chatappc34.ui.register.RegisterActivity
import com.route.islamigsun.base.BaseFragment

class LoginFragment:BaseFragment<ActivityLoginBinding,LoginViewModel>(),Navigator {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.viewModel = viewModel
        viewModel.navigator = this
    }


    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initializeViewModel(): LoginViewModel {
        return ViewModelProvider(this).get(LoginViewModel::class.java)//initialize
    }

    override fun gotoRegister() {
       /** val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    */
        findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
    }

    override fun gotoHome() {
       /** val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)*/

        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
    }
}