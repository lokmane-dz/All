package me.lokmvne.mylearning

data class SignInState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null
)