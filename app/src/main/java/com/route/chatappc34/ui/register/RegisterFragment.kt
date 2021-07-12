package com.route.chatappc34.ui.register

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.route.chatappc34.R
import com.route.chatappc34.databinding.ActivityRegisterBinding
import com.route.chatappc34.ui.home.HomeActivity
import com.route.islamigsun.base.BaseFragment

class RegisterFragment:BaseFragment<ActivityRegisterBinding,RegisterViewModel>(),Navigator {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.vm = viewModel
        viewModel.navigator=this
    }
    override fun getLayoutId(): Int {
        return R.layout.activity_register
    }

    override fun initializeViewModel(): RegisterViewModel {
        return ViewModelProvider(this).get(RegisterViewModel::class.java)
    }

    override fun gotoHomeActivity() {
      /**  val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)*/

        findNavController().navigate(R.id.action_registerFragment_to_homeFragment)
    }
}