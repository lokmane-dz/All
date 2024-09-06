package me.lokmvne.common_ui.components.auth

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun AppTextField_1(
    value: String,
    onValueChange: (String) -> Unit,
    iconModifier: Modifier = Modifier,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    trailingIcon: ImageVector,
    keyboardActions: KeyboardActions = KeyboardActions(),
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.width(300.dp),
        placeholder = { Text(text = placeholder) },
        readOnly = false,
        enabled = true,
        singleLine = true,
        trailingIcon = {
            Icon(
                imageVector = trailingIcon,
                contentDescription = placeholder,
                modifier = iconModifier
            )
        },
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation,
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.colors(
            cursorColor = MaterialTheme.colorScheme.onPrimary,

            focusedContainerColor = MaterialTheme.colorScheme.primary,
            focusedTextColor = MaterialTheme.colorScheme.onPrimary,
            focusedLeadingIconColor = MaterialTheme.colorScheme.onPrimary,
            focusedTrailingIconColor = MaterialTheme.colorScheme.onPrimary,
            focusedLabelColor = MaterialTheme.colorScheme.onPrimary,
            focusedPlaceholderColor = MaterialTheme.colorScheme.onPrimary,
            focusedIndicatorColor = Color.Transparent,
            focusedPrefixColor = Color.Black,
            focusedSuffixColor = Color.Red,
            focusedSupportingTextColor = MaterialTheme.colorScheme.primary,

            unfocusedTextColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.6f),
            unfocusedContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.6f),
            unfocusedLeadingIconColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.6f),
            unfocusedTrailingIconColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.6f),
            unfocusedLabelColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.6f),
            unfocusedPlaceholderColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.6f),
            unfocusedIndicatorColor = Color.Transparent,
            unfocusedPrefixColor = Color.Black,
            unfocusedSuffixColor = Color.Black,
            unfocusedSupportingTextColor = MaterialTheme.colorScheme.primary,

            disabledTextColor = MaterialTheme.colorScheme.secondary,
            disabledContainerColor = Color.LightGray,
            disabledLeadingIconColor = Color.Gray,
            disabledTrailingIconColor = Color.LightGray,
            disabledLabelColor = Color.LightGray,
            disabledPlaceholderColor = Color.LightGray,
            disabledIndicatorColor = Color.Transparent,
            disabledPrefixColor = Color.Black,
            disabledSuffixColor = Color.Black,
            disabledSupportingTextColor = Color.Gray,

            errorTextColor = MaterialTheme.colorScheme.error,
            errorContainerColor = MaterialTheme.colorScheme.primary,
            errorCursorColor = MaterialTheme.colorScheme.error,
            errorLeadingIconColor = MaterialTheme.colorScheme.error,
            errorTrailingIconColor = MaterialTheme.colorScheme.error,
            errorLabelColor = MaterialTheme.colorScheme.error,
            errorPlaceholderColor = MaterialTheme.colorScheme.error,
            errorIndicatorColor = Color.Transparent,
            errorPrefixColor = MaterialTheme.colorScheme.error,
            errorSuffixColor = MaterialTheme.colorScheme.error,
            errorSupportingTextColor = MaterialTheme.colorScheme.error,

            selectionColors = TextSelectionColors(
                handleColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.6f),
                backgroundColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.6f),
            ),
        )
    )
}


@Composable
fun MyButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
        .width(150.dp)
        .height(48.dp),
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = true,
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContentColor = Color.Gray,
            disabledContainerColor = Color.LightGray,
        )
    ) {
        Text(text = text)
    }
}