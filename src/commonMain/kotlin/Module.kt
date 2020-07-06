import com.soywiz.korge.scene.Module
import com.soywiz.korge.scene.Scene
import com.soywiz.korinject.AsyncInjector
import com.soywiz.korma.geom.SizeInt
import kotlin.reflect.KClass

object MyModule : Module() {
    override val icon: String? = "korge.png"
    override var size = SizeInt(1280, 960)
    override val windowSize: SizeInt
        get() = super.windowSize
    override val title = "Evil Dungeons"
    override val mainScene: KClass<out Scene> = Menu::class

    override suspend fun AsyncInjector.configure() {
        mapPrototype { Menu() }
        mapPrototype { Test() }
        mapPrototype { Raumtest() }
        mapPrototype { Level() }
    }

}