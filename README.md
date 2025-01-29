[AsyncNonBlockingModel.kt](src/main/kotlin/model/AsyncNonBlockingModel.kt)
- async/non-blocking model
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