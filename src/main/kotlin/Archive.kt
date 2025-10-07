open class Archive (override val name:String): Storage() {
    override var parent:MutableList<Archive> = mutableListOf()
    var list:MutableList<Archive> = mutableListOf()
    override var text:String=""
    companion object {
        val helper=Helper()
        val emoji:String = helper.getEmoji(0x1F4C1)
        val emojiExit:String = helper.getEmoji(0x1F51A)
        val type: String = "Архив"
        val whatType: String = "Архив"
        val ofTypes: String = "Архивов"
        val exit: String = "$emojiExit Выйти из программы"
        val img: String = emoji
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

    fun addArchive(parentArchive:Archive) {
        println("Введите название нового архива:")
        val name: String = helper.getText()
        list.add(Archive(name))
        list[list.lastIndex].parent.add(parentArchive)
    }

    fun addNote() {
        println("Введите название заметки:")
        val name:String = helper.getText()
        println("Введите текст новой заметки:")
        val text:String = helper.getText()
        list.add(Note(name, text))
    }
    fun printNote()
    {
        println("\n\n $text")
        println("\nДля выхода введите \"0\"")
        var input:Int = helper.getDigit()
        while(input!=0)
            input = helper.getDigit()
    }
}

