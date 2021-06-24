package com.appcode

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAdapter()
        tv_title.setOnClickListener {
            val intent = Intent(this, ProductDetailActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setAdapter() {
        vp_choose_band.setCurrentItem(0, true)
        val adapter = BandAdapter(this)
        vp_choose_band.adapter = adapter
//        binding.indicator.attachToPager(binding.vpOnboarding, ViewPagerTwoWidgetAttacher())

        val linearLayoutManager1 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapter1 = CategoryAdapter(this)
        rv_category.layoutManager = linearLayoutManager1
        rv_category.adapter = adapter1

        val linearLayoutManager2 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapter2 = CategoryListAdapter(this)
        rv_category_list.layoutManager = linearLayoutManager2
        rv_category_list.adapter = adapter2

        val linearLayoutManager3 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapter3 = TrendingAdapter(this)
        rv_trending.layoutManager = linearLayoutManager3
        rv_trending.adapter = adapter3

        val linearLayoutManager4 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapter4 = TrendingListAdapter(this)
        rv_trending_list.layoutManager = linearLayoutManager4
        rv_trending_list.adapter = adapter4

        setViewPagerTransformer()
    }

    private fun setViewPagerTransformer() {

// You need to retain one page on each side so that the next and previous items are visible
        vp_choose_band.offscreenPageLimit = 1

// Add a PageTransformer that translates the next and previous items horizontally
// towards the center of the screen, which makes them visible
        val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
        val currentItemHorizontalMarginPx =
            resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
        val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
        val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
            page.translationX = -pageTranslationX * position
            // Next line scales the item's height. You can remove it if you don't want this effect
            page.scaleY = 1 - (0.25f * abs(position))
            // If you want a fading effect uncomment the next line:
            // page.alpha = 0.25f + (1 - abs(position))
        }
        vp_choose_band.setPageTransformer(pageTransformer)

// The ItemDecoration gives the current (centered) item horizontal margin so that
// it doesn't occupy the whole screen width. Without it the items overlap
        val itemDecoration = HorizontalMarginItemDecoration(
            this,
            R.dimen.viewpager_current_item_horizontal_margin
        )
        vp_choose_band.addItemDecoration(itemDecoration)
    }
}