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
import com.github.francoisadam.adventuregamebook.manager.UserManager
import com.github.francoisadam.adventuregamebook.repository.UserRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onResume() {
        super.onResume()

        activity?.takeIf { act -> act is HomeActivity }?.let { act ->
            (act as HomeActivity).setupHomeButton()
            view?.let { v ->
                act.navController = Navigation.findNavController(v)
            }
        }

        context?.let { ctx ->
            UserRepository.createUser(user)
                    ?.observeOn(AndroidSchedulers.mainThread())
                    ?.subscribeOn(Schedulers.io())
                    ?.subscribe({ user ->
                        UserManager.saveUser(ctx, user)
                        view?.let { v ->
                            Navigation.findNavController(v).navigate(R.id.action_characterCreationFragment_to_homeActivity)
                            activity?.finish()
                        }
                    }, { throwable ->
                        LogManager.logError(throwable)
                    })
        }
    }

    // TODO
    /*
        - deplacer la creation de user au niveau de l'auth
        - créer un perso au niveau de la page de création de character
        - stocker le perso quelque part
        - au niveau de la home, selectionner story puis afficher au moins de le texte de la premiere page de la story
        - mettre en place des champs tout con pour pouvoir creer un perso et un user avec les valeures voulues

        - Une fois tout ça fait, mettre en place l'ui de la home et l'enchainement des pages
     */

}