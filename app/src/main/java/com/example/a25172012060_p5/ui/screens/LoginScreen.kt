package com.example.a25172012060_p5.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.ui.text.style.TextAlign
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
fun LoginScreen(
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit,
    onNavigateToRegister: () -> Unit,
    onLoginSuccess: (name: String, email: String) -> Unit
) {
    val context = LocalContext.current

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Color definitions based on current theme mode
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
                    .height(64.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(36.dp))

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
                        .padding(horizontal = 18.dp, vertical = 24.dp)
                ) {
                    // Row 1: Email
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Email",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                                color = labelColor
                            ),
                            modifier = Modifier.width(95.dp)
                        )

                        OutlinedTextField(
                            value = email,
                            onValueChange = { email = it },
                            placeholder = {
                                Text(
                                    text = "Enter Email",
                                    fontSize = 13.sp,
                                    color = placeholderColor
                                )
                            },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                            shape = RoundedCornerShape(8.dp),
                            textStyle = TextStyle(fontSize = 14.sp, color = inputTextColor),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = if (isDarkTheme) Color.White else buttonBg,
                                unfocusedBorderColor = borderColor,
                                focusedTextColor = inputTextColor,
                                unfocusedTextColor = inputTextColor,
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent
                            ),
                            modifier = Modifier
                                .weight(1f)
                                .height(52.dp)
                        )
                    }

                    // Row 2: Password
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Password",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                                color = labelColor
                            ),
                            modifier = Modifier.width(95.dp)
                        )

                        OutlinedTextField(
                            value = password,
                            onValueChange = { password = it },
                            placeholder = {
                                Text(
                                    text = "Enter Password",
                                    fontSize = 13.sp,
                                    color = placeholderColor
                                )
                            },
                            singleLine = true,
                            visualTransformation = PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            shape = RoundedCornerShape(8.dp),
                            textStyle = TextStyle(fontSize = 14.sp, color = inputTextColor),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = if (isDarkTheme) Color.White else buttonBg,
                                unfocusedBorderColor = borderColor,
                                focusedTextColor = inputTextColor,
                                unfocusedTextColor = inputTextColor,
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent
                            ),
                            modifier = Modifier
                                .weight(1f)
                                .height(52.dp)
                        )
                    }

                    // Forgot Password?
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 4.dp, bottom = 16.dp),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        Text(
                            text = "Forgot Password?",
                            fontSize = 12.sp,
                            color = labelColor,
                            modifier = Modifier.padding(end = 4.dp)
                        )
                    }

                    // Login Button
                    Button(
                        onClick = {
                            if (email.trim().isEmpty() || password.isEmpty()) {
                                Toast.makeText(context, "Please enter email and password", Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(context, "Login Successful!", Toast.LENGTH_SHORT).show()
                                val name = email.substringBefore("@")
                                    .replace(".", " ")
                                    .replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
                                onLoginSuccess(name, email)
                            }
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = buttonBg),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(46.dp)
                    ) {
                        Text(
                            text = "Login",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = buttonTextColor
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Bottom Switch Row
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Don't have an account? ",
                    fontSize = 13.sp,
                    color = bottomTextColor
                )
                TextButton(onClick = onNavigateToRegister) {
                    Text(
                        text = "SIGN UP",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = GuniPink
                    )
                }
            }
        }
    }
}
