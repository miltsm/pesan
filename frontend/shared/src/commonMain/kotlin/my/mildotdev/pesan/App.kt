package my.mildotdev.pesan

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import my.mildotdev.pesan.login.Login
import my.mildotdev.pesan.login.LoginScreen
import my.mildotdev.pesan.sign_up.SignUp
import my.mildotdev.pesan.sign_up.SignUpScreen
import my.mildotdev.pesan.sign_up.SignUpViewModel
import my.mildotdev.pesan.splash.Splash
import my.mildotdev.pesan.splash.SplashScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        val modifier = Modifier
        NavHost(navController = navController, startDestination = Splash) {
            composable<Splash> { SplashScreen(modifier,
                { navController.navigate(Login) },
                { navController.navigate(SignUp) })
            }
            composable<Login> { LoginScreen(modifier) }
            composable<SignUp> {

                SignUpScreen(modifier,{ navController.navigateUp() })
            }
        }
    }
}