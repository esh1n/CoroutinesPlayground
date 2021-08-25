package com.esh1n.coroutineslab.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.esh1n.coroutineslab.R

class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: CancelViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn_run).setOnClickListener {
            viewModel.onRun()
        }
        view.findViewById<Button>(R.id.btn_stop).setOnClickListener {
            viewModel.onCancel()
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.log("FRAGMENT onDestroyView")
    }
    override fun onDestroy() {
        super.onDestroy()
        viewModel.log("FRAGMENT onDestroy")
    }



}