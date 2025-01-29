package com.example.model

import mu.KotlinLogging
import java.lang.Thread.sleep
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ForkJoinPool
import java.util.stream.LongStream

// implemented by ForkJoinPool

private val logger = KotlinLogging.logger {}

private fun completableFuture(): CompletableFuture<Unit> {
    return CompletableFuture.supplyAsync {
        sleep(500)
        logger.debug("complete future")
    }
}

fun main(args: Array<String>) {

    // using common pool
    LongStream.range(0, 5).parallel().forEach {
        logger.debug("$it")
    }
    completableFuture().join()

    // using user created pool
    val forkJoinPool = ForkJoinPool(1) // use 1 thread
    forkJoinPool.submit {
        LongStream.range(0, 5).parallel().forEach {
            logger.debug("$it")
        }
    }.join()
    logger.info("==> END")
}