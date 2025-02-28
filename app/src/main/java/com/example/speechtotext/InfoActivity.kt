package com.example.speechtotext

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.speechtotext.databinding.ActivityInfoBinding
import com.google.android.material.tabs.TabLayoutMediator

class InfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View Binding aktiv edilir
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ViewPager və TabLayout ilə əlaqələndirmə
        val sectionsPagerAdapter = SectionsPagerAdapter(this)
        binding.viewPager.adapter = sectionsPagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Haqqımızda"
                    tab.setIcon(R.mipmap.icon) // Haqqımızda üçün ikon
                }
                1 -> {
                    tab.text = "Dəstək"
                    tab.setIcon(R.mipmap.icon) // Dəstək üçün ikon
                }
            }
        }.attach()
    }
}
