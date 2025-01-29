[CreateThreadModel.kt](src/main/kotlin/model/CreateThreadModel.kt)[AsyncNonBlockingModel.kt](src/main/kotlin/model/AsyncNonBlockingModel.kt)
- async/non-blocking model
- always create thread
```log
01:09.339|DEBUG|Thread-1|c.e.m.AsyncNonBlockingModelKt.subB|start B
01:09.339|DEBUG|Thread-0|c.e.m.AsyncNonBlockingModelKt.subA|start A
01:10.345|DEBUG|Thread-0|c.e.m.AsyncNonBlockingModelKt.subA|end A
01:10.345|DEBUG|Thread-1|c.e.m.AsyncNonBlockingModelKt.subB|end B
01:10.346|INFO |main|c.e.m.AsyncNonBlockingModelKt.main|==> END
```

[SyncNonBlockingModel.kt](src/main/kotlin/model/SyncNonBlockingModel.kt)
- sync/non-blocking model
- ForkJoinPool(thread pool)
```log
01:59.444|DEBUG|main|c.e.m.SyncNonBlockingModelKt.main|waiting...
01:59.444|DEBUG|ForkJoinPool.commonPool-worker-19|c.e.m.SyncNonBlockingModelKt.subA$lambda$1|start A
01:59.444|DEBUG|ForkJoinPool.commonPool-worker-5|c.e.m.SyncNonBlockingModelKt.subB$lambda$2|start B
02:00.461|DEBUG|main|c.e.m.SyncNonBlockingModelKt.main|waiting...
02:01.470|DEBUG|main|c.e.m.SyncNonBlockingModelKt.main|waiting...
02:02.467|DEBUG|ForkJoinPool.commonPool-worker-5|c.e.m.SyncNonBlockingModelKt.subB$lambda$2|end B
02:02.482|DEBUG|main|c.e.m.SyncNonBlockingModelKt.main|waiting...
02:03.495|DEBUG|main|c.e.m.SyncNonBlockingModelKt.main|waiting...
02:04.506|DEBUG|main|c.e.m.SyncNonBlockingModelKt.main|waiting...
02:05.453|DEBUG|ForkJoinPool.commonPool-worker-19|c.e.m.SyncNonBlockingModelKt.subA$lambda$1|end A
02:05.515|INFO |main|c.e.m.SyncNonBlockingModelKt.main|==> END
```


