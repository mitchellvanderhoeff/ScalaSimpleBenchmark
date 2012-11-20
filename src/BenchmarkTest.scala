
/**
 * Created by Mitchell Vanderhoeff
 * Date: 2012-11-20
 * Time: 4:43 PM
 */


benchmark {
  val doubles = (1 to 1000000).par.map(math.sqrt(_))
  doubles.foldRight(0.0)(_ + _)
}(times = 100)

benchmark {
  val doubles = (1 to 1000000).seq.map(math.sqrt(_))
  doubles.foldRight(0.0)(_ + _)
}(times = 100)