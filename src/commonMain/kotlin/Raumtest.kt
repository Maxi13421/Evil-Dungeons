import com.soywiz.korge.scene.Scene
import com.soywiz.korge.view.Container
import com.soywiz.korge.view.Image
import com.soywiz.korim.format.readBitmap
import com.soywiz.korio.file.std.resourcesVfs

class Raumtest : Scene() {
    suspend override fun Container.sceneInit() {
        val wandl = Image(resourcesVfs["wandlr.png"].readBitmap(),anchorX= 0.0,anchorY= 0.0)
        wandl.x = 0.0
        wandl.y = 0.0
        wandl.scale = 5.0
        val wandr = Image(resourcesVfs["wandlr.png"].readBitmap())
        wandr.x = 960.0
        wandr.y = 0.0
        wandr.scale = 5.0
        val wando = Image(resourcesVfs["wandou.png"].readBitmap())
        wando.x = 120.0
        wando.y = 0.0
        wando.scale = 5.0
        val wandu = Image(resourcesVfs["wandou.png"].readBitmap())
        wandu.x = 120.0
        wandu.y = 600.0
        wandu.scale = 5.0
        addChild(wandl)
        addChild(wandr)
        addChild(wando)
        addChild(wandu)
    }
}