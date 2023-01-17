class General : AbstractWarrior() {
    override val maxHealth: Int = 100
    override val accuracy: Int = 80
    override val weapon: AbstractWeapon = Weapons.createGun()
    override var currentHealth: Int = 100

    override val name = "general"


    override var chanceToAvoid: Int = 80

    override fun attack(warrior: AbstractWarrior) {
        if (weapon.magazine.stack.size == 0) {
            weapon.recharge()
        } else {
            weapon.getPatron()
            var check = (accuracy * (100 - warrior.chanceToAvoid)).toDouble() / 100
            val checkChance = Random.nextInt(1, 100)
            if (checkChance <= check) {
                val damageAttack = weapon.createAmmo(Weapons.createGun().typAmmo)?.damageShot()
                warrior.getDamaged(damageAttack!!)
                println("General shot the enemy!")
            } else {
                println("The enemy evaded!")
            }
        }
    }

    override fun getDamaged(damage: Int) {
        currentHealth -= damage
    }
}