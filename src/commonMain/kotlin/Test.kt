import com.soywiz.klock.milliseconds
import com.soywiz.korev.Key
import com.soywiz.korge.input.onClick
import com.soywiz.korge.scene.Scene
import com.soywiz.korge.scene.SceneContainer
import com.soywiz.korge.view.*
import com.soywiz.korim.format.readBitmap
import com.soywiz.korinject.AsyncInjector
import com.soywiz.korinject.InjectorAsyncDependency
import com.soywiz.korio.async.launchImmediately
import com.soywiz.korio.file.std.resourcesVfs
import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext
inline fun Container.sceneContainer(views: Views, callback: SceneContainer.() -> Unit = {}): SceneContainer = SceneContainer(views).addTo(this).apply(callback)
class Test() : Scene() {
    suspend override fun Container.sceneInit() {
        // @TODO: Scene initialization here
        var v: Int = 2
        camera {
            /*
    val beispielMap = resourcesVfs[""].readTiledMap()


    tiledMapView(tiledMap = beispielMap) {
        scale = 2.0
    }

     */

            val test = Image(resourcesVfs["Moon384.png"].readBitmap())
            test.scale = 20.0
            addChild(test)
            for (xran in 0..6) {
                for (yran in 0..6) {
                    addChild(generatemap(xran, yran))
                }
            }


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
                xy(600, 600)
            }
            addChild(player)
            position(210 - player.x, 210 - player.y)
            var lr: Boolean = true
            addUpdater {

                if (views.input.keys[Key.A]) {
                    player.playAnimation(animationLeft, spriteDisplayTime = 85.milliseconds)
                    player.x = player.x - v
                    position(210 - player.x, 210 - player.y)
                    lr = false
                }
                if (views.input.keys[Key.D]) {
                    player.playAnimation(animationRight, spriteDisplayTime = 85.milliseconds)
                    player.x = player.x + v
                    position(210 - player.x, 210 - player.y)
                    lr = true
                }
                if (views.input.keys[Key.W]) {
                    if (lr) {
                        player.playAnimation(animationRight, spriteDisplayTime = 85.milliseconds)
                    } else {
                        player.playAnimation(animationLeft, spriteDisplayTime = 85.milliseconds)
                    }
                    player.y = player.y - v
                    position(210 - player.x, 210 - player.y)
                }
                if (views.input.keys[Key.S]) {
                    if (lr) {
                        player.playAnimation(animationRight, spriteDisplayTime = 85.milliseconds)
                    } else {
                        player.playAnimation(animationLeft, spriteDisplayTime = 85.milliseconds)
                    }
                    player.y = player.y + v
                    position(210 - player.x, 210 - player.y)
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
