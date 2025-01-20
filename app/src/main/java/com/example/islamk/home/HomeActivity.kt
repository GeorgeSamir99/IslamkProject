package com.example.islamk.home

import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.islamk.R
import com.example.islamk.databinding.ActivityHomeBinding
import com.example.islamk.fragments.HadethFragment
import com.example.islamk.fragments.QuranFragment
import com.example.islamk.fragments.RadioFragment
import com.example.islamk.fragments.TasbeehFragment

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        window.insetsController?.hide(WindowInsets.Type.statusBars())
        onContextItemSelected()
        binding.islamkNavView.selectedItemId = R.id.navigation_quran
    }


    private fun onContextItemSelected() {
        binding.islamkNavView.setOnItemSelectedListener {
            itemSelected->

            if ( itemSelected.itemId == R.id.navigation_quran){
                showFragment(QuranFragment())
            }
            else if (itemSelected.itemId == R.id.navigation_hadeth){
                showFragment(HadethFragment())
            }
            else if (itemSelected.itemId == R.id.navigation_tasbeeh){
                showFragment(TasbeehFragment())
            }
            else if (itemSelected.itemId == R.id.navigation_radio){
                showFragment(RadioFragment())
            }

            return@setOnItemSelectedListener true
        }
    }

    private fun showFragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.islamk_fragment_container , fragment)
            .commit()
    }


}
