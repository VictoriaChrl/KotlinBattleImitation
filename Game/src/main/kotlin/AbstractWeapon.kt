abstract class AbstractWeapon {
    abstract val patronMax: Int
    abstract var fire: FireType
    abstract var magazine: Stack<Ammo>
    abstract var patronInMagazine: Boolean
    abstract val typAmmo: String

    open fun createAmmo(typAmmo: String): Ammo? {
        var patron = Ammo.SHOT1
        when (typAmmo) {
            "1" -> patron = Ammo.SHOT1
            "2" -> patron = Ammo.SHOT2
            "3" -> patron = Ammo.SHOT3
            else -> println("Choose ammo: 1, 2, 3.")
        }
        return patron
    }


    abstract fun recharge(): Stack<Ammo>
    abstract fun getPatron(): Stack<Ammo>

}
