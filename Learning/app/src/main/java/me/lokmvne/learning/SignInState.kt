package me.lokmvne.learning

data class SignInState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null
)