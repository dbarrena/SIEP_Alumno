package com.dbxprts.siepalumno.views.main.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

import com.dbxprts.siepalumno.R
import com.dbxprts.siepalumno.adapters.home.DashboardRecyclerViewAdapter
import com.dbxprts.siepalumno.model.DashboardItem
import com.dbxprts.siepalumno.views.base.BaseFragment
import com.dbxprts.siepalumno.views.main.MainActivity
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : BaseFragment<HomeFragmentViewModel>(HomeFragmentViewModel::class) {
    private lateinit var adapter: DashboardRecyclerViewAdapter
    private lateinit var activity: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = getActivity() as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = DashboardRecyclerViewAdapter(activity, arrayListOf(
            DashboardItem("Tareas", "3 tareas hoy"),
            DashboardItem("Eventos", "2 eventos este mes"),
            DashboardItem("Avisos", "4 nuevos avisos")
        ))

        dashboardRecyclerView.layoutManager = LinearLayoutManager(activity)
        dashboardRecyclerView.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        dashboardRecyclerView.adapter = adapter
    }

    companion object {
        fun newInstance() = HomeFragment()
    }


}
