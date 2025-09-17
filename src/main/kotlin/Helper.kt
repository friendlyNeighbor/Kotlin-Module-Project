class Helper {

    fun inputDigit():Int {
        var input:String=""
        var errorOfInput:Boolean=true

        while(errorOfInput){
            input = readln()
            try  {
                input.toInt()
                errorOfInput = false
            }
            catch(e: Exception) {
                println("Неверный ввод (требуется ввести номер пункта)")
            }
        }
        return input.toInt()
        }

    fun inputText():String {
        var text:String=""
        var errorInput:Boolean = true
        while(errorInput){
            text = readln().trim()
            if(text.isEmpty())
                println("Строка не может быть пустой!")
            else
                errorInput=false
        }
        return text
    }

    fun addNotes():Notes? {
        println("МЕНЮ СОЗДАНИЯ ЗАМЕТОК:")
        println("Введите название новой заметки: (или введите \"Q\" для выхода в предыдущее меню)")
        var nameOfNewNotes:String = inputText()
        if (nameOfNewNotes.equals("Q"))
            return null
        println("Введите текст новой заметки: (или введите \\\"Q\\\" для выхода в предыдущее меню)\"")
        val textOfNewNotes:String =  inputText()
        if (textOfNewNotes.equals("Q"))
            return null
        println("Заметка \"$nameOfNewNotes\" создана.")
        return Notes(nameOfNewNotes, textOfNewNotes)
    }

    fun printListNotes(arrayNotes: MutableList<Notes>) {
        while(true) {
            println("0. Создать новую заметку")
            for (i in 1..arrayNotes.size)
                println("${i}. ${arrayNotes[i-1].name}")
            println("${arrayNotes.size+1}. Выйти из меню заметок в меню архивов.")
            var input=inputDigit()
            when {
                input == 0 -> {
                    val notes = addNotes()
                    if (notes!=null)
                        arrayNotes.add(notes)
                }
                input == (arrayNotes.size+1) -> return
                (input > 0 && input < arrayNotes.size+1) -> print("${arrayNotes[input-1].text} \n")
                else -> println("Такого пункта нет")
            }
        }}
    fun addArchives():Archives? {
        println("МЕНЮ СОЗДАНИЯ АРХИВОВ:")
        println("Введите название нового архива:(или введите \"Q\" для выхода в предыдущее меню)")
        var nameOfNewArchives:String = inputText()
        if (nameOfNewArchives.equals("Q"))
            return null
        println("Архив \"$nameOfNewArchives\" создан.")
        return Archives(nameOfNewArchives)
    }
    fun printListArchives(arrayArchives: MutableList<Archives>) {

        while(true) {
            println("МЕНЮ АРХИВОВ:")
            println("0. Создать новый архив.")
            for (i in 1..arrayArchives.size)
                println("${i}. ${arrayArchives[i-1].name}")
            println("${arrayArchives.size+1}. Выйти из программы.")
            var input=inputDigit()
            when {
                input == 0 -> {
                    val archives = addArchives()
                    if(archives!=null)
                        arrayArchives.add(archives)
                }
                input == arrayArchives.size+1 -> {
                    println("Программа завершена")
                    return
                }
                (input > 0 && input < arrayArchives.size+1) -> {
                    printListNotes(arrayArchives[input - 1].arrayNotes)
                 }

                else -> println("Такого пункта нет")

            }
        }}



}
