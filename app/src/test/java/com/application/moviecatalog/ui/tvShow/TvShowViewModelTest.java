package com.application.moviecatalog.ui.tvShow;

import static org.junit.Assert.*;

import com.application.moviecatalog.data.TvShowEntity;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TvShowViewModelTest {
    private TvShowViewModel viewModel;

    @Before
    public void setUp(){
        viewModel = new TvShowViewModel();
    }

    @Test
    public void getTvShows() {
        List<TvShowEntity> tvShowEntities = viewModel.getTvShows();
        assertNotNull(tvShowEntities);
        assertEquals(20, tvShowEntities.size());
    }
}