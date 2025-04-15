package com.digitele.template.presentation.home.bottomscreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.digitele.template.app.PrimaryGreen
import com.digitele.template.navgraph.AppRoute

@Composable
fun SettingsScreen(mainAppNavController: NavHostController) {
    // Sample state for switches/checkboxes
    val (isDarkTheme, setIsDarkTheme) = remember { mutableStateOf(false) }
    val (isNotificationsEnabled, setIsNotificationsEnabled) = remember { mutableStateOf(true) }

    Surface(color = MaterialTheme.colorScheme.background) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Title
            Text(
                text = "Settings",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onBackground
            )

            // Theme switch
            Text(text = "Dark Theme", modifier = Modifier.padding(top = 16.dp))
            Switch(
                checked = isDarkTheme,
                onCheckedChange = { setIsDarkTheme(it) },
                modifier = Modifier.padding(top = 8.dp),
                colors = SwitchDefaults.colors(
                    checkedThumbColor = PrimaryGreen,  // Green color for the thumb
                    checkedTrackColor = PrimaryGreen.copy(alpha = 0.6f)  // Lighter green for track
                )
            )

            // Notifications switch
            Text(text = "Enable Notifications", modifier = Modifier.padding(top = 16.dp))
            Switch(
                checked = isNotificationsEnabled,
                onCheckedChange = { setIsNotificationsEnabled(it) },
                modifier = Modifier.padding(top = 8.dp),
                colors = SwitchDefaults.colors(
                    checkedThumbColor = PrimaryGreen,
                    checkedTrackColor = PrimaryGreen.copy(alpha = 0.6f)
                )
            )

            // Some other option: Privacy policy checkbox
            Text(text = "Agree to Privacy Policy", modifier = Modifier.padding(top = 16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                val (isPrivacyPolicyAccepted, setIsPrivacyPolicyAccepted) = remember { mutableStateOf(false) }
                Checkbox(
                    checked = isPrivacyPolicyAccepted,
                    onCheckedChange = { setIsPrivacyPolicyAccepted(it) },
                    colors = CheckboxDefaults.colors(checkedColor = PrimaryGreen)  // Green for the checkbox
                )
                Text("I accept the terms and conditions.", color = MaterialTheme.colorScheme.onBackground)
            }

            // Version display
            Text(text = "App Version: 1.0.0", modifier = Modifier.padding(top = 16.dp))

            // Save button
            Button(
                onClick = {
                    mainAppNavController.navigate(AppRoute.Terms.route) {
                        popUpTo(AppRoute.Terms.route) { inclusive = true } // Clear login from back stack
                    }
                },
                modifier = Modifier.padding(top = 16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryGreen) // Green button
            ) {
                Text("Terms &Conditions", color = MaterialTheme.colorScheme.onPrimary) // White text
            }

            // Logout Button at the bottom
            Button(
                onClick = { /* Handle logout action */ },
                modifier = Modifier
                    .padding(top = 32.dp)
                    .align(Alignment.CenterHorizontally), // Center align the button
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryGreen) // Green button
            ) {
                Text("Logout", color = MaterialTheme.colorScheme.onPrimary) // White text
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    var navController = rememberNavController();
    SettingsScreen(navController)
}
