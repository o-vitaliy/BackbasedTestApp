package ru.ovi.backbased.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.TT
import org.kodein.di.direct
import org.kodein.di.generic.instance

class KodeinViewModelFactory(private val kodein: Kodein) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        kodein.direct.Instance(TT(modelClass))
}

inline fun <reified VM : ViewModel, T> T.viewModel(): Lazy<VM> where T : KodeinAware, T : FragmentActivity {
    return lazy {
        val i = ViewModelProviders.of(this, direct.instance())
        i.get(VM::class.java)
    }
}

inline fun <reified VM : ViewModel, T, reified A : Any> T.viewModel(arg: A):
        Lazy<VM> where T : KodeinAware, T : FragmentActivity {
    return lazy {
        ViewModelProviders.of(this, direct.instance(arg = arg)).get(VM::class.java)
    }
}

inline fun <reified VM : ViewModel, T> T.viewModel(): Lazy<VM> where T : KodeinAware, T : Fragment {
    return lazy {
        ViewModelProviders.of(this, direct.instance()).get(VM::class.java)
    }
}

inline fun <reified VM : ViewModel, T> T.activityViewModel(): Lazy<VM> where T : KodeinAware, T : Fragment {
    return lazy {
        ViewModelProviders.of(this, direct.instance()).get(VM::class.java)
    }
}

inline fun <reified VM : ViewModel, T, reified A> T.viewModel(arg: A):
        Lazy<VM> where T : KodeinAware, T : Fragment {
    return lazy {
        ViewModelProviders.of(this, direct.instance(arg = arg)).get(VM::class.java)
    }
}
