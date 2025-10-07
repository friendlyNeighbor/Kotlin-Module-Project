class Note (override val name:String, override var text:String):Archive(name) {
override var parent:MutableList<Archive> = mutableListOf()
companion object {
    val helper = Helper()
    val emoji: String = helper.getEmoji(0x1F4DD)
    val emojiBack: String = helper.getEmoji(0x1F519)

    val type: String = "Заметка"
    val whatType: String = "Заметку"
    var ofTypes: String = "Заметок"
    var exit: String =  "$emojiBack Вернуться назад"
    var img: String = emoji
    }

    override fun printCompanion(text: String): String {
    return when(text) {
        "type" -> type
        "whatType" -> whatType
        "ofTypes" -> ofTypes
        "exit" -> exit
        "img" -> img
        else -> "ошибка программы"
    }
    }

 /*   fun printNote()
    {
        println(text)
        println("Для выхода введите \"0\"")
        var input:Int = helper.getDigit()
        while(input!=0)
            input = helper.getDigit()
    }

  */
}
