package com.application.moviecatalog.ui.movies;
import android.annotation.SuppressLint;
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
import com.application.moviecatalog.data.source.local.entity.movie.list.MovieEntity;
import com.application.moviecatalog.data.source.MovieCatalogRepository;
import com.application.moviecatalog.data.source.remote.RemoteDataSource;
import com.application.moviecatalog.databinding.MoviesFragmentBinding;
import com.application.moviecatalog.ui.detail.DetailListActivity;
import com.application.moviecatalog.utils.ViewModelFactory;

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

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getActivity() !=null){
            ViewModelFactory factory = ViewModelFactory.getInstance(MovieCatalogRepository.getInstance(RemoteDataSource.getInstance()),requireActivity() );
            MoviesViewModel viewModel = new ViewModelProvider(requireActivity(),factory).get(MoviesViewModel.class);
            MoviesAdapter adapter = new MoviesAdapter(this);

            fragmentBinding.progressBar.setVisibility(View.VISIBLE);
            viewModel.getMovies().observe(requireActivity(), movieEntities -> {
                fragmentBinding.progressBar.setVisibility(View.GONE);
                adapter.setMoviesEntityList(movieEntities);
                adapter.notifyDataSetChanged();
            });

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