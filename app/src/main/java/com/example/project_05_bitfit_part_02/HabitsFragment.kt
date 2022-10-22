package com.example.project_05_bitfit_part_02

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import androidx.appcompat.app.AppCompatActivity



class HabitsFragment() : Fragment() {

    private val habits = mutableListOf<DisplayHabit>()
    private lateinit var habitsRecyclerView: RecyclerView

    private lateinit var habitAdapter: HabitAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_activies, container, false)


        val layoutManager = LinearLayoutManager(context)
        habitsRecyclerView = view.findViewById(R.id.habitListRV)
        habitsRecyclerView.layoutManager = layoutManager
        habitsRecyclerView.setHasFixedSize(true)
        habitAdapter = HabitAdapter(view.context, habits)
        habitsRecyclerView.adapter = habitAdapter


        return view
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            HabitsFragment().apply {
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            (activity?.application as HabitApplication).db.articleDao().getAll().collect { databaseList ->
                databaseList.map { entity ->
                    DisplayHabit(
                        entity.habitName,
                        entity.habitValue
                    )
                }.also { mappedList ->
                    habits.clear()
                    habits.addAll(mappedList)
                    habitAdapter.notifyDataSetChanged()
                }
            }
        }

        val addButton: Button = view.findViewById<Button>(R.id.addBtn)

        //Moves to second screen for adding a new item
        addButton.setOnClickListener(View.OnClickListener {
            val intent = Intent(view.context, HabitInformation::class.java)
            this.startActivity(intent)
        })
    }
}


