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
//      val text = "Hello to everybody"
//      val immutableMap = Map('H' -> 'Н',
//                             'e' -> 'е',
//                             'l' -> 'л',
//                             'o' -> 'о',
//                             't' -> 'т',
//                             'v' -> 'в',
//                             'r' -> 'р',
//                             'y' -> 'у',
//                             'b' -> 'б',
//                             'd' -> 'д'
//                            )
//      val replaced = text.map(char => immutableMap.getOrElse(char.toLower, char))
//
//      println(replaced)

      val text = "Hello to everybody"

      val latinRegex = new Regex("[a-zA-Z]")

      def replaceLatinWithRussian(matched: Regex.Match): String = {
        val latinChar = matched.group(0)
        val russianChar = latinChar match {
          case "H" => "Н"
          case "e" => "е"
          case "l" => "л"
          case "o" => "о"
          case "t" => "т"
          case "v" => "в"
          case "y" => "у"
          case "b" => "б"
          case _ => latinChar
        }
        russianChar
      }

      val result = latinRegex.replaceAllIn(text, replaceLatinWithRussian _)

      println(result)

    } else if (choice == 3) {
      val text = "When executing the exercise extract all extra words"

      val regex = "\\bext\\w*".r

      val matches = regex.findAllIn(text).toList

      matches.foreach(println)
    } else if (choice == 4) {
//      val text = "A big round ball fall to the ground"
//      val words = text.split("\\s+")
//
//      def replaceTheWithA(word: String): String = {
//        if (word.toLowerCase == "the") {
//          "a"
//        } else {
//          word
//        }
//      }
//
//      val replacedText = words.map(replaceTheWithA).mkString(" ")
//
//      println(replacedText)
      val text = "A big round ball fall to the ground"

      val regex = "\\bthe\\b".r

      val result = regex.replaceAllIn(text, _ => "a")

      println(result)
    } else if (choice == 5) {
      val text = "A big round ball falls to the ground"

      val words = text.split("\\s+")

      val reversedWords = words.reverse

      val reversedText = reversedWords.mkString(" ")

      println(reversedText)
    } else if (choice == 6) {
      val text = "Hello to everybody"

      def removeVowels(input: String): String = {
        input.replaceAll("[aeiouAEIOUаеёиоуыэюяАЕЁИОУЫЭЮЯ]", "")
      }

      val textWithoutVowels = removeVowels(text)

      println(textWithoutVowels)
    } else if (choice == 7) {
//      val text = "Hello to everybody"
//
//      def doubleLettersInWord(word: String): String = {
//        word.flatMap(char => char.toString * 2)
//      }
//
//      val words = text.split("\\s+")
//      val textWithDoubledLetters = words.map(doubleLettersInWord).mkString(" ")
//
//      println(textWithDoubledLetters)
      val text = "Hello to everybody"

      val regex = "\\w".r

      def doubleLetter(matched: Regex.Match): String = {
        val letter = matched.group(0)
        letter + letter
      }

      val result = regex.replaceAllIn(text, doubleLetter _)

      println(result)
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
    } else if(choice == 10) {
      val text = "Hello to everybody"
      val pattern = new Regex("\\b\\w")
      val modifiedString = pattern.replaceAllIn(text, m => m.matched * 3)

      print(modifiedString)

    } else if(choice == 11) {
      val inputString = "Hello to everybody"
      val outputString = inputString.replaceAll("\\s+", "")

      println(outputString)

    }


  }
}

object RegexExample extends App {
  // Исходный текст
  val text = "This is a sample text with some words to extract."

  // Регулярное выражение для поиска слов
  val regex = "\\b\\w+\\b".r

  // Находим все совпадения в тексте
  val words = regex.findAllIn(text).toList

  // Выводим найденные слова
  words.foreach(println)
}


// предложение
// каждое слово в предложении первую букву утроить