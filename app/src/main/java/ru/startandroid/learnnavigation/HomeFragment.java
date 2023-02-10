package ru.startandroid.learnnavigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.startandroid.learnnavigation.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater,container,false);

        binding.btnNext.setOnClickListener(view -> {
            String str = binding.editText.getText().toString();
            Bundle bundle = new Bundle();
            bundle.putString("name",str);

            NavOptions navOptions = new NavOptions.Builder().setEnterAnim(R.anim.enter).setExitAnim(R.anim.exit).setPopEnterAnim(R.anim.pop_enter).setPopExitAnim(R.anim.pop_exit).build();

            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_homeFragment_to_firstFragment,bundle,navOptions);
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}