import com.soywiz.klock.milliseconds
import com.soywiz.korev.Key
import com.soywiz.korge.scene.Scene
import com.soywiz.korge.time.delay
import com.soywiz.korge.time.delayFrame
import com.soywiz.korge.view.*
import com.soywiz.korim.format.readBitmap
import com.soywiz.korio.file.std.resourcesVfs
import com.soywiz.korio.lang.Thread_sleep
import kotlin.math.abs

class Level : Scene() {
    suspend override fun Container.sceneInit() {
    Map.generateMap()
        for(y in 0..100){
            println(Map.map[y])
        }




        var v = 10
        var camx : Double = 0.0
        var camy : Double = 0.0
        var camxn : Double = 0.0
        var camyn : Double = 0.0
        camera {
            var ax = 0
            for(xxx in 0..50000){
                if(Map.map[xxx]!=24){
                    ax++
                    println(ax)
                    var x : Image = Image(resourcesVfs[Map.raumliste[Map.map[xxx]].sprite].readBitmap())
                    x.scale = 3.3333
                    x.x = Map.inttox(xxx).toDouble()*1280
                    x.y = -Map.inttoy(xxx).toDouble()*960
                    addChild(x)
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
                scale = 3.0
                xy(640, 360)
            }
            addChild(player)
            position(camx, camy)
            var lr: Boolean = true
            var time : Long = 0
            addUpdater {
                time++
                /*
                print(player.x)
                print(" ")
                print(player.y)
                print(" ")
                println(Map.map[Map.plaroom])

                 */
                /*if(Map.raumliste[Map.map[Map.plaroom]].exith[0] && player.y+Map.inttoy(Map.plaroom)*960<0 ){
                    Map.raumo()
                    camyn = camyn + 960
                }
                if(Map.raumliste[Map.map[Map.plaroom]].exith[1] && player.x- Map.inttox(Map.plaroom)*1280>1280){
                    Map.raumr()
                    print("aa")
                    camxn = camxn - 1280
                }
                /*
                print(Map.raumliste[Map.map[Map.plaroom]].exith[1])
                print(player.x- Map.inttox(Map.plaroom)*1280>1280)
                print(player.y - Map.inttoy(Map.plaroom)*720 >= 300)
                print(player.y - Map.inttoy(Map.plaroom)*720 <= 420)
                print(Map.plaroom)

                 */

                if(Map.raumliste[Map.map[Map.plaroom]].exith[2] && player.y+ Map.inttoy(Map.plaroom)*960>960){
                    Map.raumu()
                    camyn = camyn - 960
                }
                if(Map.raumliste[Map.map[Map.plaroom]].exith[3] && player.x- Map.inttox(Map.plaroom)*1280<0){
                    Map.rauml()
                    camxn = camxn + 1280
                }

                 */
                if(player.x>0){
                    camxn= -player.x+player.x%1280
                }
                else{
                    camxn= -player.x-abs(player.x%1280)
                }
                if(player.y>0){
                    camyn = - player.y+player.y%960
                }
                else{
                    camyn= -player.y-abs(player.y%960) + 960
                }


                for(aaa in 0..2) {
                    if (camx > camxn) {

                        camx = camx - 10
                        position(camx, camy)

                    }
                    if (camx < camxn) {

                        camx = camx + 10
                        position(camx, camy)

                    }
                    if (camy > camyn) {

                        camy = camy - 10
                        position(camx, camy)

                    }
                    if (camy < camyn) {

                        camy = camy + 10
                        position(camx, camy)

                    }
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
                /*
                print(player.x)
                print("   ")
                println(player.y - Map.inttoy(Map.plaroom)*720)

                 */
            }
        }
    }
}