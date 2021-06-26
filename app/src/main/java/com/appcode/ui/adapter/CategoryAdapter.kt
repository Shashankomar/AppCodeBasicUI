package com.appcode.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.appcode.R

class CategoryAdapter(private val context: Context) :
    RecyclerView.Adapter<CategoryAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_category, parent, false)
        return ProductViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 7
    }

    inner class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }
}