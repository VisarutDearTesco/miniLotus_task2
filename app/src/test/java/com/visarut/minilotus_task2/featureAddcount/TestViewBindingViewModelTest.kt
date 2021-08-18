package com.visarut.minilotus_task2.featureAddcount

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TestViewBindingViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    lateinit var viewModel: TestViewBindingViewModel

    @Before
    fun setUp() {
        viewModel = TestViewBindingViewModel()
    }

    @Test
    fun testUpdateNumber(){
        viewModel.updateNumber()
        Assert.assertEquals(1, viewModel.numberLiveData.value)
    }

}