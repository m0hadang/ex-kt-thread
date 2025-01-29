package com.example.model

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import mu.KotlinLogging
import java.lang.Thread.sleep

private val logger = KotlinLogging.logger {}

val singleWorker = newSingleThreadContext("singleWorker")

suspend fun main() {
    run {
        val scopeNum = 0L
        logger.info("==> start [$scopeNum]. single thread process")
        firstJobNonBlocking(scopeNum = scopeNum)
        secondJob(scopeNum = scopeNum)
    }

    coroutineScope {
        val scopeNum = 1L
        logger.info("==> start [$scopeNum]. parallelism process, worker is N, non-blocking")
        // job worker is N
        launch { firstJobNonBlocking(scopeNum = scopeNum) }
        launch { secondJob(scopeNum = scopeNum) }
    }

    coroutineScope {
        val scopeNum = 2L
        logger.info("==> start [$scopeNum]. concurrency process, worker in only 1, non-blocking")
        // job worker is only 1
        launch(singleWorker) { firstJobNonBlocking(scopeNum = scopeNum) }
        launch(singleWorker) { secondJob(scopeNum = scopeNum) }
    }

    coroutineScope {
        val scopeNum = 3L
        logger.warn("==> start [$scopeNum]. !!! invalid concurrency process, worker in only 1, blocking")
        // job worker is only 1
        launch(singleWorker) { firstJobBlocking(scopeNum = scopeNum) }
        launch(singleWorker) { secondJob(scopeNum = scopeNum) }
    }

    logger.info("==> END")
}

private suspend fun firstJobNonBlocking(scopeNum: Long) {
    logger.debug("[$scopeNum] start First job")
    repeat(3) {
        delay(1_000)// not io
        logger.debug("[$scopeNum] delay First job...")
    }
    logger.debug("[$scopeNum] end First job")
}

private fun firstJobBlocking(scopeNum: Long) {
    logger.debug("[$scopeNum] start First job")
    repeat(3) {
        sleep(1_000)// blocking
        logger.debug("[$scopeNum] sleep First job...")
    }
    logger.debug("[$scopeNum] end First job")
}

private suspend fun secondJob(scopeNum: Long) {
    logger.debug("[$scopeNum] start Second job")
    delay(1_000)
    logger.debug("[$scopeNum] end Second job")
}