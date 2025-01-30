package com.example.performance

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import java.util.concurrent.atomic.AtomicLong
import kotlin.system.measureTimeMillis

private val logger = KotlinLogging.logger {}

fun main() {
    val sum = AtomicLong(0)
    runBlocking {
        CoroutineScope(Dispatchers.IO).launch {
            measureTimeMillis {
                repeat(REPEAT_COUNT_1) {
                    launch {
                        repeat(REPEAT_COUNT_2) {
                            sum.addAndGet(1)
                        }
//                        logger.debug("worker finished")
                    }
                }
            }.let { logger.debug { "sum: $sum elapsed: $it ms" } }
        }.join()
    }
    logger.info("==> END")
}