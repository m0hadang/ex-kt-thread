[AsyncNonBlockingModel.kt](src/main/kotlin/model/AsyncNonBlockingModel.kt)
- async/non-blocking model
```log
16:21:43.030|DEBUG|Thread-0|c.e.m.AsyncNonBlockingModelKt.subA|start A
16:21:43.030|DEBUG|Thread-1|c.e.m.AsyncNonBlockingModelKt.subB|start B
16:21:44.049|DEBUG|Thread-1|c.e.m.AsyncNonBlockingModelKt.subB|end B
16:21:44.049|DEBUG|Thread-0|c.e.m.AsyncNonBlockingModelKt.subA|end A
16:21:44.050|INFO |main|c.e.m.AsyncNonBlockingModelKt.main|==> END
```

[SyncNonBlockingModel.kt](src/main/kotlin/model/SyncNonBlockingModel.kt)
- sync/non-blocking model
- ForkJoinPool(thread pool)
```log
16:19:56.420|DEBUG|main|c.e.m.SyncNonBlockingModelKt.main|waiting...
16:19:56.420|DEBUG|ForkJoinPool.commonPool-worker-19|c.e.m.SyncNonBlockingModelKt.subA$lambda$3|start A
16:19:56.420|DEBUG|ForkJoinPool.commonPool-worker-5|c.e.m.SyncNonBlockingModelKt.subB$lambda$6|start B
16:19:57.430|DEBUG|main|c.e.m.SyncNonBlockingModelKt.main|waiting...
16:19:58.444|DEBUG|main|c.e.m.SyncNonBlockingModelKt.main|waiting...
16:19:59.428|DEBUG|ForkJoinPool.commonPool-worker-5|c.e.m.SyncNonBlockingModelKt.subB$lambda$6|end B
16:19:59.459|DEBUG|main|c.e.m.SyncNonBlockingModelKt.main|waiting...
16:20:00.474|DEBUG|main|c.e.m.SyncNonBlockingModelKt.main|waiting...
16:20:01.486|DEBUG|main|c.e.m.SyncNonBlockingModelKt.main|waiting...
16:20:02.424|DEBUG|ForkJoinPool.commonPool-worker-19|c.e.m.SyncNonBlockingModelKt.subA$lambda$3|end A
```