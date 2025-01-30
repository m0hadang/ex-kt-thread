package com.example.performance

import mu.KotlinLogging
import java.util.concurrent.CountDownLatch
import java.util.concurrent.atomic.AtomicLong
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

private val logger = KotlinLogging.logger {}

fun main() {
    val sum = AtomicLong(0)
    val counter = CountDownLatch(REPEAT_COUNT_1)
    measureTimeMillis {
        repeat(REPEAT_COUNT_1) {
            thread(name = "calc-$it") {
                repeat(REPEAT_COUNT_2) {
                    sum.addAndGet(1)
                }
//                logger.debug("thread finished")
            }
            counter.countDown()
        }
        counter.await()// wait another thread
    }.let {
        logger.debug("sum: $sum elapsed: $it ms")
    }
    logger.info("==> END")
}