package com.github.francoisadam.adventuregamebook.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.github.francoisadam.adventuregamebook.R
import com.github.francoisadam.adventuregamebook.manager.LogManager
import com.github.francoisadam.adventuregamebook.manager.UserManager
import com.github.francoisadam.adventuregamebook.model.User
import com.github.francoisadam.adventuregamebook.repository.UserRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_character_creation.*

class CharacterCreationFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_character_creation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        create.setOnClickListener {
            //TODO unmock step 2
            /*Navigation.findNavController(it).navigate(R.id.action_characterCreationFragment_to_homeActivity)
            activity?.finish()*/
        }

        create()
    }

    @SuppressLint("CheckResult")
    private fun create() {
        val user = User()
        user.givenName = "Dugrak"
        user.avatarUri = "https://www.drivethrurpg.com/images/8135/239925.jpg"
        user.token = "DugrakToken"
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
}