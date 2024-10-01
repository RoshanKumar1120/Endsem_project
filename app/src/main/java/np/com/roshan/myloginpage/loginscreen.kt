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
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import java.util.regex.Pattern





@Composable
fun loginscreen(navController: NavController) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "WelcomeScreen") {
        composable("registerscreen") { registerscreen() }
    }
    var emailOrPhone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var inputError by remember { mutableStateOf("") }

    // Context for displaying Toast
    val context = LocalContext.current

    // Regex for validating email
    val emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.supermarket),
            contentDescription = "Login Image",
            modifier = Modifier.size(100.dp)
        )

        Text(
            text = "WELCOME BACK",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Login to Your Account")

        // Input field for email or phone
        OutlinedTextField(
            value = emailOrPhone,
            onValueChange = {
                emailOrPhone = it
                inputError = if (!emailPattern.matcher(it).matches() && !it.matches(Regex("^\\d{10}\$"))) {
                    "Enter valid Email or Phone number"
                } else {
                    ""
                }
            },
            label = { Text(text = "Email or Phone Number") },
            isError = inputError.isNotEmpty()
        )
        if (inputError.isNotEmpty()) {
            Text(text = inputError, color = MaterialTheme.colorScheme.error)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Password field
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Login button in green
        Button(
            onClick = {
                if (inputError.isEmpty()) {
                    Log.i("Credential", "Email or Phone: $emailOrPhone, Password: $password")
                    Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Please fix the errors", Toast.LENGTH_SHORT).show()
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary) // Customize button color
        ) {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Forgot Password
        Text(
            text = "Forgot Password?",
            modifier = Modifier.clickable {
                // Handle Forgot Password here
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Create Account button or link
        Text(
            text = "Don't have an account? Create one",
            modifier = Modifier.clickable {
                navController.navigate("registerscreen")
            }
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Social login options
        Text(text = "Or Sign in With")

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(40.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(id = R.drawable.fb),
                contentDescription = "Facebook",
                modifier = Modifier
                    .size(48.dp) // Adjusted size for Facebook icon
                    .clickable {
                        // Handle Facebook login
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.mail),
                contentDescription = "Gmail",
                modifier = Modifier
                    .size(48.dp) // Adjusted size for Gmail icon
                    .clickable {
                        // Handle Gmail login
                    }
            )
        }
    }
}
