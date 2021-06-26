package com.appcode.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.appcode.R
import com.appcode.ui.activity.ProductDetailActivity

class CategoryListAdapter(private val context: Context) :
    RecyclerView.Adapter<CategoryListAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_category_list, parent, false)
        return ProductViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.mainLl.setOnClickListener {
            val intent = Intent(context, ProductDetailActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return 7
    }

    inner class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var mainLl: LinearLayout = view.findViewById(R.id.ll_main)
    }

}