package ru.mozgolom112.electronicqueue.features.screen.authorization

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.mozgolom112.electronicqueue.R
import ru.mozgolom112.electronicqueue.features.component.EQEntryLogoImage
import ru.mozgolom112.electronicqueue.features.component.EQPasswordTextField
import ru.mozgolom112.electronicqueue.features.component.EQUsernameTextField

@Composable
fun AuthorizationScreen(viewModel: AuthorizationViewModel = viewModel()) {
    val state by viewModel.authorizationState.collectAsState()

    val username by remember { derivedStateOf { state.username } }
    val password by remember { derivedStateOf { state.password } }
    val isLoading by remember { derivedStateOf { state.isLoading } }
    val isPasswordVisible by remember { derivedStateOf { state.isPasswordVisible } }
    val errorMessage by remember { derivedStateOf { state.errorMessage } }

    Content(
        username = username,
        password = password,
        isLoading = isLoading,
        isPasswordVisible = isPasswordVisible,
        errorMessage = errorMessage,
        onUsernameChange = { viewModel.onUsernameChange(it) },
        onPasswordChange = { viewModel.onPasswordChange(it) },
        onShowPasswordClick = { viewModel.onShowPasswordClick() },
        onLoginClick = { viewModel.onLoginClick() },
        onRegistrationClick = { viewModel.onRegistrationClick() }
    )
}

@Composable
private fun Content(
    username: String,
    password: String,
    isLoading: Boolean,
    isPasswordVisible: Boolean,
    errorMessage: String,
    onUsernameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onShowPasswordClick: () -> Unit,
    onLoginClick: () -> Unit,
    onRegistrationClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(32.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        EQEntryLogoImage()
        Spacer(modifier = Modifier.height(32.dp))
        EQUsernameTextField(name = username, onNameChange = onUsernameChange)
        Spacer(modifier = Modifier.height(8.dp))
        EQPasswordTextField(
            password = password,
            onPasswordChange = onPasswordChange,
            isPasswordVisible = isPasswordVisible,
            onShowPasswordClick = onShowPasswordClick
        )
        Spacer(modifier = Modifier.height(8.dp))

        Column(
            modifier = Modifier
                .width(150.dp)
        ) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onLoginClick
            ) {
                Text(stringResource(R.string.login))
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onRegistrationClick
            ) {
                Text(stringResource(R.string.registration))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AuthorizationScreenPreview() {
    AuthorizationScreen()
}