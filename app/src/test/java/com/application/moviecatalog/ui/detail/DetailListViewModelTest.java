//package com.application.moviecatalog.ui.detail;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
//import androidx.lifecycle.LiveData;
//import androidx.lifecycle.MutableLiveData;
//import androidx.lifecycle.Observer;
//
//import com.application.moviecatalog.data.source.local.entity.movie.detail.DetailMovieEntity;
//import com.application.moviecatalog.data.source.local.entity.movie.list.MovieEntity;
//import com.application.moviecatalog.data.source.local.entity.tvShow.list.TvShowEntity;
//import com.application.moviecatalog.data.source.MovieCatalogRepository;
//import com.application.moviecatalog.utils.MovieItems;
//import com.application.moviecatalog.utils.TvShowItems;
//
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RunWith(MockitoJUnitRunner.class)
//public class DetailListViewModelTest {
//    private DetailListViewModel viewModel;
//
//    private final MovieEntity movieEntities = MovieItems.movieEntities().get(0);
//    private final int moviesId = movieEntities.getId();
//
//    private final TvShowEntity tvShowEntities = TvShowItems.tvShowEntities().get(0);
//    private final int tvShowId = tvShowEntities.getId();
//
//    @Rule
//    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
//
//    @Mock
//    private MovieCatalogRepository catalogRepository;
//
//    @Mock
//    private Observer<DetailMovieEntity> movieEntityObserver;
//
//    @Mock
//    private Observer<TvShowEntity> tvShowEntityObserver;
//
//    @Before
//    public void setUp(){
//        viewModel = new DetailListViewModel(catalogRepository);
//        viewModel.setMoveId(moviesId);
//        viewModel.setTvId(tvShowId);
//    }
//
//    @Test
//    public void getDetailMovies() {
//        DetailMovieEntity detailMovieEntity = viewModel.getDetailMovie().getValue();
//        MutableLiveData<DetailMovieEntity> mutableLiveData = new MutableLiveData<>();
//        mutableLiveData.setValue(detailMovieEntity);
//
//        when(catalogRepository.detailMovieEntity(moviesId)).thenReturn(mutableLiveData);
//
//        assertNotNull(movieEntities);
//        assert detailMovieEntity != null;
//        assertEquals(movieEntities.getId(), detailMovieEntity.getId());
//        assertEquals(movieEntities.getPosterPath(), detailMovieEntity.getPosterPath());
//        assertEquals(movieEntities.getTitle(), detailMovieEntity.getTitle());
//        assertEquals(movieEntities.getReleaseDate(), detailMovieEntity.getReleaseDate());
////        assertEquals(detailMovies.getVoteAverage(), detailMovieEntity.getVoteAverage());
//        assertEquals(movieEntities.getOriginalLanguage(), detailMovieEntity.getOriginalLanguage());
//        assertEquals(movieEntities.getOverview(), detailMovieEntity.getOverview());
//
//        viewModel.getDetailMovie().observeForever(movieEntityObserver);
//        verify(movieEntityObserver).onChanged(detailMovieEntity);
//    }
//
//    @Test
//    public void getDetailTvShow() {
//        MutableLiveData<TvShowEntity> tvShowEntityMutableLiveData = new MutableLiveData<>();
//        tvShowEntityMutableLiveData.setValue(detailTvShow);
//        when(catalogRepository.detailTvShowEntity(tvShowId)).thenReturn(tvShowEntityMutableLiveData);
//        TvShowEntity tvShowEntity = viewModel.getTvShow().getValue();
//
//        assertNotNull(tvShowEntity);
//        assertEquals(detailTvShow.getId(), tvShowEntity.getId());
//        assertEquals(detailTvShow.getPosterPath(), tvShowEntity.getPosterPath());
//        assertEquals(detailTvShow.getName(), tvShowEntity.getName());
//        assertEquals(detailTvShow.getFirstAirDate(), tvShowEntity.getFirstAirDate());
////        assertEquals(detailTvShow.getVoteAverage(), tvShowEntity.getVoteAverage());
//        assertEquals(detailTvShow.getOriginalLanguage(), tvShowEntity.getOriginalLanguage());
//        assertEquals(detailTvShow.getOverview(), tvShowEntity.getOverview());
//
//        viewModel.getTvShow().observeForever(tvShowEntityObserver);
//        verify(tvShowEntityObserver).onChanged(detailTvShow);
//    }
//
//}