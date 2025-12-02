package com.example.account.ui.register

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.account.R
import com.example.account.databinding.FragmentRegisterBinding
import com.example.account.di.ServiceLocator
import com.example.account.ui.MainActivity
import kotlinx.coroutines.launch

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private val repository = ServiceLocator.authRepository

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRegisterBinding.bind(view)
        initView()
    }

    private fun initView() = with(binding) {
        ivBack.setOnClickListener {
            it.startAnimation(AnimationUtils.loadAnimation(requireContext(), androidx.appcompat.R.anim.abc_fade_in))
            (activity as? MainActivity)?.gotoLoginScreen()
        }
        tvRegister.setOnClickListener {
            it.startAnimation(AnimationUtils.loadAnimation(requireContext(), androidx.appcompat.R.anim.abc_fade_in))
            attemptRegister()
        }
        tvGotoLogin.setOnClickListener {
            (activity as? MainActivity)?.gotoLoginScreen()
        }
    }

    private fun attemptRegister() {
        val email = binding.edtEmail.text?.toString()?.trim().orEmpty()
        val password = binding.edtPass.text?.toString()?.trim().orEmpty()
        val rePassword = binding.edtRePass.text?.toString()?.trim().orEmpty()

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(rePassword)) {
            (activity as? MainActivity)?.showToast(getString(R.string.error_empty_fields))
            return
        }

        if (password != rePassword) {
            (activity as? MainActivity)?.showToast(getString(R.string.error_password_not_match))
            return
        }

        lifecycleScope.launch {
            setLoading(true)
            repository.register(email, password)
                .onSuccess { response ->
                    (activity as? MainActivity)?.showToast(
                        response.message.ifBlank { getString(R.string.msg_register_success) }
                    )
                    (activity as? MainActivity)?.gotoLoginScreen()
                }
                .onFailure { throwable ->
                    (activity as? MainActivity)?.showToast(
                        throwable.message ?: getString(R.string.msg_register_failed)
                    )
                }
            setLoading(false)
        }
    }

    private fun setLoading(loading: Boolean) = with(binding.tvRegister) {
        isEnabled = !loading
        text = if (loading) "${context.getString(R.string.action_register)}..." else context.getString(R.string.action_register)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

