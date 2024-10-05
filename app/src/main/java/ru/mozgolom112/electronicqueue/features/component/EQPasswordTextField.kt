package ru.mozgolom112.electronicqueue.features.component

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import ru.mozgolom112.electronicqueue.R

@Composable
fun EQPasswordTextField(
    modifier: Modifier = Modifier,
    password: String,
    onPasswordChange: (String) -> Unit,
    isPasswordVisible: Boolean,
    onShowPasswordClick: () -> Unit,
) {
    OutlinedTextField(
        modifier = modifier,
        value = password,
        label = { Text(stringResource(R.string.password)) },
        visualTransformation = if (isPasswordVisible)
            VisualTransformation.None
        else
            PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        onValueChange = { onPasswordChange(it) },
        singleLine = true,
        trailingIcon = {
            IconButton(onClick = {
                onShowPasswordClick()
            }) {
                Icon(
                    imageVector = if (isPasswordVisible)
                        Icons.Filled.Visibility
                    else
                        Icons.Filled.VisibilityOff,
                    contentDescription = "Password Visibility"
                )
            }
        },
    )
}