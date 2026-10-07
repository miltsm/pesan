package my.mildotdev.pesan.sign_up

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import pesan.frontend.shared.generated.resources.Res
import pesan.frontend.shared.generated.resources.alt_sign_up
import pesan.frontend.shared.generated.resources.baseline_arrow_back_24
import pesan.frontend.shared.generated.resources.how_passkeys_work
import pesan.frontend.shared.generated.resources.name
import pesan.frontend.shared.generated.resources.sign_up
import pesan.frontend.shared.generated.resources.signing_in
import pesan.frontend.shared.generated.resources.username_label
import pesan.frontend.shared.generated.resources.why_passkey

@Serializable
object SignUp

@Composable
fun SignUpScreen(modifier: Modifier, navigateBack: () -> Unit, vm: SignUpViewModel = viewModel()) {
    val uiState by vm.uiState.collectAsStateWithLifecycle()
    Scaffold(
        topBar = {
            LargeTopAppBar(title = {
                Text(stringResource(Res.string.sign_up))
            }, navigationIcon = {
                IconButton(navigateBack) {
                    Icon(
                        painterResource(Res.drawable.baseline_arrow_back_24),
                        contentDescription = ""
                    )
                }
            })
        }
    ) { innerPadding ->
        Column(modifier = modifier
            .padding(innerPadding)
            .padding(16.dp)
            .safeContentPadding()
            .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            TextField(
                value = uiState.name,
                onValueChange = { vm.updateName(it) },
                modifier =  modifier.defaultMinSize(minWidth = Dp.Infinity),
                label = {
                Text(stringResource(Res.string.name))
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next)
            )
            TextField(
                value = uiState.username,
                onValueChange = { vm.updateUsername(it) },
                modifier = modifier.defaultMinSize(Dp.Infinity),
                label = {
                    Text(stringResource(Res.string.username_label))
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done
                )
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Spacer(modifier.height(16.dp))
                Text(
                    stringResource(Res.string.signing_in),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyMedium
                )
                Card {
                    Column(modifier = modifier.padding(16.dp)) {
                        Text(buildAnnotatedString {
                            append(stringResource(Res.string.why_passkey))
                            append(" ")
                            withLink(
                                LinkAnnotation.Url("https://google.com", TextLinkStyles(style = SpanStyle(fontWeight = FontWeight.Bold)))
                            ) {
                                append(stringResource(Res.string.how_passkeys_work))
                            }
                        }, style = MaterialTheme.typography.bodySmall)
                        Spacer(modifier.height(16.dp))
                        TextButton(onClick = {}) {
                            Text(stringResource(Res.string.alt_sign_up))
                        }
                    }
                }
            }
            Button(
                onClick = {},
                modifier = modifier.defaultMinSize(minWidth = Dp.Infinity)) {
                Text(stringResource(Res.string.sign_up))
            }
        }
    }
}

@Composable
@Preview
fun PreviewSignUpScreen() {
    SignUpScreen(Modifier, {})
}