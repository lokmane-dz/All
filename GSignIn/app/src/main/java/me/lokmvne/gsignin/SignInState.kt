package me.lokmvne.gsignin

data class SignInState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null
)