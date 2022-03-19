package com.moizaandroid.moiza.ui.component.profile.edit

import android.view.View
import androidx.navigation.fragment.findNavController
import com.moizaandroid.moiza.R
import com.moizaandroid.moiza.databinding.FragmentProfileEditBinding
import com.moizaandroid.moiza.ui.base.BaseFragment

class EditFragment : BaseFragment<FragmentProfileEditBinding>(R.layout.fragment_profile_edit), View.OnClickListener {
    val colorList = arrayOf(
        R.color.dark_red,
        R.color.light_red,
        R.color.red,
        R.color.light_orange,
        R.color.orange,
        R.color.yellow,
        R.color.light_yellow,
        R.color.dark_green,
        R.color.green,
        R.color.light_green,
        R.color.blue,
        R.color.dark_blue,
        R.color.light_purple,
        R.color.purple,
        R.color.light_blue,
        R.color.pink,
        R.color.dark_pink,
        R.color.light_grey,
        R.color.grey,
        R.color.dark_grey,
        R.color.light_black
    )
    val colorViewList = arrayOf(
        R.id.view1,
        R.id.view2,
        R.id.view3,
        R.id.view4,
        R.id.view5,
        R.id.view6,
        R.id.view7,
        R.id.view8,
        R.id.view9,
        R.id.view10,
        R.id.view11,
        R.id.view12,
        R.id.view13,
        R.id.view14,
        R.id.view15,
        R.id.view16,
        R.id.view17,
        R.id.view18,
        R.id.view19,
        R.id.view20,
        R.id.view21,
    )
    override fun init() {
        initClick()
    }

    override fun onClick(widget: View) {
        for(i in 0..colorViewList.size){
            if(widget.id == colorViewList[i]) {
                binding.profileBackground.setBackgroundColor(requireContext().getColor(colorList[i]))
                break
            }
        }
    }

    private fun initClick(){
        binding.apply {
            view1.setOnClickListener(this@EditFragment)
            view2.setOnClickListener(this@EditFragment)
            view3.setOnClickListener(this@EditFragment)
            view4.setOnClickListener(this@EditFragment)
            view5.setOnClickListener(this@EditFragment)
            view6.setOnClickListener(this@EditFragment)
            view7.setOnClickListener(this@EditFragment)
            view8.setOnClickListener(this@EditFragment)
            view9.setOnClickListener(this@EditFragment)
            view10.setOnClickListener(this@EditFragment)
            view11.setOnClickListener(this@EditFragment)
            view12.setOnClickListener(this@EditFragment)
            view13.setOnClickListener(this@EditFragment)
            view14.setOnClickListener(this@EditFragment)
            view15.setOnClickListener(this@EditFragment)
            view16.setOnClickListener(this@EditFragment)
            view17.setOnClickListener(this@EditFragment)
            view18.setOnClickListener(this@EditFragment)
            view19.setOnClickListener(this@EditFragment)
            view20.setOnClickListener(this@EditFragment)
            view21.setOnClickListener(this@EditFragment)
            editIntroduce.setOnClickListener { findNavController().navigate(R.id.action_editFragment_to_editTextFragment) }
        }
    }
}