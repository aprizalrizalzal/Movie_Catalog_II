package com.application.moviecatalog.ui.tvShow;

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
import com.application.moviecatalog.data.source.local.entity.tvShow.list.TvShowEntity;
import com.application.moviecatalog.data.source.MovieCatalogRepository;
import com.application.moviecatalog.data.source.remote.RemoteDataSource;
import com.application.moviecatalog.databinding.TvShowFragmentBinding;
import com.application.moviecatalog.ui.detail.DetailListActivity;
import com.application.moviecatalog.utils.ViewModelFactory;

public class TvShowFragment extends Fragment implements TvShowCallback {

    private TvShowFragmentBinding fragmentBinding;

    public TvShowFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentBinding = TvShowFragmentBinding.inflate(inflater, container,false);
        return fragmentBinding.getRoot();
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getActivity() !=null){
            ViewModelFactory factory = new ViewModelFactory(MovieCatalogRepository.getInstance(RemoteDataSource.getInstance()), requireActivity());
            TvShowViewModel viewModel = new ViewModelProvider(requireActivity(),factory).get(TvShowViewModel.class);
            TvShowAdapter adapter = new TvShowAdapter(this);

            fragmentBinding.progressBar.setVisibility(View.VISIBLE);
            viewModel.getTvShows().observe(requireActivity(), tvShowEntities -> {
                fragmentBinding.progressBar.setVisibility(View.GONE);
                adapter.setTvShowEntityList(tvShowEntities);
                adapter.notifyDataSetChanged();

            });

            fragmentBinding.rvTvShow.setLayoutManager(new LinearLayoutManager(getContext()));
            fragmentBinding.rvTvShow.setHasFixedSize(true);
            fragmentBinding.rvTvShow.setAdapter(adapter);
        }
    }


    @Override
    public void onItemClick(TvShowEntity tvShowEntity) {
        Intent intent = new Intent(requireActivity(), DetailListActivity.class);
        intent.putExtra(DetailListActivity.EXTRA_TV_SHOW, tvShowEntity);
        startActivity(intent);
    }

    @Override
    public void onShareClick(TvShowEntity tvShowEntity) {
        if (getActivity() !=null){
            String mimeType = "text/plan";
            ShareCompat.IntentBuilder.from(getActivity()).setType(mimeType).setChooserTitle(R.string.share_tv_show).setText(getString(R.string.tv_show_share_link, tvShowEntity.getId())).startChooser();
        }
    }
}