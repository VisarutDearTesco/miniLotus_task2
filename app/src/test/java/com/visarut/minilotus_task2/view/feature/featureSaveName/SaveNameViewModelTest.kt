package com.visarut.minilotus_task2.view.feature.featureSaveName

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.visarut.minilotus_task2.domain.usecase.GetSavedNameUseCase
import com.visarut.minilotus_task2.domain.usecase.PostSavedNameUseCase
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SaveNameViewModelTest {

    private lateinit var viewModel : SaveNameViewModel

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        val getSavedNameUseCase : GetSavedNameUseCase = mockk()
        val postSavedNameUseCase : PostSavedNameUseCase = mockk()

        coEvery {
            getSavedNameUseCase.invoke()
        }returns ""

        viewModel = SaveNameViewModel(getSavedNameUseCase, postSavedNameUseCase)

    }

    @Test
    fun checkIdSuccessTestCase(){

        val result = viewModel.checkID("1104700021826")
        Assert.assertTrue(result)
    }

    @Test
    fun checkIdFailTestCase(){

        val result = viewModel.checkID("1104700021825")
        Assert.assertFalse(result)
    }

    @Test
    fun checkIdFailTestCase2(){

        val result = viewModel.checkID("")
        Assert.assertFalse(result)
    }

    @Test
    fun checkIdFailTestCase3(){

        val result = viewModel.checkID("asdasdasdasdasdasdaasdasd")
        Assert.assertFalse(result)
    }

    @Test
    fun checkIdFailTestCase4(){

        val result = viewModel.checkID("-12233-4232")
        Assert.assertFalse(result)
    }

    @Test
    fun checkIdFailTestCase5(){

        val result = viewModel.checkID("1140dfgmrmsd3")
        Assert.assertFalse(result)
    }





}