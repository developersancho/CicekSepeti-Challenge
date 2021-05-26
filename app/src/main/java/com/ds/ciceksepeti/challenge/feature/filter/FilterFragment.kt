package com.ds.ciceksepeti.challenge.feature.filter

import com.ds.ciceksepeti.challenge.databinding.FragmentFilterBinding
import com.ds.ciceksepeti.common.base.BaseViewModelFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class FilterFragment : BaseViewModelFragment<FragmentFilterBinding, FilterViewModel>() {
    override val viewModel: FilterViewModel by sharedViewModel()

    override fun createBinding(): FragmentFilterBinding {
        return FragmentFilterBinding.inflate(layoutInflater)
    }


}