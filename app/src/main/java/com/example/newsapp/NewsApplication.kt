package com.example.newsapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//присоединяется к жизненному циклу объекта Application и обеспечивает для него зависимости.
// +Это родительский компонент приложения, другие компоненты могут получить доступ к зависимостям,
// которые оно предоставляет.

@HiltAndroidApp
class NewsApplication: Application()