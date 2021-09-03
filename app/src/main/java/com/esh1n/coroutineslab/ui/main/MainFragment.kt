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

    private val cancelViewModel: CancelViewModel by viewModels()
    private val innerCoViewmodel: InnerCoViewmodel by viewModels()
    private val lazyCoVM: LazyCoVM by viewModels()
    private val asyncAwaitVM: AsyncAwaitSimpleVM by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn_run).setOnClickListener {
//            cancelViewModel.onRun()
//            innerCoViewmodel.onRun()
//            lazyCoVM.onPrepareLazyRun()
            asyncAwaitVM.onRunInParallel()
        }
        view.findViewById<Button>(R.id.btn_stop).setOnClickListener {
            cancelViewModel.onCancel()
        }
        view.findViewById<Button>(R.id.btn_run2).setOnClickListener {
            innerCoViewmodel.onRunAndWait()
            lazyCoVM.onRunLazy()
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        cancelViewModel.log("FRAGMENT onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        cancelViewModel.log("FRAGMENT onDestroy")
    }


}