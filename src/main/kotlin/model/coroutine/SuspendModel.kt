package com.example.model.coroutine

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

suspend fun suspendFunction() { // coroutine Extract function. refactoring code.
    coroutineScope {  // [coroutine builder] this: CoroutineScope. non-blocking this thread(main).
        // work independently. wait all children coroutines.
        launch {
            delay(2000L)
            logger.debug("Hello World! 1")
        }
        launch {
            delay(1000L)
            logger.debug("Hello World! 2")
        }
        logger.debug("Hello World! 0")
    }
}

fun main() {
    // use only main thread

    runBlocking {
        suspendFunction()
    }
    logger.info("==> END")
}