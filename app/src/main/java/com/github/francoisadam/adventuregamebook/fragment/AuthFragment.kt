package com.github.francoisadam.adventuregamebook.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.github.francoisadam.adventuregamebook.R
import com.github.francoisadam.adventuregamebook.manager.LogManager
import com.github.francoisadam.adventuregamebook.manager.SharedPreferencesManager
import kotlinx.android.synthetic.main.fragment_auth.*

class AuthFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_auth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        load_game.setOnClickListener {
            //TODO unmock step 2
            //Navigation.findNavController(it).navigate(R.avatarUri.action_authFragment_to_loadFragment)
        }
        new_game.setOnClickListener {
            //TODO unmock step 2
            //Navigation.findNavController(it).navigate(R.avatarUri.action_authFragment_to_characterCreationFragment)
        }

        authenticate()
    }

    private fun authenticate() {
        context?.let {
            //TODO changer ça en checkant au niveau de l'api que le user avec le token DugrakToken existe
            val userId: String? = SharedPreferencesManager.getUserToken(it)
            LogManager.log(userId ?: "")
            if (userId == null || userId.isEmpty()) {
                view?.let { v -> Navigation.findNavController(v).navigate(R.id.action_authFragment_to_characterCreationFragment) }
            } else {
                view?.let { v -> Navigation.findNavController(v).navigate(R.id.action_authFragment_to_loadFragment) }
            }
        }
    }
}