package com.application.moviecatalog.ui.movies;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ShareCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.application.moviecatalog.R;
import com.application.moviecatalog.data.MovieEntity;
import com.application.moviecatalog.databinding.MoviesFragmentBinding;
import com.application.moviecatalog.ui.detail.DetailListActivity;

import java.util.List;

public class MoviesFragment extends Fragment implements MoviesCallback {

    private MoviesFragmentBinding fragmentBinding;

    public MoviesFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentBinding = MoviesFragmentBinding.inflate(inflater, container,false);
        return fragmentBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getActivity() !=null){
            MoviesViewModel viewModel = new ViewModelProvider(requireActivity(),new ViewModelProvider.NewInstanceFactory()).get(MoviesViewModel.class);
            List<MovieEntity> movieEntities = viewModel.getMovies();

            MoviesAdapter adapter = new MoviesAdapter(this);
            adapter.setMoviesCatalogEntityList(movieEntities);

            fragmentBinding.rvMovies.setLayoutManager(new LinearLayoutManager(getContext()));
            fragmentBinding.rvMovies.setHasFixedSize(true);
            fragmentBinding.rvMovies.setAdapter(adapter);
        }
    }

    @Override
    public void onItemClick(MovieEntity movieEntity) {
        Intent intent = new Intent(requireActivity(), DetailListActivity.class);
        intent.putExtra(DetailListActivity.EXTRA_MOVIE, movieEntity);
        startActivity(intent);
    }

    @Override
    public void onShareClick(MovieEntity movieEntity) {
        if (getActivity() !=null){
            String mimeType = "text/plan";
            ShareCompat.IntentBuilder.from(getActivity()).setType(mimeType).setChooserTitle(R.string.share_movies).setText(getString(R.string.movie_share_link, movieEntity.getId())).startChooser();
        }
    }
}