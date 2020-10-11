import kotlin.system.exitProcess
import java.nio.file.Files
import java.nio.file.Paths


if (args.size == 0) {
  println("Usage: rename2date <folder>")
  exitProcess(1)
}

val folder = Paths.get(args[0])
if (!Files.isDirectory(folder)) {
  println("This should be an existing folder: ${args[0]}")
  exitProcess(2)
}

println(args[0])