class Battle(var members: Int) {
    val team1: Team = Team()
    val team2: Team = Team()
    val over: String = "Battle is over"
    var deadList1 = mutableListOf<AbstractWarrior>()
    var deadList2 = mutableListOf<AbstractWarrior>()


    fun battleState(state: BattleState) {
        when (state) {
            BattleState.WinnerTeam2 -> {
                println("Team 2 is a winner!")
            }

            BattleState.WinnerTeam1 -> {
                println("Team 1 is a winner!")
            }

            BattleState.Progress -> {
                println(
                    "Team 1 has ${deadList1.size} dead members. " +
                            "Team 2 has ${deadList2.size} dead members."
                )
                team1.teamList.stack.forEach { println("Team 1 warriors' health: ${it.name} - ${it.currentHealth}") }
                team2.teamList.stack.forEach { println("Team 2 warriors' health: ${it.name} - ${it.currentHealth}") }

            }
            BattleState.Draw -> println("Draw!")
        }
    }

    fun createTeams() {
        team1.createTeam(members)
        team2.createTeam(members)
    }

    fun startBattle(): BattleState {
        var condition: BattleState = BattleState.Draw
        when {
            deadList2.size == members -> {

                battleState(BattleState.WinnerTeam1)
                println(over)
                condition = BattleState.WinnerTeam1
            }
            deadList1.size == members -> {

                battleState(BattleState.WinnerTeam2)
                println(over)
                condition = BattleState.WinnerTeam2
            }
            deadList2.size == members && deadList1.size == members -> {
                condition = BattleState.Draw
                battleState(BattleState.Draw)
                println(over)
            }

            deadList1.size != members && deadList2.size != members -> {
                team2.teamList.stack.shuffle()
                team1.teamList.stack.shuffle()
                for (i in 0 until team2.teamList.stack.size) {
                    if (!team2.teamList.stack[i].isKilled && !team1.teamList.stack[i].isKilled) {
                        team1.teamList.stack[i].attack(team2.teamList.stack[i])
                    }
                }
                for (i in 0 until team1.teamList.stack.size) {
                    if (!team2.teamList.stack[i].isKilled && !team1.teamList.stack[i].isKilled) {
                        team2.teamList.stack[i].attack(team1.teamList.stack[i])
                    }
                }
                deadList2.clear()
                for (i in 0 until team2.teamList.stack.size) {
                    if (team2.teamList.stack[i].isKilled && i >= deadList2.lastIndex) {
                        deadList2.add(deadList2.size, team2.teamList.stack[i])
                    }
                }
                deadList1.clear()
                for (i in 0 until team1.teamList.stack.size) {
                    if (team1.teamList.stack[i].isKilled && i >= deadList1.lastIndex) {
                        deadList1.add(deadList1.size, team1.teamList.stack[i])
                    }
                }
                condition = BattleState.Progress
                battleState(BattleState.Progress)
            }
        }


        return condition
    }
}