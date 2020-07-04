package com.jramirez.soccerteamboard.service

import com.jramirez.soccerteamboard.service.repository.BaseRepository
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.IOException


class BaseRepositoryTest {

    private val dispatcher = TestCoroutineDispatcher()
    private val teamSuccessResult = ResultServiceHandler.Success(SUCCESS)
    private val teamErrorResult = ResultServiceHandler.Error
    private lateinit var repository: BaseRepository

    @Before
    fun setUp() {
        repository = BaseRepository(dispatcher)
    }

    @Test
    fun `result service handler return success`() {
        runBlockingTest {
            val result = repository.handleAPICall { SUCCESS }
            Assert.assertEquals(teamSuccessResult, result)
        }
    }

    @Test
    fun `result service handler return error`() {
        runBlockingTest {
            val result = repository.handleAPICall { throw IOException() }
            Assert.assertEquals(teamErrorResult, result)
        }
    }

    companion object {
        private const val SUCCESS = "Success"
    }
}