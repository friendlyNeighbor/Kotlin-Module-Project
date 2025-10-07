fun main() {
    var path: MutableList<String> = mutableListOf()
    val helper = Helper()
    val emojiNew = helper.getEmoji(0x1F195)
    val emojiBack: String = helper.getEmoji(0x1F519)
    val emojiArrow: String = helper.getEmoji(0x1F449)
    var currentStorage = Archive("Главное меню")
    path.add(currentStorage.name)

    fun <T : Storage> printMenu(list: MutableList<T>) {
        println()
        for (p in path)
            print("$emojiArrow $p ")
        println("\n\n0. $emojiNew Создать ${Archive.whatType}.")
        println("1. $emojiNew Создать ${Note.whatType}.")
        if (list.size > 0) {
            for (i in 0..list.size - 1) {
                println("${i + 2}. ${list[i].printCompanion("img")} ${list[i].name}")
            }
        }
        println("${list.size + 2}. ${emojiBack} Назад (Выйти).\n")
    }



    while (true) {
        printMenu(currentStorage.list)
        println("Введите номер пункта:")
        var number: Int = helper.getDigit()
        when {
            number == 0 -> currentStorage.addArchive(currentStorage)
            number == 1 -> currentStorage.addNote()
            number > 1 && number < currentStorage.list.size + 2 -> {
                if (currentStorage.list.get(number - 2) is Note) {
                    path.add(currentStorage.list.get(number - 2).name)
                    for (p in path)
                        print("$emojiArrow $p ")
                    currentStorage.list.get(number - 2).printNote()
                    path.removeLast()
                }
                    else {
                    currentStorage = currentStorage.list.get(number - 2)
                    path.add(currentStorage.name)
                }
            }

            number == currentStorage.list.size + 2 -> {
                try {
                    currentStorage = currentStorage.parent[0]
                    path.removeLast()
                } catch (e: Exception) {
                    println("Выход из программы")
                    return
                }

            }

            else -> println("Такого пункта не существует")
        }
    }


} // конец main


