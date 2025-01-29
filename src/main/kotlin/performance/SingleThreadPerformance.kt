package com.example.performance

import mu.KotlinLogging
import java.util.concurrent.CountDownLatch
import java.util.concurrent.atomic.AtomicLong
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

private val logger = KotlinLogging.logger {}

fun main() {
    var sum = 0L
    measureTimeMillis {
        for (i in 0 until REPEAT_COUNT_1) {
            for (j in 0 until REPEAT_COUNT_2) {
                sum += 1
            }
        }
    }.let {
        logger.debug("sum: $sum elapsed: $it ms")
    }
}