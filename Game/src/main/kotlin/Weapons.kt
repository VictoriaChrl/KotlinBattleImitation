object Weapons {
    fun firePatron(fireType: FireType): Int{
        var order: Int
        order = when(fireType){
            FireType.SingleShot -> 1
            is FireType.Burst -> fireType.burstSize
        }
        return order
    }

    fun createPistol(): AbstractWeapon {
        val pistol = object : AbstractWeapon() {
            override val patronMax: Int = 10
            override var magazine: Stack<Ammo> = Stack<Ammo>()
            override var patronInMagazine: Boolean = magazine.isEmpty()
            override var fire: FireType = FireType.SingleShot

            override val typAmmo: String = "1"


            override fun createAmmo(typAmmo: String) = Ammo.SHOT1


            override fun recharge(): Stack<Ammo> {
                for (n in 1..patronMax) {
                    magazine.push(createAmmo(typAmmo))
                }
                return magazine
            }

            override fun getPatron(): Stack<Ammo> {
                magazine.pop()
                return magazine
            }
        }
        return pistol
    }

    fun createGun(): AbstractWeapon {
        val gun = object : AbstractWeapon() {
            override val patronMax: Int = 30
            override var magazine: Stack<Ammo> = Stack<Ammo>()
            override var patronInMagazine: Boolean = magazine.isEmpty()
            override var fire: FireType = FireType.Burst(3)

            override val typAmmo: String = "2"

            override fun createAmmo(typAmmo: String) = Ammo.SHOT2

            override fun recharge(): Stack<Ammo> {
                for (n in 1..patronMax) {
                    magazine.push(createAmmo(typAmmo))
                }
                return magazine
            }

            override fun getPatron(): Stack<Ammo> {
                val order = firePatron(fire)

                for (n in 1..order) {
                    magazine.pop()
                }
                return magazine
            }
        }
        return gun
    }

    fun createBigPistol(): AbstractWeapon{
        val bigPistol = object : AbstractWeapon() {
            override val patronMax: Int = 20
            override var magazine: Stack<Ammo> = Stack<Ammo>()
            override var patronInMagazine: Boolean = magazine.isEmpty()
            override var fire: FireType = FireType.SingleShot

            override val typAmmo: String = "3"


            override fun createAmmo(typAmmo: String) = Ammo.SHOT3


            override fun recharge(): Stack<Ammo> {
                for (n in 1..patronMax) {
                    magazine.push(createAmmo(typAmmo))
                }
                return magazine
            }

            override fun getPatron(): Stack<Ammo> {
                magazine.pop()
                return magazine
            }
        }
        return bigPistol
    }

    fun createChopper(): AbstractWeapon{
        val chopper = object : AbstractWeapon() {
            override val patronMax: Int = 52
            override var magazine: Stack<Ammo> = Stack<Ammo>()
            override var patronInMagazine: Boolean = magazine.isEmpty()
            override var fire: FireType = FireType.Burst(4)

            override val typAmmo: String = "1"

            override fun createAmmo(typAmmo: String) = Ammo.SHOT1

            override fun recharge(): Stack<Ammo> {
                for (n in 1..patronMax) {
                    magazine.push(createAmmo(typAmmo))
                }
                return magazine
            }

            override fun getPatron(): Stack<Ammo> {
                val order = firePatron(fire)

                for (n in 1..order) {
                    magazine.pop()
                }
                return magazine
            }
        }
        return chopper

    }
}