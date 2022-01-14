package com.application.moviecatalog.ui.movies;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.application.moviecatalog.data.source.local.entity.movie.list.MovieEntity;
import com.application.moviecatalog.data.source.MovieCatalogRepository;
import com.application.moviecatalog.utils.MovieItems;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class MoviesViewModelTest {
    private MoviesViewModel viewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private MovieCatalogRepository catalogRepository;

    @Mock
    private Observer<List<MovieEntity>> observer;

    @Before
    public void setUp(){
        viewModel = new MoviesViewModel(catalogRepository);
    }

    @Test
    public void getMovies() {
        List<MovieEntity> movieEntities = MovieItems.movieEntities();
        MutableLiveData<List<MovieEntity>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(movieEntities);

        when(catalogRepository.movieEntities()).thenReturn(mutableLiveData);
        List<MovieEntity> movieEntityList = viewModel.getMovies().getValue();
        verify(catalogRepository).movieEntities();
        assertNotNull(movieEntityList);
        assertEquals(20, movieEntityList.size());

        viewModel.getMovies().observeForever(observer);
        verify(observer).onChanged(movieEntities);
    }
}