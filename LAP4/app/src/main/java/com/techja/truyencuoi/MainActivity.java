package com.techja.truyencuoi;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.techja.truyencuoi.databinding.ActivityMainBinding;
import com.techja.truyencuoi.ui.splash.M000SplashFrg;
import com.techja.truyencuoi.ui.storydetail.M003StoryPagerFrg;
import com.techja.truyencuoi.ui.storylist.M002StoryListFrg;
import com.techja.truyencuoi.ui.topics.M001TopicsFrg;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        showFrg(new M000SplashFrg(), false);
    }

    private void showFrg(Fragment frg, boolean addToBackStack) {
        androidx.fragment.app.FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_main, frg);
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }

    public void gotoM001Screen() {
        clearBackStack();
        showFrg(M001TopicsFrg.newInstance(), false);
    }

    public void gotoM002Screen(String topicId) {
        showFrg(M002StoryListFrg.newInstance(topicId), true);
    }

    public void gotoM003Screen(String topicId, int position) {
        showFrg(M003StoryPagerFrg.newInstance(topicId, position), true);
    }

    public void navigateBack() {
        getOnBackPressedDispatcher().onBackPressed();
    }

    private void clearBackStack() {
        getSupportFragmentManager().popBackStack(null, getSupportFragmentManager().POP_BACK_STACK_INCLUSIVE);
        getSupportFragmentManager().executePendingTransactions();
    }
}

