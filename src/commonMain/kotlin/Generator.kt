import com.soywiz.korge.view.Image
import com.soywiz.korim.format.readBitmap
import com.soywiz.korio.file.std.resourcesVfs
import com.soywiz.korge.view.camera
import com.soywiz.korge.Korge

suspend fun generatemap(Num :Int, Num2 : Int) : Image{

        val randomInteger = (0..1).shuffled().first()


    if(randomInteger == 1) {
        val g1 = Image(resourcesVfs["Moon384.png"].readBitmap())
        g1.x = 192.0 * Num
        g1.y = 192.0 * Num2
        g1.scale = 0.5
        return g1
    }
    else{
        val g1 = Image(resourcesVfs["2000px-Solid_white.svg.jpg"].readBitmap())
        g1.x=192.0 * Num
        g1.y=192.0 *Num2
        g1.scale = 0.096
        return g1
    }
}