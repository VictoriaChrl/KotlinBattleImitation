sealed class FireType{
    object SingleShot: FireType()

    data class Burst(val burstSize: Int): FireType()

}