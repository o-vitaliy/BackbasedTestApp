package ru.ovi.backbased.presentation.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_content_loader.*
import ru.ovi.backbased.R
import ru.ovi.backbased.domain.common.Result
import ru.ovi.backbased.domain.common.isEmpty

abstract class BaseContentLoaderFragment : Fragment() {

    abstract val contentLayoutId: Int

    private lateinit var contentView: View

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_content_loader, container, false).apply {
        findViewById<ViewStub>(R.id.containerContent).apply {
            layoutResource = contentLayoutId
            contentView = inflate()
        }
    }

    fun <T : Any> subscribe(result: LiveData<Result<T>>) {
        result.observe(viewLifecycleOwner, Observer {
            it ?: return@Observer
            when (it) {
                is Result.Loading -> showOnly(
                    containerLoading,
                    containerError, contentView, contentEmpty
                )
                is Result.Error -> {
                    containerError.findViewById<TextView>(R.id.errorMessageText).text = it.message
                    showOnly(
                        containerError,
                        containerLoading, contentView, contentEmpty
                    )
                }
                is Result.Success ->
                    if (it.isEmpty()) {
                        showOnly(
                            contentEmpty,
                            contentView, containerError, containerLoading
                        )
                    } else {
                        showOnly(
                            contentView,
                            contentEmpty, containerError, containerLoading
                        )
                    }
            }
        })
    }
}
