package me.cyberdie22.clipc

class Lexer(val code: String) {
    fun lex(): List<Token> {
        val tokens = mutableListOf<Token>()

        for (i in 1..codeArray.size) {
            println("a")
            val token = getNextToken()
            if (token != null) tokens += token
            else throw RuntimeException("No or invalid token")
        }

        return tokens
    }

    var codeArray: CharArray = code.toCharArray()
    var column = 0
    var line = 0
    var position = -1
    var currentChar = ' '

    var inFunction = false
    var inClass = false
    var inFunctionCall = false
    var inVariableDeclaration = false

    fun nextChar(): Char? {
        position++
        println("Getting next char; Pos = $position")
        currentChar = codeArray[position]
        return currentChar
    }

    fun peekNextChar(): Char {
        return codeArray[position + 1]
    }

    fun getNextToken(): Token? {
        var operation = ""
        when (nextChar()) {
            in arrayOf<Char>('+', '-', '*', '/', '%', '=', '{', '}') -> {
                println("Finding operator")
                return Token(Tokens.fromString(currentChar.toString()), null)
            }
            in arrayOf<Char>('0', '1', '2', '3', '4', '5', '6', '7', '8', '9') -> {
                println("Finding number")
                // TODO: Find number
            }
            else -> {
                val string = findString()
                if (isStringKeyword(string)) {
                    println("Finding keyword")
                    return when (string) {
                        "{" -> {
                            if (inFunction) return Token(Tokens.OPERATOR_BEGIN_FUNCTION, null)
                            else throw InvalidTokenException(string)
                        }
                        "}" -> {
                            if (inFunction) {
                                inFunction = false
                                return Token(Tokens.OPERATOR_END_FUNCTION, null)
                            } else throw InvalidTokenException(string)
                        }
                        "fun" -> {
                            inFunction = true
                            Token(Tokens.KEYWORD_FUN, null)
                        }
                        "var" -> {
                            inVariableDeclaration = true
                            Token(Tokens.KEYWORD_VAR, null)
                        }
                        else -> {
                            Token(Tokens.TYPE_STRING, string)
                        }
                    }
                } else return Token(Tokens.TYPE_STRING, string)
            }
        }
        println("Returning null")
        return null
    }

    fun isStringKeyword(string: String): Boolean {
        return string in arrayOf("fun", "var")
    }

    fun findString(): String {
        var string = ""
        while (currentChar !in " \n\t\r") {
            string += currentChar
        }
        return string
    }

}