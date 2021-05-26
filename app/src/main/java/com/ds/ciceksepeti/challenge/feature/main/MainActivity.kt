package com.ds.ciceksepeti.challenge.feature.main

import android.os.Bundle
import com.ds.ciceksepeti.challenge.databinding.ActivityMainBinding
import com.ds.ciceksepeti.common.base.BaseViewModelActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseViewModelActivity<ActivityMainBinding, MainViewModel>() {

    override fun createBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override val viewModel: MainViewModel by viewModel()

    override fun onViewReady(bundle: Bundle?) {
        super.onViewReady(bundle)
    }
}