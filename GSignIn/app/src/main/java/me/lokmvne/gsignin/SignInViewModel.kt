package me.lokmvne.gsignin

import android.content.Context
import androidx.credentials.Credential
import androidx.credentials.CredentialManager

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignInViewModel(
    context: Context
) : ViewModel() {

    private val credentialManager = CredentialManager.create(context)
    val googleAuthUiClient by lazy {
        GoogleAuthUiClient(
            context = context,
        )
    }

    private val _res = MutableStateFlow(UserData("", "", "", ""))
    val res = _res.asStateFlow()

    fun viewSignIn(context: Context) {
        viewModelScope.launch {
            val res = googleAuthUiClient.signIn(credentialManager)
            if (res != null) {
                val userData = googleAuthUiClient.handleSignIn(res)
                _res.update { userData }
            }
        }
    }

}