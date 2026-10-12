package com.example.a25172012060_p5.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a25172012060_p5.R
import com.example.a25172012060_p5.ui.theme.DarkBorder
import com.example.a25172012060_p5.ui.theme.DarkButtonBg
import com.example.a25172012060_p5.ui.theme.DarkButtonText
import com.example.a25172012060_p5.ui.theme.DarkCardBg
import com.example.a25172012060_p5.ui.theme.DarkInputText
import com.example.a25172012060_p5.ui.theme.DarkLabel
import com.example.a25172012060_p5.ui.theme.DarkPlaceholder
import com.example.a25172012060_p5.ui.theme.DarkScreenBg
import com.example.a25172012060_p5.ui.theme.GuniPink
import com.example.a25172012060_p5.ui.theme.LightBorder
import com.example.a25172012060_p5.ui.theme.LightButtonBg
import com.example.a25172012060_p5.ui.theme.LightButtonText
import com.example.a25172012060_p5.ui.theme.LightCardBg
import com.example.a25172012060_p5.ui.theme.LightInputText
import com.example.a25172012060_p5.ui.theme.LightLabel
import com.example.a25172012060_p5.ui.theme.LightPlaceholder
import com.example.a25172012060_p5.ui.theme.LightScreenBg

@Composable
fun RegisterScreen(
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit,
    onNavigateToLogin: () -> Unit,
    onRegisterSuccess: (name: String, email: String) -> Unit
) {
    val context = LocalContext.current

    var name by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    val screenBg = if (isDarkTheme) DarkScreenBg else LightScreenBg
    val cardBg = if (isDarkTheme) DarkCardBg else LightCardBg
    val labelColor = if (isDarkTheme) DarkLabel else LightLabel
    val placeholderColor = if (isDarkTheme) DarkPlaceholder else LightPlaceholder
    val inputTextColor = if (isDarkTheme) DarkInputText else LightInputText
    val borderColor = if (isDarkTheme) DarkBorder else LightBorder
    val buttonBg = if (isDarkTheme) DarkButtonBg else LightButtonBg
    val buttonTextColor = if (isDarkTheme) DarkButtonText else LightButtonText
    val bottomTextColor = if (isDarkTheme) Color(0xFFD2D8E4) else Color(0xFF2C3242)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(screenBg)
    ) {
        // Theme toggle button at top right
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 36.dp, end = 16.dp),
            contentAlignment = Alignment.TopEnd
        ) {
            IconButton(onClick = onToggleTheme) {
                Icon(
                    imageVector = if (isDarkTheme) Icons.Default.LightMode else Icons.Default.DarkMode,
                    contentDescription = "Toggle Theme",
                    tint = if (isDarkTheme) Color.White else Color(0xFF2C3242)
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // GUNI Pink Logo
            Image(
                painter = painterResource(id = R.drawable.guni_pink_logo),
                contentDescription = "GUNI Logo",
                modifier = Modifier
                    .fillMaxWidth(0.65f)
                    .height(60.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Main Card Container
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = cardBg),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp, vertical = 20.dp)
                ) {
                    // Row 1: Name
                    FormRow(
                        label = "Name",
                        value = name,
                        placeholder = "Enter Name",
                        onValueChange = { name = it },
                        keyboardType = KeyboardType.Text,
                        labelColor = labelColor,
                        placeholderColor = placeholderColor,
                        inputTextColor = inputTextColor,
                        borderColor = borderColor,
                        activeColor = if (isDarkTheme) Color.White else buttonBg
                    )

                    // Row 2: Phone Number
                    FormRow(
                        label = "Phone Number",
                        value = phoneNumber,
                        placeholder = "Enter Phone Number",
                        onValueChange = { phoneNumber = it },
                        keyboardType = KeyboardType.Phone,
                        labelColor = labelColor,
                        placeholderColor = placeholderColor,
                        inputTextColor = inputTextColor,
                        borderColor = borderColor,
                        activeColor = if (isDarkTheme) Color.White else buttonBg
                    )

                    // Row 3: City
                    FormRow(
                        label = "City",
                        value = city,
                        placeholder = "Enter City",
                        onValueChange = { city = it },
                        keyboardType = KeyboardType.Text,
                        labelColor = labelColor,
                        placeholderColor = placeholderColor,
                        inputTextColor = inputTextColor,
                        borderColor = borderColor,
                        activeColor = if (isDarkTheme) Color.White else buttonBg
                    )

                    // Row 4: Email
                    FormRow(
                        label = "Email",
                        value = email,
                        placeholder = "Enter Email",
                        onValueChange = { email = it },
                        keyboardType = KeyboardType.Email,
                        labelColor = labelColor,
                        placeholderColor = placeholderColor,
                        inputTextColor = inputTextColor,
                        borderColor = borderColor,
                        activeColor = if (isDarkTheme) Color.White else buttonBg
                    )

                    // Row 5: Password
                    FormRow(
                        label = "Password",
                        value = password,
                        placeholder = "Enter Password",
                        onValueChange = { password = it },
                        isPassword = true,
                        keyboardType = KeyboardType.Password,
                        labelColor = labelColor,
                        placeholderColor = placeholderColor,
                        inputTextColor = inputTextColor,
                        borderColor = borderColor,
                        activeColor = if (isDarkTheme) Color.White else buttonBg
                    )

                    // Row 6: Confirm Password
                    FormRow(
                        label = "Confirm\nPassword",
                        value = confirmPassword,
                        placeholder = "Enter Confirm Password",
                        onValueChange = { confirmPassword = it },
                        isPassword = true,
                        keyboardType = KeyboardType.Password,
                        labelColor = labelColor,
                        placeholderColor = placeholderColor,
                        inputTextColor = inputTextColor,
                        borderColor = borderColor,
                        activeColor = if (isDarkTheme) Color.White else buttonBg
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    // Register Button
                    Button(
                        onClick = {
                            if (name.trim().isEmpty() || email.trim().isEmpty() || password.isEmpty()) {
                                Toast.makeText(context, "Please complete all required fields", Toast.LENGTH_SHORT).show()
                            } else if (password != confirmPassword) {
                                Toast.makeText(context, "Passwords do not match", Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(context, "Registration Successful!", Toast.LENGTH_SHORT).show()
                                onRegisterSuccess(name, email)
                            }
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = buttonBg),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(46.dp)
                    ) {
                        Text(
                            text = "Register",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = buttonTextColor
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Bottom Switch Row
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Do you have an account? ",
                    fontSize = 13.sp,
                    color = bottomTextColor
                )
                TextButton(onClick = onNavigateToLogin) {
                    Text(
                        text = "LOGIN",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = GuniPink
                    )
                }
            }
        }
    }
}

@Composable
private fun FormRow(
    label: String,
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    isPassword: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    labelColor: Color,
    placeholderColor: Color,
    inputTextColor: Color,
    borderColor: Color,
    activeColor: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = TextStyle(
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                color = labelColor,
                lineHeight = 16.sp
            ),
            modifier = Modifier.width(95.dp)
        )

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(
                    text = placeholder,
                    fontSize = 12.sp,
                    color = placeholderColor
                )
            },
            singleLine = true,
            visualTransformation = if (isPassword) PasswordVisualTransformation() else androidx.compose.ui.text.input.VisualTransformation.None,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            shape = RoundedCornerShape(8.dp),
            textStyle = TextStyle(fontSize = 13.sp, color = inputTextColor),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = activeColor,
                unfocusedBorderColor = borderColor,
                focusedTextColor = inputTextColor,
                unfocusedTextColor = inputTextColor,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            ),
            modifier = Modifier
                .weight(1f)
                .height(50.dp)
        )
    }
}
