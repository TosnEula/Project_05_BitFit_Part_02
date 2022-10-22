package com.example.project_05_bitfit_part_02

import android.app.Application


class HabitApplication : Application() {
    val db by lazy { AppDatabase.getInstance(this) }
}

