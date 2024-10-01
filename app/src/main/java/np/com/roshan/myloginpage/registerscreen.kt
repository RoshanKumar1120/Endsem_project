package np.com.roshan.myloginpage

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.regex.Pattern

@Composable
fun registerscreen() {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

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
            painter = painterResource(id = R.drawable.regi),
            contentDescription = "Register Image",
            modifier = Modifier.size(100.dp)
        )

        Text(
            text = "CREATE ACCOUNT",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Full Name input field
        OutlinedTextField(
            value = fullName,
            onValueChange = { fullName = it },
            label = { Text(text = "Full Name") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Email input field
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                inputError = if (!emailPattern.matcher(it).matches()) {
                    "Enter a valid email"
                } else {
                    ""
                }
            },
            label = { Text(text = "Email") },
            isError = inputError.isNotEmpty()
        )
        if (inputError.isNotEmpty()) {
            Text(text = inputError, color = MaterialTheme.colorScheme.error)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Phone Number input field
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = {
                phoneNumber = it
                inputError = if (!it.matches(Regex("^\\d{10}\$"))) {
                    "Enter a valid phone number"
                } else {
                    ""
                }
            },
            label = { Text(text = "Phone Number") },
            isError = inputError.isNotEmpty()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password input field
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Confirm Password input field
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text(text = "Confirm Password") },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Register button
        Button(onClick = {
            if (inputError.isEmpty() && password == confirmPassword) {
                Log.i("Register", "Full Name: $fullName, Email: $email, Phone: $phoneNumber, Password: $password")
                Toast.makeText(context, "Registration Successful", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(context, "Passwords do not match", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Please fix the errors", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text(text = "Register")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Already have an account? Sign In
        Text(
            text = "Already have an account? Sign In",
            modifier = Modifier.clickable {
                // Handle Sign In navigation
                Toast.makeText(context, "Navigating to Login", Toast.LENGTH_SHORT).show()
            }
        )
    }
}
