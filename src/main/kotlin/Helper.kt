class Helper {

    fun getEmoji(unicode: Int): String {
        return String(Character.toChars(unicode))
    }

    fun getDigit(): Int {
        var errorOfInput: Boolean = true
        var scanner: String = ""
        var result: Int = 0
        while (errorOfInput) {
            scanner = readln()
            try {
                result = scanner.toInt()
                errorOfInput = false
            } catch (e: Exception) {
                println("Необходимо ввести число.")
            }
        }
        return result
    }

    fun getText(): String {
        var errorOfInput: Boolean = true
        var scanner: String = ""
        while (errorOfInput) {
            scanner = readln()
            if (scanner.trim().isEmpty())
                println("Введённый текст не может быть пустым!")
            else {
                errorOfInput = false
            }
        }
        return scanner.trim()
    }

}
