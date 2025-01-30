package com.example.model.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

fun main() {
    // use only main thread

    runBlocking { // [coroutine builder] this: CoroutineScope. blocking this thread(main)
        // work independently. wait all children coroutines.
        launch { // [coroutine builder] launch a new coroutine and continue
            delay(2000L) // non-blocking delay for 1 second (default time unit is ms)
            logger.debug("Hello World! 1") // print after delay
        }
        launch { // launch a new coroutine again
            delay(1000L)
            logger.debug("Hello World! 2")
        }
        val job = launch { // launch return a job that can be used to cancel the coroutine
            delay(3000L)
            logger.debug("Hello World! Finish!")
        }

        logger.debug("Hello World! 0") // main coroutine continues while a previous one is delayed
        job.join()
        logger.debug("Every Body!")
    }
    logger.info("==> END")
}