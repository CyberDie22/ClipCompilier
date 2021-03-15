package me.cyberdie22.clipc

data class Token(val token: Tokens, val value: Any?) {
    override fun toString(): String {
        return "Token{token:$token, value:$value}"
    }
}
