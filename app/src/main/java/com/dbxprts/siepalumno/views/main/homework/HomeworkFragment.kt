package com.dbxprts.siepalumno.views.main.homework


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.dbxprts.siepalumno.R
import com.dbxprts.siepalumno.adapters.homework.HomeworkRecyclerViewAdapter
import com.dbxprts.siepalumno.views.base.BaseFragment
import com.dbxprts.siepalumno.views.main.MainActivity

class HomeworkFragment : BaseFragment<HomeworkFragmentViewModel>(HomeworkFragmentViewModel::class) {
    lateinit var activity: MainActivity
    lateinit var adapter: HomeworkRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_homework, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        observe()
    }

    private fun init() {
        activity = getActivity() as MainActivity
        adapter = HomeworkRecyclerViewAdapter(
            activity,
            arrayListOf()
        )
    }


}
