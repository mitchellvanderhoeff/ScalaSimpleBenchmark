
/**
 * Created by Mitchell Vanderhoeff
 * Date: 2012-11-20
 * Time: 4:27 PM
 */

import compat.Platform

object benchmark {
  def apply(benchmarkFunction: => Unit)(times:Int = 1) = {
    println("BENCHMARK: Start.")
    val startTime = Platform.currentTime
    for (i <- 0 until times)
      benchmarkFunction
    val endTime = Platform.currentTime
    val timeElapsed = (endTime - startTime).toDouble / times.toDouble
    println(s"BENCHMARK: End. Operation took $timeElapsed ms ${if(times > 1) "on average" else ""}")
    timeElapsed
  }
}
