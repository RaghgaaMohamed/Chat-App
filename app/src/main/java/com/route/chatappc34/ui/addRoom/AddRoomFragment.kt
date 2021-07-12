package com.route.chatappc34.ui.addRoom

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.route.chatappc34.R
import com.route.chatappc34.databinding.ActivityAddRoomBinding
import com.route.islamigsun.base.BaseFragment

class AddRoomFragment:BaseFragment<ActivityAddRoomBinding,AddRoomViewModel>(),Navigator {

    override fun getLayoutId(): Int {
        return R.layout.activity_add_room
    }

    override fun initializeViewModel(): AddRoomViewModel {
        return ViewModelProvider(this).get(AddRoomViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.vm=viewModel;
        viewModel.navigator=this
        viewModel.roomAdded.observe(viewLifecycleOwner, Observer {
            showDialoge(message = "room Added successfully",
                posActionName = "ok",
                posAction = DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                },
                isCancelable = false)


        })
    }
}