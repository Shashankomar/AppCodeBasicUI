package com.appcode.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.appcode.R
import com.appcode.ui.adapter.OtherProductAdapter
import com.appcode.ui.adapter.ProductImageAdapter
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        setViewPagerAdapter()
        setOtherProductAdapter()
        setPageChangeListener()
    }

    private fun setOtherProductAdapter() {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_other_products.layoutManager = linearLayoutManager
        val adapter1 = OtherProductAdapter(this, true)
        rv_other_products.adapter = adapter1
    }

    private fun setViewPagerAdapter() {
        vpProductDetail.setCurrentItem(0, true)
        val adapter = ProductImageAdapter(this)
        vpProductDetail.adapter = adapter
        dots_indicator.setViewPager2(vpProductDetail)
    }

    private fun setPageChangeListener() {
        vpProductDetail.setCurrentItem(0, true)
        vpProductDetail.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                vpProductDetail.setCurrentItem(position, true)
            }
        })
    }
}
