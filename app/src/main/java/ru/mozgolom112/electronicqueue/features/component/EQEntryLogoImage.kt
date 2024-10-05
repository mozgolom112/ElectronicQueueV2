package ru.mozgolom112.electronicqueue.features.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.mozgolom112.electronicqueue.R

@Composable
fun EQEntryLogoImage(
    modifier: Modifier = Modifier
) {
    // Изображение логотипа
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "App Logo",
        modifier = modifier.size(120.dp)
            .background(color = Color.DarkGray), // Размер логотипа
        contentScale = ContentScale.Fit
    )
}

@Preview(showBackground = true)
@Composable
fun EQEntryLogoImagePreview(){
    EQEntryLogoImage()
}