package com.github.francoisadam.adventuregamebook.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.github.francoisadam.adventuregamebook.R
import com.github.francoisadam.adventuregamebook.activity.HomeActivity
import com.github.francoisadam.adventuregamebook.manager.LogManager
import com.github.francoisadam.adventuregamebook.manager.SharedPreferencesManager
import com.github.francoisadam.adventuregamebook.manager.UserManager
import com.github.francoisadam.adventuregamebook.repository.UserRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_load.*

class LoadFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_load, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        start.setOnClickListener {
            //TODO unmock step 2
            /*Navigation.findNavController(it).navigate(R.avatarUri.action_loadFragment_to_homeActivity)
            activity?.finish()*/
        }

        load()
    }

    override fun onResume() {
        super.onResume()
        activity?.takeIf { act -> act is HomeActivity }?.let { act ->
            (act as HomeActivity).setupBackButton()
        }
    }

    private fun load() {
        context?.let { ctx ->
            SharedPreferencesManager.getUserToken(ctx)?.let { token ->
                UserRepository.getUser(token)
                        ?.observeOn(AndroidSchedulers.mainThread())
                        ?.subscribeOn(Schedulers.io())
                        ?.subscribe({ user ->
                            UserManager.saveUser(ctx, user)
                            view?.let { v ->
                                Navigation.findNavController(v).navigate(R.id.action_loadFragment_to_homeActivity)
                                activity?.finish()
                            }
                        }, { throwable ->
                            LogManager.logError(throwable)
                        })
            }
        }
    }
}