package com.onboarding.wheatherapp.data.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.onboarding.wheatherapp.data.entity.Data
import com.onboarding.wheatherapp.databinding.WeatherDialogBinding
import com.onboarding.wheatherapp.mvp.contract.ForecastDayContract
import com.onboarding.wheatherapp.mvp.presenter.ForecastDayPresenter
import com.onboarding.wheatherapp.mvp.view.ForecastDayView

class ForecastDayFragment : DialogFragment() {

    private lateinit var binding: WeatherDialogBinding
    private lateinit var presenter: ForecastDayContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = WeatherDialogBinding.inflate(inflater, container, false)
        presenter = ForecastDayPresenter(ForecastDayView(this, binding))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val forecastForDay: ArrayList<Data>? = arguments?.getSerializable(FORECAST_EXTEND) as? ArrayList<Data>
        forecastForDay?.let {
            presenter.showForecastDay(forecastForDay)
        }
    }

    companion object {

        private const val FORECAST_EXTEND = "FORECAST_EXTEND"
        const val TAG = "WEATHER_FRAGMENT_TAG"

        fun newInstance(forecastExtend: ArrayList<Data>): ForecastDayFragment {
            val args = Bundle()
            args.apply {
                putSerializable(FORECAST_EXTEND, forecastExtend)
            }
            val fragment = ForecastDayFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
