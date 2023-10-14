package com.soon.activity4.datastore

import android.content.Context

class SharedPref(context: Context) {
    private val sharedPref = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

    var emailaddress: String?
        get() = sharedPref.getString("email", "")
        set(value) {
            sharedPref.edit().putString("email", value).apply()
        }

    var theme: String?
        get() = sharedPref.getString("theme", "")
        set(value) {
            sharedPref.edit().putString("theme", value).apply()
        }

    var nickname: String?
        get() = sharedPref.getString("nickname", "")
        set(value) {
            sharedPref.edit().putString("nickname", value).apply()
        }

    var allowPushNotifications: Boolean
        get() = sharedPref.getBoolean("allow_push_notifications", false)
        set(value) {
            sharedPref.edit().putBoolean("allow_push_notifications", value).apply()
        }
}
