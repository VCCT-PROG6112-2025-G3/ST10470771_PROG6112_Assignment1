
package tvseriesdetailstracking.test;

import org.junit.Before;
import org.junit.Test;
import tvseriesdetailstracking.Series;
import tvseriesdetailstracking.SeriesModel;

import static org.junit.Assert.*;

public class SeriesTest {

    private Series seriesManager;

    @Before
    public void setUp() {
        seriesManager = new Series();
        // Add a sample series to test with
        seriesManager.addSeries(new SeriesModel("S001", "Breaking Code", 16, 10));
    }

    @Test
    public void TestSearchSeries() {
        SeriesModel s = seriesManager.getSeriesById("S001");
        assertNotNull("Series should be found", s);
        assertEquals("Breaking Code", s.getName());
    }

    @Test
    public void TestSearchSeries_SeriesNotFound() {
        SeriesModel s = seriesManager.getSeriesById("S999");
        assertNull("Series should not be found", s);
    }

    @Test
    public void TestUpdateSeries() {
        boolean updated = seriesManager.updateSeriesById("S001", "Breaking Code Reloaded", 15, 12);
        assertTrue("Update should succeed", updated);

        SeriesModel updatedSeries = seriesManager.getSeriesById("S001");
        assertEquals("Breaking Code Reloaded", updatedSeries.getName());
        assertEquals(15, updatedSeries.getAgeRestriction());
        assertEquals(12, updatedSeries.getNumEpisodes());
    }

    @Test
    public void TestDeleteSeries() {
        boolean deleted = seriesManager.deleteSeriesById("S001");
        assertTrue("Series should be deleted", deleted);
        assertNull(seriesManager.getSeriesById("S001"));
    }

    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        boolean deleted = seriesManager.deleteSeriesById("S999");
        assertFalse("Deleting non-existent series should fail", deleted);
    }

    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        assertTrue(seriesManager.isValidAge(10));
        assertTrue(seriesManager.isValidAge(18));
        assertTrue(seriesManager.isValidAge(2));
    }

    @Test
    public void TestSeriesAgeRestriction_AgeInvalid() {
        assertFalse(seriesManager.isValidAge(1));
        assertFalse(seriesManager.isValidAge(19));
        assertFalse(seriesManager.isValidAge(-5));
    }
}
