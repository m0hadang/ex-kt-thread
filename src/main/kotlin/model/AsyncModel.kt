package com.example.service

import mu.KotlinLogging
import java.lang.Thread.sleep
import kotlin.concurrent.thread

private val logger = KotlinLogging.logger {}

private fun subA() {
    logger.debug { "start A" }
    sleep(1000)
    logger.debug { "end A" }
}

private fun subB() {
    logger.debug { "start B" }
    sleep(1000)
    logger.debug { "end B" }
}

fun main() {
    val a = thread {
        subA()
    }
    val b = thread {
        subB()
    }
    a.join()
    b.join()
    logger.info("==> END")
}