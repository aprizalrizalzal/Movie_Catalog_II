package com.application.moviecatalog.ui.tvShow;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.application.moviecatalog.data.source.local.entity.tvShow.list.TvShowEntity;
import com.application.moviecatalog.data.source.MovieCatalogRepository;
import com.application.moviecatalog.utils.TvShowItems;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TvShowViewModelTest {
    private TvShowViewModel viewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private MovieCatalogRepository catalogRepository;

    @Mock
    private Observer<List<TvShowEntity>> observer;

    @Before
    public void setUp(){
        viewModel = new TvShowViewModel(catalogRepository);
    }

    @Test
    public void getTvShow() {
        List<TvShowEntity> tvShowEntities = TvShowItems.tvShowEntities();
        MutableLiveData<List<TvShowEntity>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(tvShowEntities);

        when(catalogRepository.tvShowEntities()).thenReturn(mutableLiveData);
        List<TvShowEntity> tvShowEntityList = viewModel.getTvShows().getValue();
        verify(catalogRepository).tvShowEntities();
        assertNotNull(tvShowEntityList);
        assertEquals(20, tvShowEntityList.size());

        viewModel.getTvShows().observeForever(observer);
        verify(observer).onChanged(tvShowEntities);
    }
}
