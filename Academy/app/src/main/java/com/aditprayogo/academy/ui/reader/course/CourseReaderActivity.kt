package com.aditprayogo.academy.ui.reader.course

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.aditprayogo.academy.R
import com.aditprayogo.academy.ui.reader.CourseReaderCallback
import com.aditprayogo.academy.ui.reader.module_content.ModuleContentFragment
import com.aditprayogo.academy.ui.reader.module_list.ModuleListFragment
import com.aditprayogo.academy.viewModel.ViewModelFactory

class CourseReaderActivity : AppCompatActivity(), CourseReaderCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_reader)
        setupData()
    }

    private fun setupData() {
        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[CourseReaderViewModel::class.java]

        val bundle = intent.extras
        bundle?.let {
            val courseId = bundle.getString(EXTRA_COURSE_ID)

            courseId?.let {
                viewModel.setSelectedCourse(it)
                populateFragment()
            }
        }
    }

    override fun moveTo(position: Int, moduleId: String) {
        val fragment = ModuleContentFragment.newInstance()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.frame_container, fragment, ModuleContentFragment.TAG)
            .addToBackStack(null)
            .commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount <= 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }

    private fun populateFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        var fragment = supportFragmentManager.findFragmentByTag(ModuleListFragment.TAG)

        if (fragment == null) {
            fragment = ModuleListFragment.newInstance()
            fragmentTransaction.add(R.id.frame_container, fragment, ModuleListFragment.TAG)
            fragmentTransaction.addToBackStack(null)
        }

        fragmentTransaction.commit()
    }

    companion object {
        const val EXTRA_COURSE_ID = "extra_course_id"
    }
}