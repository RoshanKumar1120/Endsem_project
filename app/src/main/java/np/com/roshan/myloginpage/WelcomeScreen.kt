package np.com.roshan.myloginpage
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedTextField

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button


import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.widget.Toast
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import java.util.regex.Pattern

//
//@Composable
//fun WelcomeScreen() {
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = "WelcomeScreen") {
//        composable("WelcomeScreen"){ WelcomeScreen(navController) }
//        composable("signup") { loginscreen(navController) }
//        composable("register") { registerscreen() }
//
//    }
//}

@Composable

fun WelcomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Image in the middle
        Image(
            painter = painterResource(id = R.drawable.twitter), // Replace with your image resource
            contentDescription = "Welcome Image",
            modifier = Modifier.size(150.dp) // Adjust size as needed
        )

        Spacer(modifier = Modifier.height(24.dp)) // Space between image and text

        // Text below the image
        Text(
            text = "Welcome to Our App! Get Started by Signing Up or Registering.",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp) // Padding for the text
        )

        Spacer(modifier = Modifier.height(32.dp)) // Space between text and buttons

        // Sign Up Button
        Button(
            onClick = {
             //   navController.navigate("signup") // Navigate to Sign Up screen
            },
            modifier = Modifier.fillMaxWidth() // Button fills the width
        ) {
            Text(text = "Sign Up")
        }

        Spacer(modifier = Modifier.height(16.dp)) // Space between buttons

        // Register Button
        Button(
            onClick = {

              //  navController.navigate("register") // Navigate to Register screen
            },
            modifier = Modifier.fillMaxWidth() // Button fills the width
        ) {
            Text(text = "Register")
        }
    }
}
