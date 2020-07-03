import com.soywiz.korge.view.Image
import com.soywiz.korim.bitmap.Bitmap
import com.soywiz.korim.format.readBitmap
import com.soywiz.korio.file.std.resourcesVfs

class Raum(val sprite : String,
           val noth : List<Hitbox>,
           val damh : List<Hitbox>,
           val exith : Array<Boolean>,
           val posen : List<Point>,
           val posch : List<Point>)

class Raumex(val raum : Raum, val ort : Point)