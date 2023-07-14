package com.sky.recruitmenttest

import com.sky.recruitmenttest.domain.repository.MyRepository
import com.sky.recruitmenttest.presentation.HomeUIState
import com.sky.recruitmenttest.presentation.HomeViewModel
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@ExperimentalCoroutinesApi
class HomeViewModelTest {
    private lateinit var viewModel: HomeViewModel
    private lateinit var mockRepository: MyRepository

    @Before
    fun setup() {
        mockRepository = mockk()
        viewModel = HomeViewModel(mockRepository)
    }

    @Test
    fun `onSearchBarChange updates search attribute`() {
        runBlocking {
            val initialState = HomeUIState()
            val expectedSearch = "example search"

            assertEquals(initialState.search, viewModel.homeUIState.first().search)

            viewModel.onSearchBarChange(expectedSearch)

            assertEquals(expectedSearch, viewModel.homeUIState.first().search)
        }
    }
}