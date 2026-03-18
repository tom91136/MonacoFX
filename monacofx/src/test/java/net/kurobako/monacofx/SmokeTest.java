package net.kurobako.monacofx;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/** Basic smoke test: MonacoPane can be constructed and shown. */
class SmokeTest extends MonacoPaneTestBase {

    @Test
    void paneIsCreated() {
        assertThat(pane).isNotNull();
        assertThat(ctx).isNotNull();
        assertThat(editor).isNotNull();
    }
}
