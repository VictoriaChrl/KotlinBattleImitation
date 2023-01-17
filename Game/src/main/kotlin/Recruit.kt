class Recruit : AbstractWarrior() {
    override val maxHealth: Int = 30
    override val accuracy: Int = 20
    override val weapon: AbstractWeapon = Weapons.createPistol()
    override var currentHealth: Int = 30


    override var chanceToAvoid: Int = 20

    override val name = "recruit"

    override fun attack(warrior: AbstractWarrior) {
        if (weapon.magazine.stack.size == 0) {
            weapon.recharge()
        } else {
            weapon.getPatron()
            var check = (accuracy * (100 - warrior.chanceToAvoid)).toDouble() / 100
            val checkChance = Random.nextInt(1, 100)
            if (checkChance <= check) {
                val damageAttack = weapon.createAmmo(Weapons.createPistol().typAmmo)?.damageShot()
                warrior.getDamaged(damageAttack!!)
                println("Recruit shot the enemy!")
            } else {
                println("The enemy evaded!")
            }
        }
    }

    override fun getDamaged(damage: Int) {
        currentHealth -= damage
    }
}