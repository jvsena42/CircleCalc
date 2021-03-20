package com.anushka.circlecalc

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import org.junit.Test


import org.junit.Before
import org.junit.Rule
import org.mockito.Mockito

class CalcViewModelTest {

    private lateinit var calcViewModel: CalcViewModel
    private lateinit var calculations: Calculations

    //para testar livedata é necessário adicionar InstantClassExecutorRule
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        calculations = Mockito.mock(Calculations::class.java)
        Mockito.`when`(calculations.calculateArea(2.1)).thenReturn(13.8474)
        Mockito.`when`(calculations.calculateCircumference(2.1)).thenReturn(13.188)
        calcViewModel = CalcViewModel(calculations)
    }

    @Test
    fun calculateArea_radiusSent_UpdateLiveData() {
        calcViewModel.calculateArea(2.1)
        val result:String? = calcViewModel.areaValue.value
        assertThat(result).isEqualTo("13.8474")
    }

    @Test
    fun calculateCircumference_radiusSent_UpdateLiveData() {
        calcViewModel.calculateCircumference(2.1)
        val result:String? = calcViewModel.circumferenceValue.value
        assertThat(result).isEqualTo("13.188")
    }
}