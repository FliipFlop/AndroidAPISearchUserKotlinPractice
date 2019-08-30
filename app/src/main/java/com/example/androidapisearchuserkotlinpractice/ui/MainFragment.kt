package com.example.androidapisearchuserkotlinpractice.ui

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.androidapisearchuserkotlinpractice.R
import com.example.androidapisearchuserkotlinpractice.model.UserItem
import com.example.androidapisearchuserkotlinpractice.model.UserModel
import kotlinx.android.synthetic.main.fragment_main.*
import kotlin.system.measureNanoTime

class MainFragment : Fragment(), IMainView {

    private lateinit var presenter: MainPresenter
    private lateinit var userAdapter: UserRVAdapter

    companion object {
        fun newInstance(): MainFragment {
            var fragment: MainFragment = MainFragment()
            var args: Bundle = Bundle()
            fragment.arguments = args

            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // onRestoreState
        // init variable
        initPresenter()
        initAdapter()
    }

    private fun initPresenter() {
        presenter = MainPresenter()
    }

    private fun initAdapter() {
        userAdapter = UserRVAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView: View = inflater.inflate(R.layout.fragment_main, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // init view
        presenter.attachView(this)
        initList()
        initInputText()
    }

    private fun initList() {
        rvUserList.adapter = userAdapter
    }

    private fun initInputText() {
        etSearch.setOnEditorActionListener(object : TextView.OnEditorActionListener {
            override fun onEditorAction(text: TextView?, actionID: Int, event: KeyEvent?): Boolean {
                if (actionID == EditorInfo.IME_ACTION_SEARCH) {
                    presenter.loadUser(etSearch.text.toString())
                    return true
                }
                return false
            }
        })
    }

    override fun updateUserList(userList: ArrayList<UserItem>?) {
        userAdapter.updateUserList(userList)
        userAdapter.notifyDataSetChanged()
    }

    override fun hideKeyboard() {
        etSearch.clearFocus()
        var inputMethodManager: InputMethodManager =
            activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(etSearch.windowToken, 0)
    }
}