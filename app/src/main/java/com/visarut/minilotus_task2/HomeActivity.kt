package com.visarut.minilotus_task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.visarut.minilotus_task2.Modules.appModule
import com.visarut.minilotus_task2.Modules.viewmodelModule
import com.visarut.minilotus_task2.databinding.ActivityHomeBinding
import com.visarut.minilotus_task2.databinding.Page1fragmentFragmentBinding

class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

//        val viewModel = getViewModel<Page1fragmentViewModel>()

//        if(savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, HomeFragment.newInstance())
//                .commitNow()
//        }
    }
}