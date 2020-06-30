import com.soywiz.klock.milliseconds
import com.soywiz.korau.sound.readMusic
import com.soywiz.korau.sound.readSound
import com.soywiz.korev.Key
import com.soywiz.korge.input.keys
import com.soywiz.korge.input.mouse
import com.soywiz.korge.input.onClick
import com.soywiz.korge.input.onMouseDrag
import com.soywiz.korge.scene.Scene
import com.soywiz.korge.ui.TextButton
import com.soywiz.korge.ui.UIButton
import com.soywiz.korge.ui.UISkin
import com.soywiz.korge.view.Container
import com.soywiz.korge.view.*
import com.soywiz.korim.bitmap.toUri
import com.soywiz.korim.color.Colors
import com.soywiz.korim.format.readBitmap
import com.soywiz.korim.format.readBitmapSlice
import com.soywiz.korio.file.std.resourcesVfs
import com.soywiz.korma.geom.IPoint
import com.soywiz.korma.geom.Point
import com.soywiz.korma.geom.Rectangle
import com.soywiz.korma.geom.triangle.Triangle
import com.soywiz.korma.geom.triangle.containsPoint
import kotlinx.coroutines.isActive

class Menu : Scene() {
    suspend override fun Container.sceneMain() {
        // @TODO: Scene initialization here
        /*
        val cir = solidRect(200,400,Colors.WHEAT)
        addChild(cir)

         */
        val sound = resourcesVfs["mscf.mp3"].readMusic()
        val channel = sound.play()
        val menuback = resourcesVfs["startscreen.png"].readBitmap()
        val menubacka = SpriteAnimation(
                spriteMap = menuback,
                spriteWidth = 256,
                spriteHeight = 144,
                marginTop = 0,
                marginLeft = 0,
                columns = 1,
                rows = 20,
                offsetBetweenColumns = 0,
                offsetBetweenRows = 0
        )
        val mback = Sprite(menubacka).apply {
            scale = 5.0
            xy(0,0)
        }
        addChild(mback)
        addUpdater {
                mback.playAnimation(menubacka, 125.milliseconds)
        }
        val playb = UIButton()
        addChild(playb)
        playb.scale = 5.0
        val ax = Triangle(Point(72.0,124.0),Point(0.0,0.0),Point(100.0,0.0))

              /*
                .down(Key.SPACE) {
            sceneContainer.changeTo<Test>()

               */
        }
    }

