import com.soywiz.klock.milliseconds
import com.soywiz.korev.Key
import com.soywiz.korge.scene.Scene
import com.soywiz.korge.time.delay
import com.soywiz.korge.time.delayFrame
import com.soywiz.korge.view.*
import com.soywiz.korim.format.readBitmap
import com.soywiz.korio.file.std.resourcesVfs
import com.soywiz.korio.lang.Thread_sleep

class Level : Scene() {
    suspend override fun Container.sceneInit() {
        camera {
            var test = Image(resourcesVfs["Moon384.png"].readBitmap())
            addChild(test)
        }
        var v = 10
        var camx : Double = 0.0
        var camy : Double = 0.0
        var camxn : Double = 0.0
        var camyn : Double = 0.0
        camera {




            val cl = resourcesVfs["characterleft.png"].readBitmap()
            val cr = resourcesVfs["characterright.png"].readBitmap()
            val animationLeft = SpriteAnimation(
                    spriteMap = cl,
                    spriteWidth = 128,
                    spriteHeight = 32,
                    marginTop = 0,
                    marginLeft = 0,
                    columns = 1,
                    rows = 4,
                    offsetBetweenColumns = 0,
                    offsetBetweenRows = 0
            )

            val animationRight = SpriteAnimation(
                    spriteMap = cr,
                    spriteWidth = 128,
                    spriteHeight = 32,
                    marginTop = 0,
                    marginLeft = 0,
                    columns = 1,
                    rows = 4,
                    offsetBetweenColumns = 0,
                    offsetBetweenRows = 0
            )
            val standRight = SpriteAnimation(
                    spriteMap = cr,
                    spriteWidth = 32,
                    spriteHeight = 32,
                    marginTop = 0,
                    marginLeft = 0,
                    columns = 1,
                    rows = 1,
                    offsetBetweenColumns = 0,
                    offsetBetweenRows = 0
            )
            val standLeft = SpriteAnimation(
                    spriteMap = cl,
                    spriteWidth = 32,
                    spriteHeight = 32,
                    marginTop = 0,
                    marginLeft = 0,
                    columns = 1,
                    rows = 1,
                    offsetBetweenColumns = 0,
                    offsetBetweenRows = 0
            )
            val player = Sprite(animationRight).apply {
                scale = 2.0
                xy(640, 360)
            }
            addChild(player)
            position(camx, camy)
            var lr: Boolean = true
            addUpdater {
                if (camx > camxn) {

                        camx=camx - 10
                        position(camx, camy)

                }
                if (camx < camxn) {

                    camx=camx + 10
                    position(camx, camy)

                }
                if (camy > camyn) {

                    camy=camy - 10
                    position(camx, camy)

                }
                if (camy < camyn) {

                    camy=camy + 10
                    position(camx, camy)

                }

                if (views.input.keys[Key.A]) {
                    player.playAnimation(animationLeft, spriteDisplayTime = 85.milliseconds)
                    player.x = player.x - v
                    lr = false
                }
                if (views.input.keys[Key.D]) {
                    player.playAnimation(animationRight, spriteDisplayTime = 85.milliseconds)
                    player.x = player.x + v
                    lr = true
                }
                if (views.input.keys[Key.W]) {
                    if (lr) {
                        player.playAnimation(animationRight, spriteDisplayTime = 85.milliseconds)
                    } else {
                        player.playAnimation(animationLeft, spriteDisplayTime = 85.milliseconds)
                    }
                    player.y = player.y - v
                }
                if (views.input.keys[Key.S]) {
                    if (lr) {
                        player.playAnimation(animationRight, spriteDisplayTime = 85.milliseconds)
                    } else {
                        player.playAnimation(animationLeft, spriteDisplayTime = 85.milliseconds)
                    }
                    player.y = player.y + v
                }
                if (!views.input.keys[Key.W] && !views.input.keys[Key.A] && !views.input.keys[Key.S] && !views.input.keys[Key.D]) {
                    if (lr) {
                        player.playAnimation(standRight, spriteDisplayTime = 1.milliseconds)
                    } else {
                        player.playAnimation(standLeft, spriteDisplayTime = 1.milliseconds)
                    }
                }
            }
        }
    }
}