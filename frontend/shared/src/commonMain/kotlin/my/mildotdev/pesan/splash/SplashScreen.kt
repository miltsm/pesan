package my.mildotdev.pesan.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.serialization.Serializable

@Serializable
object Splash

@Composable
fun SplashScreen(
    modifier: Modifier,
    navigateLogin: () -> Unit,
    navigateSignUp: () -> Unit
)  {
    MaterialTheme {
        Column(modifier = modifier
            .background(MaterialTheme.colorScheme.primaryContainer)
            .safeContentPadding()
            .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier.weight(1f))
            Button(onClick = navigateLogin, content = {
                Text("Sign in")
            })
            OutlinedButton(onClick = navigateSignUp, content = {
                Text("Sign up")
            })
            Spacer(modifier.weight(1f))
        }
    }
}

@Composable
@Preview
fun PreviewSplashScreen() {
    SplashScreen(Modifier, {}, {})
}