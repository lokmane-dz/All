package me.lokmvne.gsignin

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.GetCredentialResponse
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException
import kotlin.coroutines.cancellation.CancellationException

class GoogleAuthUiClient(
    private val context: Context,
) {
    suspend fun signIn(credentialManager: CredentialManager): GetCredentialResponse? {
        return try {
            val result = credentialManager.getCredential(
                request = buildSignInRequest(),
                context = context
            )
            result
        } catch (e: Exception) {
            e.printStackTrace()
            if (e is CancellationException) throw e
            null
        }
    }

    fun handleSignIn(result: GetCredentialResponse): UserData {
        val credential = result.credential
        when (credential) {
            is CustomCredential -> {
                if (credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
                    try {
                        val googleIdTokenCredential = GoogleIdTokenCredential
                            .createFrom(credential.data)
                        return UserData(
                            userId = googleIdTokenCredential.id,
                            name = googleIdTokenCredential.givenName,
                            phone = googleIdTokenCredential.phoneNumber.toString(),
                            profilePictureUrl = googleIdTokenCredential.profilePictureUri.toString()
                        )
                    } catch (e: GoogleIdTokenParsingException) {
                        Log.e(TAG, "Received an invalid google id token response", e)
                        return UserData(
                            userId = "error",
                            name = "error",
                            phone = "error",
                            profilePictureUrl = "error"
                        )
                    }
                } else {
                    Log.e(TAG, "Unexpected type of credential")
                    return UserData(
                        userId = "error",
                        name = "error",
                        phone = "error",
                        profilePictureUrl = "error"
                    )
                }
            }

            else -> {
                Log.e(TAG, "Unexpected type of credential")
            }
        }
        return UserData(
            userId = "error",
            name = "error",
            phone = "error",
            profilePictureUrl = "error"
        )
    }


    private fun buildSignInRequest(): GetCredentialRequest {
        return GetCredentialRequest.Builder()
            .addCredentialOption(
                GetGoogleIdOption.Builder()
                    .setFilterByAuthorizedAccounts(false)
                    .setServerClientId("1072558585099-7ou60mjjo0nc7lfovt8vpisb9onrnvtv.apps.googleusercontent.com")
                    .setAutoSelectEnabled(true)
                    .build()
            )
            .build()
    }
}