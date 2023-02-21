package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {

    @Test
    public void whenComparatorByNameAsc() {
        int rsl = new JobAscByName().compare(
                new Job("Back", 1),
                new Job("Fix", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByNameDesc() {
        int rsl = new JobDescByName().compare(
                new Job("Back", 1),
                new Job("Fix", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByPriorityAsc() {
        int rsl = new JobAscByName().compare(
                new Job("Back", 0),
                new Job("Fix", 10)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByPriorityDesc() {
        int rsl = new JobDescByName().compare(
                new Job("Back", 0),
                new Job("Fix", 10)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByPriorityAndName() {
        int rsl = new JobAscByPriority().thenComparing(new JobAscByName()).compare(
                new Job("Back", 0),
                new Job("Fix", 10)
        );
        assertThat(rsl).isLessThan(0);
    }
}