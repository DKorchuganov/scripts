import kotlin.system.exitProcess

if (args.size == 0) {
  println("Usage: rename2date <folder>")
  exitProcess(1)
}

println(args[0])