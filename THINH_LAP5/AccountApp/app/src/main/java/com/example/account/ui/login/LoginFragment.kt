package com.example.account.ui.login

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.account.R
import com.example.account.databinding.FragmentLoginBinding
import com.example.account.di.ServiceLocator
import com.example.account.ui.MainActivity
import kotlinx.coroutines.launch

class LoginFragment : Fragment(R.layout.fragment_login) {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val repository = ServiceLocator.authRepository

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentLoginBinding.bind(view)
        initView()
    }

    private fun initView() = with(binding) {
        tvLogin.setOnClickListener {
            it.startAnimation(AnimationUtils.loadAnimation(requireContext(), androidx.appcompat.R.anim.abc_fade_in))
            attemptLogin()
        }
        tvRegister.setOnClickListener {
            (activity as? MainActivity)?.gotoRegisterScreen()
        }
    }

    private fun attemptLogin() {
        val email = binding.edtEmail.text?.toString()?.trim().orEmpty()
        val password = binding.edtPass.text?.toString()?.trim().orEmpty()

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            (activity as? MainActivity)?.showToast(getString(R.string.error_empty_fields))
            return
        }

        lifecycleScope.launch {
            setLoading(true)
            repository.login(email, password)
                .onSuccess { response ->
                    (activity as? MainActivity)?.apply {
                        showToast(response.message.ifBlank { getString(R.string.msg_login_success) })
                        saveLastLogin(email)
                    }
                }
                .onFailure { throwable ->
                    (activity as? MainActivity)?.showToast(
                        throwable.message ?: getString(R.string.msg_login_failed)
                    )
                }
            setLoading(false)
        }
    }

    private fun setLoading(loading: Boolean) = with(binding.tvLogin) {
        isEnabled = !loading
        text = if (loading) "${context.getString(R.string.action_login)}..." else context.getString(R.string.action_login)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

