package id.rrdev.jetpackpro.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.rrdev.jetpackpro.ui.adapter.SectionsPagerAdapter
import id.rrdev.jetpackpro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupViewAdapter()
    }

    private fun setupViewAdapter() {
        val sectionAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        binding.viewPager.adapter = sectionAdapter
        binding.tabs.setupWithViewPager(binding.viewPager)
        supportActionBar?.elevation = 0f
    }
}