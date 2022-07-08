package com.juhnny.tptyped

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.juhnny.tptyped.databinding.FragmentInfoBinding

class InfoFragment: Fragment() {

    val b by lazy { FragmentInfoBinding.inflate(layoutInflater) }
    val ma by lazy { requireActivity() as MainActivity }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ma.setSupportActionBar(b.toolbar)
    }
}