package ru.mozgolom112.electronicqueue.features.component

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import ru.mozgolom112.electronicqueue.R

@Composable
fun EQUsernameTextField(
    modifier: Modifier = Modifier,
    name: String,
    onNameChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
        value = name,
        singleLine = true,
        label = { Text(stringResource(R.string.name)) },
        onValueChange = onNameChange
    )
}