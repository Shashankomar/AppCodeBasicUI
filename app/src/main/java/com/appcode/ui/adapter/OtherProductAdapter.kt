package com.appcode.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.appcode.R
import com.appcode.ui.activity.ProductInfoActivity

class OtherProductAdapter(private val context: Context, private val clickableView: Boolean) :
    RecyclerView.Adapter<OtherProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_other_product, parent, false)
        return ProductViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.ivOtherProducts.setOnClickListener {
            holder.llOtherProducts.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.blue
                )
            )
            if (clickableView) {
                val intent = Intent(context, ProductInfoActivity::class.java)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return 7
    }

    inner class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var ivOtherProducts: ImageView = view.findViewById(R.id.iv_other_products)
        var llOtherProducts: LinearLayout = view.findViewById(R.id.ll_other_product)
    }
}
