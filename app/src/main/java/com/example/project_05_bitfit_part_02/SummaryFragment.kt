package com.example.project_05_bitfit_part_02

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.launch

class SummaryFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_summary, container, false)
        val layoutManager = LinearLayoutManager(context)

        return view
    }

    companion object {
        fun newInstance(): SummaryFragment {
            return SummaryFragment()
                }
            }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val highTextView = view.findViewById<TextView>(R.id.highFreqTotalTV)


        //Get the total of all the high, medium and low activities
//        lifecycleScope.launch {
//                (activity?.application as HabitApplication).db.articleDao().getHighTotal()
//        }


        val addButton: Button = view.findViewById(R.id.sumAddBtn)

        //Moves to second screen for adding a new item
        addButton.setOnClickListener {
            val intent = Intent(view.context, HabitInformation::class.java)
            this.startActivity(intent)
        }
    }

}

