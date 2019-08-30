package com.example.androidapisearchuserkotlinpractice.template

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidapisearchuserkotlinpractice.R

class FragmentTemplate : Fragment() {

    companion object {
        fun newInstance(): FragmentTemplate {
            var fragment: FragmentTemplate = FragmentTemplate()
            var args: Bundle = Bundle()
            fragment.arguments = args

            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // onRestoreState
        // init variable
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView: View = inflater.inflate(R.layout.fragment_template, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // init view
    }
}