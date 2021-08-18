package com.visarut.minilotus_task2.view.feature.featureAddcount

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.visarut.minilotus_task2.domain.epoxy.modules.viewmodelModule
import com.visarut.minilotus_task2.view.feature.featureSaveName.SaveNameViewModel
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TestViewBindingViewModelTest{

    private lateinit var viewModel : TestViewBindingViewModel

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        viewModel = TestViewBindingViewModel()
    }

    @Test
    fun add0Test(){
        Assert.assertEquals(0,viewModel.numberLiveData.value)
    }

    @Test
    fun add1Test(){
        viewModel.updateNumber()
        Assert.assertEquals(1,viewModel.numberLiveData.value)
    }

    @Test
    fun add2Test(){
        viewModel.updateNumber()
        viewModel.updateNumber()
        Assert.assertEquals(2,viewModel.numberLiveData.value)
    }
}