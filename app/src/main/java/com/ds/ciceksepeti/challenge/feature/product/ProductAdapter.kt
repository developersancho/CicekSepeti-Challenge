package com.ds.ciceksepeti.challenge.feature.product

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ds.ciceksepeti.challenge.databinding.RowItemProductBinding
import com.ds.ciceksepeti.common.binding.toBinding
import com.ds.ciceksepeti.common.extension.load
import com.ds.ciceksepeti.model.product.Product

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    var onItemClicked: ((Product) -> Unit)? = null

    private var items = arrayListOf<Product>()

    fun addData(list: List<Product>) {
        items.addAll(list)
        notifyDataSetChanged()
    }

    fun clearData() {
        items.clear()
    }

    inner class ProductViewHolder(private val binding: RowItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: Product) {
            binding.tvProductName.text = item.name
            binding.tvProductInstallment.text = item.installmentText
            binding.tvProductPrice.text = "${item.price?.total} ${item.price?.currency}"
            item.mediumImage?.let { binding.ivProduct.load(it) }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(parent.toBinding())
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

}