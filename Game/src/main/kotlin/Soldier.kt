class Soldier : AbstractWarrior() {
    override val maxHealth: Int = 50
    override val accuracy: Int = 40
    override val weapon: AbstractWeapon = Weapons.createBigPistol()
    override var currentHealth: Int = 50

    override val name = "soldier"


    override var chanceToAvoid: Int = 60

    override fun attack(warrior: AbstractWarrior) {
        if (weapon.magazine.stack.size == 0) {
            weapon.recharge()
        } else {
            weapon.getPatron()
            var check = (accuracy * (100 - warrior.chanceToAvoid)).toDouble() / 100
            val checkChance = Random.nextInt(1, 100)
            if (checkChance <= check) {
                val damageAttack = weapon.createAmmo(Weapons.createBigPistol().typAmmo)?.damageShot()
                warrior.getDamaged(damageAttack!!)
                println("Soldier shot the enemy!")
            } else {
                println("The enemy evaded!")
            }
        }
    }

    override fun getDamaged(damage: Int) {
        currentHealth -= damage
    }
}