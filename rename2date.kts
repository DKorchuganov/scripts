import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.attribute.BasicFileAttributes
import kotlin.system.exitProcess


if (args.size == 0) {
  println("Usage: rename2date <folder>")
  exitProcess(1)
}

val folder = Paths.get(args[0])
if (!Files.isDirectory(folder)) {
  println("This should be an existing folder: $folder")
  exitProcess(2)
}

Files.list(folder).forEach {
  val modified = Files.readAttributes(it, BasicFileAttributes::class.java).lastModifiedTime()
  println("$it $modified")
}