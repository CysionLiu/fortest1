package com.cysion.forTest.ui

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import com.cysion.forTest.tools.log

class DFragment : DialogFragment() {

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        log("onAttach")
        log(A.toString())
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        log("onActivityCreated")
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        log("onCreateDialog")
        return super.onCreateDialog(savedInstanceState)
    }
    fun show(a:FragmentActivity) {
        show(a.supportFragmentManager, "")

    }
}
object A{
    override fun toString(): String {
        return super.toString()
    }
}