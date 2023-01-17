class Team {
    val general: AbstractWarrior = General()
    val captain: AbstractWarrior = Captain()
    val soldier: AbstractWarrior = Soldier()
    val recruit: AbstractWarrior = Recruit()
    val general2: AbstractWarrior = General()
    val captain2: AbstractWarrior = Captain()
    val soldier2: AbstractWarrior = Soldier()
    val recruit2: AbstractWarrior = Recruit()
    val general3: AbstractWarrior = General()
    val captain3: AbstractWarrior = Captain()
    val soldier3: AbstractWarrior = Soldier()
    val recruit3: AbstractWarrior = Recruit()
    val general4: AbstractWarrior = General()
    val captain4: AbstractWarrior = Captain()
    val soldier4: AbstractWarrior = Soldier()
    val recruit4: AbstractWarrior = Recruit()


    var teamList: Stack<AbstractWarrior> = Stack<AbstractWarrior>()

    fun createTeam(members: Int): Stack<AbstractWarrior> {
        for (i in 1..members) {
            when (Random.nextInt(1, 100)) {
                in 1..10 -> {
                    when (i) {
                        1 -> teamList.push(general)
                        2 -> teamList.push(general2)
                        3 -> teamList.push(general3)
                        4 -> teamList.push(general4)
                    }
                }
                in 11..30 -> {
                    when (i) {
                        1 -> teamList.push(captain)
                        2 -> teamList.push(captain2)
                        3 -> teamList.push(captain3)
                        4 -> teamList.push(captain4)
                    }
                }
                in 31..60 -> {
                    when (i) {
                        1 -> teamList.push(soldier)
                        2 -> teamList.push(soldier2)
                        3 -> teamList.push(soldier3)
                        4 -> teamList.push(soldier4)
                    }
                }
                in 61..100 -> {
                    when (i) {
                        1 -> teamList.push(recruit)
                        2 -> teamList.push(recruit2)
                        3 -> teamList.push(recruit3)
                        4 -> teamList.push(recruit4)
                    }
                }
            }
        }
        return teamList
    }
}