abstract class AbstractWarrior: Warrior {
    abstract val maxHealth: Int

    abstract val accuracy: Int
    abstract val weapon: AbstractWeapon
    abstract var currentHealth: Int

    abstract  val name: String

    override var isKilled: Boolean = true
        get() = currentHealth<=0


}