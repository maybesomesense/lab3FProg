import scala.collection.mutable.ListBuffer
import scala.util.matching.Regex

object stringLab {
  def main(args: Array[String]): Unit = {
    print("VARIANT FIRST\n" +
      "1 — dop task \n" +
      "2 — first task\n" +
      "3 — second task\n" +
      "4 — third task\n" +
      "5 — fourth task\n" +
      "6 — fifth task\n" +
      "7 — sixth task\n" +
      "8 — seventh task\n" +
      "9 — eighth task\n" +
      "Enter task: ")

    val choice = scala.io.StdIn.readInt()

    if (choice == 1) {
      val text = scala.io.StdIn.readLine()
      val vowels = Set('а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я', 'А', 'Е', 'Ё', 'И', 'О', 'У', 'Ы', 'Э', 'Ю', 'Я',
        'a', 'e', 'i', 'o', 'y', 'u', 'A', 'E', 'I', 'O', 'Y', 'U')

      val vowelCount = text.count(char => vowels.contains(char))

      println(s"Суммарное число гласных в тексте: $vowelCount")
    } else if (choice == 2) {
      val text = "Hello to everybody"
      val immutableMap = Map('H' -> 'Н',
                             'e' -> 'е',
                             'l' -> 'л',
                             'o' -> 'о',
                             't' -> 'т',
                             'v' -> 'в',
                             'r' -> 'р',
                             'y' -> 'у',
                             'b' -> 'б',
                             'd' -> 'д'
                            )
      val replaced = text.map(char => immutableMap.getOrElse(char.toLower, char))

      println(replaced)
    } else if (choice == 3) {
      val text = "When executing the exercise extract all extra words"

      val regex = "\\bext\\w*".r

      val matches = regex.findAllIn(text).toList

      matches.foreach(println)
    } else if (choice == 4) {
      val text = "A big round ball fall to the ground"

      val words = text.split("\\s+")

      def replaceTheWithA(word: String): String = {
        if (word.toLowerCase == "the") {
          "a"
        } else {
          word
        }
      }

      val replacedText = words.map(replaceTheWithA).mkString(" ")

      println(replacedText)
    } else if (choice == 5) {
      val text = "A big round ball falls to the ground"

      val words = text.split("\\s+")

      val reversedWords = words.reverse

      val reversedText = reversedWords.mkString(" ")

      println(reversedText)
    } else if (choice == 6) {
      val text = "Hello to everybody"

      def removeVowels(input: String): String = {
        input.replaceAll("[aeiouAEIOU]", "")
      }

      val textWithoutVowels = removeVowels(text)

      println(textWithoutVowels)
    } else if (choice == 7) {
      val text = "Hello to everybody"

      def doubleLettersInWord(word: String): String = {
        word.flatMap(char => char.toString * 2)
      }

      val words = text.split("\\s+")
      val textWithDoubledLetters = words.map(doubleLettersInWord).mkString(" ")

      println(textWithDoubledLetters)
    } else if(choice == 8) {
      val text = "Hello to everybody"

      def removeLetterY(input: String): String = {
        input.replaceAll("y", "")
      }

      val textWithoutLetterY = removeLetterY(text)

      println(textWithoutLetterY)
    } else if(choice == 9) {
      val text = "Hello to everybody"
      val wordToInsert = "with heartness"

      val words = text.split("\\s+")

      val positionToInsert = 1
      val modifiedWords = words.patch(positionToInsert, Seq(wordToInsert), 0)

      val modifiedText = modifiedWords.mkString(" ")

      println(modifiedText)
    }

  }
}
