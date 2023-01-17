class Captain : AbstractWarrior() {
    override val maxHealth: Int = 80
    override val accuracy: Int = 60
    override val weapon: AbstractWeapon = Weapons.createChopper()
    override var currentHealth: Int = 80

    override val name = "captain"


    override var chanceToAvoid: Int = 60

    override fun attack(warrior: AbstractWarrior) {
        if (weapon.magazine.stack.size == 0) {
            weapon.recharge()
        } else {
            weapon.getPatron()
            var check = (accuracy * (100 - warrior.chanceToAvoid)).toDouble() / 100
            val checkChance = Random.nextInt(1, 100)
            if (checkChance <= check) {
                val damageAttack = weapon.createAmmo(Weapons.createChopper().typAmmo)?.damageShot()
                warrior.getDamaged(damageAttack!!)
                println("Captain shot the enemy!")
            } else {
                println("The enemy evaded!")
            }
        }
    }

    override fun getDamaged(damage: Int) {
        currentHealth -= damage
    }
}