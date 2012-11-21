Description
-----------
Simple benchmark framework for scala using anonymous functions. 
Usage
-----
To benchmark a code block, write
```scala
benchmark {
  val doubles = (1 to 100000).map(math.sqrt(_))
  doubles.foldRight(0.0)(_ * _)
}()
```
If you want to specify an amount of times to run the operation
and average the benchmark time, specify the times parameter like so
```scala
benchmark {
  val doubles = (1 to 100000).map(math.sqrt(_))
  doubles.foldRight(0.0)(_ * _)
}(times = 100)
```

The ```benchmark``` function returns the amount of milliseconds the benchmark took, so you can do things like
```scala
val sequential = benchmark {
  val doubles = (1 to 1000000).seq.map(math.sqrt(_))
  doubles.foldRight(0.0)(_ + _)
}(times = 10)

val parallel = benchmark {
  val doubles = (1 to 1000000).par.map(math.sqrt(_))
  doubles.foldRight(0.0)(_ + _)
}(times = 10)

println(s"Sequential took $sequential ms, parallel took $parallel ms.")
```
This produces
```
BENCHMARK: Start.
BENCHMARK: End. Operation took 497.7 ms on average
BENCHMARK: Start.
BENCHMARK: End. Operation took 560.9 ms on average
Sequential took 497.7 ms, parallel took 560.9 ms.
```

That's all, folks!
------------------