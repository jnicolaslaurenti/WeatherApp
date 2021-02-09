package com.onboarding.wheatherapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.onboarding.wheatherapp.data.dialog.OnForecastListener
import com.onboarding.wheatherapp.data.entity.Data
import com.onboarding.wheatherapp.databinding.ItemWeatherDayBinding
import com.onboarding.wheatherapp.utils.getForecastDate
import com.onboarding.wheatherapp.utils.getForecastHour

class WeatherAdapter(
    private val days: List<Data>,
    private val onForecastListener: OnForecastListener? = null
) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        WeatherViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_weather_day, parent, false), onForecastListener)

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(days[position])
    }

    override fun getItemCount() = days.size

    class WeatherViewHolder(itemView: View, private val onForecastListener: OnForecastListener?) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemWeatherDayBinding.bind(itemView)
        fun bind(item: Data) {
            val requestOptions = RequestOptions().placeholder(R.drawable.icon_default).error(R.drawable.icon_default)
            binding.apply {
                Glide.with(itemView.context)
                    .applyDefaultRequestOptions(requestOptions)
                    .load("$URL${item.weather.first().iconWeather}$FORMAT")
                    .into(weatherIcon)
                item.main.apply {
                    if (onForecastListener != null) {
                        date.text = item.date.getForecastDate()
                    } else {
                        date.text = item.date.getForecastHour()
                    }
                    TempMin.text = "$tempMin${itemView.resources.getString(R.string.units)}"
                    TempMax.text = "$tempMax${itemView.resources.getString(R.string.units)}"
                    textViewTempNow.text = "$temp${itemView.resources.getString(R.string.units)}"
                }
                binding.item.setOnClickListener {
                    onForecastListener?.onForecastClick(item.date.getForecastDate())
                }
            }
        }
    }

    companion object {
        private const val URL = "https://openweathermap.org/img/wn/"
        private const val FORMAT = ".png"
    }
}
