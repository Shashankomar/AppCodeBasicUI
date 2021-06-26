package com.appcode.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.appcode.R
import com.appcode.ui.adapter.OtherProductAdapter
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_info)

        setAdapter()
    }

    private fun setAdapter() {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_other_products.layoutManager = linearLayoutManager
        val adapter1 = OtherProductAdapter(this, false)
        rv_other_products.adapter = adapter1
    }
}