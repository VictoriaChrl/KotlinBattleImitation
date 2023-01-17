interface Warrior {
    var isKilled: Boolean
    var chanceToAvoid: Int

    fun attack(warrior: AbstractWarrior)
    fun getDamaged(damage: Int)

}