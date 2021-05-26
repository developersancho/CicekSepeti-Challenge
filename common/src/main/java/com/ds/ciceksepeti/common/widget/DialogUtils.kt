package com.ds.ciceksepeti.common.widget

import android.content.Context
import android.view.LayoutInflater
import android.view.Window
import com.ds.ciceksepeti.common.databinding.DialogInternetCheckBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

object DialogUtils {

    fun showInternetCheckDialog(context: Context, handler: () -> Unit) {
        val dialogBuilder = MaterialAlertDialogBuilder(context)
        val layoutInflater = LayoutInflater.from(context)
        val binding = DialogInternetCheckBinding.inflate(layoutInflater)
        dialogBuilder.setView(binding.root)

        val alertDialog = dialogBuilder.create()
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        alertDialog.setCanceledOnTouchOutside(false)
        val decorView = alertDialog.window?.decorView
        decorView?.setBackgroundResource(android.R.color.transparent)
        alertDialog.show()

        binding.btnOk.setOnClickListener {
            alertDialog.dismiss()
            handler()
        }
    }

}