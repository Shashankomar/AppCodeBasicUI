package com.appcode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        setAdapter()
        setPageChangeListener()
    }


    private fun setAdapter() {
        vpProductDetail.setCurrentItem(0, true)
        val adapter = ProductImageAdapter(this)
        vpProductDetail.adapter = adapter
//        binding.indicator.attachToPager(binding.vpOnboarding, ViewPagerTwoWidgetAttacher())

        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        rv_other_products.layoutManager = linearLayoutManager
        val adapter1 = OtherProductAdapter(this, true)
        rv_other_products.adapter = adapter1

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
