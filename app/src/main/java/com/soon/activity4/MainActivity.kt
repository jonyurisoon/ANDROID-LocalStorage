package com.soon.activity4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.soon.activity4.databinding.ActivityMainBinding
import com.soon.activity4.datastore.SharedPref

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPref: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref = SharedPref(this)

        // Load the saved email address and populate the EditText
        binding.EmailAddress.setText(sharedPref.emailaddress)

        // Load the saved nickname and populate the EditText
        binding.Nickname.setText(sharedPref.nickname)

        // Load the selected theme
        val savedTheme = sharedPref.theme
        if (savedTheme == "light") {
            binding.LightMode.isChecked = true
        } else if (savedTheme == "dark") {
            binding.DarkMode.isChecked = true
        }

        // Load the saved notification preference and update the CheckBox
        binding.AllowPushNotificationCheckbox.isChecked = sharedPref.allowPushNotifications

        binding.SaveButton.setOnClickListener {
            val email = binding.EmailAddress.text.toString()
            val nickname = binding.Nickname.text.toString()

            // Determine the selected theme by iterating through RadioButtons
            var selectedTheme = ""

            if (binding.LightMode.isChecked) {
                selectedTheme = "light"
            } else if (binding.DarkMode.isChecked) {
                selectedTheme = "dark"
            }

            // Save data to shared preferences
            sharedPref.emailaddress = email
            sharedPref.nickname = nickname
            sharedPref.theme = selectedTheme
            sharedPref.allowPushNotifications = binding.AllowPushNotificationCheckbox.isChecked

            // Display a toast message to indicate that data has been saved
            Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show()
        }

    }
}