[AsyncNonBlockingModel.kt](src/main/kotlin/model/AsyncNonBlockingModel.kt)
- async/non-blocking model
```log
56:58.258|INFO |main|c.e.m.AsyncNonBlockingModelKt.main|==> start [0]. single thread process
56:58.262|DEBUG|main|c.e.m.AsyncNonBlockingModelKt.firstJobNonBlocking|[0] start First job
56:59.283|DEBUG|kotlinx.coroutines.DefaultExecutor|c.e.m.AsyncNonBlockingModelKt.firstJobNonBlocking|[0] delay First job...
57:00.289|DEBUG|kotlinx.coroutines.DefaultExecutor|c.e.m.AsyncNonBlockingModelKt.firstJobNonBlocking|[0] delay First job...
57:01.303|DEBUG|kotlinx.coroutines.DefaultExecutor|c.e.m.AsyncNonBlockingModelKt.firstJobNonBlocking|[0] delay First job...
57:01.303|DEBUG|kotlinx.coroutines.DefaultExecutor|c.e.m.AsyncNonBlockingModelKt.firstJobNonBlocking|[0] end First job
57:01.305|DEBUG|kotlinx.coroutines.DefaultExecutor|c.e.m.AsyncNonBlockingModelKt.secondJob|[0] start Second job
57:02.315|DEBUG|kotlinx.coroutines.DefaultExecutor|c.e.m.AsyncNonBlockingModelKt.secondJob|[0] end Second job
57:02.324|INFO |kotlinx.coroutines.DefaultExecutor|c.e.m.AsyncNonBlockingModelKt$main$3.invokeSuspend|==> start [1]. parallelism process, worker is N, non-blocking
57:02.335|DEBUG|DefaultDispatcher-worker-1|c.e.m.AsyncNonBlockingModelKt.firstJobNonBlocking|[1] start First job
57:02.336|DEBUG|DefaultDispatcher-worker-2|c.e.m.AsyncNonBlockingModelKt.secondJob|[1] start Second job
57:03.340|DEBUG|DefaultDispatcher-worker-1|c.e.m.AsyncNonBlockingModelKt.secondJob|[1] end Second job
57:03.340|DEBUG|DefaultDispatcher-worker-2|c.e.m.AsyncNonBlockingModelKt.firstJobNonBlocking|[1] delay First job...
57:04.353|DEBUG|DefaultDispatcher-worker-2|c.e.m.AsyncNonBlockingModelKt.firstJobNonBlocking|[1] delay First job...
57:05.365|DEBUG|DefaultDispatcher-worker-2|c.e.m.AsyncNonBlockingModelKt.firstJobNonBlocking|[1] delay First job...
57:05.365|DEBUG|DefaultDispatcher-worker-2|c.e.m.AsyncNonBlockingModelKt.firstJobNonBlocking|[1] end First job
57:05.369|INFO |DefaultDispatcher-worker-2|c.e.m.AsyncNonBlockingModelKt$main$4.invokeSuspend|==> start [2]. concurrency process, worker in only 1, non-blocking
57:05.371|DEBUG|singleWorker|c.e.m.AsyncNonBlockingModelKt.firstJobNonBlocking|[2] start First job
57:05.373|DEBUG|singleWorker|c.e.m.AsyncNonBlockingModelKt.secondJob|[2] start Second job
57:06.374|DEBUG|singleWorker|c.e.m.AsyncNonBlockingModelKt.firstJobNonBlocking|[2] delay First job...
57:06.375|DEBUG|singleWorker|c.e.m.AsyncNonBlockingModelKt.secondJob|[2] end Second job
57:07.384|DEBUG|singleWorker|c.e.m.AsyncNonBlockingModelKt.firstJobNonBlocking|[2] delay First job...
57:08.396|DEBUG|singleWorker|c.e.m.AsyncNonBlockingModelKt.firstJobNonBlocking|[2] delay First job...
57:08.396|DEBUG|singleWorker|c.e.m.AsyncNonBlockingModelKt.firstJobNonBlocking|[2] end First job
57:08.398|WARN |singleWorker|c.e.m.AsyncNonBlockingModelKt$main$5.invokeSuspend|==> start [3]. !!! invalid concurrency process, worker in only 1, blocking
57:08.400|DEBUG|singleWorker|c.e.m.AsyncNonBlockingModelKt.firstJobBlocking|[3] start First job
57:09.407|DEBUG|singleWorker|c.e.m.AsyncNonBlockingModelKt.firstJobBlocking|[3] sleep First job...
57:10.418|DEBUG|singleWorker|c.e.m.AsyncNonBlockingModelKt.firstJobBlocking|[3] sleep First job...
57:11.423|DEBUG|singleWorker|c.e.m.AsyncNonBlockingModelKt.firstJobBlocking|[3] sleep First job...
57:11.424|DEBUG|singleWorker|c.e.m.AsyncNonBlockingModelKt.firstJobBlocking|[3] end First job
57:11.425|DEBUG|singleWorker|c.e.m.AsyncNonBlockingModelKt.secondJob|[3] start Second job
57:12.434|DEBUG|singleWorker|c.e.m.AsyncNonBlockingModelKt.secondJob|[3] end Second job
57:12.435|INFO |singleWorker|c.e.m.AsyncNonBlockingModelKt.main|==> END
```

[KotlinThreadPoolSystem.kt](src/main/kotlin/model/KotlinThreadPoolSystem.kt)
- kotlin thread pool system
```log
01:30.620|DEBUG|ForkJoinPool.commonPool-worker-5|c.e.m.KotlinThreadPoolSystemKt.main$lambda$2|1
01:30.620|DEBUG|main|c.e.m.KotlinThreadPoolSystemKt.main$lambda$2|2
01:30.620|DEBUG|ForkJoinPool.commonPool-worker-19|c.e.m.KotlinThreadPoolSystemKt.main$lambda$2|4
01:30.620|DEBUG|ForkJoinPool.commonPool-worker-23|c.e.m.KotlinThreadPoolSystemKt.main$lambda$2|3
01:30.624|DEBUG|ForkJoinPool.commonPool-worker-5|c.e.m.KotlinThreadPoolSystemKt.main$lambda$2|0
01:31.140|DEBUG|ForkJoinPool.commonPool-worker-5|c.e.m.KotlinThreadPoolSystemKt.completableFuture$lambda$1|complete future
01:31.141|DEBUG|ForkJoinPool-1-worker-3|c.e.m.KotlinThreadPoolSystemKt.main$lambda$4$lambda$3|2
01:31.141|DEBUG|ForkJoinPool-1-worker-3|c.e.m.KotlinThreadPoolSystemKt.main$lambda$4$lambda$3|4
01:31.142|DEBUG|ForkJoinPool-1-worker-3|c.e.m.KotlinThreadPoolSystemKt.main$lambda$4$lambda$3|3
01:31.142|DEBUG|ForkJoinPool-1-worker-3|c.e.m.KotlinThreadPoolSystemKt.main$lambda$4$lambda$3|1
01:31.142|DEBUG|ForkJoinPool-1-worker-3|c.e.m.KotlinThreadPoolSystemKt.main$lambda$4$lambda$3|0
01:31.142|INFO |main|c.e.m.KotlinThreadPoolSystemKt.main|==> END
```

