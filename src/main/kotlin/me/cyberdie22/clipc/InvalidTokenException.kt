package me.cyberdie22.clipc

class InvalidTokenException(token: String): Exception("Invalid Token: $token") {
}