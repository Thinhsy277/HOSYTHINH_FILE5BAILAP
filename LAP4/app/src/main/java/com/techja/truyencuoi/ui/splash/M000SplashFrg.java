package com.techja.truyencuoi.ui.splash;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.techja.truyencuoi.MainActivity;
import com.techja.truyencuoi.databinding.M000FrgSplashBinding;

public class M000SplashFrg extends Fragment {

    private static final long SPLASH_DELAY = 2000L;
    private M000FrgSplashBinding binding;
    private final Handler handler = new Handler(Looper.getMainLooper());

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = M000FrgSplashBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        handler.postDelayed(() -> {
            if (isAdded()) {
                ((MainActivity) requireActivity()).gotoM001Screen();
            }
        }, SPLASH_DELAY);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        handler.removeCallbacksAndMessages(null);
        binding = null;
    }
}

