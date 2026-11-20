package com.example.ktlab3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ktlab3.ui.theme.KtLab3Theme

private enum class Screen(@StringRes val titleRes: Int) {
    MENU(R.string.menu_title),
    ARTICLE(R.string.menu_article),
    TASK(R.string.menu_task),
    QUADRANT(R.string.menu_quadrant),
    INFO(R.string.menu_info)
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KtLab3Theme(dynamicColor = false) {
                App()
            }
        }
    }
}

@Composable
private fun App() {
    var screen by rememberSaveable { mutableStateOf(Screen.MENU) }
    BackHandler(enabled = screen != Screen.MENU) { screen = Screen.MENU }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color.Transparent
        ) { padding ->
            val content = Modifier.padding(padding)
            when (screen) {
                Screen.MENU -> Menu(content) { screen = it }
                Screen.ARTICLE -> ArticleScreen(content)
                Screen.TASK -> TaskManagerScreen(content)
                Screen.QUADRANT -> QuadrantScreen(content)
                Screen.INFO -> InfoScreen(content)
            }
        }
    }
}

@Composable
private fun Menu(modifier: Modifier, onSelect: (Screen) -> Unit) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(Screen.MENU.titleRes),
            style = MaterialTheme.typography.headlineSmall
        )
        Screen.entries.filter { it != Screen.MENU }.forEach { target ->
            Button(onClick = { onSelect(target) }, modifier = Modifier.fillMaxWidth()) {
                Text(stringResource(target.titleRes))
            }
        }
    }
}
