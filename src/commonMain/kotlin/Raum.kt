import com.soywiz.korge.view.Image
import com.soywiz.korim.bitmap.Bitmap
import com.soywiz.korim.format.readBitmap
import com.soywiz.korio.file.std.resourcesVfs

class Raum(val sprite : String,
           val hitbox : List<Hitbox>,
           val exith : Array<Boolean>,
           val posen : List<Point>)
