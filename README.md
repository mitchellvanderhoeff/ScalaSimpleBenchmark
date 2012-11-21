Simple benchmark framework for scala using anonymous functions. 

Usage:
```scala
benchmark {
  // insert operation here
}()
```

If you want to specify an amount of times to run the operation:
```scala
benchmark {
  // insert operation here
}(times = 100)
```
That's all, folks!