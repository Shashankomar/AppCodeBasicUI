package com.appcode.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.appcode.R
import com.appcode.ui.adapter.*
import com.appcode.utils.HorizontalMarginItemDecoration
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setViewPagerAdapter()
        setCategoryAdapter()
        setCategoryProductListAdapter()
        setTrendingCategoryAdapter()
        setTrendingProductListAdapter()
        setViewPagerTransformer()
    }

    private fun setTrendingProductListAdapter() {
        val linearLayoutManager4 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapter4 = TrendingListAdapter(this)
        rv_trending_list.layoutManager = linearLayoutManager4
        rv_trending_list.adapter = adapter4
    }

    private fun setTrendingCategoryAdapter() {
        val linearLayoutManager3 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapter3 = CategoryAdapter(this)
        rv_trending.layoutManager = linearLayoutManager3
        rv_trending.adapter = adapter3
    }

    private fun setCategoryProductListAdapter() {
        val linearLayoutManager2 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapter2 = CategoryListAdapter(this)
        rv_category_list.layoutManager = linearLayoutManager2
        rv_category_list.adapter = adapter2
    }

    private fun setCategoryAdapter() {
        val linearLayoutManager1 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapter1 = CategoryAdapter(this)
        rv_category.layoutManager = linearLayoutManager1
        rv_category.adapter = adapter1
    }

    private fun setViewPagerAdapter() {
        vp_choose_band.setCurrentItem(0, true)
        val adapter = ProductImageAdapter(this)
        vp_choose_band.adapter = adapter
    }

    private fun setViewPagerTransformer() {
        vp_choose_band.offscreenPageLimit = 1
        val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
        val currentItemHorizontalMarginPx =
            resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
        val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
        val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
            page.translationX = -pageTranslationX * position
            page.scaleY = 1 - (0.25f * kotlin.math.abs(position))
        }
        vp_choose_band.setPageTransformer(pageTransformer)
        val itemDecoration =
            HorizontalMarginItemDecoration(this, R.dimen.viewpager_current_item_horizontal_margin)
        vp_choose_band.addItemDecoration(itemDecoration)
    }
}