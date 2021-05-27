package com.ds.ciceksepeti.challenge.feature.filter.item

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ds.ciceksepeti.challenge.R
import com.ds.ciceksepeti.challenge.databinding.DialogFilterItemBinding
import com.ds.ciceksepeti.challenge.feature.filter.FilterViewModel
import com.ds.ciceksepeti.common.base.BaseViewModelDialog
import com.ds.ciceksepeti.common.extension.classTag
import com.ds.ciceksepeti.model.filter.FilterCategory
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class FilterItemDialog : BaseViewModelDialog<DialogFilterItemBinding, FilterViewModel>() {

    private var filterCategory: FilterCategory? = null
    private var adapter: FilterItemAdapter? = null
    override val viewModel: FilterViewModel by sharedViewModel()
    var filterDone : (()->Unit) = {}

    companion object {
        private const val ARG_FILTER_ITEM = "arg_filter_item"

        fun newInstance() = FilterItemDialog()

        fun show(fragmentManager: FragmentManager, filter: FilterCategory): FilterItemDialog {
            val fragmentTransaction = fragmentManager.beginTransaction()
            val prev = fragmentManager.findFragmentByTag(FilterItemDialog().classTag)
            if (prev != null) {
                fragmentTransaction.remove(prev)
            }
            fragmentTransaction.addToBackStack(null)
            val dialog = newInstance().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_FILTER_ITEM, filter)
                }
            }
            dialog.isCancelable = false
            dialog.show(fragmentManager, FilterItemDialog().classTag)
            return dialog
        }
    }

    override fun createBinding(): DialogFilterItemBinding {
        return DialogFilterItemBinding.inflate(layoutInflater)
    }

    override fun onViewReady(bundle: Bundle?) {
        filterCategory = arguments?.getParcelable(ARG_FILTER_ITEM)
        binding.tvCategoryName.text = filterCategory?.name
        initAdapter()
    }

    private fun initAdapter() {
        adapter = FilterItemAdapter(viewModel)
        binding.rvFilterItem.setHasFixedSize(true)
        binding.rvFilterItem.adapter = adapter
        val layoutManager = LinearLayoutManager(context)
        binding.rvFilterItem.layoutManager = layoutManager
        adapter?.setData(filterCategory?.items.orEmpty())
    }

    override fun onViewListener() {
        super.onViewListener()
        binding.toolbar.setNavigationOnClickListener {
            dismiss()
        }

        binding.tvClear.setOnClickListener {
            adapter?.clearData()
            viewModel.clearCategoryItems(filterCategory)
        }

        binding.btnOk.setOnClickListener {
            filterDone.invoke()
            dismiss()
        }
    }

    override fun getTheme(): Int {
        return R.style.FullScreenDialog
    }


}