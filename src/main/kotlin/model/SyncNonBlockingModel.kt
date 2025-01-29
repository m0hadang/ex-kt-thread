package com.example.model

import mu.KotlinLogging
import java.lang.Thread.sleep
import java.util.concurrent.CompletableFuture

private val logger = KotlinLogging.logger {}

private fun subA(): CompletableFuture<Unit> {
    return CompletableFuture.supplyAsync {
        logger.debug("start A")
        sleep(6_000)
        logger.debug("end A")
    }
}

private fun subB(): CompletableFuture<Unit> {
    return CompletableFuture.supplyAsync {
        logger.debug("start B")
        sleep(3_000)
        logger.debug("end B")
    }
}

fun main() {
    val a = subA()
    val b = subB()
    while (!a.isDone || !b.isDone) {
        logger.debug("waiting...")
        sleep(1_000)
    }
    logger.info("==> END")
}

