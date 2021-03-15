package me.cyberdie22.clipc

enum class Tokens {

    // Keywords
    KEYWORD_FUN,    // Function declaration
    KEYWORD_VAR,    // Directly mutable variable declaration
    KEYWORD_TYPE,   // Type keyword

    // Operators
    OPERATOR_ASSIGN,            // Assigning operator
    OPERATOR_PLUS,              // Addition operator
    OPERATOR_MINUS,             // Subtraction operator
    OPERATOR_TIMES,             // Multiplication operator
    OPERATOR_DIVIDE,            // Division operator
    OPERATOR_MODULO,            // Modulus operator
    OPERATOR_BEGIN_FUNCTION,    // Function beginning operator
    OPERATOR_END_FUNCTION,      // Function ending operator
    OPERATOR_TYPE_DECLARATION,  // Explicit type declaration
    OPERATOR_PARAMETER_BEGIN,   // Parameter start
    OPERATOR_PARAMETER_END,     // Parameter end

    // Primitives
    PRIMITIVE_INT,          // Integer primitive
    PRIMITIVE_FLOAT,        // Float primitive
    PRIMITIVE_CHARACTER,    // Char primitive

    // Types
    TYPE_STRING,    // String type

    // Identifiers
    IDENTIFIER_FUNCTION_NAME,   // Function name identifier
    IDENTIFIER_VARIABLE_NAME    // Variable name identifier

    ;
    companion object {
        fun fromString(string: String): Tokens {
            return when (string) {
                "+" -> OPERATOR_PLUS
                "-" -> OPERATOR_MINUS
                "*" -> OPERATOR_TIMES
                "/" -> OPERATOR_DIVIDE
                "%" -> OPERATOR_MODULO
                "=" -> OPERATOR_ASSIGN
                "{" -> OPERATOR_BEGIN_FUNCTION
                "}" -> OPERATOR_END_FUNCTION
                "fun" -> KEYWORD_FUN
                "var" -> KEYWORD_VAR
                else -> throw InvalidTokenException(string)
            }
        }
    }
}