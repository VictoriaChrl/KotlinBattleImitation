import kotlin.random.Random

enum class Ammo(val damage: Int, val damageChance: Int, val damageChancePercent: Int) {
    SHOT1(1, 25, 2),
    SHOT2(3, 35, 3),
    SHOT3(5, 55, 4);

    fun damageShot(): Int {
        return if (damageChance.chance()) {
            damage * damageChancePercent
        } else damage
    }
}

private fun Int.chance(): Boolean {
    val criticalDamage = Random.nextInt(1, 100)
    return this > criticalDamage
}