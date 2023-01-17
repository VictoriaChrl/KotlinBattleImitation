fun main(args: Array<String>) {
    //можно выбрать до 4 человек в команде
    val battle1 = Battle(4)
    battle1.createTeams()
    while(battle1.startBattle() is BattleState.Progress){battle1.startBattle()}
}