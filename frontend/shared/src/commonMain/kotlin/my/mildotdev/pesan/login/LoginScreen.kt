package my.mildotdev.pesan.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SecureTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.stringResource
import pesan.frontend.shared.generated.resources.Res
import pesan.frontend.shared.generated.resources.password_label
import pesan.frontend.shared.generated.resources.sign_in_w_passkey
import pesan.frontend.shared.generated.resources.sign_in_w_password
import pesan.frontend.shared.generated.resources.username_label

@Serializable
object Login

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun LoginScreen(modifier: Modifier) {
    MaterialTheme {
        Column(modifier = modifier
            .background(MaterialTheme.colorScheme.primaryContainer)
            .safeContentPadding()
            .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier.weight(1f))
            TextField(label = {
                Text(stringResource(Res.string.username_label))
            }, value = "", onValueChange = {})
            SecureTextField(
                state = TextFieldState(),
                label = {
                Text(stringResource(Res.string.password_label))
            })
            OutlinedButton(onClick = {}) {
                Text(stringResource(Res.string.sign_in_w_password))
            }
            Text("or")
            Button(content = {
                Text(stringResource(Res.string.sign_in_w_passkey))
            }, onClick = {})
            Spacer(modifier.weight(1f))
        }
    }
}

@Composable
@Preview
fun PreviewLoginScreen() {
    LoginScreen(Modifier)
}