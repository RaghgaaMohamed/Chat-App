package com.route.chatappc34.ui.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.route.chatappc34.R
import com.route.chatappc34.database.model.Room
import com.route.chatappc34.databinding.ActivityHomeBinding
import com.route.islamigsun.base.BaseFragment

class HomeFragment:BaseFragment<ActivityHomeBinding,HomeViewModel>(),Navigator {
    lateinit var roomsAdapter :RoomsRecyclerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.vm=viewModel
        viewModel.navigator=this
        setUpViews()
        observeLiveData()
    }


    fun observeLiveData(){
        viewModel.roomsLiveData.observe(viewLifecycleOwner, Observer {
            roomsAdapter.changeData(it)
        })
    }
    override fun onStart() {
        super.onStart()
        viewModel.getRoomsList()
    }
    private fun setUpViews() {
        roomsAdapter = RoomsRecyclerAdapter(listOf())
        roomsAdapter.onItemClickListener = object :RoomsRecyclerAdapter.OnItemClickListener{
            override fun onItemClick(position: Int, room: Room) {
              /**  val intent = Intent(this@HomeActivity,
                    RoomDetailsActivity::class.java)
                intent.putExtra("room",room);
                startActivity(intent)
*/               val action = HomeFragmentDirections.actionHomeFragmentToRoomDetailsFragment(room)
          //    val action=HomeFragmentDirections.actionHomeFragmentToRoomDetailsFragment(room)
         findNavController().navigate(action)

              //  findNavController().navigate(action)
            }
        }
        viewDataBinding.roomsRecyclerView.adapter =roomsAdapter
        val layoutManager = LinearLayoutManager(context);
        viewDataBinding.roomsRecyclerView.layoutManager
        viewDataBinding.roomsRecyclerView.layoutManager=layoutManager
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_home
    }

    override fun initializeViewModel(): HomeViewModel {
        return ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun openAddRoom() {
    /**    val intent = Intent(this, AddRoomActivity::class.java)
        startActivity(intent)
   */
        findNavController()
            .navigate(R.id.action_homeFragment_to_addRoomFragment)
    }
}