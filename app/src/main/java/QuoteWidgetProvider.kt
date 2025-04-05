package com.pranathi.dailyquotewidget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import kotlin.random.Random

class QuoteWidgetProvider : AppWidgetProvider() {

    private val quotes = listOf(
        "Believe you can and you're halfway there. - Theodore Roosevelt",
        "Keep going. Everything you need will come to you. - Unknown",
        "Dream big and dare to fail. - Norman Vaughan",
        "Don’t wait for opportunity. Create it. - Unknown",
        "Success is not final, failure is not fatal. - Winston Churchill",
        "Push yourself, because no one else is going to do it for you. - Unknown",
        "Great things never come from comfort zones. - Unknown",
        "Don’t stop when you’re tired. Stop when you’re done. - Unknown",
        "Success doesn’t just find you. You have to go out and get it. - Unknown",
        "Dream it. Wish it. Do it. - Unknown",
        "Stay positive. Work hard. Make it happen. - Unknown",
        "Doubt kills more dreams than failure ever will. - Suzy Kassem",
        "The harder you work for something, the greater you’ll feel when you achieve it. - Unknown",
        "Don’t limit your challenges. Challenge your limits. - Unknown",
        "Little things make big days. - Unknown",
        "It always seems impossible until it’s done. - Nelson Mandela",
        "Wake up with determination. Go to bed with satisfaction. - Unknown",
        "Do something today that your future self will thank you for. - Unknown",
        "Push harder than yesterday if you want a different tomorrow. - Unknown",
        "Don’t watch the clock; do what it does. Keep going. - Sam Levenson"
    )

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        for (id in appWidgetIds) {
            val randomQuote = quotes[Random.nextInt(quotes.size)]
            val views = RemoteViews(context.packageName, R.layout.quote_widget)
            views.setTextViewText(R.id.quoteTextView, randomQuote)

            // Intent to update the widget on click
            val intent = Intent(context, QuoteWidgetProvider::class.java).apply {
                action = AppWidgetManager.ACTION_APPWIDGET_UPDATE
                putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds)
            }

            val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)
            views.setOnClickPendingIntent(R.id.quoteTextView, pendingIntent)

            appWidgetManager.updateAppWidget(id, views)
        }
    }
}
