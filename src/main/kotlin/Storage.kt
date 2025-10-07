abstract class Storage {
        abstract val name:String
        abstract fun printCompanion(text:String):String
        abstract var parent:MutableList<Archive>
        abstract var text:String

}
