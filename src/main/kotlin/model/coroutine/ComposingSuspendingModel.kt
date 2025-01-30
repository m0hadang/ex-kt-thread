package com.example.model.coroutine

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import kotlin.system.measureTimeMillis

private val logger = KotlinLogging.logger {}

suspend fun doJob1(): Long {
    logger.debug("doJob1 start")
    delay(1000L) // pretend we are doing something useful here
    return 13
}

suspend fun doJob2(): Long {
    logger.debug("doJob2 start")
    delay(1000L) // pretend we are doing something useful here, too
    return 29
}

fun main() {
    runBlocking {
        val time = measureTimeMillis {
            val one = doJob1()
            val two = doJob2()
            logger.debug("[sequentially] after job start")
            logger.debug("[sequentially] The answer is ${one + two}")
        }
        logger.debug("[sequentially] Completed in $time ms")
    }

    runBlocking {
        val time = measureTimeMillis {
            val one = async { doJob1() }
            val two = async { doJob2() }
            logger.debug("[async] after job start")
            logger.debug("[async] The answer is ${one.await() + two.await()}")
        }
        logger.debug("[async] Completed in $time ms")
    }

    runBlocking {
        val time = measureTimeMillis {
            val one = async(start = CoroutineStart.LAZY) { doJob1() }
            val two = async(start = CoroutineStart.LAZY) { doJob2() }
            // some computation
            logger.debug("[lazy] before job start")
            one.start() // start the first one
            two.start() // start the second one
            logger.debug("[lazy] The answer is ${one.await() + two.await()}")
        }
        logger.debug("[lazy] Completed in $time ms")
    }

    logger.info("==> END")
}