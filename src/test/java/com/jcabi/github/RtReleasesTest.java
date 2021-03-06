/**
 * Copyright (c) 2012-2013, JCabi.com
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met: 1) Redistributions of source code must retain the above
 * copyright notice, this list of conditions and the following
 * disclaimer. 2) Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution. 3) Neither the name of the jcabi.com nor
 * the names of its contributors may be used to endorse or promote
 * products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.jcabi.github;

import com.jcabi.aspects.Immutable;
import com.rexsl.test.mock.MkAnswer;
import com.rexsl.test.mock.MkContainer;
import com.rexsl.test.mock.MkGrizzlyContainer;
import java.net.HttpURLConnection;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Test case for {@link RtReleases}.
 * @author Paul Polishchuk (ppol@ua.fm)
 * @version $Id$
 * @since 0.8
 * @checkstyle MultipleStringLiterals (500 lines)
 */
@Immutable
public final class RtReleasesTest {

    /**
     * RtReleases can fetch empty list of releases.
     * @throws Exception if some problem inside
     */
    @Test
    public void canFetchEmptyListOfReleases() throws Exception {
        final MkContainer container = new MkGrizzlyContainer().next(
            new MkAnswer.Simple(HttpURLConnection.HTTP_OK, "[]")
        ).start();
        final Releases releases = new RtReleases(
            RtReleasesTest.repo()
        );
        MatcherAssert.assertThat(
            releases.iterate(),
            Matchers.emptyIterable()
        );
        container.stop();
    }

    /**
     * RtReleases can fetch non empty list of releases.
     *
     * @todo #123 RtReleases should iterate multiple releases. Let's implement
     *  a test here and a method of RtReleases. The method should iterate
     *  multiple releases. See how it's done in other classes with GhPagination.
     *  When done, remove this puzzle and Ignore annotation from the method.
     */
    @Test
    @Ignore
    public void canFetchNonEmptyListOfReleases() {
        // to be implemented
    }

    /**
     * RtReleases can fetch single release.
     *
     * @todo #123 RtReleases should be able to get a single release.
     *  Let's implement a test here and a method get() of RtReleases.
     *  The method should fetch a single release.
     *  See how it's done in other classes, using Rexsl request/response.
     *  When done, remove this puzzle and Ignore annotation from the method.
     */
    @Test
    @Ignore
    public void canFetchSingleRelease() {
        // to be implemented
    }

    /**
     * RtReleases can create a release.
     *
     * @todo #123 RtReleases should be able to create a Release. Let's implement
     *  a test here and a method create() of RtReleases.
     *  The method should create a release.
     *  See how it's done in other classes, using Rexsl request/response.
     *  When done, remove this puzzle and Ignore annotation from the method.
     */
    @Test
    @Ignore
    public void canCreateRelease() {
        // to be implemented
    }

    /**
     * RtReleases can delete a release.
     *
     * @todo #123 RtReleases should be able to delete a Release. Let's implement
     *  a test here and a method remove() of RtReleases.
     *  The method should remove a release by it's id.
     *  See how it's done in other classes, using Rexsl request/response.
     *  When done, remove this puzzle and Ignore annotation from the method.
     */
    @Test
    @Ignore
    public void canDeleteRelease() {
        // to be implemented
    }

    /**
     * Create and return repo for testing.
     * @return Repo
     */
    private static Repo repo() {
        final Repo repo = Mockito.mock(Repo.class);
        Mockito.doReturn(new Coordinates.Simple("test", "releases"))
            .when(repo).coordinates();
        return repo;
    }
}
