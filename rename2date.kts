import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.attribute.BasicFileAttributes
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import kotlin.system.exitProcess


if (args.size == 0) {
  println("Usage: rename2date <folder> [<time shift in seconds>]")
  exitProcess(1)
}

val folder = Paths.get(args[0])
if (!Files.isDirectory(folder)) {
  println("This should be an existing folder: $folder")
  exitProcess(2)
}

val timeShift = if (args.size > 1) {
  args[1].toLong()
} else 0

Files.list(folder).forEach {
  val modified = Files.readAttributes(it, BasicFileAttributes::class.java).lastModifiedTime()
  val newName = "IMG_" +
      modified.toInstant()
          .plusSeconds(timeShift)
          .atZone(ZoneId.systemDefault())
          .toLocalDateTime()
          .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) + ".jpg"

  println("$it $newName $modified")
}