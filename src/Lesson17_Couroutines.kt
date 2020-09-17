/**
 * Note : This is not completed
 *
 * Coroutines : You entire kotlin learning is incomplete if you
 * haven't learnt about coroutines.
 *
 * What are coroutines.?
 *
 * Consider them as very light weight thread. In fact they are jobs
 * getting executed on a dedicated thread pool. But language has made
 * its usage so easy, meaningful, leak safe and performing.
 *
 * You will see them as clear replacement of traditional thread and services
 * Imagine the shitty long code you had to write to create AsyncTasks, IntentService
 * or Loaders.
 *
 * You have to learn its syntax. Which is as easy as
 *    GlobalScope.launch {
 *       println("Do something in the background")
 *    }
 *
 * These are advanced language stuff and you have to go through with
 * kotlin doc for better understanding.
 *
 * Look for suspend keyword in function declaration,
 * Coroutine Scope, Structured coroutines, ScopeBuilder,
 * isActive, cancelAndJoin, withContext(NonCancellable), withTimeout(timeOut)
 *
 * https://kotlinlang.org/docs/reference/coroutines/coroutines-guide.html
 * https://developer.android.com/kotlin/coroutines
 */

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    // Print the thread name
    println(Thread.currentThread().name)

    // Our coroutine
    var job = GlobalScope.launch {
        delay(2000)
        println("World")
        println(Thread.currentThread().name)
    }

    print("Hello ")
    runBlocking {
        job.join()
    }

}